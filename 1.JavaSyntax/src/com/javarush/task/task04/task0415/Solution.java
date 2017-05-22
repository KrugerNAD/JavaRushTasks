package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        result(isExist(a,b,c));
    }

    public static void result (boolean var)
    {
        if (var)
        {
            System.out.println("Треугольник существует.");
        }else
            {
                System.out.println("Треугольник не существует.");
            }
    }

    public static boolean isExist(int a, int b ,int c)
    {
        int [] numArr = {a,b,c};
        int sum = 0;

        for (int i = 0 ; i < numArr.length; i ++)
        {
            for (int j = 0 ; j < numArr.length; j ++)
            {
                if (i!=j)
                {
                    sum += numArr[j];
                }
            }

            if (numArr[i] > sum)
            {
                return false;
            }
            sum = 0;
        }
        return true;
    }
}