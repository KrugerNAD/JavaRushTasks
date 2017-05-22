package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        result(initArray(3));
    }
    public static boolean checkNegative(int num)
    {
        return num < 0;
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
    public static void result(int[] arrayNum)
    {
        int count = 0;
        for (int i:arrayNum)
        {
            count += checkNegative(i) ? 0 : 1;
        }
        System.out.println(count);
    }

}
