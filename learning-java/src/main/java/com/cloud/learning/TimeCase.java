package com.cloud.learning;

import javafx.util.converter.LocalDateStringConverter;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName: MainTest
 * @Description:java8 日期类型
 * @Author: pzl
 * @CreateDate: 2021/1/27 17:49
 * @Version: 1.0
 * <p>
 * https://www.cnblogs.com/wang-yaz/p/10757937.html
 */
public class TimeCase {
    public static void main(String[] args) {
        //如何在java8中获取当前的年月日
        /*LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();*/
        /*System.out.println(year + "年" + month + "月" + day + "日");*/

        //在java8中如何获取某个特定的日期
        /*LocalDate birthDay = LocalDate.of(2020, 9, 10);*/
        /*System.out.println("指定生日：" + birthDay);*/

        //在java8中检查两个日期是否相等
        /*System.out.println("日期比较：" + today.equals(birthDay));*/

        //在java8中如何检查重复事件，比如生日
        //在java中还有一个与时间日期相关的任务就是检查重复事件，比如每月的账单日
        //如何在java中判断是否是某个节日或者重复事件，使用MonthDay类。这个类由月日组合，不包含年信息，
        //可以用来代表每年重复出现的一些日期或其他组合。他和新的日期库中的其他类一样也都是不可变且线程安全的，
        //并且它还是一个值类（value class）。
        /*MonthDay birDay = MonthDay.of(birthDay.getMonth(), birthDay.getDayOfMonth());
        MonthDay currentDay = MonthDay.from(today);

        if (currentDay.equals(birDay)) {
            System.out.println("今天是你的生日");
        } else {
            System.out.println("今天不是你的生日");
        }*/

        //获取一周后的时间
        /*LocalDate today_1 = LocalDate.now();
        LocalDate after_week = today_1.plus(1, ChronoUnit.WEEKS);
        System.out.println("今天的时间是：" + today_1+",一周后的时间是："+after_week);*/

        //获取一年前或一年后的时间
        LocalDate today=LocalDate.now();
        LocalDate priviewYear = today.minus(1, ChronoUnit.YEARS);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年前的时间："+priviewYear+"，当前时间："+today+",一年后的时间："+nextYear);

        //java8 时钟 替代System.currentTimelnMillis()与TimeZone.getDefault()方法
        //返回当前系统时间
        /*Clock clock= Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println(clock1.instant());*/

        //在java中如何判断某个日期在另一个日期的前面还是后面
        //如何判断某个日期在另一个日期的前面还是后面或者相等，在java8中，LocalDate类中使用isBefore()、isAfter()、equals()方法来比较两个日期。
        // 如果调用方法的那个日期比给定的日期要早的话，isBefore()方法会返回true。equals()方法在前面的例子中已经说明了
        //System.out.println(today.isBefore(priviewYear));

        //如何在java8中检查闰年

        //两个日期之间包含多少天，多少月
        // 每个Java开发人员都应该至少了解这套新的API中的这五个类：

        //●Instant 它代表的是时间戳，比如2016-04-14T14:20:13.592Z，这可以从java.time.Clock类中获取，
        //  像这样： Instant current = Clock.system(ZoneId.of("Asia/Tokyo")).instant();
        //
        //●LocalDate 它表示的是不带时间的日期，比如2016-04-14。它可以用来存储生日，周年纪念日，入职日期等。
        //
        //●LocalTime - 它表示的是不带日期的时间
        //
        //●LocalDateTime - 它包含了时间与日期，不过没有带时区的偏移量
        //
        //●ZonedDateTime - 这是一个带时区的完整时间，它根据UTC/格林威治时间来进行时区调整
        //
        //●这个库的主包是java.time，里面包含了代表日期，时间，瞬时以及持续时间的类。它有两个子package，一个是java.time.foramt，
        //  这个是什么用途就很明显了，还有一个是java.time.temporal，它能从更低层面对各个字段进行访问。
        //
        //●时区指的是地球上共享同一标准时间的地区。每个时区都有一个唯一标识符，同时还有一个地区/城市(Asia/Tokyo)的格式以及从格林威治时间开始的一个偏移时间。比如说，东京的偏移时间就是+09:00。
        //
        //●OffsetDateTime类实际上包含了LocalDateTime与ZoneOffset。它用来表示一个包含格林威治时间偏移量（+/-小时：分，比如+06:00或者 -08：00）的完整的日期（年月日）及时间（时分秒，纳秒）。
        //
        //●DateTimeFormatter类用于在Java中进行日期的格式化与解析。与SimpleDateFormat不同，它是不可变且线程安全的，如果需要的话，可以赋值给一个静态变量。DateTimeFormatter类提供了许多预定义的格式器，你也可以自定义自己想要的格式。当然了，根据约定，它还有一个parse()方法是用于将字符串转换成日期的，如果转换期间出现任何错误，它会抛出DateTimeParseException异常。类似的，DateFormatter类也有一个用于格式化日期的format()方法，它出错的话则会抛出DateTimeException异常。
        //
        //●再说一句，“MMM d yyyy”与“MMm dd yyyy”这两个日期格式也略有不同，前者能识别出"Jan 2 2014"与"Jan 14 2014"这两个串，
        // 而后者如果传进来的是"Jan 2 2014"则会报错，因为它期望月份处传进来的是两个字符。
        // 为了解决这个问题，在天为个位数的情况下，你得在前面补0，比如"Jan 2 2014"应该改为"Jan 02 2014"。

    }
}
