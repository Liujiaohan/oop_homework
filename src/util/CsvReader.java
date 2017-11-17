package util;

import java.io.*;

public class CsvReader {
    public static void main(String[] args){
       // generateMassSql();
        generateUserSql();
    }

    private static void generateUserSql() {
        try {
            File file=new File("/home/ljh/study/面向对象/homework/社团及活动信息表/社团表.csv");
            File file2=new File("/home/ljh/study/面向对象/homework/社团及活动信息表/用户.sql");
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB18030"));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2),"GB18030"));
            String line=br.readLine();
            line=br.readLine();
            StringBuilder builder=new StringBuilder();
            String temp="INSERT INTO users (name,college,class) VALUES ";
            builder.append(temp);
            while ((line=br.readLine())!=null){
                String[] item1=line.split(",");
                String[] item=item1[5].split("、");
                for (int i=0;i<item.length;i++){
                    builder.append("(\""+item[i]+"\",\"软件学院\",\"1604\"),");
                }
                System.out.println(builder.toString()+"\n");
            }
            builder.append(";");
            bw.write(builder.toString());
            bw.flush();
            System.out.println(builder.toString()+"\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void generateMassSql() {
        try {
            File file=new File("/home/ljh/study/面向对象/homework/社团及活动信息表/社团表.csv");
            File file2=new File("/home/ljh/study/面向对象/homework/社团及活动信息表/社团表.sql");
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB18030"));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2),"GB18030"));
            String line=br.readLine();
            line=br.readLine();
            StringBuilder builder=new StringBuilder();
            String temp="INSERT INTO mass (name,time,principal,telephone,email,members,activities,introduction) VALUES ";
            builder.append(temp);
            while ((line=br.readLine())!=null){
                String[] item=line.split(",");
                builder.append("(\""+item[0]+"\","
                        +"\""+item[1]+"\","
                        +"\""+item[2]+"\","
                        +"\""+item[3]+"\","
                        +"\""+item[4]+"\","
                        +"\""+item[5]+"\","
                        +"\""+item[6]+"\","
                        +"\""+item[7]+"\""
                        +"),");
                System.out.println(builder.toString()+"\n");
            }
            builder.append(";");
            bw.write(builder.toString());
            bw.flush();
            System.out.println(builder.toString()+"\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
