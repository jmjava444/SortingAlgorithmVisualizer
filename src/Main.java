import javax.swing.*;
import java.util.ArrayList;

public class Main
{
    /**
     * The main function creates a Main object, and it instantiates a new AppWindow object to create the GUI.
     *
     * @param args Application arguments (not used in this application).
     */
    public static void main(String[] args)
    {
        Main main = new Main();
        new AppWindow(main);
    }

    /**
     * Starts over and creates a new bar graph with randomized values for the length of the bars and
     * uses the JSpinner to input the number of bars in the array.
     *
     * @param appWindow The current AppWindow object being operated on.
     * @param numberOfBars The number of bars in the array. Typical use is to plug in the JSpinner value here.
     * @return The array of the randomized set of bars.
     */
    public ArrayList<Bar> generateNewBarGraph(AppWindow appWindow, int numberOfBars)
    {
        final int marginBetweenBars = 5;
        ArrayList<Bar> barArrayList = new ArrayList<>();
        for(int i = 0; i < numberOfBars; i++)
        {
            // Generates a new bar of random height, not exceeding the height of the JPanel it's in.
            barArrayList.add(new Bar(
                    generateRandomInt(0, appWindow.getBarPanel().getHeight()) - marginBetweenBars,
                    (appWindow.getBarPanel().getWidth() / numberOfBars) - marginBetweenBars));
        }
        return barArrayList;
    }

    /**
     * Returns a random integer between the min and max bounds (inclusive).
     *
     * @param min The minimum value the randomly generated integer could be.
     * @param max The maximum value the randomly generated integer could be.
     * @return The random integer between the bounds (inclusive).
     */
    public static int generateRandomInt(int min, int max)
    {
        return (int) (Math.round(Math.random() * (max - min)) + min);
    }
}