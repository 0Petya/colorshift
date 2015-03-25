package colorshift;

import java.awt.Color;

/**
 *	<p>
 *	This data type allows you to have the average RGB value of a Color associated with its respective RGB values. The main purpose is so that this will be sortable.
 *	</p>
 *
 *	@author Peter Tran
 */
public class ColorData implements Comparable<ColorData>
{
	private String data;

	/**
	 *	Constructs the ColorData with the Color given it. It stores the data in a String in the form of: [Average RGB, Red component, Green component, Blue component]
	 */
	public ColorData(Color color)
	{
		int average = ((color.getRed() + color.getGreen() + color.getBlue()) / 3);

		data = (average + "," + color.getRed() + "." + color.getGreen() + "/" + color.getBlue());
	}

	/**
	 *	Gets the Color of this ColorData.
	 *
	 *	@return Color of this ColorData.
	 */
	public Color getColor()
	{
		String reddata = this.data.substring(this.data.indexOf(',') + 1, this.data.indexOf('.'));
		String greendata = this.data.substring(this.data.indexOf('.') + 1, this.data.indexOf('/'));
		String bluedata = this.data.substring(this.data.indexOf('/') + 1, this.data.length());

		int red = Integer.parseInt(reddata);
		int blue = Integer.parseInt(bluedata);
		int green = Integer.parseInt(greendata);

		return new Color(red, green, blue);
	}

	/**
	 *	Compares ColorData by comparing the Average RGB of this to that.
	 */
	public int compareTo(ColorData that)
	{
		String thisdata = this.data.substring(0, this.data.indexOf(','));
		String thatdata = that.data.substring(0, that.data.indexOf(','));
		int thisnum = Integer.parseInt(thisdata);
		int thatnum = Integer.parseInt(thatdata);

		if (thisnum < thatnum)
			return -1;
		else if (thisnum > thatnum)
			return 1;
		else
			return 0;
	}
}
