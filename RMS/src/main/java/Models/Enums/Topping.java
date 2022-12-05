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
            return 250;
        }
    },
    CHICKEN {
        @Override
        public float getCost() {
            return 350;
        }
    },
    MUSHROOM {
        @Override
        public float getCost() {
            return 200;
        }
    };

    public abstract float getCost();
    public static String[] toppings() {
        return Stream.of(Topping.values()).map(Topping::name).toArray(String[]::new);
    }

}
