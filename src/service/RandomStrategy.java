package service;

import interfaces.Strategy;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements Strategy {
    @Override
    public Integer chooseNumber(List<Integer> numbers) {
        return numbers.get(new Random().nextInt(numbers.size()));
    }
}
