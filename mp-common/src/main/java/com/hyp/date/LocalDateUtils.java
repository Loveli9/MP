package com.hyp.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateUtils {

    public static final String MMM = "MMM";
    public static final String YYYYMM = "yyyy-MM";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String HHMMSS = "HH:mm:ss";
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern(YYYYMMDD);
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS);
    public static final DateTimeFormatter M_M_M = DateTimeFormatter.ofPattern(MMM, Locale.ENGLISH);

    public static String parseDateToStrForYyyyMmDdHhMmSs(LocalDateTime date) {
        return YYYY_MM_DD_HH_MM_SS.format(date);
    }

    public static String parseDateToStrForYyyyMmDd(LocalDate date) {
        return YYYY_MM_DD.format(date);
    }

    public static LocalDate parseStrToDateForYyyyMmDd(String yyyymmdd) {
        return LocalDate.parse(yyyymmdd);
    }
    public static LocalTime parseStrToDateForHhMmSs(String hhmmss) {
        return LocalTime.parse(hhmmss);
    }
    public static LocalDateTime parseStrToDateForYyyyMmDdHhMmSs(String yyyymmddhhmmss) {
        return LocalDateTime.parse(yyyymmddhhmmss,YYYY_MM_DD_HH_MM_SS);
    }

    public static String getNowDateToYyyyMmDd() {
        LocalDate current = LocalDate.now();
        return current.format(YYYY_MM_DD);
    }
    public static String getNowDateToYyyyMmDdHhMmSs() {
        LocalDateTime current = LocalDateTime.now();
        return current.format(YYYY_MM_DD_HH_MM_SS);
    }

}
