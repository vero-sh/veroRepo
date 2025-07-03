public partial class MainWindow : Window
{
    public MainWindow(
        ProcessManager processManager,
        MemoryScanner memoryScanner,
        NetworkMonitor networkMonitor)
    {
        InitializeComponent();
        
        // Usa le istanze qui
        processManager.GetAllProcesses().ForEach(p => Console.WriteLine(p.Name));
    }
}