package dino.http.test;

import dino.http.HttpRequest;

public class HttpRequestTest {
	public static void main(String[] argus){
		int response = HttpRequest.get("http://googleereddvdrererfe.com").code();
		System.out.println(response);
		String response1 = HttpRequest.get("http://google.com1").body();
		System.out.println("Response was: " + response1);
	}
}
