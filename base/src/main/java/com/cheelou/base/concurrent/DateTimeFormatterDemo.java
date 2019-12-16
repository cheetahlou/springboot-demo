package com.cheelou.base.concurrent;
import java.time.*;
import	java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @decription DateTimeFormatter 线程安全日期格式操作类
 * DateTimeFormatter、LocalDate、LocalTime、ChronoUnit class is immutable and thread-safe.
 * Instant：时间戳
 * Duration：持续时间，时间差
 * LocalDate：只包含日期，比如：2016-10-20
 * LocalTime：只包含时间，比如：23:12:10
 * LocalDateTime：包含日期和时间，比如：2016-10-20 23:14:21
 * Period：时间段
 * ZoneOffset：时区偏移量，比如：+8:00
 * ZonedDateTime：带时区的时间
 * Clock：时钟，比如获取目前美国纽约的时间
 * ChronoUnit 时间单位
 * @createTime 2019/12/13 11:05
 */
public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        //LocalDate中可以取年月日等，也可做加减计算，也可以用util计算时间差
        LocalDate start = LocalDate.now();
        LocalDate oneday = LocalDate.of(2019,12,13);
        LocalTime onetime = LocalTime.now();
        LocalTime onetime1 = LocalTime.parse("12:00:01").plus(-3, ChronoUnit.MINUTES);
        System.out.println("today is "+start+","+"one day is "+oneday+","+"time is "+ onetime1);

        //DateTimeFormatter格式化使用
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String format = formatter.format(oneday);
        System.out.println(format);

        //Date与Instant的相互转化,结合 LocalDateTime 
        Instant instant  = Instant.now();
        Date date = Date.from(instant);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
