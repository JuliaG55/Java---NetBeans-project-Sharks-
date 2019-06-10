package task.pkg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        String fileLocation = System.getProperty("user.dir");  // Get directory path
        String dataPath = fileLocation + File.separator + "shark-data.txt"; // Generate file path

        Scanner fileScanner = null;    // Initialise Scanner
        File inputFile = new File(dataPath);  // Creating a File object to represent the "shark_data.txt"
        try {
            fileScanner = new Scanner(inputFile);
            fileScanner.useDelimiter("\\n");  // Set a new pattern to detect any new linefeed character and use it as a file delimiter 
        } catch (FileNotFoundException e) {
            System.out.print("Error: File Not Found");
            System.exit(0); //Quit
        }

        ArrayList<Shark3> sharks = new ArrayList<>();     // Create an ArrayList

        while (fileScanner.hasNext()) { // While there is still a word to fetch    
            String split_shark_data = fileScanner.nextLine();
            String[] split_shark_dataArray = split_shark_data.split(":");

            sharks.add(new Shark3(
                    split_shark_dataArray[0],
                    split_shark_dataArray[1])
            );

        }

        Scanner input = new Scanner(System.in); // Input Scanner 

        // Prompt the user to enter the search string for Latin names
        System.out.print("Enter search string for Latin names: > ");

        String word = input.next();
        word = word.toLowerCase();
        
        // Show on the console the user output
        System.out.println("You entered string: " + word);

        // Show what matches have been found 
        System.out.println("");
        System.out.println("The following matches have been found : - ");
        
        for (int n = 0; n < sharks.size(); n++) {   // main for loop is going through all sharks in the txt file
            String l_name = sharks.get(n).getLatin_name();

            String temp = l_name;       // set String temporary to lower case letters
            l_name = l_name.toLowerCase();  

            String Capital = word.toUpperCase();
            if (l_name.contains(word)) {
                l_name = l_name.replaceAll(word, Capital);

                if (temp.charAt(0) >= 65 && temp.charAt(0) <= 90) {  //Convert char into int (type casting)
                    l_name = temp.charAt(0) + l_name.substring(1);
                }
                System.out.println(sharks.get(n).getCommon_name() + " : " + l_name);

            }

        }

        fileScanner.close(); //Close the Scanner (Add the File)

    }

}
