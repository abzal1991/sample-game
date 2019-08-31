package model;

import constants.AppConstants;
import enums.StrategyType;
import interfaces.Strategy;

import java.util.List;

public class Player {
    private String id;
    private Strategy strategy;
    private List<Integer> numbers;
    private int score;
    private Integer currentChoice;

    public Player(String id, StrategyType strategyType, List<Integer> numbers) {
        this.id = id;
        this.strategy = AppConstants.strategyMap.get(strategyType);
        this.numbers = numbers;
        this.score = 0;
    }

    public Integer makeChoice() {
        currentChoice = strategy.chooseNumber(numbers);
        numbers.remove(currentChoice);
        return currentChoice;
    }
    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(Integer currentChoice) {
        this.currentChoice = currentChoice;
    }
}
