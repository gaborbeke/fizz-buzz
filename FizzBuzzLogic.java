package p92.fizzbuzz.com;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import org.json.JSONException;
import org.json.JSONObject;

public abstract class FizzBuzzLogic {

	/** Store the minimum value of range */
	private int minRange;

	/** Store the maximum value of range */
	private int maxRange;

	public FizzBuzzLogic(int min, int max) {
		this.minRange = min;
		this.maxRange = max;
	}

	/** Get the minimum range given by the user */
	public int getMinRange() {
		return minRange;
	}

	/** Get the maximum range given by the user */
	public int getMaxRange() {
		return maxRange;
	}

	/** Viewing the result */
	public void checkMultiples() throws JSONException {

		JSONObject obj = new JSONObject();

		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>FizzBuzz");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");

		for (int i = 1; i < 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {

				System.out.println("FizzBuzz");

				obj.put(i + ".", "FizzBuzz");

				sb.append("<br/>FizzBuzz");
			} else if (i % 3 == 0) {

				System.out.println("Fizz");
				obj.put(i + ".", "Fizz");
				sb.append("<br/>Fizz");
			} else if (i % 5 == 0) {

				System.out.println("Buzz");
				obj.put(i + ".", "Buzz");
				sb.append("<br/>Buzz");
			} else {

				System.out.println(i);
				obj.put(i + ".", "" + i);
				sb.append("<br/>"+ i);
			}
		}

		sb.append("</body>");
		sb.append("</html>");
		
		FileWriter fstream;
		try {
			fstream = new FileWriter("MyHtml.html");

			BufferedWriter out = new BufferedWriter(fstream);
			out.write(sb.toString());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		URI uri = null;
		try {
			uri = new URI("file:///home/bekeg/java/workspace/FizzBuzz/MyHtml.html");
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("\nJSON Object: ");
		

		System.out.println(obj.toString());

	}

}
