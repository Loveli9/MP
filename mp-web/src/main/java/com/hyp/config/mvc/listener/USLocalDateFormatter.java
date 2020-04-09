package com.hyp.config.mvc.listener;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class USLocalDateFormatter implements Formatter {

    @Override
    public Object parse(String s, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Object o, Locale locale) {
        return null;
    }

}
