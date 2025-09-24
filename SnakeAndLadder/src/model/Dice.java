package model;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Dice {
    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int total = 0, count = 0;
        while(count < diceCount) {
            total += ThreadLocalRandom.current().nextInt(1, 7);
            count++;
        }
        return total;
    }
}
