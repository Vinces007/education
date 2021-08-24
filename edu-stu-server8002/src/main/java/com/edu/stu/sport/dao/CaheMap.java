package com.edu.stu.sport.dao;

import java.util.*;

public class CaheMap {
    private Map<String,Object> mapMap = new HashMap<>();
    private Map<String,String> mapStr = new HashMap<>();
    private static CaheMap caheMap = new CaheMap();
    private CaheMap(){}

    public static CaheMap getInstance(){
        return caheMap;
    }

    //添加数据
    public void putValue(String key,Object o){
        mapMap.put(key,o);
    }
    public Object getValue(String key){
        return mapMap.get(key);
    }
    public Set<String> getValueList(){
        return mapMap.keySet();
    }

    public Set<String> getValueStrList(){
        return mapStr.keySet();
    }

    //添加数据
    public void putValueStr(String key,String str){
        mapStr.put(key,str);
    }
    public String getValueStr(String key){
        return mapStr.get(key);
    }
}
