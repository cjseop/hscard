package Adapter_DPP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {
	@Override
	public void readFromFile(String filename) throws IOException {
		
		FileInputStream fis = new FileInputStream(filename);
		load(new BufferedInputStream(fis));
		
		String msg = this.getProperty("year");
		System.out.println(msg);
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		File myfile = new File(filename);
		if(!myfile.exists())
		{
			myfile.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(filename);
		store(fos, "written by FileProperties");
	}

	@Override
	public void setValue(String key, String value) {
		this.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return getProperty(key);
	}

}
