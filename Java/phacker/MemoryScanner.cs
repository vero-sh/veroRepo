public unsafe class MemoryScanner {
    [DllImport("kernel32.dll")]
    public static extern bool ReadProcessMemory(IntPtr hProcess, IntPtr lpBaseAddress, byte[] lpBuffer, int dwSize, out int lpNumberOfBytesRead);

    public byte[] ScanMemory(IntPtr processHandle, IntPtr baseAddress, int size) {
        byte[] buffer = new byte[size];
        ReadProcessMemory(processHandle, baseAddress, buffer, size, out _);
        return buffer;
    }
}