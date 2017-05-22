package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String,Integer> newMap = new HashMap<>();
        newMap.put("a",1234);
        newMap.put("b",900);
        newMap.put("c",500);
        newMap.put("d",300);
        newMap.put("e",700);
        newMap.put("f",950);
        newMap.put("g",250);
        newMap.put("h",500);
        newMap.put("i",800);
        newMap.put("j",1500);
        return (HashMap<String, Integer>) newMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Set<String> mustRemove = new HashSet<>();
        for (Map.Entry<String,Integer> i: map.entrySet()
             ) {
            if (i.getValue() < 500)
            {
                mustRemove.add(i.getKey());
            }
        }
        map.keySet().removeAll(mustRemove);
    }

    public static void main(String[] args) {

        HashMap<String,Integer> myMap = createMap();
        removeItemFromMap(myMap);
    }
}