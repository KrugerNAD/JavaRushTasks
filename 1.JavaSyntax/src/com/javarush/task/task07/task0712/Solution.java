package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

    }

    public static ArrayList<String> inputLogic(int amountOfIndex) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myStrings = new ArrayList<>(amountOfIndex);
        for (int i = 0; i < amountOfIndex; i++) {
            myStrings.add(reader.readLine());
        }
        return myStrings;
    }


}