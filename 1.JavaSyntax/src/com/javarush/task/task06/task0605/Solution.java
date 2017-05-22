package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            //напишите тут ваш код
            double indexOfMass = weight/(height*height);
            System.out.println(indexOfMass < 18.5 ? "Недовес: меньше чем 18.5" :
                    indexOfMass >=18.5 && indexOfMass <= 24.9 ? "Нормальный: между 18.5 и 24.9" :
                    indexOfMass >= 25 && indexOfMass <= 29.9 ? "Избыточный вес: между 25 и 29.9" :
                    "Ожирение: 30 или больше");
        }
    }
}
