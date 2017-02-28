package p92.fizzbuzz.com;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;

public class Main {

	public static void main(String[] args) throws JSONException{
		FizzBuzz fb = new FizzBuzz(1, 100);
		fb.checkMultiples();

	}

}
