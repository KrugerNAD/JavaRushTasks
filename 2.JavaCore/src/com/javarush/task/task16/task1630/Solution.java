package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }catch (IOException e){}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private String myFilename;
        private String myFileContent ="";

        @Override
        public void setFileName(String fullFileName) {
            myFilename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return myFileContent;
        }
        @Override
        public void run()
        {
            String swapLine;
            try {
                BufferedReader MyFileReader = new BufferedReader(new FileReader(myFilename));
                while ((swapLine = MyFileReader.readLine())!=null)
                {
                    myFileContent += swapLine + " ";
                }
                MyFileReader.close();
            }catch (IOException e ){}


        }
    }
}
