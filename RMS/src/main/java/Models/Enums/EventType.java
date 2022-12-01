package Models.Enums;

import java.util.stream.Stream;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public enum EventType {
    BIRTHDAY,
    ANNIVERSARY,
    PARTY;

    public static String[] events() {
        return Stream.of(EventType.values()).map(EventType::name).toArray(String[]::new);
    }
}
