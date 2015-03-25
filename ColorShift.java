package colorshift;

import java.awt.Color;

/**
 *	<p>
 *	ColorShift analyzes a Picture, sorting all the pixels in the Picture by their respective average RGB values.
 *	</p>
 *
 *	<img src="../../resources/starrynight.jpg" width = "250" height = "250">
 *	<img src="../../resources/starrynightShift.jpg" width = "250" height = "250">
 *
 *	@author Peter Tran
 */
public class ColorShift
{
	public static void main(String[] args)
	{
		// take in the Picture File as a command line argument
		// get the width and height
		Picture og = new Picture(args[0]);
		int width = og.width();
		int height = og.height();

		// create a new Picture with that width and height
		Picture ng = new Picture(width, height);

		// create an array of ColorDatas for each pixel in the image
		ColorData[] data = new ColorData[width * height];
		int count = 0;

		// populate that array with the ColorData gathered from the
		// individual pixels
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				data[count] = new ColorData(og.get(i,j));
				count++;
			}
		}

		// sort the array with merge sort
		// this will sort the ColorData to ascending order
		// based on average RGB value
		Merge.sort(data);

		// now set pixels in the new Picture to the color
		// based on its average RGB value
		count = 0;
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				ng.set(i, j, data[count].getColor());
				count++;
			}
		}

		// save it to a new File
		String name = args[0].substring(0, args[0].indexOf('.'));
		String extension = args[0].substring(args[0].indexOf('.'), args[0].length());

		ng.save(name + "Shift" + extension);
	}
}
