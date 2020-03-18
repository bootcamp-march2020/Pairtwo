package com.bootcamp.test.part2;

public class Ex1 {

    public String weekday1(int day) throws Exception {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                throw new Exception("day must be in range 1 to 7");
        }
    }

    public String weekday2(int day) throws Exception {
        if ((day < 1) || (day > 7)) throw new Exception("day must be in range 1 to 7");
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        return days[day - 1];
    }

    public static void main(String[] args) {
        try {
            System.out.println(new Ex1().weekday1(3));
            System.out.println(new Ex1().weekday2(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

