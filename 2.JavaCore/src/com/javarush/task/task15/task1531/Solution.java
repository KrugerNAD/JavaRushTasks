package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if(n<0)
        {
            return ""+0;
        }
            //int result = (n == 0) ? 1 : (n < 0) ? 0 : n * Integer.parseInt(factorial(n - 1));
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = BigDecimal.valueOf(n);

        while (b.compareTo(BigDecimal.ONE) == 1)
        {
            a = a.multiply(b);
            b = b.subtract(BigDecimal.ONE);
        }
        return ""+a;
    }
}
