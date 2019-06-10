package task.pkg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {

        String fileLocation = System.getProperty("user.dir");  // Get directory path
        String dataPath = fileLocation + File.separator + "shark-data.txt"; // Generate file path

        java.io.File fileSave = new java.io.File("results.txt");    
        java.io.PrintWriter output = new java.io.PrintWriter(fileSave);     // Create PrintWriter

        Scanner fileScanner = null;    // Initialise Scanner
        File inputFile = new File(dataPath);  // Creating a File object to represent the "shark_data.txt"
        try {
            fileScanner = new Scanner(inputFile);
            fileScanner.useDelimiter("\\n");  // Set a new pattern to detect any new linefeed character and use it as a file delimiter 
        } catch (FileNotFoundException e) {
            System.out.print("Error: File Not Found");
            System.exit(0); //Quit
        }

        ArrayList<Shark1> sharks = new ArrayList<>();     // Create an ArrayList

        while (fileScanner.hasNext()) { // While there is still a word to fetch    
            String split_shark_data = fileScanner.nextLine();
            String[] split_shark_dataArray = split_shark_data.split(":"); // Split data in txt file 

            sharks.add(new Shark1(
                    split_shark_dataArray[0],
                    split_shark_dataArray[1],
                    Double.parseDouble(split_shark_dataArray[2])
            ));

        }

        sharks.sort(Comparator.comparing(Shark1::getMax_length));   // Create comparator

        // Get 3 Largest Sharks
        System.out.println("  ---  Three Largest Sharks  ---");
        output.println("  ---  Three Largest Sharks  ---");

        System.out.println(sharks.get(sharks.size() - 1).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 1).getMax_length() + " centimeters.");
        output.println(sharks.get(sharks.size() - 1).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 1).getMax_length() + " centimeters.");
        System.out.println(sharks.get(sharks.size() - 2).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 2).getMax_length() + " centimeters.");
        output.println(sharks.get(sharks.size() - 2).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 2).getMax_length() + " centimeters.");
        System.out.println(sharks.get(sharks.size() - 3).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 3).getMax_length() + " centimeters.");
        output.println(sharks.get(sharks.size() - 3).getCommon_name()
                + ", Length = " + sharks.get(sharks.size() - 3).getMax_length() + " centimeters.");

        System.out.println("  -------------------------------------------------");
        output.println("  -------------------------------------------------");

        // Get 3 Smallest Sharks
        System.out.println("  ---  Three Smallest Sharks  ---");
        output.println("  ---  Three Smallest Sharks  ---");

        System.out.println(sharks.get(0).getCommon_name()
                + ", Length = " + sharks.get(0).getMax_length() + " centimeters.");
        output.println(sharks.get(0).getCommon_name()
                + ", Length = " + sharks.get(0).getMax_length() + " centimeters.");
        System.out.println(sharks.get(1).getCommon_name()
                + ", Length = " + sharks.get(1).getMax_length() + " centimeters.");
        output.println(sharks.get(1).getCommon_name()
                + ", Length = " + sharks.get(1).getMax_length() + " centimeters.");
        System.out.println(sharks.get(2).getCommon_name()
                + ", Length = " + sharks.get(2).getMax_length() + " centimeters.");
        output.println(sharks.get(2).getCommon_name()
                + ", Length = " + sharks.get(2).getMax_length() + " centimeters.");

        System.out.println("  -------------------------------------------------");
        output.println("  -------------------------------------------------");

        // Get total number of letters in all Latin names
        int total = 0;
        for (int i = 0; i < sharks.size(); i++) {
            total = total + sharks.get(i).getLatin_name().replace(" ", "").length(); // replacing the empty space 
        }
        System.out.println("Total number of letters in all Latin names = " + total);
        output.println("Total number of letters in all Latin names = " + total);

        // Remove duplicated words
        HashSet<String> uniqueWords = new HashSet<String>();

        for (int n = 0; n < sharks.size(); n++) {
            for (String myString : sharks.get(n).getLatin_name().split(" ")) {
                uniqueWords.add(myString);
            }
        }

        int even = 0;
        int odd = 0;

        for (String word : uniqueWords) {
            if (word.length() % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        // Get total number of unique even words in all Latin names
        System.out.println("Total number of unique even words in all Latin names = " + even);
        output.println("Total number of unique even words in all Latin names = " + even);

        // Get total number of unique odd words in all Latin names
        System.out.println("Total number of unique odd words in all Latin names = " + odd);
        output.println("Total number of unique odd words in all Latin names = " + odd);

        fileScanner.close(); //Close the Scanner (Add the File)
        output.close(); //Close the result.txt

    }

}
