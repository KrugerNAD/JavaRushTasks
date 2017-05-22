package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        System.out.println(arithMean(inputLogic()));
    }


    public static int[] inputLogic() throws Exception
    {
        int [] arrayRelative = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
        do
        {
            num = Integer.parseInt(reader.readLine());
            if (num != -1)
            {
                arrayRelative = arrayRelative == null ? flexArray(num):flexArray(arrayRelative,num);
                continue;
            }
            break;
        }while (true);
        return arrayRelative;
    }

    public static int [] flexArray(int[] arrayHard,int addNum)
    {
        int[] newArray = new int[arrayHard.length + 1];
        for (int i = 0; i < newArray.length; i++)
        {
            newArray[i] = i < arrayHard.length ? arrayHard[i] : addNum;
        }
        return newArray;
    }
    public static int [] flexArray(int addNum)
    {
        int [] a = {addNum};
        return a;
    }
    public  static  double  arithMean (int [] myArray)
    {
        int sum = 0;

        for (int i :
                myArray) {
            sum += i;
        }
        return (double)sum / myArray.length;
    }

}

