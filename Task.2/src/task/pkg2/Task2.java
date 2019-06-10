package task.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Task2 {

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

        ArrayList<Shark2> sharks = new ArrayList<>();     // Create an ArrayList

        while (fileScanner.hasNext()) { // While there is still a word to fetch    
            String split_shark_data = fileScanner.nextLine();
            String[] split_shark_dataArray = split_shark_data.split(":");

            sharks.add(new Shark2(
                    split_shark_dataArray[0],
                    split_shark_dataArray[6].split(", ")));
        }
        // Create a TreeSet of String type
        TreeSet<String> al = new TreeSet<String>();

        for (int n = 0; n < sharks.size(); n++) {   // main for loop is going through all sharks in the txt file
            for (String myString : sharks.get(n).getOceanic_regions()) { //for each loop running through every shark regions
                al.add(myString.trim()); // trim remove the space because there where one region the same just with an extra space and adding to a al array
            }
        }
        for (String region : al) { // for each looop runing through an array of regions (unqie ones and ordered)
            System.out.print(region + " -> "); // print out the region
            output.print(region + " -> "); // print region to file
            TreeSet<String> sharkSet = new TreeSet<String>(); // definition of the tree set of common names
            for (Shark2 shark : sharks) { // for each loop runing through every shark in the main array
                for (String reg : shark.getOceanic_regions()) { // for each loop running through shark regions
                    if (reg.equalsIgnoreCase(region)) { // if shark region matches the main region do..
                        sharkSet.add(shark.getCommon_name()); // if matches add the common name to the set of common nammes
                    }
                }
            }
            System.out.println(sharkSet.toString()); // print out all the common names that were put into the array on the one oucasion of the loop
            output.println(sharkSet.toString()); // same thing for the file
        }

        fileScanner.close(); //Close the Scanner (Add the File)
        output.close(); //Close the result.txt

    }
}
