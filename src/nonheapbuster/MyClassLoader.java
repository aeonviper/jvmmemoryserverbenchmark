package nonheapbuster;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyClassLoader extends ClassLoader {

	public Class findClass(String name, String filename) {
		FileInputStream inFile = null;
		try {
			inFile = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] classBytes = null;
		try {
			classBytes = new byte[inFile.available()];
			inFile.read(classBytes);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return defineClass(name, classBytes, 0, classBytes.length);
	}
	
	private byte[] loadClassDataOld(String name, String filename) {
		int b;
		List<Byte> byteList = new ArrayList<Byte>();
		byte[] bytes;
		InputStream inputStream = null;
		BufferedInputStream bufferedInputStream = null;
		FileInputStream fileInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(fileInputStream = new FileInputStream(filename));
			while ((b = bufferedInputStream.read()) != -1) {
				byteList.add(new Integer(b).byteValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (inputStream != null) { 
					inputStream.close();
				}
			} catch (IOException e) {					
				e.printStackTrace();
			}
		}
		bytes = new byte[byteList.size()];
		b = 0;
		for (Byte me : byteList) {
			bytes[b++] = me;
		}
		return bytes;
	}
}

