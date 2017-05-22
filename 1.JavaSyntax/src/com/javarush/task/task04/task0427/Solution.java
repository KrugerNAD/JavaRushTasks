package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int entry = Integer.parseInt(reader.readLine());
        if (entry > 0 && entry < 1000)
        {
            logicResult(entry);
        }
    }
    public static void logicResult(int num)
    {
        if (checkEven(num))
        {
            System.out.print("четное");
        }else {
            System.out.print("нечетное");
        }

        switch (checkCharQuantity(num))
        {
            case 3 :
            {
                System.out.println(" трехзначное число");
                break;
            }
            case 2 :
            {
                System.out.println(" двузначное число");
                break;
            }
            case 1:
            {
                System.out.println(" однозначное число");
            }
        }
    }
    public static boolean checkEven(int num)
    {
        return num % 2 == 0;
    }

    public static int checkCharQuantity(int num)
    {
        return num / 100 > 0 ? 3 : num / 10 > 0 ? 2 : 1;
    }

    public static boolean checkNegative(int num)
    {
        return num < 0;
    }

}
