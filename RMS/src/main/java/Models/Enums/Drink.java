package Models.Enums;

import java.util.stream.Stream;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public enum Drink {
    NONE {
        @Override
        public float getCost() {
            return 0;
        }
    },
    COKE {
        @Override
        public float getCost() {
            return 200;
        }
    },
    PEPSI {
        @Override
        public float getCost() {
            return 200;
        }
    },
    FANTA {
        @Override
        public float getCost() {
            return 200;
        }
    },
    SPRITE {
        @Override
        public float getCost() {
            return 200;
        }
    };

    public abstract float getCost();
    public static String[] drinks() {
        return Stream.of(Drink.values()).map(Drink::name).toArray(String[]::new);
    }

}
