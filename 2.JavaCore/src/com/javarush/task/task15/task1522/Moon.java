package com.javarush.task.task15.task1522;

/**
 * Created by HAMSTER on 19.03.17.
 */
public class Moon implements Planet
{
    private static Moon instance;

    private Moon()
    {

    }
    public static Moon getInstance()
    {
        return instance == null ? new Moon() : instance;
    }
}
