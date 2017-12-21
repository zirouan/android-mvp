package br.com.liveo.mvp.util.date;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by rudsonlima on 11/16/17.
 */

public class DateUtil {
    private static final String DATE_FORMAT_API = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_FORMAT_LOCAL = "dd/MM/yyyy";

    public static Date getDate(String dateAsString, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        try {
            return simpleDateFormat.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date getDate(String dateAsString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                DATE_FORMAT_API, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.parse(dateAsString);
    }

    public static Date getDateScore(String dateAsString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy/MM/dd'T'HH:mm:ss", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.parse(dateAsString);
    }

    public static String getDay(String date) {
        if (TextUtils.isEmpty(date)) {
            return "";
        }

        Calendar dateTime = Calendar.getInstance();
        try {
            dateTime.setTime(getDate(date));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd", Locale.getDefault());
            return simpleDateFormat.format(dateTime.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getMonth(String date) {
        if (TextUtils.isEmpty(date)) {
            return "";
        }

        Calendar dateTime = Calendar.getInstance();

        try {
            dateTime.setTime(getDate(date));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
            return simpleDateFormat.format(dateTime.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat(DATE_FORMAT_API, Locale.getDefault()).format(
                Calendar.getInstance().getTime());
    }

    public static String getTime(String date) {
        if (TextUtils.isEmpty(date)) {
            return "...";
        }
        Calendar dateTime = Calendar.getInstance();

        try {
            dateTime.setTime(getDate(date));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            return simpleDateFormat.format(dateTime.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String date(String date, String formatDateReturn) {
        if (TextUtils.isEmpty(date)) {
            return "...";
        }

        Calendar dateTime = Calendar.getInstance();
        try {
            dateTime.setTime(getDate(date));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDateReturn, Locale.getDefault());
            return simpleDateFormat.format(dateTime.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String dateScore(String date, String formatDateReturn) {
        if (TextUtils.isEmpty(date)) {
            return "...";
        }

        Calendar dateTime = Calendar.getInstance();
        try {
            dateTime.setTime(getDateScore(date));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatDateReturn, Locale.getDefault());
            return simpleDateFormat.format(dateTime.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String formatDateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date);
    }

    public static String formatDateToStringToSendServer(Date date) {
        if (date != null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
        } else {
            return "";
        }
    }

    public static String formatDateToStringApi(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DATE_FORMAT_API, Locale.getDefault()).format(date);
        } else {
            return "";
        }
    }
}
