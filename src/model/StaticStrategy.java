package model;

import interfaces.Strategy;

import java.util.List;

public class StaticStrategy implements Strategy {

    @Override
    public Integer chooseNumber(List<Integer> numbers) {
        return numbers.get(0);
    }
}
