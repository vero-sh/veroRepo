using System.Windows;

public partial class App : Application
{
    protected override void OnStartup(StartupEventArgs e)
    {
        base.OnStartup(e);
        
        // Inizializza le dipendenze
        var processManager = new ProcessManager();
        var memoryScanner = new MemoryScanner();
        var networkMonitor = new NetworkMonitor();
        
        // Crea e mostra la finestra principale
        var mainWindow = new MainWindow(processManager, memoryScanner, networkMonitor);
        mainWindow.Show();
    }
}