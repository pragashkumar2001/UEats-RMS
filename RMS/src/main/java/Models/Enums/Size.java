package Models.Enums;

import java.util.stream.Stream;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public enum Size {
    SMALL {
        @Override
        public float getCost() {
            return 100;
        }
    },
    MEDIUM {
        @Override
        public float getCost() {
            return 200;
        }
    },
    LARGE {
        @Override
        public float getCost() {
            return 300;
        }
    };

    public abstract float getCost();
    public static String[] sizes() {
        return Stream.of(Size.values()).map(Size::name).toArray(String[]::new);
    }

}
