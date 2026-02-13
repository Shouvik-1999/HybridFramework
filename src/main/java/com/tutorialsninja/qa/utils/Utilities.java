package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {
    public static String GenerateEmailWithTimeStamp() {
        Date dt = new Date();
        String timeStamp = dt.toString().replace(" ", "_").replace(":", "_");
        return "krshou"+timeStamp+"@gmail.com";
    }
}
