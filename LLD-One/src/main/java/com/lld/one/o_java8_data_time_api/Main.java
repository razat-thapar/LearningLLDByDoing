package com.lld.one.o_java8_data_time_api;

import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Traditional way to store dates.
        Date d1 = new Date(); // shows us current system time.
        System.out.println(d1);
        //setting the date.
        d1.setTime(123000); // sets the milliseconds. with reference 1st Jan 1970 00:00 UTC
        System.out.println(d1);
        //how to get previous dates than 1970 ?
        d1.setTime(-234123000); //using negative
        System.out.println(d1);

        //setting the month.
        Date d2 = new Date();
        d2.setMonth(5);//it will calculate with 0 based indexing.
        System.out.println(d2);

        System.out.println("-----------------------------------------------------------");

        //Java 8 New Date and Time APi
        LocalDate ld1 = LocalDate.now();
        System.out.println(ld1); //by default it will show only date part.
        LocalTime ldt1 = LocalTime.now();
        System.out.println(ldt1);
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println(ldt2);

        //here , only 1 based indexing for month
        LocalDate ld2 = LocalDate.of(2024,12,23);
        System.out.println(ld2);
        //including zone.
        LocalTime lt2 = LocalTime.ofInstant(Instant.now(), ZoneId.of("Singapore"));
        System.out.println(lt2);
        LocalTime lt3 = LocalTime.now(ZoneId.of("America/Panama"));
        System.out.println(lt3);
        //how to get the zone id details ?
        //using ZoneId.getAvailableZoneIds()
        ZoneId.getAvailableZoneIds().forEach(System.out::println);


        //DateTime api


    }
}
