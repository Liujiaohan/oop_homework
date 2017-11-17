package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LogUtil {
    public static void print(String message) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream("/root/log.txt", true));
            out.println(message);
            out.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
