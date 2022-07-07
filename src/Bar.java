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
	
	public Bar(int pHeight)
	{
		xPos = 0;
		yPos = 0;
		width = 30;
		height = pHeight;
		isFilled = true;
		color = new Color(0, 155, 255);
	}

	@Override
	public void paintComponent(Graphics pBar)
	{
		if(isFilled)
		{
			pBar.setColor(color);
			// Draw filled rectangle
			pBar.fillRoundRect(xPos, yPos, width, height, 10, 10);
			pBar.setColor(Color.white);
			// Draw outlined rectangle
			pBar.drawRoundRect(xPos, yPos, width + 1, height + 2, 12, 12);
		}
		else
		{
			pBar.setColor(Color.lightGray);
			pBar.drawRect(xPos, yPos, width, height);
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
