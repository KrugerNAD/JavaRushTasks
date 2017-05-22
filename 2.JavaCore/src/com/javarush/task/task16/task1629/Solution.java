package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException,IOException{
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        reader.close();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread
    {
        int countStrRead = 3;
        private List<String> result = new ArrayList<String>();

        public void printResult()
        {
            for (String i :
                    result) {
                System.out.print(i+" ");
            }
            System.out.println();
        }


        @Override
        public void run()
        {
            int i = 0;
            while (true)
            {
                try{
                    if(i < countStrRead){
                        if(reader.ready())
                        {
                            result.add(reader.readLine());
                            i++;
                        }
                        continue;
                    }
                    break;
                }catch (IOException e) {}
            }
        }
    }
}
