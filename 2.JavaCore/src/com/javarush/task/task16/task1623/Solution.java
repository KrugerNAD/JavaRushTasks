package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
        //new GenerateThread();
    }

    public static class GenerateThread extends Thread
    {

        public GenerateThread()
        {

            super("" + ++countCreatedThreads);
            if (countCreatedThreads < count ) {
                start();
            }


        }

        @Override
        public String toString() {
            return super.getName()+ " created";
        }

        @Override
        public void run()
        {


                System.out.println(new GenerateThread());


        }
    }
}
