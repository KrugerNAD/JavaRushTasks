package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        if(!clock.isInterrupted())
        {
            System.out.println();
        }
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
//            //System.out.println("asdasd");
//            try {
//                while (tru) {
//
//                    System.out.print((countSeconds--) + " ");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException j) {
//                        continue;
//                    }
//
//                }
//                System.out.println("Марш!");
//            }  catch (e) {
//            //continue;
//            System.out.println("Прерванно!");
//            }

        }
    }
}
