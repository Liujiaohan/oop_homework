package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    public static <T> List<T> jsonToList(String json,Class<T> clazz){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<T>>(){
        }.getType();
        ArrayList<T> list=gson.fromJson(json,type);
        return list;
    }

    public static <T> T jsonToObject(String json,Class<T> clazz){
        Gson gson=new Gson();
        return gson.fromJson(json,clazz);
    }

    public static <T> String toJson(List<T> list){
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<T>>(){
        }.getType();
        return gson.toJson(list,type);
    }

    public static <T> String toJson(T object){
        Gson gson=new Gson();
        return gson.toJson(object);
    }
}
