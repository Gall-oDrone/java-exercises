package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ByteStreamExample {

	public static void main(String[] args) {
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		
		try {
			inStream = new FileInputStream("users/diegogallovalenzeula/Downloads/hackerX-expo.html/");
			outStream = new FileOutputStream("users/diegogallovalenzeula/downloads/hackerX-expo-2.html");
			
			int content;
			while((content = inStream.read()) != -1) {
				outStream.write((byte) content);
			}
		} finally {
			if (inStream != null) {
				inStream.close();
			}
			if (outStream != null) {
				outStream.close();
			}
		}

	}

}
