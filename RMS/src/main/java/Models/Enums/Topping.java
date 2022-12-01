package Models.Enums;

import java.util.stream.Stream;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public enum Topping {
    NONE {
        @Override
        public float getCost() {
            return 0;
        }
    },

    PEPPERONI {
        @Override
        public float getCost() {
            return 30;
        }
    },
    CHICKEN {
        @Override
        public float getCost() {
            return 35;
        }
    },
    MUSHROOM {
        @Override
        public float getCost() {
            return 20;
        }
    };

    public abstract float getCost();
    public static String[] toppings() {
        return Stream.of(Topping.values()).map(Topping::name).toArray(String[]::new);
    }

}
