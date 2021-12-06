

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: mouse litianlei
 * @Description: 时间调整工具类
 */
public class TimeUtils {
    /**
     * 获取指定时间戳所在月份第一天时间戳
     *
     * @param time
     * @return
     */
    public static Long getMonthBegin(Long time) {
        Date date = new Date(time);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // 设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        // 设置为00:00:00
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        // 获取 本月第一天第一秒时间戳
        return c.getTimeInMillis();
    }


    /**
     * 获取指定时间戳所在月份最后一天时间戳（最后一毫秒）
     *
     * @param time
     * @return
     */
    public static Long getMonthEnd(Long time) {
        Date date = new Date(time);
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        // 设置为当月最后一天
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 设置为23:59:59 999
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);

        return c.getTimeInMillis();
    }

    /**
     * 获取时间戳当天0点时间戳
     */
    public static Long dayTimestamp(Long time) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(time);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        time = calendar.getTimeInMillis();
        return time;
    }


    /**
     * 获取当前时间  昨天0点的时间戳（毫秒）
     */
    public static Long yesterdayStart(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        long yesterdayStart = calendar.getTime().getTime();
        return yesterdayStart;
    }

    /**
     * 获取当前时间 昨天23:59:59 秒的时间戳(毫秒)
     */
    public static Long yesterdayEnd(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,23,59,59);
        long yesterdayEnd = calendar.getTime().getTime();
        return yesterdayEnd;
    }


    /**
     * 获取时间戳所在月份第一天0点时间戳（即当月第一天0点时间戳）
     *
     * @return
     */
    public static Long monthTimestamp(Long time) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(time);
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        // 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取时间戳所在年份第一天0点时间戳（即当年第一天0点时间戳）
     *
     * @return
     */
    public static Long yearTimestamp(Long time) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(time);
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        // 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        time = calendar.getTimeInMillis();
        return time;
    }

    public static Long getMonthBegin(String month) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date parse = dateFormat.parse(month);
        return parse.getTime();
    }

    public static Long getMonthEnd(String month) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date parse = dateFormat.parse(month);
        Long monthEnd = getMonthEnd(parse.getTime());
        return monthEnd;
    }

    public static Long getMonthBeginFormat(Integer month) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = dateFormat.parse(month.toString());
        return parse.getTime();
    }

    public static Long getMonthEndFormat(Integer month) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        Date parse = dateFormat.parse(month.toString());
        Long monthEnd = getMonthEnd(parse.getTime());
        return monthEnd;
    }

    public static Long getDayStart(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Long getDayEnd(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }

    public static Long getYearBegin(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Long getYearEnd(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }


    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");;
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");;
    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间
     *
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * 时间的 加上+/减去- 对应的月数
     *
     * @param time   需要改变的时间
     * @param months 改变方向和值 +/- 为其前进/倒退方向
     * @return 时间改变后日期时间戳
     */
    public static Long changeMonth(Long time, Integer months) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.add(Calendar.MONTH, months);
        return instance.getTimeInMillis();
    }

    /**
     * 时间的 加上+/减去- 对应的年数
     *
     * @param time  需要改变的时间
     * @param years 改变方向和值 +/- 为其前进/倒退方向
     * @return 时间改变后日期时间戳
     */
    public static Long changeYear(Long time, Integer years) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.add(Calendar.YEAR, years);
        return instance.getTimeInMillis();
    }

    /**
     * time 的months月以后的data日起始时间戳
     *
     * @param time
     * @param months
     * @param scheduledDate
     * @return
     */
    public static Long monthsLaterDate(Long time, Integer months, Long scheduledDate) {
        Calendar dateCaledar = Calendar.getInstance();
        dateCaledar.setTimeInMillis(scheduledDate);
        int date = dateCaledar.get(Calendar.DAY_OF_MONTH);

        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.add(Calendar.MONTH, months);
        instance.set(Calendar.DAY_OF_MONTH, date);
        return instance.getTimeInMillis();
    }



    /**
     * time 的 days 天以后的日期时间戳
     *
     * @param time
     * @param days
     * @return
     */
    public static Long daysLaterDate(Long time, Integer days) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.add(Calendar.DAY_OF_MONTH, days);
        return instance.getTimeInMillis();
    }

    /**
     * time 的years年以后的scheduledDate日时间戳
     *
     * @param time
     * @param yaers
     * @param scheduledDate
     * @return
     */
    public static Long yearsLaterDate(Long time, Integer yaers, Long scheduledDate) {
        Calendar dateCaledar = Calendar.getInstance();
        dateCaledar.setTimeInMillis(scheduledDate);
        int date = dateCaledar.get(Calendar.DAY_OF_YEAR);

        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        instance.add(Calendar.YEAR, yaers);
        instance.set(Calendar.DAY_OF_YEAR, date);
        return instance.getTimeInMillis();
    }

    public static Integer getDayNumber(long startTimeMillis, long endTimeMillis) {
        Long startDay = getDayStart(startTimeMillis);
        Long endDay = getDayStart(endTimeMillis);
        return (int) ((startDay - endDay) / (24 * 60 * 60 * 1000));
    }

    public static Integer getYearNumber(long startTimeMillis, long endTimeMillis) {
        Long startDay = getDayStart(startTimeMillis);
        Long endDay = getDayStart(endTimeMillis);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeInMillis(startDay);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeInMillis(endDay);
        int startYear = startCalendar.get(Calendar.YEAR);
        int startDate = startCalendar.get(Calendar.DAY_OF_YEAR);
        int endYear = endCalendar.get(Calendar.YEAR);
        int endDate = endCalendar.get(Calendar.DAY_OF_YEAR);

        if (startDate <= endDate) {
            return endYear - startYear;
        } else {
            return endYear - startYear - 1;
        }
    }

    public static Integer getMonthNumber(long startTimeMillis, long endTimeMillis) {
        Long startDay = getDayStart(startTimeMillis);
        Long endDay = getDayStart(endTimeMillis);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeInMillis(startDay);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeInMillis(endDay);
        int startYear = startCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);
        int startDate = startCalendar.get(Calendar.DAY_OF_MONTH);
        int endYear = endCalendar.get(Calendar.YEAR);
        int endMonth = endCalendar.get(Calendar.MONTH);
        int endDate = endCalendar.get(Calendar.DAY_OF_MONTH);
        int years = endYear - startYear;
        if (years > 1) {
            if (startDate <= endDate) {
                return 12 * (years - 1) + (11 - startMonth) + (endMonth + 1);
            } else {
                return 12 * (years - 1) + (11 - startMonth) + (endMonth);
            }
        }
        if (years == 1) {
            if (startDate <= endDate) {
                return (11 - startMonth) + (endMonth + 1);
            } else {
                return (11 - startMonth) + (endMonth);
            }
        }
        if (startDate <= endDate) {
            return endMonth - startMonth;
        } else {
            return endMonth - startMonth - 1;
        }
    }

    /**
     * 一月李到少天
     *
     * @param startTimeMillis
     * @param endTimeMillis
     * @return
     */
    public static Integer getDaysBaseMonth(long startTimeMillis, long endTimeMillis) {
        Long startDay = getDayStart(startTimeMillis);
        Long endDay = getDayStart(endTimeMillis);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeInMillis(startDay);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeInMillis(endDay);

        Long monthEnd = getMonthEnd(startTimeMillis);
        Calendar monthEndCalendar = Calendar.getInstance();
        monthEndCalendar.setTimeInMillis(monthEnd);
        int montEndDate = monthEndCalendar.get(Calendar.DAY_OF_MONTH);

        int startDate = startCalendar.get(Calendar.DAY_OF_MONTH);
        int endDate = endCalendar.get(Calendar.DAY_OF_MONTH);
        if (startDate <= endDate) {
            return endDate - startDate;
        } else {
            return montEndDate - startDate + endDate;
        }
    }

    public static Integer getDaysBaseYear(long startTimeMillis, long endTimeMillis) {
        Long startDay = getDayStart(startTimeMillis);
        Long endDay = getDayStart(endTimeMillis);
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTimeInMillis(startDay);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTimeInMillis(endDay);

        Long yearEnd = getYearEnd(startTimeMillis);
        Calendar yearEndCalendar = Calendar.getInstance();
        yearEndCalendar.setTimeInMillis(yearEnd);
        int yearEndDate = yearEndCalendar.get(Calendar.DAY_OF_YEAR);

        int startDate = startCalendar.get(Calendar.DAY_OF_YEAR);
        int endDate = endCalendar.get(Calendar.DAY_OF_YEAR);
        if (startDate <= endDate) {
            return endDate - startDate;
        } else {
            return yearEndDate - startDate + endDate;
        }
    }

    /**
     * 获取time的日期
     *
     * @param settlementDate
     * @return
     */
    public static Integer getDateOfMonth(Long settlementDate) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(settlementDate);
        return instance.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * 获取time的日期
     *
     * @param settlementDate
     * @return
     */
    public static Integer getDateOfYear(Long settlementDate) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(settlementDate);
        return instance.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取time时间是星期几
     *
     * @param time
     * @return
     */
    public static Integer getDateOfWeek(Long time) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(time);
        return instance.get(Calendar.DAY_OF_WEEK);
    }

    public static Integer getMonth(Long settlementDate) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(settlementDate);
        return instance.get(Calendar.MONTH);
    }

    public static Integer getYear(Long timeStamp) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(timeStamp);
        return instance.get(Calendar.YEAR);
    }

    public static String formatTime(Long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        return format.format(time);
    }

    public static List<Long> getDateList(Long startTime, Long endTime) {
        List<Long> dateList = new ArrayList<>();
        startTime = getDayStart(startTime);
        while (startTime <= endTime) {
            dateList.add(startTime);
            startTime=getDayStart(daysLaterDate(startTime,1));
        }
        return dateList;
    }

    /**
     * 获取上个月的第一天
     * @param i
     * @return
     */
    public static Long getDayStartOfLastMouth(int i) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - i); // 设置为上一个月
        date = calendar.getTime();
        return getMonthBegin(date.getTime());
    }
    /**
     * 获取上个月的最后天
     * @param i
     * @return
     */
    public static Long getDayEndOfLastMouth(int i) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - i); // 设置为上一个月
        date = calendar.getTime();
        return getMonthEnd(date.getTime());
    }



//    public static Long getTimeMillis(String format){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = dateFormat.parse(format);
//        return parse.getTime();
//    }
//    public static void main(String[] args) throws ParseException {
//        Integer monthNumber = getMonthNumber(getTimeMillis("2019-12-3"), getTimeMillis("2020-1-2"));
//        System.out.println(monthNumber);
//    }
}
