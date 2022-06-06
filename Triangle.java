import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program checks if the sides for the triangle make a valid triangle,
* if so then it checks what type of triangle it is and creates an object
* of it.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-31
*/

public class Triangle {
    /**
    * Sides do not make a triangle.
    */
    private static final String INVALID = "Not a valid triangle.\n";

    /**
    * Separates each triangle.
    */
    private static final String SEPARATOR = "\n---\n";

    /**
    * Triangle side 1.
    */
    private double _side1;

    /**
    * Triangle side 2.
    */
    private double _side2;

    /**
    * Triangle side 3.
    */
    private double _side3;

    /**
    * Newline property.
    */
    private final String newLine = "\n";

    /**
    * Output path property.
    */
    private final String outputPath = "/home/runner/Assign-04-Java/output.txt";

    /**
    * Constructor.
    *
    * @param side1 as double
    * @param side2 as double
    * @param side3 as double
    */
    public Triangle(double side1, double side2, double side3) {
        _side1 = side1;
        _side2 = side2;
        _side3 = side3;
    }

    /**
    * This method verifies if the side lengths entered make a triangle or not.
    *
    * @throws IOException if no file is passed in.
    */
    public void isTriangle() {
        if (_side1 < (_side2 + _side3) && _side2
            < (_side1 + _side3) && _side3 < (_side2 + _side1)) {
            // From https://www.javatpoint.com/java-program-to-find-
            // largest-of-three-numbers
            final double largest = _side3 > (_side1 > _side2
                ? _side1 : _side2) ? _side3 : ((_side1 > _side2)
                ? _side1 : _side2);

            final double largestSquared = largest * largest;

            if (largest == _side1) {
                if (largestSquared == Math.pow(_side2, 2)
                    + Math.pow(_side3, 2)) {

                    // Creating right triangle object
                    final RightTriangle rightTriangle = new
                        RightTriangle(_side1, _side2, _side3);

                    rightTriangle.getName();
                    rightTriangle.getPerimeter();
                    rightTriangle.getArea();
                    rightTriangle.getAngles();
                } else if (largestSquared < Math.pow(_side2, 2)
                           + Math.pow(_side3, 2)) {

                    // Creating acute triangle object
                    final AcuteTriangle acuteTriangle = new
                        AcuteTriangle(_side1, _side2, _side3);

                    acuteTriangle.getName();
                    acuteTriangle.getPerimeter();
                    acuteTriangle.getArea();
                    acuteTriangle.getAngles();
                } else if (largestSquared > Math.pow(_side2, 2)
                           + Math.pow(_side3, 2)) {

                    // Creating obtuse triangle object
                    final ObtuseTriangle obtuseTriangle = new
                        ObtuseTriangle(_side1, _side2, _side3);

                    obtuseTriangle.getName();
                    obtuseTriangle.getPerimeter();
                    obtuseTriangle.getArea();
                    obtuseTriangle.getAngles();
                } else {
                    System.out.println(INVALID + SEPARATOR);

                    try {
                        // Build a string containing that string
                        final StringBuilder builder = new StringBuilder();
                        builder.append(INVALID);
                        builder.append(newLine);

                        // Create new file called "output.txt"
                        final FileWriter fileWriter = new
                            FileWriter(outputPath, true);

                        // Add the string to the output.txt file
                        final BufferedWriter writer = new
                            BufferedWriter(fileWriter);
                        writer.append(builder.toString());
                        writer.append(newLine);
                        writer.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            } else if (largest == _side2) {
                if (largestSquared == Math.pow(_side1, 2)
                    + Math.pow(_side3, 2)) {

                    // Creating right triangle object
                    final RightTriangle rightTriangle = new
                        RightTriangle(_side1, _side2, _side3);

                    rightTriangle.getName();
                    rightTriangle.getPerimeter();
                    rightTriangle.getArea();
                    rightTriangle.getAngles();
                } else if (largestSquared < Math.pow(_side1, 2)
                           + Math.pow(_side3, 2)) {

                    // Creating acute triangle object
                    final AcuteTriangle acuteTriangle = new
                        AcuteTriangle(_side1, _side2, _side3);

                    acuteTriangle.getName();
                    acuteTriangle.getPerimeter();
                    acuteTriangle.getArea();
                    acuteTriangle.getAngles();
                } else if (largestSquared > Math.pow(_side1, 2)
                           + Math.pow(_side3, 2)) {

                    // Creating obtuse triangle object
                    final ObtuseTriangle obtuseTriangle = new
                        ObtuseTriangle(_side1, _side2, _side3);

                    obtuseTriangle.getName();
                    obtuseTriangle.getPerimeter();
                    obtuseTriangle.getArea();
                    obtuseTriangle.getAngles();
                } else {
                    System.out.println(INVALID + SEPARATOR);

                    try {
                        // Build a string containing that string
                        final StringBuilder builder = new StringBuilder();
                        builder.append(INVALID);
                        builder.append(newLine);

                        // Create new file called "output.txt"
                        final FileWriter fileWriter = new
                            FileWriter(outputPath, true);

                        // Add the string to the output.txt file
                        final BufferedWriter writer = new
                            BufferedWriter(fileWriter);
                        writer.append(builder.toString());
                        writer.append(newLine);
                        writer.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            } else if (largest == _side3) {
                if (largestSquared == Math.pow(_side1, 2)
                    + Math.pow(_side2, 2)) {

                    // Creating right triangle object
                    final RightTriangle rightTriangle = new
                        RightTriangle(_side1, _side2, _side3);

                    rightTriangle.getName();
                    rightTriangle.getPerimeter();
                    rightTriangle.getArea();
                    rightTriangle.getAngles();
                } else if (largestSquared < Math.pow(_side1, 2)
                           + Math.pow(_side1, 2)) {

                    // Creating acute triangle object
                    final AcuteTriangle acuteTriangle = new
                        AcuteTriangle(_side1, _side2, _side3);

                    acuteTriangle.getName();
                    acuteTriangle.getPerimeter();
                    acuteTriangle.getArea();
                    acuteTriangle.getAngles();
                } else if (largestSquared > Math.pow(_side1, 2)
                           + Math.pow(_side1, 2)) {

                    // Creating obtuse triangle object
                    final ObtuseTriangle obtuseTriangle = new
                        ObtuseTriangle(_side1, _side2, _side3);

                    obtuseTriangle.getName();
                    obtuseTriangle.getPerimeter();
                    obtuseTriangle.getArea();
                    obtuseTriangle.getAngles();
                } else {
                    System.out.println(INVALID + SEPARATOR);

                    try {
                        // Build a string containing that string
                        final StringBuilder builder = new StringBuilder();
                        builder.append(INVALID);
                        builder.append(newLine);

                        // Create new file called "output.txt"
                        final FileWriter fileWriter = new
                            FileWriter(outputPath, true);

                        // Add the string to the output.txt file
                        final BufferedWriter writer = new
                            BufferedWriter(fileWriter);
                        writer.append(builder.toString());
                        writer.append(newLine);
                        writer.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println(INVALID + SEPARATOR);

            try {
                // Build a string containing that string
                final StringBuilder builder = new StringBuilder();
                builder.append(INVALID);
                builder.append(SEPARATOR);

                // Create new file called "output.txt"
                final FileWriter fileWriter = new FileWriter(outputPath, true);

                // Add the string to the output.txt file
                final BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.append(builder.toString());
                writer.append(newLine);
                writer.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
