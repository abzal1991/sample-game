package constants;

import enums.StrategyType;
import interfaces.Strategy;
import service.RandomStrategy;
import service.StaticStrategy;

import java.util.HashMap;
import java.util.Map;

public class AppConstants {
    public static final Map<StrategyType, Strategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put(StrategyType.RANDOM, new RandomStrategy());
        strategyMap.put(StrategyType.STATIC, new StaticStrategy());
    }
}
