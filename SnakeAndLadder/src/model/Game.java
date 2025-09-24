package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Queue;

@Getter
@Setter
public class Game {
    private Queue<Player> playersList = new ArrayDeque<Player>();
    private Board board;
    private Dice dice;

    public void addPlayer(int id, String name) {
        Player player = new Player(id, name);
        playersList.add(player);
        System.out.println("Player added: "+ name);
    }

    public void setBoard(int size, int snake, int ladder) {
        board = new Board(size, snake, ladder);
        System.out.println("Board size " + size);
        System.out.println("snakes added " + snake);
        System.out.println("ladders added " + ladder);
    }

    public void setDice(int size) {
        dice = new Dice(size);
        System.out.println("No. of Dice created " + size);
    }

    public void startGame() {
        Player winner = null;
        boolean gameOver = false;

        while(!gameOver) {
            Player player = playersList.poll();
            System.out.println("Turn: " + player.getName());
            System.out.println(player.getName() + " is at : " + player.getCurrentPosition());

            int move = dice.rollDice();
            System.out.println("Move " + move);
            int updatedPosition = player.getCurrentPosition() + move;
            if(updatedPosition >= board.getBoardSize()) {
                winner = player;
                System.out.println("Player won " + player.getName());
                gameOver = true;
                break;
            } else {
                int finalPosition = board.getFinalPosition(updatedPosition);
                player.setCurrentPosition(finalPosition);
                System.out.println(player.getName() + " moved to : " + finalPosition);
                playersList.add(player);

            }
        }

        System.out.println("Game over");
        System.out.println("Winner is " + winner.getName());
    }
}
