package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        checkFirstNotEqual(initArray(3));


    }

    public static void checkFirstNotEqual(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (i!=j && array[i] == array[j])
                {

                    for (int k = 0; k < array.length; k++)
                    {
                        if (k != j && array[k] != array[j])
                        {
                            System.out.println(k + 1);
                            return;
                        }
                    }
                    return;

                }
                else if (i!=j && array[i] !=array[j] && i == array.length - 1)
                {
                    return;
                }
            }

        }
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
