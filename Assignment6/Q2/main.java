import java.io.*;
public class LogFileProcessor {
    public static void main(String[] args) {
        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;
        try (
            BufferedReader br = new BufferedReader(new FileReader("application.log"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("filtered.log"))
        ){
            String line;
            bw.write("Filtered Log Entries (ERROR and WARNING)");
            bw.newLine();
            bw.write("----------------------------------------");
            bw.newLine();
            while ((line = br.readLine()) != null) {
                totalEntries++;
                if (line.contains("ERROR")) {
                    errorCount++;
                    bw.write(line);
                    bw.newLine();
                }
                else if (line.contains("WARNING")) {
                    warningCount++;
                    bw.write(line);
                    bw.newLine();
                }
            }
            System.out.println("Log File Processing Completed!");
            System.out.println("Total Log Entries: " + totalEntries);
            System.out.println("ERROR Entries: " + errorCount);
            System.out.println("WARNING Entries: " + warningCount);
            System.out.println("Filtered Entries: " + (errorCount + warningCount));
            System.out.println("Results saved in filtered.log");
        }
        catch (FileNotFoundException e) {
            System.out.println("Log file not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
