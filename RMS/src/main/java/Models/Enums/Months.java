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

    public static String[] items() {
        return Stream.of(FoodType.values()).map(FoodType::name).toArray(String[]::new);
    }
}
