import java.io.*;
import java.util.*;

public class DataCleaner {
    public static void main(String[] args) {
        String inputPath = "../data/employees.csv";
        String outputPath = "../output/cleaned_java.csv";
        
        // Use a Set to store unique lines (removes duplicates automatically)
        Set<String> uniqueLines = new LinkedHashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma to check specific columns
                String[] columns = line.split(",");
                
                // DATA CLEANING LOGIC:
                // 1. Skip if the row is missing 'Salary' (column 7 for example)
                if (columns.length < 7 || columns[6].trim().isEmpty()) {
                    continue; 
                }
                
                // 3. TRANSFORM: Make Department (Index 5) Uppercase
                if (columns.length > 6) {
                    columns[5] = columns[5].toUpperCase();
                }

                // Rebuild the line string after transformation
                String cleanedLine = String.join(",", columns);
                uniqueLines.add(cleanedLine);
            }
            
            // Write the cleaned data to a new file
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));
            for (String uniqueLine : uniqueLines) {
                bw.write(uniqueLine);
                bw.newLine();
            }
            bw.close();
            System.out.println("Java Cleaning Complete!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}