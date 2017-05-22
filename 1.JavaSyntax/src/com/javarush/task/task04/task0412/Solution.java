package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        logic(Integer.parseInt(reader.readLine()));



    }

    public static boolean suZero(int number)
    {
        return number < 0;
    }
    public static boolean suZero(double number)
    {
        return number < 0;
    }



    public static void logic(int number)
    {
        if (suZero(number))
        {
            System.out.println(number + 1);
            return;
        }
        if (!suZero(number))
        {
            System.out.println(2 * number);
            return;
        }
        System.out.println(0);
    }

}