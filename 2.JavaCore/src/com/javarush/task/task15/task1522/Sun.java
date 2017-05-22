package com.javarush.task.task15.task1522;

/**
 * Created by HAMSTER on 19.03.17.
 */
public class Sun implements Planet
{
    private static Sun instance;

    private Sun()
    {

    }
    public static Sun getInstance()
    {
        return instance == null ? new Sun() : instance;
    }
}
