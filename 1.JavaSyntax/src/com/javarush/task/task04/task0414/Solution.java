package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (leapYear(Integer.parseInt(reader.readLine())))
        {
            System.out.println("количество дней в году: 366");
        }else
            {
                System.out.println("количество дней в году: 365");
            }
    }

    public static boolean leapYear(int year)
    {
        return ((year %100 != 0 && year % 4 ==0) || (year % 400 == 0));
    }
}