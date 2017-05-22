package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        boolean result = isOddSumMore(inputLogic());
        System.out.println(result ? "В домах с нечетными номерами проживает больше жителей.":
                "В домах с четными номерами проживает больше жителей.");
    }

    public static int [] inputLogic() throws Exception
    {
        int [] arrayNum = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arrayNum.length; i++) {

            arrayNum[i]= Integer.parseInt(reader.readLine());
        }

        return arrayNum;
    }

    public static boolean isOddSumMore(int[] arrayNum)
    {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < arrayNum.length; i++)
        {
            if (i % 2 == 0)
            {
                evenSum += arrayNum[i];
            }else
            {
                oddSum +=arrayNum[i];
            }
        }

        return oddSum > evenSum;
    }
}
