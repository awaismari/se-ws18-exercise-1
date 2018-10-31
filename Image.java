


/*
 * Submitted by Awais Mari (119456) & Afshin Ghasemi (120521)
 * 	
 */

import java.io.FileOutputStream;
import java.io.IOException;

public class Image
{
	public static int width;
	public static int height;
	public static byte  [] data;
	static int index;
	static String hexVal = "0x";
	
	public Image(int width, int height) {
		Image.width = width;
		Image.height = height;
		data = new byte[3*height*width];
			
	}
public static void set(int x, int y, int val) {
		String st = hexVal + Integer.toHexString(val) ;
		System.out.println(st);
		index = (y*width+x)*3;
		int count=0; 
		int sub1=2; 
		int sub2=4;
		//https://stackoverflow.com/questions/28667777/how-to-create-valid-image-from-rgb-pixel-values-using-java
		//setting up the pixel position
				while (count <= 2 )
				 {
					String substr = st.substring(sub1, sub2);
					data [index + count] = (byte) Integer.parseInt(substr, 16);			//https://www.javamex.com/tutorials/conversion/decimal_hexadecimal.shtml
					count++;
					sub1 = sub2;
					sub2 +=2;
				}
	
}
public void write(String filename) throws IOException {
	
	FileOutputStream out = new FileOutputStream(filename);
	byte[] header = ("P3\n" + width + "\n" + height + "\n255\n").getBytes();
	out.write(header);
	out.write(data);
	out.close();
}
}
