package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {

        threads.add(new MyThread_1());
        threads.add(new MyThread_2());
        threads.add(new MyThread_3());
        threads.add(new MyThread_4());
        threads.add(new MyThread_5());

    }

    public static void main(String[] args) throws InterruptedException{
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
        //((MyThread_4)threads.get(3)).


    }
    public static class MyThread_1 extends Thread
    {
        @Override
        public void run()
        {
            while (true) {}
        }
    }
    public static class MyThread_2 extends Thread
    {
        @Override
        public void run() {

            //
                try{
                    Thread.sleep(20000);

                }catch(InterruptedException e) {
                System.out.println("InterruptedException");
                }

        }
    }
    public static class MyThread_3 extends Thread
    {
        @Override
        public void run()
        {   try {
            while (true) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
            }catch (InterruptedException e){}
        }
    }
    public static class MyThread_4 extends Thread implements Message
    {
        Thread myThread;
        @Override
        public void showWarning() {

//                myThread.interrupt();
//                while (true)
//                {
//                    if (!myThread.isAlive())
//                    {
//                        return;
//                    }
//                }
            this.interrupt();

        }
        @Override
        public void run()
        {
//            myThread = Thread.currentThread();
//            while (!myThread.isInterrupted()){
//            }
            super.run();
            System.out.println("++");
        }
    }
    public static class MyThread_5 extends Thread
    {
        @Override
        public void run()
        {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String mightNum;
            int sum = 0;

            while (true)
            {
                try {
                    mightNum = reader.readLine();
                    if(mightNum.equals("N"))
                    {
                        reader.close();
                        break;
                    }else {
                        sum+=Integer.parseInt(mightNum);
                    }
                }catch (IOException e) {
                   // continue;
                }
            }

            System.out.println(sum);
        }
    }
}