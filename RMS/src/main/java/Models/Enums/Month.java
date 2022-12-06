package Models.Enums;


import java.util.stream.Stream;

public enum Month {

    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static String[] months() {
        return Stream.of(Month.values()).map(Month::name).toArray(String[]::new);
    }
}
