/**
 * This class helps by reducing the amount of text when calling for the screen dimensions.
 */

import java.awt.*;

public abstract class Screen
{
    public static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = dimension.width;
    public static final int height = dimension.height;
}
