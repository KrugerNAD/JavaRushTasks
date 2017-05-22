package com.javarush.task.task15.task1522;

/**
 * Created by HAMSTER on 19.03.17.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth()
    {

    }
    public static Earth getInstance()
    {
        return instance == null ? new Earth() : instance;
    }

}
