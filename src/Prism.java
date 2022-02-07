/**
 * This class represents a prism object
 *
 * @author Michael Miller
 */
public class Prism
{
    /** The length of the Prism */
    private int length;

    /** The width of the Prism */
    private int width;

    /** The height of the Prism */
    private int height;

    /** A sample public instance variable for demo purposes */
    public int somePublicField;

    /**
     * Instantiates a Prism object.
     *
     * @param length The length
     * @param width The width
     * @param height The height
     */
    public Prism(int length, int width, int height)
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Static method that returns the volume of a prism with any three dimensions
     * <p>
     * PRECONDITION: all side lengths are positive numbers
     *
     * @param side1 Side 1 length
     * @param side2 Side 2 length
     * @param side3 Side 3 length
     * @return The volume of a prism with side lengths side1, side2, and side3
     */
    public static int volume(int side1, int side2, int side3) {
        return side1 * side2 * side3;
    }

    /**
     * Returns the current length of the prism.
     *
     * @return The length of the prism
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the length of the prism to a new value.
     *
     * @param newLength The new length of the prism
     */
    public void setLength(int newLength)
    {
        length = newLength;
    }

    /**
     * Returns the volume of the prism, calculated
     * by multiplying length, width, and height
     *
     * @return The volume of the prism
     */
    public int volume()
    {
        return length * width * height;
    }

    /**
     * Returns the surface area of the prism.
     * <p>
     * The surface area is calculated by adding up the areas of the sides.
     * If openTop is false, surface area is the sum of all six sides;
     * if openTop is true, surface area is the sum of 5 sides, excluding
     * the "top" of the box, which is represented by length and width
     *
     * @param openTop whether to include the "top" in the surface area calculation
     * @return The surface area of the prism
     */
    public int surfaceArea(boolean openTop)
    {
        int topBottom = area(length, width);
        int leftRight = area(width, height);
        int frontBack = area(length, height);
        int surfaceArea = 2 * leftRight + 2 * frontBack + topBottom;
        if (!openTop)
        {
            surfaceArea += topBottom;
        }
        return surfaceArea;
    }

    /**
     * Private helper method that calculates area of a rectangle with two side lengths
     *
     * @param side1 The first side
     * @param side2 The second side
     * @return The area of the rectangle with side lengths side1 and side
     */
    private int area(int side1, int side2)
    {
        return side1 * side2;
    }

    /**
     * Returns a String that includes values
     * of the three instance variables (the object state)
     *
     * @return  String representation of the object's state
     */
    public String toString()
    {
        return "Length = " + length + ", Width = " + width + ", Height = " + height;
    }
}
