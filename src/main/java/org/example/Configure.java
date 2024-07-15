package org.example;

import java.io.FileInputStream;
import java.util.Properties;

public class Configure {
    public static final String filename="/src/test/java/Utility/Configure.properties";
    public static Properties config =new Properties();
    public static void loadConfigure(){
        FileInputStream inputStream=null;
        try {
            inputStream=new FileInputStream(System.getProperty("user.dir")+filename);
            config.load(inputStream);

        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }
}
