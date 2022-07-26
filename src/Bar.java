import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Bar extends JComponent
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private boolean isFilled;
	private Color color;

	public Bar()
	{
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
		isFilled = true;
		color = new Color(0, 155, 255);
	}
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
	public void paintComponent(Graphics g)
	{
		if(isFilled)
		{
			g.setClip(xPos, yPos, width + 10, getParent().getHeight());
			g.setColor(color);
			// Draw filled rectangle
			g.fillRoundRect(xPos, yPos, width, height, 14, 14);
			g.setColor(Color.lightGray);
			// Draw outlined rectangle
			g.drawRoundRect(xPos, yPos, width, height, 14, 14);
		}
		else
		{
			g.setColor(Color.lightGray);
			g.drawRect(xPos, yPos, width, height);
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

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Bar bar = (Bar) o;
		return getxPos() == bar.getxPos() && getyPos() == bar.getyPos() && getWidth() == bar.getWidth() && getHeight() == bar.getHeight() && isFilled == bar.isFilled && Objects.equals(
				getColor(), bar.getColor());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getxPos(), getyPos(), getWidth(), getHeight(), isFilled, getColor());
	}
}
