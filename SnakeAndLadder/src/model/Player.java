package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    int id;
    String name;
    @Setter
    int currentPosition;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.currentPosition = 1;
    }
}
