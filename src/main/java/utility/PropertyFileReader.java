package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	protected static Properties property;
	private static FileReader filereader;

	public static void loadPropertyFile() throws IOException {

		property = new Properties();

		final File file = new File(
				String.valueOf(System.getProperty("user.dir") + "\\src\\main\\resources\\testdata.properties"));
		PropertyFileReader.filereader = new FileReader(file);
		PropertyFileReader.property.load(PropertyFileReader.filereader);

	}

	// To retrieve value from property file
	public static String getString(final String value) {
		return PropertyFileReader.property.getProperty(value).toLowerCase();
	}
	
	// To set value to property file
		public static void setvalue(final String key,String value) {
			property.setProperty(key, value);
		}
	
	
	
	
	
}
