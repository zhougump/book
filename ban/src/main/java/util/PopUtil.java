package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PopUtil {
	 
	public static String getPop(String path) {  
		String _path="";
        InputStream in = PopUtil.class.getClassLoader() 
                .getResourceAsStream("config.properties");  
        Properties p = new Properties();  
        try {  
            p.load(in);  
            _path = p.getProperty("path");  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return _path;  
    }
	public static void main(String[] args) {
		String value = PopUtil.getPop("path");
		System.out.println(value);
	}
}
