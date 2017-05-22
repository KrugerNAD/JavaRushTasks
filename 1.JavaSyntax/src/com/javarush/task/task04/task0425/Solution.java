package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        result(initArray(2));
    }

    public static void result (int[] coordinates)
    {
        int a = coordinates[0];
        int b = coordinates[1];
        System.out.println(a > 0 && b > 0 ? 1 : a < 0 && b > 0 ? 2 : a < 0 && b < 0 ? 3 : 4);
    }




    public static int[] initArray(int size) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int [] arrayNum = new int[size];

        for (int i = 0 ; i < arrayNum.length; i ++)
        {
            arrayNum[i] = Integer.parseInt(reader.readLine());
        }

        return arrayNum;
    }

}
