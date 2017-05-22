package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
///*
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        //напишите тут ваш код
//        ArrayList<Integer> thisMustDonetheySaid = inputLogic();
//
//        System.out.println(maxNumseq(numSequence(swaper(thisMustDonetheySaid))));
//    }
//
//
//
//    public static ArrayList<Integer> inputLogic() throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<Integer> myNums = new ArrayList<>(10);
//        for (int i = 0; i < 10; i++) {
//            myNums.add(Integer.parseInt(reader.readLine()));
//        }
//        return myNums;
//    }
//
//    public static int [] swaper(ArrayList<Integer> mustBeSwaped)
//    {
//        int[] swappedNow = new int[mustBeSwaped.size()];
//        for (int i = 0; i < swappedNow.length; i++) {
//            swappedNow[i] = mustBeSwaped.get(i);
//        }
//        return swappedNow;
//    }
//
//    public static ArrayList<ArrayList<Integer>> numSequence(int[] numArr)
//    {
//        ArrayList<ArrayList<Integer>> resultsArr = new ArrayList<>();
//        ArrayList<Integer> SeqNum;
//        for (int i = 0; i < numArr.length ; i++) {
//            SeqNum = new ArrayList<>();
//            SeqNum.add(numArr[i]);
//            for (int j = i; j < numArr.length - 1; j++) {
//                if (numArr[j] == numArr[j+1])
//                {
//                    SeqNum.add(numArr[j+1]);
//                    if(j+1==numArr.length-1)
//                    {
//                        resultsArr.add(SeqNum);
//                        i = j;
//                        break;
//                    }
//                    continue;
//                }
//                resultsArr.add(SeqNum);
//                i = j;
//                break;
//            }
//        }
//        return resultsArr;
//    }
//    public static int maxNumseq(ArrayList<ArrayList<Integer>> numSeq)
//    {
//        int max = 0;
//        for (ArrayList<Integer> i :
//                numSeq) {
//            max = i.size() > max ? i.size() : max;
//        }
//        return max;
//    }
//
//
//}*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> thisMustDonetheySaid = inputLogic();

        System.out.println(maxSeq(thisMustDonetheySaid));
    }

    public static ArrayList<Integer> inputLogic() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> myNums = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            myNums.add(Integer.parseInt(reader.readLine()));
        }
        return myNums;
    }

    public static int maxSeq(ArrayList<Integer> myList)
    {
        int cur = 1;
        int maxSeq = 1;
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i).equals(myList.get(i+1)))
            {
                cur++;
                maxSeq = maxSeq < cur ? cur : maxSeq;
            }else
            {
                //maxSeq = maxSeq < cur ? cur : maxSeq;
                cur = 1;

            }

        }
        return maxSeq;
    }
}