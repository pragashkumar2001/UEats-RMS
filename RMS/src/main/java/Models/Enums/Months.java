package Models.Enums;


import java.util.stream.Stream;

public enum Months {

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
        return Stream.of(Months.values()).map(Months::name).toArray(String[]::new);
    }
}
