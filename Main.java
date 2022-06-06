import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* This program creates a triangle object by verifying if the inputted values
* are valid numbers.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-31
*/

final class Main {
    /**
    * Array of vehicle info.
    */
    private static String[] triangleSidesArray;

    /**
    * Output path.
    */
    private static final String OUTPUTPATH = "/home/"
        + "runner/Assign-04-Java/output.txt";

    /**
    * Newline property.
    */
    private static final String NEWLINE = "\n";

    /**
    * Invalid side length string.
    */
    private static final String INVALID = "Not a valid triangle.\n";

    /**
    * Default constructor.
    */
    private Main() { }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    * @throws IOException if no file is passed in
    */
    public static void main(String[] args)
            throws IOException {
        // Declaring variables
        double userSide1Double;
        double userSide2Double;
        double userSide3Double;

        // Create list to get the strings
        final List<String> listTriangleSides =
            new ArrayList<String>();

        BufferedReader buffer = null;
        try {
            // Check if there are some arguments
            if (null != args[0]
                // Length > 4 because a.txt will be shortest filename
                && args[0].length() > 4
                // Check if arguments have the correct file extension
                && args[0].endsWith(".txt")) {
                buffer = new BufferedReader(new FileReader(args[0]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String line = buffer.readLine();

        // Add file elements to list
        while (line != null) {
            listTriangleSides.add(line);
            line = buffer.readLine();
        }

        // Create array of vehicle info of the size of the list
        triangleSidesArray = listTriangleSides.toArray(new String[0]);

        for (int counter = 0; counter < triangleSidesArray.length; counter++) {
            final List<String> list = new ArrayList<String>(Arrays.asList(
                triangleSidesArray[counter].split(" ")));

            secondloop: for (int counter2 = 0; counter2
                < list.size(); counter2++) {
                try {
                    final double userSides =
                        Double.parseDouble(list.get(counter2));

                    System.out.println("***" + userSides);
                    if (userSides < 1) {
                        System.out.println(INVALID);

                        try {
                            // Build a string containing that string
                            final StringBuilder builder = new StringBuilder();
                            builder.append(INVALID);
                            builder.append(NEWLINE);

                            // Create new file called "output.txt"
                            final FileWriter fileWriter = new
                                FileWriter(OUTPUTPATH, true);

                            // Add the string to the output.txt file
                            final BufferedWriter writer = new
                                BufferedWriter(fileWriter);
                            writer.append(builder.toString());
                            writer.append(NEWLINE);
                            writer.close();
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                    break secondloop;

                } catch (NumberFormatException ex) {
                    System.out.println(INVALID);

                    try {
                        // Build a string containing that string
                        final StringBuilder builder = new StringBuilder();
                        builder.append(INVALID);
                        builder.append(NEWLINE);

                        // Create new file called "output.txt"
                        final FileWriter fileWriter = new
                            FileWriter(OUTPUTPATH, true);

                        // Add the string to the output.txt file
                        final BufferedWriter writer = new
                            BufferedWriter(fileWriter);
                        writer.append(builder.toString());
                        writer.append(NEWLINE);
                        writer.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }

            userSide1Double = Double.valueOf(list.get(0));
            userSide2Double = Double.valueOf(list.get(1));
            userSide3Double = Double.valueOf(list.get(2));

            // Creating object
            final Triangle myTriangle = new Triangle(userSide1Double,
                userSide2Double, userSide3Double);

            myTriangle.isTriangle();
        }
    }
}
