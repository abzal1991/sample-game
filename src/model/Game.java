package model;

import enums.StrategyType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Integer> startNumbers;

    public Game() {
        startNumbers = Arrays.asList(4,5,1,3,5,6,7,0);
        Player player1 = new Player("Player1", StrategyType.STATIC,new LinkedList<>(startNumbers));
        Player player2 = new Player("Player2", StrategyType.RANDOM,new LinkedList<>(startNumbers));
        players = Arrays.asList(player1,player2);
    }

    public int start() {
        try {
            int rounds = 1;
            while(rounds <= startNumbers.size()) {
                System.out.println("ROUND "+rounds+":");
                Integer winnerChoice = Collections.max(players, Comparator.comparing(Player::makeChoice)).getCurrentChoice();
                players.forEach(player -> {
                    System.out.println(player.getId()+" chose "+player.getCurrentChoice());
                    if(winnerChoice.equals(player.getCurrentChoice())) {
                        player.incrementScore();
                        System.out.println(player.getId()+" +1");
                    }
                });
                System.out.println("----------------------");
                rounds++;
            }
            System.out.println();
            Player winner = Collections.max(players,Comparator.comparing(Player::getScore));
            long winnerSize = players.stream().filter(player -> player.getScore() == winner.getScore()).count();
            if(winnerSize == 1) {
                System.out.println(winner.getId() + " won the Game!");
            } else {
                System.out.println("DRAW");
            }

            return 0;
        } catch (Exception e) {
            System.out.println("Game has ended abnormally");
            return -1;
        }
    }
}
