package cse.duytan.coms.untils;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import cse.duytan.coms.R;

/**
 * Created by Pham Van Thien on 7/31/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class DateTimeFormater {
    public static final String HH_MM = "HH:mm";
    public static final String HH_MM_DD_MM_YY = "HH:mm dd/MM/yyyy";
    public static final String DD_MM_YY = "dd/MM/yyyy";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SS = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String HH_MM_DD_MM_YYYY = "hh:mm dd-MM-yyyy";
    public static final String MMMMM_DD_YY = "EE, dd-MM-yy";
    public static final String MMM_d_YYYY = "MMM d, yyyy";

    public static String stringToTime(String dateTime, String outFormat) {
        try {
            Date date = DateTimeFormater.stringToDate(dateTime, YYYY_MM_DD_T_HH_MM_SS_SSS);
            return dateToTime(date, outFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String stringToTime(String dateTime, String inputFormat, String outFormat) {
        try {
            Date date = DateTimeFormater.stringToDate(dateTime, inputFormat);
            return dateToTime(date, outFormat);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /*Chuyển ngày sang chuỗi*/
    public static String dateToTime(Date date, String outputFormat) {
        SimpleDateFormat format = new SimpleDateFormat(outputFormat);
        try {
            String str = format.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*Chuyển chuỗi thành ngày*/
    public static Date stringToDate(String time, String inputFormat) {
        SimpleDateFormat format = new SimpleDateFormat(inputFormat);
        try {
            Date date = format.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*Lấy ngày giờ hiện tại*/
    public static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /*Tính ra thời gian đã trôi qua*/
    public static String getTimeAgo(Date date, Context ctx) {

        if (date == null) {
            return null;
        }

        long time = date.getTime();

        Date curDate = currentDate();
        long now = curDate.getTime();
        if (time > now || time <= 0) {
            return null;
        }

        int dim = getTimeDistanceInMinutes(time);

        String timeAgo = null;

        if (dim == 0) {
            timeAgo = ctx.getResources().getString(R.string.date_util_term_less) + " " + ctx.getResources().getString(R.string.date_util_term_a) + " " + ctx.getResources().getString(R.string.date_util_unit_minute);
        } else if (dim == 1) {
            return "1 " + ctx.getResources().getString(R.string.date_util_unit_minute);
        } else if (dim >= 2 && dim <= 44) {
            timeAgo = dim + " " + ctx.getResources().getString(R.string.date_util_unit_minutes);
        } else if (dim >= 45 && dim <= 89) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_about) + " " + ctx.getResources().getString(R.string.date_util_term_an) + " " + ctx.getResources().getString(R.string.date_util_unit_hour);
        } else if (dim >= 90 && dim <= 1439) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_about) + " " + (Math.round(dim / 60)) + " " + ctx.getResources().getString(R.string.date_util_unit_hours);
        } else if (dim >= 1440 && dim <= 2519) {
            timeAgo = "1 " + ctx.getResources().getString(R.string.date_util_unit_day);
        } else if (dim >= 2520 && dim <= 43199) {
            timeAgo = (Math.round(dim / 1440)) + " " + ctx.getResources().getString(R.string.date_util_unit_days);
        } else if (dim >= 43200 && dim <= 86399) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_about) + " " + ctx.getResources().getString(R.string.date_util_term_a) + " " + ctx.getResources().getString(R.string.date_util_unit_month);
        } else if (dim >= 86400 && dim <= 525599) {
            timeAgo = (Math.round(dim / 43200)) + " " + ctx.getResources().getString(R.string.date_util_unit_months);
        } else if (dim >= 525600 && dim <= 655199) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_about) + " " + ctx.getResources().getString(R.string.date_util_term_a) + " " + ctx.getResources().getString(R.string.date_util_unit_year);
        } else if (dim >= 655200 && dim <= 914399) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_over) + " " + ctx.getResources().getString(R.string.date_util_term_a) + " " + ctx.getResources().getString(R.string.date_util_unit_year);
        } else if (dim >= 914400 && dim <= 1051199) {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_almost) + " 2 " + ctx.getResources().getString(R.string.date_util_unit_years);
        } else {
            timeAgo = ctx.getResources().getString(R.string.date_util_prefix_about) + " " + (Math.round(dim / 525600)) + " " + ctx.getResources().getString(R.string.date_util_unit_years);
        }

        return timeAgo + " " + ctx.getResources().getString(R.string.date_util_suffix);
    }

    /*Tính khoản thời gian cách thời gian hiện tại tính bằng giây*/
    private static int getTimeDistanceInMinutes(long time) {
        long timeDistance = currentDate().getTime() - time;
        return Math.round((Math.abs(timeDistance) / 1000) / 60);
    }

    /*Kiểm tra khoảng thời gian có cách nhau hơn 1 ngày không*/
    public static boolean moreThanOneDay(Date date, Date dateLater) {
        if (date == null || dateLater == null) return false;
        long timeDistance = date.getTime() - dateLater.getTime();
        int time = Math.round((Math.abs(timeDistance) / 1000 / 60));
        if (time >= 1440) {
            return true;
        }
        return false;
    }
}
