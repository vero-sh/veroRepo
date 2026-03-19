// ============================================
// DRONE DELIVERY MANAGEMENT SYSTEM
// REST API Server
// ============================================
//
// Questo server simula un sistema di gestione droni per consegne urbane.
// Gli studenti NON devono leggere questo codice - è una BLACK BOX.
// Interagiscono solo tramite la documentazione API fornita separatamente.
//
// Porta: 3000
// Base URL: http://localhost:3000
//
// ============================================

const express = require('express');
const app = express();

app.use(express.json());

app.use(function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  next();
});

// ============================================
// UTILITY FUNCTIONS
// ============================================

const randomInRange = function(min, max) {
  return Math.random() * (max - min) + min;
};

const randomPick = function(arr) {
  return arr[Math.floor(Math.random() * arr.length)];
};

const generateId = function(prefix, counter) {
  return prefix + '-' + String(counter).padStart(3, '0');
};

// ============================================
// SYSTEM STATE (MUTABILE)
// ============================================

let systemState = {
  drones: [
    {
      id: 'D-001',
      model: 'SkyRunner X2',
      status: 'available',
      battery: 85,
      location: {
        zone: 'north',
        coordinates: { lat: 45.4842, lng: 9.2061 }
      },
      specs: {
        maxWeight: 5.0,
        maxRange: 15,
        speed: 45
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-02-01',
        nextDue: '2026-05-01',
        issues: []
      }
    },
    {
      id: 'D-002',
      model: 'CargoMax 3000',
      status: 'available',
      battery: 92,
      location: {
        zone: 'south',
        coordinates: { lat: 45.4508, lng: 9.1832 }
      },
      specs: {
        maxWeight: 8.0,
        maxRange: 20,
        speed: 40
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-01-28',
        nextDue: '2026-04-28',
        issues: []
      }
    },
    {
      id: 'D-003',
      model: 'SkyRunner X2',
      status: 'charging',
      battery: 18,
      location: {
        zone: 'north',
        coordinates: { lat: 45.4895, lng: 9.2108 }
      },
      specs: {
        maxWeight: 5.0,
        maxRange: 15,
        speed: 45
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-02-10',
        nextDue: '2026-05-10',
        issues: []
      }
    },
    {
      id: 'D-004',
      model: 'QuickFlyer Pro',
      status: 'available',
      battery: 67,
      location: {
        zone: 'east',
        coordinates: { lat: 45.4635, lng: 9.2112 }
      },
      specs: {
        maxWeight: 3.0,
        maxRange: 12,
        speed: 55
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-02-05',
        nextDue: '2026-05-05',
        issues: []
      }
    },
    {
      id: 'D-005',
      model: 'CargoMax 3000',
      status: 'maintenance',
      battery: 0,
      location: {
        zone: 'south',
        coordinates: { lat: 45.4512, lng: 9.1845 }
      },
      specs: {
        maxWeight: 8.0,
        maxRange: 20,
        speed: 40
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-02-15',
        nextDue: '2026-05-15',
        issues: ['rotor-damage', 'gps-calibration']
      }
    },
    {
      id: 'D-006',
      model: 'SkyRunner X2',
      status: 'available',
      battery: 78,
      location: {
        zone: 'west',
        coordinates: { lat: 45.4698, lng: 9.1625 }
      },
      specs: {
        maxWeight: 5.0,
        maxRange: 15,
        speed: 45
      },
      assignedDelivery: null,
      maintenance: {
        lastService: '2026-02-08',
        nextDue: '2026-05-08',
        issues: []
      }
    }
  ],
  
  deliveries: [
    {
      id: 'DEL-001',
      package: {
        weight: 2.3,
        fragile: true,
        category: 'food',
        description: 'Fresh pizza delivery'
      },
      destination: {
        address: 'Via Dante 42, Milano',
        zone: 'north',
        coordinates: { lat: 45.4856, lng: 9.2075 },
        distance: 2.8
      },
      priority: 'high',
      status: 'pending',
      assignedDrone: null,
      timeline: {
        created: '2026-03-05T09:15:00Z',
        assigned: null,
        inTransit: null,
        completed: null
      }
    },
    {
      id: 'DEL-002',
      package: {
        weight: 4.5,
        fragile: false,
        category: 'electronics',
        description: 'Laptop computer'
      },
      destination: {
        address: 'Corso Buenos Aires 18, Milano',
        zone: 'east',
        coordinates: { lat: 45.4712, lng: 9.2098 },
        distance: 5.2
      },
      priority: 'medium',
      status: 'pending',
      assignedDrone: null,
      timeline: {
        created: '2026-03-05T09:28:00Z',
        assigned: null,
        inTransit: null,
        completed: null
      }
    },
    {
      id: 'DEL-003',
      package: {
        weight: 1.8,
        fragile: true,
        category: 'medical',
        description: 'Prescription medications'
      },
      destination: {
        address: 'Via Tortona 31, Milano',
        zone: 'west',
        coordinates: { lat: 45.4534, lng: 9.1612 },
        distance: 4.1
      },
      priority: 'high',
      status: 'pending',
      assignedDrone: null,
      timeline: {
        created: '2026-03-05T09:42:00Z',
        assigned: null,
        inTransit: null,
        completed: null
      }
    },
    {
      id: 'DEL-004',
      package: {
        weight: 0.8,
        fragile: false,
        category: 'documents',
        description: 'Legal documents'
      },
      destination: {
        address: 'Via Larga 7, Milano',
        zone: 'central',
        coordinates: { lat: 45.4628, lng: 9.1895 },
        distance: 18.5
      },
      priority: 'low',
      status: 'pending',
      assignedDrone: null,
      timeline: {
        created: '2026-03-05T10:05:00Z',
        assigned: null,
        inTransit: null,
        completed: null
      }
    }
  ],
  
  zones: [
    { name: 'north', activeDeliveries: 0, completedToday: 3, avgDeliveryTime: 12.5 },
    { name: 'south', activeDeliveries: 0, completedToday: 5, avgDeliveryTime: 15.2 },
    { name: 'east', activeDeliveries: 0, completedToday: 2, avgDeliveryTime: 11.8 },
    { name: 'west', activeDeliveries: 0, completedToday: 4, avgDeliveryTime: 13.1 },
    { name: 'central', activeDeliveries: 0, completedToday: 1, avgDeliveryTime: 9.5 }
  ],
  
  nextDeliveryId: 5
};

// ============================================
// HELPER FUNCTIONS
// ============================================

function findDrone(droneId) {
  return systemState.drones.find(function(d) { return d.id === droneId; });
}

function findDelivery(deliveryId) {
  return systemState.deliveries.find(function(d) { return d.id === deliveryId; });
}

function findZone(zoneName) {
  return systemState.zones.find(function(z) { return z.name === zoneName; });
}

function calculateDistance(coord1, coord2) {
  const R = 6371;
  const dLat = (coord2.lat - coord1.lat) * Math.PI / 180;
  const dLng = (coord2.lng - coord1.lng) * Math.PI / 180;
  const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(coord1.lat * Math.PI / 180) * Math.cos(coord2.lat * Math.PI / 180) *
            Math.sin(dLng / 2) * Math.sin(dLng / 2);
  const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
  return R * c;
}

// ============================================
// GET ENDPOINTS
// ============================================

app.get('/drones', function(req, res) {
  res.json({
    timestamp: new Date().toISOString(),
    count: systemState.drones.length,
    drones: systemState.drones
  });
});

app.get('/deliveries', function(req, res) {
  res.json({
    timestamp: new Date().toISOString(),
    count: systemState.deliveries.length,
    deliveries: systemState.deliveries
  });
});

app.get('/zones/stats', function(req, res) {
  res.json({
    timestamp: new Date().toISOString(),
    zones: systemState.zones
  });
});

// ============================================
// POST ENDPOINTS
// ============================================

app.post('/deliveries', function(req, res) {
  const data = req.body;
  
  if (!data.destination || !data.destination.address || !data.destination.zone) {
    return res.status(400).json({
      success: false,
      error: 'Missing required fields: destination.address, destination.zone'
    });
  }
  
  if (!data.package || !data.package.weight || !data.package.category) {
    return res.status(400).json({
      success: false,
      error: 'Missing required fields: package.weight, package.category'
    });
  }
  
  const zone = findZone(data.destination.zone);
  if (!zone) {
    return res.status(400).json({
      success: false,
      error: 'Invalid zone: ' + data.destination.zone
    });
  }
  
  const newDelivery = {
    id: generateId('DEL', systemState.nextDeliveryId),
    package: {
      weight: data.package.weight,
      fragile: data.package.fragile || false,
      category: data.package.category,
      description: data.package.description || 'No description'
    },
    destination: {
      address: data.destination.address,
      zone: data.destination.zone,
      coordinates: data.destination.coordinates || { lat: 45.4642, lng: 9.1900 },
      distance: data.destination.distance || randomInRange(1, 10)
    },
    priority: data.priority || 'medium',
    status: 'pending',
    assignedDrone: null,
    timeline: {
      created: new Date().toISOString(),
      assigned: null,
      inTransit: null,
      completed: null
    }
  };
  
  systemState.deliveries.push(newDelivery);
  systemState.nextDeliveryId = systemState.nextDeliveryId + 1;
  
  res.status(201).json({
    success: true,
    delivery: newDelivery
  });
});

app.post('/drones/:droneId/assign', function(req, res) {
  const droneId = req.params.droneId;
  const data = req.body;
  
  if (!data.deliveryId) {
    return res.status(400).json({
      success: false,
      error: 'Missing required field: deliveryId'
    });
  }
  
  const drone = findDrone(droneId);
  if (!drone) {
    return res.status(404).json({
      success: false,
      error: 'Drone not found: ' + droneId
    });
  }
  
  const delivery = findDelivery(data.deliveryId);
  if (!delivery) {
    return res.status(404).json({
      success: false,
      error: 'Delivery not found: ' + data.deliveryId
    });
  }
  
  // BUSINESS VALIDATIONS (per task a casa)
  if (drone.battery < 20) {
    return res.status(400).json({
      success: false,
      error: 'Insufficient battery: ' + drone.battery + '%. Minimum required: 20%'
    });
  }
  
  if (drone.status !== 'available') {
    return res.status(400).json({
      success: false,
      error: 'Drone not available. Current status: ' + drone.status
    });
  }
  
  if (delivery.status !== 'pending') {
    return res.status(400).json({
      success: false,
      error: 'Delivery already assigned or completed. Current status: ' + delivery.status
    });
  }
  
  if (delivery.package.weight > drone.specs.maxWeight) {
    return res.status(400).json({
      success: false,
      error: 'Package too heavy: ' + delivery.package.weight + 'kg. Max capacity: ' + drone.specs.maxWeight + 'kg'
    });
  }
  
  if (delivery.destination.distance > drone.specs.maxRange) {
    return res.status(400).json({
      success: false,
      error: 'Destination out of range: ' + delivery.destination.distance + 'km. Max range: ' + drone.specs.maxRange + 'km'
    });
  }
  
  // SIDE EFFECTS
  drone.status = 'assigned';
  drone.assignedDelivery = delivery.id;
  drone.battery = drone.battery - 5;
  
  delivery.status = 'assigned';
  delivery.assignedDrone = drone.id;
  delivery.timeline.assigned = new Date().toISOString();
  
  const zone = findZone(delivery.destination.zone);
  if (zone) {
    zone.activeDeliveries = zone.activeDeliveries + 1;
  }
  
  res.status(201).json({
    success: true,
    drone: drone,
    delivery: delivery,
    message: 'Drone ' + drone.id + ' assigned to delivery ' + delivery.id
  });
});

// ============================================
// PUT ENDPOINTS
// ============================================

app.put('/deliveries/:deliveryId', function(req, res) {
  const deliveryId = req.params.deliveryId;
  const data = req.body;
  
  const delivery = findDelivery(deliveryId);
  if (!delivery) {
    return res.status(404).json({
      success: false,
      error: 'Delivery not found: ' + deliveryId
    });
  }
  
  if (!data.status) {
    return res.status(400).json({
      success: false,
      error: 'Missing required field: status'
    });
  }
  
  const oldStatus = delivery.status;
  delivery.status = data.status;
  
  // SIDE EFFECTS basati su nuovo status
  if (data.status === 'in-transit' && oldStatus === 'assigned') {
    delivery.timeline.inTransit = new Date().toISOString();
    
    const drone = findDrone(delivery.assignedDrone);
    if (drone) {
      drone.status = 'in-flight';
    }
  }
  
  if (data.status === 'completed') {
    delivery.timeline.completed = new Date().toISOString();
    
    const drone = findDrone(delivery.assignedDrone);
    if (drone) {
      drone.status = 'available';
      drone.assignedDelivery = null;
      drone.battery = drone.battery - 10;
    }
    
    const zone = findZone(delivery.destination.zone);
    if (zone) {
      zone.activeDeliveries = zone.activeDeliveries - 1;
      zone.completedToday = zone.completedToday + 1;
    }
  }
  
  if (data.priority) {
    delivery.priority = data.priority;
  }
  
  res.json({
    success: true,
    delivery: delivery,
    changed: {
      from: oldStatus,
      to: delivery.status
    }
  });
});

app.put('/drones/:droneId/battery', function(req, res) {
  const droneId = req.params.droneId;
  const data = req.body;
  
  const drone = findDrone(droneId);
  if (!drone) {
    return res.status(404).json({
      success: false,
      error: 'Drone not found: ' + droneId
    });
  }
  
  if (data.charge === undefined) {
    return res.status(400).json({
      success: false,
      error: 'Missing required field: charge'
    });
  }
  
  const oldBattery = drone.battery;
  drone.battery = Math.min(100, drone.battery + data.charge);
  
  if (drone.status === 'charging' && drone.battery >= 80) {
    drone.status = 'available';
  }
  
  res.json({
    success: true,
    drone: drone,
    changed: {
      from: oldBattery,
      to: drone.battery
    }
  });
});

// ============================================
// DELETE ENDPOINTS
// ============================================

app.delete('/deliveries/:deliveryId', function(req, res) {
  const deliveryId = req.params.deliveryId;
  
  const deliveryIndex = systemState.deliveries.findIndex(function(d) {
    return d.id === deliveryId;
  });
  
  if (deliveryIndex === -1) {
    return res.status(404).json({
      success: false,
      error: 'Delivery not found: ' + deliveryId
    });
  }
  
  const delivery = systemState.deliveries[deliveryIndex];
  
  // BUSINESS VALIDATION (per task casa)
  if (delivery.status !== 'pending') {
    return res.status(400).json({
      success: false,
      error: 'Cannot delete delivery in status: ' + delivery.status + '. Only pending deliveries can be deleted.'
    });
  }
  
  systemState.deliveries.splice(deliveryIndex, 1);
  
  res.json({
    success: true,
    message: 'Delivery ' + deliveryId + ' deleted',
    delivery: delivery
  });
});

// ============================================
// START SERVER
// ============================================

app.listen(3000, function() {
  console.log('');
  console.log('============================================');
  console.log('DRONE DELIVERY MANAGEMENT SYSTEM');
  console.log('Server running on http://localhost:3000');
  console.log('============================================');
  console.log('');
  console.log('Available endpoints:');
  console.log('  GET    /drones');
  console.log('  GET    /deliveries');
  console.log('  GET    /zones/stats');
  console.log('  POST   /deliveries');
  console.log('  POST   /drones/:droneId/assign');
  console.log('  PUT    /deliveries/:deliveryId');
  console.log('  PUT    /drones/:droneId/battery');
  console.log('  DELETE /deliveries/:deliveryId');
  console.log('');
  console.log('============================================');
});
