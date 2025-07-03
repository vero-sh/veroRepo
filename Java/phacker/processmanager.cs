using System.Diagnostics;
using System.Runtime.InteropServices;

public class ProcessManager
{
    [DllImport("ntdll.dll")]
    private static extern int NtQuerySystemInformation(int infoClass, IntPtr buffer, int bufSize, ref int retLen);

    public static List<ProcessInfo> GetAllProcesses()
    {
        var processes = new List<ProcessInfo>();
        int size = 0;
        NtQuerySystemInformation(5, IntPtr.Zero, 0, ref size); // SystemProcessInformation

        IntPtr buffer = Marshal.AllocHGlobal(size);
        NtQuerySystemInformation(5, buffer, size, ref size);

        // Parsing della struttura SYSTEM_PROCESS_INFORMATION
        // ... (implementazione complessa)

        Marshal.FreeHGlobal(buffer);
        return processes;
    }
    
}

public record ProcessInfo(int Pid, string Name, string Owner, DateTime StartTime);