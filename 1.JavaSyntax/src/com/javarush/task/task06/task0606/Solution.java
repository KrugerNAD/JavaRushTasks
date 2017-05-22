package com.javarush.task.task06.task0606;



import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        evenOddIter(inputLogic());
        System.out.println("Even: "+ even +" Odd: " + odd);
    }

    public static int [] inputLogic() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char [] charArray = reader.readLine().toCharArray();
        int [] numArray = new int [charArray.length];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i]= Character.getNumericValue(charArray[i]);
        }
        return numArray;
    }

    public static void evenOddIter(int[] array)
    {
        for (int i :
                array) {
            if (i % 2==0)
            {
                even ++;
            }else {
                odd ++;
            }
        }
    }
}
