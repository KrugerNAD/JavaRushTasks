package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        CrudWrapper cw = new CrudWrapper();
        MyCrud p =null;

        switch (args[0])
        {
            case MyDataParams.CREATE:
            {
                synchronized (allPeople) {
                    p = new MyCreate(args);
                }
            }
            case MyDataParams.INFO:
            {
                synchronized (allPeople) {
                    p = new MyInfo(args);
                }
            }
            case MyDataParams.DELETE:
            {
                synchronized (allPeople) {
                    p = new MyDelete(args);
                }
            }
            case MyDataParams.UPDATE:
            {
                synchronized (allPeople) {
                    p = new MyUpdate(args);
                }
            }
        }

        p.executeCommand();
//       p = CrudWrapper.takeMyCRUD(new String[]{"-i","2"});
//       p.executeCommand();
//        p = CrudWrapper.takeMyCRUD(new String[]{"-u","2","Annette","ж","19/04/1997"});
////        p = CrudWrapper.takeMyCRUD(new String[]{"-i","3"});
//        p.executeCommand();
////        p = CrudWrapper.takeMyCRUD(new String[]{"-d","3"});
////        p.executeCommand();
////        p= CrudWrapper.takeMyCRUD(new String[]{"-d","2"});
////        p.executeCommand();
//        p = CrudWrapper.takeMyCRUD(new String[]{"-i","2"});
//        p.executeCommand();

//        System.out.println(allPeople.size());
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
            this.swap = MyDataParams.sexIs(mArgs[2]);
            this.name = mArgs[1];
            this.birthDate = MyDataParams.homyDate(mArgs[3]);

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
            this.index = Integer.parseInt(myArgs[1]);
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
            this.index = Integer.parseInt(myArgs[1]);
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
            this.index = Integer.parseInt(mArgs[1]);
            this.name = mArgs[2];
            this.sex = MyDataParams.sexIs(mArgs[3]);
            this.birthDate = MyDataParams.homyDate(mArgs[4]);

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
    public static class CrudWrapper
    {
        MyCreate myCreate;
        MyUpdate myUpdate;
        MyInfo   myInfo;
        MyDelete myDelete;

        public static MyCrud takeMyCRUD(String[] args)
        {
            switch (args[0])
            {
                case MyDataParams.CREATE:
                {
                    return new MyCreate(args);
                }
                case MyDataParams.INFO:
                {
                    return new MyInfo(args);
                }
                case MyDataParams.DELETE:
                {
                    return new MyDelete(args);
                }
                case MyDataParams.UPDATE:
                {
                    return new MyUpdate(args);
                }
            }
            return null;
        }
    }


}

