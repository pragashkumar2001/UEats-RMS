package Models.Enums;

import java.util.stream.Stream;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public enum FoodType {
    PIZZA {
        @Override
        public float getCost() {
            return 600;
        }
    },
    BURGER {
        @Override
        public float getCost() {
            return 400;
        }
    },
    SUBMARINE {
        @Override
        public float getCost() {
            return 500;
        }
    };

    public abstract float getCost();

    public static String[] items() {
        return Stream.of(FoodType.values()).map(FoodType::name).toArray(String[]::new);
    }

}
