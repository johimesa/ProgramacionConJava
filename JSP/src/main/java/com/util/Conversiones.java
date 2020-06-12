package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 02/06/2020
 **/
public class Conversiones {

    private static final String FORMATO_FECHA = "dd-MM";

    public static String format(Date date) {
        return new SimpleDateFormat(FORMATO_FECHA).format(date);
    }

    public static String format(String date) {
        return new SimpleDateFormat(FORMATO_FECHA).format(date);
    }
}
