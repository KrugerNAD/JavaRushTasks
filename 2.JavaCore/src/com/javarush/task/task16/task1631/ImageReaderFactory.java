package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by HAMSTER on 03.04.17.
 */
public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) throws IllegalArgumentException
    {
//        switch (type)
//        {
//            case BMP:
//            {
//                return new BmpReader();
//            }
//            case JPG:
//            {
//                return new JpgReader();
//            }
//            case PNG:
//            {
//                return new PngReader();
//            }
//            default:
//            {
//                throw new  IllegalArgumentException();
//            }
//        }
        if (type == ImageTypes.BMP) {
            return new BmpReader();
        }
        if (type == ImageTypes.PNG) {
            return new PngReader();
        }
        if (type == ImageTypes.JPG) {
            return new JpgReader();
        }
        throw new IllegalArgumentException();

    }
}
