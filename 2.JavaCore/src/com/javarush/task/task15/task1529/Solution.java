package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();

    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        try {
            //add your code here - добавьте код тут
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String swap = reader.readLine();
            if (swap.equals("helicopter"))
            {
                result = new Helicopter();
            }else if (swap.equals("plane"))
            {
                result = new Plane(Integer.parseInt(reader.readLine()));
            }
            reader.close();
        }catch (IOException e)
        {

        }
    }
}
