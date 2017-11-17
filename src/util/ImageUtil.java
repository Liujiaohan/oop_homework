package util;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

public class ImageUtil {
    private static final String GIF="image/gif;charset=UTF-8";
    private static final String JPG="image/jpg;charset=UTF-8";

    public static void showPicture(String path, HttpServletResponse response){

        try {
            ServletOutputStream os=response.getOutputStream();
            InputStream is=new FileInputStream(path);
            byte[] bytes=new byte[1000];
            while (is.read(bytes)>0){
                os.write(bytes);
            }
            is.close();
            response.setContentType("image/*");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getRandomImage(ServletContext context){
        Random random=new Random();
        System.out.println(context);
        int dir=random.nextInt(4)+1;
        int pic=random.nextInt(3)+1;
        String realPath=context.
                getRealPath(File.separator+"WEB-INF"+File.separator+"static"+File.separator+dir+File.separator+pic+".jpg");
        return realPath;
    }
}
