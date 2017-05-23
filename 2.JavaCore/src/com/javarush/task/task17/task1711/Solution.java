package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
CRUD
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException{
        //start here - начни тут
         //String[] args = new String[]{"-c","Annette","ж","19/04/1997","Annette1","ж","19/04/2997","Вася","м","21/04/2997"};
        switch (args[0])
        {
            case MyDataParams.CREATE:
            {
                String[][] myParams = helperMultiCrud(3,args);
                for (String[] i :
                       myParams ) {
                    System.out.println(Arrays.toString(i));
                }

                synchronized (allPeople) {
                    for (String[] i :
                            myParams) {
                        new MyCreate(i).executeCommand();
                    }
                }
                break;
            }
            case MyDataParams.INFO:
            {
                String[][] myParams = helperMultiCrud(1,args);

                synchronized (allPeople) {
                    for (String[] i :
                            myParams) {
                        new MyInfo(i).executeCommand();
                    }
                }
                break;
            }
            case MyDataParams.DELETE:
            {
                String[][] myParams = helperMultiCrud(1,args);

                synchronized (allPeople) {
                    for (String[] i :
                            myParams) {
                        new MyDelete(i).executeCommand();
                    }
                }
                break;
            }
            case MyDataParams.UPDATE:
            {
                String[][] myParams = helperMultiCrud(4,args);

                synchronized (allPeople) {
                    for (String[] i :
                            myParams) {
                        new MyUpdate(i).executeCommand();
                    }
                }
                break;
            }
        }

    }

    public static String[][] helperMultiCrud(int step,String[] myArgs)
    {
        int counter =0;
        String[] myNewArgs = new String[myArgs.length-1];
        System.arraycopy(myArgs,1,myNewArgs,0,myNewArgs.length);
        String[][] mulArgs = new String[(int)(myNewArgs.length/step)][step];
        for (int j = 0; j < mulArgs.length; j++) {
            for (int i = 0; i < step ; i++) {
                mulArgs[j][i]=myNewArgs[counter];
                counter++;
            }
        }
        return mulArgs;
    }


    public static class MyDataParams
    {
        static final String CREATE = "-c";
        static final String UPDATE = "-u";
        static final String DELETE = "-d";
        static final String INFO   = "-i";
        static final SimpleDateFormat MY_DATE = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date y = new Date();

        private static Date homyDate(String dataStr)
        {
            Date dataMy;
            try {
                dataMy = MY_DATE.parse(dataStr);
            }catch (ParseException e)
            {
                return new Date();
            }
            return dataMy;
        }

        public static Sex sexIs(String sex)
        {
            return sex.equals("м") ? Sex.MALE : Sex.FEMALE;
        }

    }

    public interface MyCrud
    {
        void executeCommand();
    }

    public static class MyCreate implements MyCrud
    {
        Sex swap;
        String name;
        Date birthDate;

        public MyCreate(String[] mArgs)
        {
            this.swap = MyDataParams.sexIs(mArgs[1]);
            this.name = mArgs[0];
            this.birthDate = MyDataParams.homyDate(mArgs[2]);

        }
        private  void  createPersonBySex()
        {
            switch (swap)
            {
                case MALE:
                {
                    allPeople.add(Person.createMale(name,birthDate));
                    return;
                }
                case FEMALE:
                {
                    allPeople.add(Person.createFemale(name,birthDate));

                }
            }
        }

        @Override
        public void executeCommand() {
            createPersonBySex();
            //System.out.println("id ("+(allPeople.size()-1)+")");
            System.out.println(allPeople.size()-1);
        }
    }
    public static class MyInfo implements MyCrud
    {
        int index;

        public MyInfo(String[] myArgs)
        {
            this.index = Integer.parseInt(myArgs[0]);
        }

        void infoByID()
        {
            Person p = allPeople.get(index);
            DateFormat myDate = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            String sex = p.getSex() == Sex.MALE ? "м":"ж";
            System.out.println(String.join(" ",p.getName(),sex,myDate.format(p.getBirthDay())));
        }

        @Override
        public void executeCommand() {
            infoByID();
        }
    }
    public static class MyDelete implements MyCrud
    {
        int index;

        public MyDelete(String[] myArgs) {
            this.index = Integer.parseInt(myArgs[0]);
        }
        void deletById()
        {
            Person p =allPeople.get(index);
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        }
        @Override
        public void executeCommand() {
            deletById();
        }
    }
    public static class MyUpdate implements MyCrud
    {
        int index;
        Sex sex;
        String name;
        Date birthDate;

        public MyUpdate(String[] mArgs)
        {
            this.index = Integer.parseInt(mArgs[0]);
            this.name = mArgs[1];
            this.sex = MyDataParams.sexIs(mArgs[2]);
            this.birthDate = MyDataParams.homyDate(mArgs[3]);

        }

        void upateByindex(){
            Person p = allPeople.get(this.index);
            p.setName(this.name);
            p.setSex(this.sex);
            p.setBirthDay(this.birthDate);
        }

        @Override
        public void executeCommand() {
            upateByindex();
        }
    }
}

