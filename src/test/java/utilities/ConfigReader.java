package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  public  static Properties properties;

    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //dosya yolunu verdiğimiz confuguratıon dosyasını okudu
            properties=new Properties();
            properties.load(fis);//fisin okudugu bılgılerı  properties e yukledı
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)  {
        return properties.getProperty(key);//burdakı getProperty methodu Properties classına ait
    }
}
