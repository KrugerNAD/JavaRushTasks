package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
    //напишите тут ваш код
    String name;
    int age;
    char sex;
    public char getSex()
    {
        return sex;
    }
    public int getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
    public void setSex(char newSex)
    {
        this.sex = newSex;
    }
    public void setAge(int newAge)
    {
        this.age = newAge;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }

    public static void main(String[] args) {

    }
}
