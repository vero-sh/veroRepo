using SharpPcap;

public class NetworkMonitor {
    public void StartMonitoring() {
        var devices = CaptureDeviceList.Instance;
        foreach (var dev in devices) {
            dev.OnPacketArrival += (s, e) => {
                var packet = PacketDotNet.Packet.ParsePacket(e.Packet.LinkLayerType, e.Packet.Data);
                var tcpPacket = packet.Extract<PacketDotNet.TcpPacket>();
                if (tcpPacket != null) {
                    // Analisi traffico TCP
                }
            };
            dev.Open(DeviceMode.Promiscuous);
            dev.StartCapture();
        }
    }
}