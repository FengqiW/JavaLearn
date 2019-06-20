package com.github.aquan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FillingpitApplicationTests {

    // @Test
    // public void contextLoads() {
    // }

    @Test
    public void TestMath() {
        System.out.println("Math.floorMod(-13, 12) ==> " + Math.floorMod(-13, 12));
        System.out.println("Math.PI ==> " + Math.PI);
        System.out.println("Math.E ==> " + Math.E);

        // double d = 9.997d;
        // int nd = (int) d;
        // System.out.println(nd);

        double d1 = 2;
        double d2 = 1.1;
        BigDecimal bigDecimal1 = BigDecimal.valueOf(d1);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(d2);
        double result = bigDecimal1.subtract(bigDecimal2).doubleValue();
        System.out.println(result);

        System.out.println(d1-d2);
    }

    @Test
    public void testInsert(){
        // 断言
        System.out.println("**********************");
        assertEquals("foo", "foo");
        assertFalse(Boolean.FALSE);
        System.out.println("**********************");
    }


    @Test
    public void bitOperation(){
        int a=15;   //二进制：1111
        int b=2;    //二进制：0010

        /*a	1	1	1	1	15
        b	0	0	1	0	2
        a&b	0	0	1	0	2
        a|b	1	1	1	1	15
        a^b	1	1	0	1	13*/

        System.out.println(a+"&"+b+"="+(a&b));
        System.out.println(a+"|"+b+"="+(a|b));
        System.out.println(a+"^"+b+"="+(a^b));
    }

    @Test
    public void day(){
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println(calendar.getTime());
    }

    @Test
    public void subString(){
        String greeting = "Hello";
        String s = greeting.substring(0, 3);
        String s1 = greeting.substring(0);
        System.out.println(s);
        System.out.println(s1);

        greeting = greeting.substring(0, 3) + "p!";
        System.out.println(greeting);

        String all = String.join(" / ", "S", "M","L", "XL");
        System.out.println(all);

        int cpCount = greeting.codePointCount(0, greeting.length());
        System.out.println(cpCount);
        System.out.println(greeting.length());
    }

    @Test
    public void breakAndContinueTest(){
        for (int i=0;i<5;i++){
            if (i==3) break;
            System.out.print(i + " ");
        }
        for (int i=0;i<5;i++){
            if (i==3) continue;
            System.out.print(i + " ");
        }
    }

    @Test
    public void breakLabelTest(){
        outer:
        for (int i=0; i<5; i++){
            for (int j=0; j<6; j++){
                if (j==4){
                    break outer;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println("outer!");
    }

    @Test
    public void continueLabelTest(){
        outer:
        for (int i=0; i<5; i++){
            for (int j=0; j<6; j++){
                if (j==4){
                    continue outer;
                }
                System.out.println("i = " + i + " j = " + j);
            }
        }
        System.out.println("outer!");
    }

    @Test
    public void foreachTest() {
        // String[] array = {"Aquan","Meow","miao","haha"};
        String[] array = Arrays.copyOf(new String[] {"Aquan","Meow","miao","haha"}, 10);
        for (String string : array) {
            System.out.println(string);
        }
    }

    @Test
    public void sortTest() {
        Integer[] array = {1,6,98,23,58,64,88,785,12,15,36,99,-80,0,-5,-3};
        Arrays.sort(array);
        for (Integer integer : array) {
            System.out.print(integer + ",");
        }
    }

    @Test
    public void binarySearchTest() {
        Integer[] array = {1,6,98,23,58,64,88,785,12,15,36,99,-80,0,-5,-3};
        // int[] array = new int[] {5,8,6,7,2,9,1,0};
        //使用binarySearch的前提是数组是有序的
        Arrays.sort(array);
        System.out.println("数组是: "+ Arrays.toString(array));
        System.out.println("6对应的下标是：" + Arrays.binarySearch(array, 6));
        System.out.println("3对应的下标是：" + Arrays.binarySearch(array, 3));
        System.out.println("4对应的下标是：" + Arrays.binarySearch(array, 4));
        System.out.println("9对应的下标是：" + Arrays.binarySearch(array, 9));
        System.out.println("-1对应的下标是：" + Arrays.binarySearch(array, -1));
        System.out.println("-5对应的下标是：" + Arrays.binarySearch(array, -5));


        System.out.println("0对应的下标是：" + Arrays.binarySearch(array, 0, 16,0));
    }

    @Test
    public void localDateTest() {
        // 获取今天的日期
        LocalDate today = LocalDate.of(2019, 1, 1);
        System.out.println("today ==> " + today.toString());
        System.out.println("程序员日每年的第256天 ^_^ ==> " + today.plusDays(255));//程序员日每年的第256天 ^_^
        System.out.println("withDayOfMonth修改当前的月的天数修改为6天 ==> " + today.withDayOfMonth(6));
        System.out.println("withDayOfMonth修改当前的月份修改为8月份 ==> " + today.withMonth(8));
        System.out.println("withDayOfYear修改当年中的天数为第5天 ==> " + today.withDayOfYear(5));
        System.out.println("withYear修改当前日期的年为指定的2020年 ==> " + today.withYear(2020));

        // 今天是几号
        int dayofMonth = today.getDayOfMonth();
        // 今天是周几（返回的是个枚举类型，需要再getValue()）
        int dayofWeek = today.getDayOfWeek().getValue();
        // 今年是哪一年
        int dayofYear = today.getDayOfYear();
        System.out.println(dayofMonth + "|" + dayofWeek + "|" + dayofYear);
        // {@code 1}MONDAY
        // {@code 2}TUESDAY
        // {@code 3}WEDNESDAY
        // {@code 4}THURSDAY
        // {@code 5}FRIDAY
        // {@code 6}SATURDAY
        // {@code 7}SUNDAY


        LocalDate today2 = LocalDate.parse("2020-09-09");
        int years = today.until(today2).getYears();
        int months = today.until(today2).getMonths();
        int days = today.until(today2).getDays();
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + years + " years, " + months + " months and " + days + " days");

        long year = today.until(today2, ChronoUnit.YEARS);
        long month = today.until(today2, ChronoUnit.MONTHS);
        long day = today.until(today2, ChronoUnit.DAYS);
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + year + "年");
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + month + "月");
        System.out.println(today + " 和 " + today2 + " 间隔 ==> " + day + "天");

        System.out.println(today + " 在 " + today2 + " 之前？ ==> " + today.isBefore(today2));
        System.out.println(today + " 在 " + today2 + " 之后？ ==> " + today.isAfter(today2));

        System.out.println(today + " 是闰年吗？ ==> " + today.isLeapYear());


        // 根据字符串取：
        LocalDate endOfFeb = LocalDate.parse("2019-10-24");
        System.out.println(endOfFeb.toString());
        // 严格按照yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取2019年1月第一个周一
        LocalDate firstMondayOf2019 = LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("取本月第1天 ==> " + firstDayOfThisMonth);
        System.out.println("取本月最后一天，再也不用计算是28，29，30还是31 ==> " + lastDayOfThisMonth);
        System.out.println("取2019年1月第一个周一 ==> " + firstMondayOf2019);

    }


}
