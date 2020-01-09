package com.platform.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
    // 日志
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 无分隔符日期格式 "yyyyMMddHHmmssSSS"
     */
    public static String DATE_TIME_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    // 日期转换格式数组
    public static String[][] regularExp = new String[][]{

            // 默认格式
            {"\\d{4}-((([0][1,3-9]|[1][0-2]|[1-9])-([0-2]\\d|[3][0,1]|[1-9]))|((02|2)-(([1-9])|[0-2]\\d)))\\s+([0,1]\\d|[2][0-3]|\\d):([0-5]\\d|\\d):([0-5]\\d|\\d)",
                    DATE_TIME_PATTERN},
            // 仅日期格式 年月日
            {"\\d{4}-((([0][1,3-9]|[1][0-2]|[1-9])-([0-2]\\d|[3][0,1]|[1-9]))|((02|2)-(([1-9])|[0-2]\\d)))",
                    DATE_PATTERN},
            //  带毫秒格式
            {"\\d{4}((([0][1,3-9]|[1][0-2]|[1-9])([0-2]\\d|[3][0,1]|[1-9]))|((02|2)(([1-9])|[0-2]\\d)))([0,1]\\d|[2][0-3])([0-5]\\d|\\d)([0-5]\\d|\\d)\\d{1,3}",
                    DATE_TIME_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS}
    };

    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 时间字符串转Date
     *
     * @return
     */
    public static Date convertStrToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            sdf.setLenient(false);
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Integer getWeekOfDate(Date dt) {
        Integer[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    public static String timeToStr(Long time, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        if (time.toString().length() < 13) {
            time = time * 1000L;
        }
        Date date = new Date(time);
        String value = dateFormat.format(date);
        return value;
    }

    public static long strToTime(String timeStr) {
        Date time = strToDate(timeStr);
        return time.getTime() / 1000;
    }


    /**
     * 转换为时间类型格式
     *
     * @param strDate 日期
     * @return
     */
    public static Date strToDate(String strDate) {
        try {
            String strType = getDateFormat(strDate);
            SimpleDateFormat sf = new SimpleDateFormat(strType);
            return new Date((sf.parse(strDate).getTime()));
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 根据传入的日期格式字符串，获取日期的格式
     *
     * @return 秒
     */
    public static String getDateFormat(String date_str) {
        String style = null;
        if (StringUtils.isEmpty(date_str)) {
            return null;
        }
        boolean b = false;
        for (int i = 0; i < regularExp.length; i++) {
            b = date_str.matches(regularExp[i][0]);
            if (b) {
                style = regularExp[i][1];
            }
        }
        if (StringUtils.isEmpty(style)) {
            logger.info("date_str:" + date_str);
            logger.info("日期格式获取出错，未识别的日期格式");
        }
        return style;
    }


    public static String yyyyMMdd() {
        // 返回的日期
        String resultDate = null;
        // 日期格式转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        resultDate = sdf.format(new Date());
        return resultDate;
    }

    /**
     * 添加日期
     */
    public static Date minusDateForDay(Date date, int day) {
        // 返回的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);

        return calendar.getTime();
    }

    public static String dayOfMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;
    }

    public static Date parseToDate(String dateStr, String parse) {
        // 返回的日期
        Date resultDate = null;
        try {
            // 日期格式转换
            SimpleDateFormat sdf = new SimpleDateFormat(parse);
            resultDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    //获取当前时间
    public static String getYYYYMMDDForDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String str = date.format(formatter).toString();
        return str;
    }

    public static Date getYYYYMMDDForString(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatYYYYMMDDForDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    public static Date minusDay(Date date, Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return calendar.getTime();
    }

    public static String minusDay(String strDate, Integer num) {
        Date date = getYYYYMMDDForString(strDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return formatYYYYMMDDForDate(calendar.getTime());
    }

    public static Date getPreviousWeekMonday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    public static Date getPreviousWeekSunday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    public static Date getPreWeekSunday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();

    }

    public static Integer getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.WEEK_OF_YEAR, -1);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }


    public static Date formatHourDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static String monthBegin(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());

        return first;
    }

    public static String monthLast(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
//        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String last = format.format(ca.getTime());
        return last;
    }


    public static Integer difference(String birthDate) {
        if (StringUtils.isEmpty(birthDate)) {
            return 0;
        }
        Date birthday = getYYYYMMDDForString(birthDate);
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }

    }

    //比较是否为同一天
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    //比较是否为同一月
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    //比较是否为同一年
    public static boolean isSameYear(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return isSameYear;
    }


    public static void main(String[] args) throws ParseException {
//        Date time = DateUtils.parseToDate("2019-03-05", "yyyy-MM-dd");
//        DateTime.ParseExact(,"yyyy-MM-ddTHH:mm:ss+08:00",null);
        String date = "2019-06-14T08:57:55Z";
        date = date.replace("Z", " UTC");//注意是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
        Date d = format.parse(date);
        System.out.println(format(d, "yyyy-MM-dd HH:mm:ss"));
//        String beginDate = DateUtils.monthBegin(time);
//        String endDate = DateUtils.monthLast(time);
//        System.out.println(beginDate + "==" + endDate);
    }

    //根据当前时间获取本月第一天
    public static String monthBeginByNow() {
        String str = DateUtils.getYYYYMMDDForDate();
        Date date = DateUtils.getYYYYMMDDForString(str);
        return DateUtils.monthBegin(date);
    }

    //根据当前时间获取本月最后一天
    public static String monthLastByNow() {
        String str = DateUtils.getYYYYMMDDForDate();
        Date date = DateUtils.getYYYYMMDDForString(str);
        return DateUtils.monthLast(date);
    }

    public static Date convertUTCTime(String date) {
        date = date.replace("Z", " UTC");//注意是空格+UTC
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
