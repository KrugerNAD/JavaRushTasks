package com.javarush.task.task15.task1527;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/


public class Solution {
//    static String inputUrl;
//    static {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            inputUrl = reader.readLine();
//            reader.close();
//        }catch (IOException e){
//
//        }
//    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputUrl = reader.readLine();
        reader.close();

        List<String[]> myList = initMap(inputLogic(inputUrl));
        List<Integer> indexOrg = indexOrgKeyInList(myList);
        for (String[] i :
                myList) {

            System.out.print(i[0]+" ");
        }
        System.out.println();
        for (Integer i :
                indexOrg) {

            String value = myList.get(i)[1];
            try{
                alert(Double.parseDouble(value));

            }catch (NumberFormatException e)
            {
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static String inputLogic(String url)
    {
        return url.split(".+index(\\.html)?\\?")[1];
    }
    public static List<String[]> initMap(String inStr)
    {
        List<String[]> rList = new ArrayList<>();
        String[] newStr = inStr.split("(?:&+\\?+)|(?:&+|\\?+)");
        for (String i :
                newStr) {
            rList.add(i.split("="));
        }

        return rList;
    }
    public static List<Integer> indexOrgKeyInList(List<String[]> myList)
    {
        List<Integer> rList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i)[0].equals("obj"))
            {
                rList.add(i);
            }
        }
        return rList;
    }
}
