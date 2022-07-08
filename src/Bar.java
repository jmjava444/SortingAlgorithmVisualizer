import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Bar extends JComponent
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private boolean isFilled;
	private Color color;
	
	public Bar(int pHeight, int pWidth)
	{
		xPos = 0;
		yPos = 0;
		width = pWidth;
		height = pHeight;
		isFilled = true;
		color = new Color(0, 155, 255);
	}

	@Override
	public void paintComponent(Graphics bar)
	{
		if(isFilled)
		{
			bar.setColor(color);
			// Draw filled rectangle
			bar.fillRoundRect(xPos, yPos, width, height, 10, 10);
			bar.setColor(Color.white);
			// Draw outlined rectangle
			bar.drawRoundRect(xPos, yPos, width + 1, height + 2, 12, 12);
		}
		else
		{
			bar.setColor(Color.lightGray);
			bar.drawRect(xPos, yPos, width, height);
		}
	}
	
	@Override
	public String toString()
	{
		return "Bar{" +
		       "xPos=" + xPos +
		       ", yPos=" + yPos +
		       ", width=" + width +
		       ", height=" + height +
		       ", isFilled=" + isFilled +
		       ", color=" + color +
		       '}';
	}
	
	public int getxPos()
	{
		return xPos;
	}
	
	public void setxPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public int getyPos()
	{
		return yPos;
	}
	
	public void setyPos(int yPos)
	{
		this.yPos = yPos;
	}
	
	@Override
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	@Override
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public boolean getIsFilled()
	{
		return isFilled;
	}
	
	public void setIsFilled(boolean isFilled)
	{
		this.isFilled = isFilled;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
}
