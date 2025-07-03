import sys
from PyQt5.QtWidgets import (QApplication, QMainWindow, QTableWidget, 
                             QTableWidgetItem, QVBoxLayout, QWidget)
import psutil  # Per monitorare i processi

class TaskManager(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Task Manager Light")
        self.setGeometry(100, 100, 800, 600)
        
        # Tabella processi
        self.table = QTableWidget()
        self.table.setColumnCount(4)
        self.table.setHorizontalHeaderLabels(["PID", "Nome", "CPU %", "Memoria (MB)"])
        
        # Layout
        layout = QVBoxLayout()
        layout.addWidget(self.table)
        
        container = QWidget()
        container.setLayout(layout)
        self.setCentralWidget(container)
        
        self.update_process_list()
        
    def update_process_list(self):
        self.table.setRowCount(0)
        for proc in psutil.process_iter(['pid', 'name', 'cpu_percent', 'memory_info']):
            row = self.table.rowCount()
            self.table.insertRow(row)
            self.table.setItem(row, 0, QTableWidgetItem(str(proc.info['pid'])))
            self.table.setItem(row, 1, QTableWidgetItem(proc.info['name']))
            self.table.setItem(row, 2, QTableWidgetItem(f"{proc.info['cpu_percent']:.1f}"))
            self.table.setItem(row, 3, QTableWidgetItem(f"{proc.info['memory_info'].rss / 1024 / 1024:.1f}"))

if __name__ == "__main__":
    app = QApplication(sys.argv)
    window = TaskManager()
    window.show()
    sys.exit(app.exec_())