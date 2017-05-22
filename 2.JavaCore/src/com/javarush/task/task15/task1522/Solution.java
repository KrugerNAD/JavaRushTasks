package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) throws IOException{

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
            System.out.println();
        }catch (Exception e)
        {

        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException{
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inLine = reader.readLine();
        thePlanet = inLine.equals(Planet.EARTH) ? Earth.getInstance(): inLine.equals(Planet.MOON) ? Moon.getInstance() :
                inLine.equals(Planet.SUN) ? Sun.getInstance() : null;
    }
}
