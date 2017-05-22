package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        logicResult(Integer.parseInt(reader.readLine()));

    }

    public static void logicResult(int num)
    {
        if (checkZero(num))
        {
            System.out.println("ноль");
            return;
        }
        if (checkNegative(num))
        {
            System.out.print("отрицательное");
        }else {
            System.out.print("положительное");
        }
        if (checkEven(num))
        {
            System.out.print(" четное число");
        }else {
            System.out.print(" нечетное число");
        }

    }

    public static boolean checkEven(int num)
    {
        return num % 2 == 0;
    }

    public static boolean checkZero(int num)
    {
        return num == 0;
    }

    public static boolean checkNegative(int num)
    {
        return num < 0;
    }

}
