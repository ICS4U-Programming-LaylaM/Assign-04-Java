import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program calculates and displays an obtuse triangle's, name, perimeter,
* area and angles to the console and a text file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-05-31
*/

public class ObtuseTriangle extends Triangle {
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
    * Semiperimeter.
    */
    private double semi;

    /**
    * Angle opposite to _side1.
    */
    private double angle1;

    /**
    * Angle opposite to _side2.
    */
    private double angle2;

    /**
    * Angle opposite to _side3.
    */
    private double angle3;

    /**
    * Array of strings property.
    */
    private final List<String> strList = new ArrayList<String>();

    /**
    * Newline property.
    */
    private final String newLine = "\n";

    /**
    * Output path property.
    */
    private final String outputPath = "/home/runner/Assign-04-Java/output.txt";

    /**
    * Separates each triangle.
    */
    private final String separator = "---\n";

    /**
    * Used to round the values to 2 decimal places.
    */
    private final double hundred = 100.0;

    /**
    * Constructor.
    *
    * @param side1 as double
    * @param side2 as double
    * @param side3 as double
    */
    public ObtuseTriangle(double side1, double side2, double side3) {
        super(side1, side2, side3);
        _side1 = Double.valueOf(side1);
        _side2 = Double.valueOf(side2);
        _side3 = Double.valueOf(side3);
    }

    /**
    * Displays the name/type of the triangle.
    */
    public void getName() {
        // Checks if the obtuse triangle is isosceles
        if (_side1 == _side2 || _side2 == _side3 || _side3 == _side1) {
            final String obtuseAngleStr = "This is an isosceles obtuse "
                + "angle triangle.";

            System.out.println(obtuseAngleStr + newLine);

            try {
                // Build a string containing that string
                final StringBuilder builder = new StringBuilder();
                builder.append(obtuseAngleStr);
                builder.append(newLine);

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
        // Otherwise the obtuse triangle is scalene
        } else {
            final String obtuseAngleStr = "This is a scalene "
                + "obtuse angle triangle.";

            System.out.println(obtuseAngleStr + newLine);

            try {
                // Build a string containing that string
                final StringBuilder builder = new StringBuilder();
                builder.append(obtuseAngleStr);
                builder.append(newLine);

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

    /**
    * Calculates and displays the triangle's perimeter.
    */
    public void getPerimeter() {
        final double perimeter = _side1 + _side2 + _side3;
        final double roundPerimeter = Math.round(perimeter * hundred) / hundred;
        final String perimeterStr = "The perimeter is: "
            + roundPerimeter + " units.";

        System.out.println(perimeterStr + newLine);

        semi = perimeter / 2;

        try {
            // Build a string containing that string
            final StringBuilder builder = new StringBuilder();
            builder.append(perimeterStr);
            builder.append(newLine);

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

    /**
    * Calculates and displays the triangle's area.
    */
    public void getArea() {
        final double area = Math.sqrt(semi * (semi - _side1)
                * (semi - _side2) * (semi - _side3));
        final double roundArea = Math.round(area * hundred) / hundred;
        final String areaStr = "The area is: " + roundArea + " units^2.";

        System.out.println(areaStr + newLine);

        try {
            // Build a string containing that string
            final StringBuilder builder = new StringBuilder();
            builder.append(areaStr);
            builder.append(newLine);

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

    /**
    * Calculates and displays the triangle's angles.
    */
    public void getAngles() {
        // Part of the cosine law
        final double formula1 = (Math.pow(_side2, 2)
                + Math.pow(_side3, 2) - Math.pow(_side1, 2))
                / (2 * _side2 * _side3);
        final double formula2 = (Math.pow(_side1, 2)
                + Math.pow(_side3, 2) - Math.pow(_side2, 2))
                / (2 * _side1 * _side3);
        final double formula3 = (Math.pow(_side2, 2)
                + Math.pow(_side1, 2) - Math.pow(_side3, 2))
                / (2 * _side2 * _side1);

        // Angles rounded to 2 decimals
        angle1 = Math.toDegrees(Math.acos(formula1));
        final double roundOff1 = Math.round(angle1 * hundred) / hundred;

        angle2 = Math.toDegrees(Math.acos(formula2));
        final double roundOff2 = Math.round(angle2 * hundred) / hundred;

        angle3 = Math.toDegrees(Math.acos(formula3));
        final double roundOff3 = Math.round(angle3 * hundred) / hundred;

        final String angle1Str = "Angle between sides " + _side2
            + " and " + _side3 + " is " + roundOff1 + " degrees.";
        System.out.println(angle1Str);

        final String angle2Str = "Angle between sides " + _side3
            + " and " + _side1 + " is " + roundOff2 + " degrees.";
        System.out.println(angle2Str);

        final String angle3Str = "Angle between sides " + _side2
            + " and " + _side1 + " is " + roundOff3 + " degrees.\n";
        System.out.println(angle3Str + newLine + separator);

        strList.add(angle1Str);
        strList.add(angle2Str);
        strList.add(angle3Str);

        try {
            // Build a string containing the elements
            // of the list
            final StringBuilder builder = new StringBuilder();
            for (int counter = 0; counter < strList.size(); counter++) {
                builder.append(strList.get(counter));
                builder.append(newLine);
            }

            // Separator between each triangle
            builder.append(separator);

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
