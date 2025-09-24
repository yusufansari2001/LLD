package model;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Board {
    private int boardSize;
    private int noOfLadders;
    private int noOfSnakes;
    @Setter
    private  Cell[][] cell = new Cell[1000][1000];

    public Board(int boardSize, int noOfSnakes, int noOfLadders) {
        this.boardSize = boardSize;
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 1; i <= boardSize; i++) {
            cell[generateRow(i)][generateCol(i)] = new Cell();
        }
        generateSnakes();
        generateLadders();
    }

    private int generateCol(int num) {
        int dimension = (int) Math.sqrt(boardSize);
        return (num - 1) % dimension;
    }

    private int generateRow(int num) {
        int dimension = (int) Math.sqrt(boardSize);
        return (num - 1) / dimension;
    }

    private void generateSnakes() {
        int snakeCount = 0;

        while(snakeCount < noOfSnakes) {
            int start = ThreadLocalRandom.current().nextInt(2, boardSize);
            int end = ThreadLocalRandom.current().nextInt(2, boardSize);
            if(start <= end) continue;
            if(cell[generateRow(start)][generateCol(start)].getSnake() == null) {
                cell[generateRow(start)][generateCol(start)].setSnake(new Snake(start, end));
            }
            snakeCount++;
        }
    }

    private void generateLadders() {
        int ladderCount = 0;

        while(ladderCount < noOfLadders) {
            int start = ThreadLocalRandom.current().nextInt(2, boardSize);
            int end = ThreadLocalRandom.current().nextInt(2, boardSize);
            if(start >= end) continue;
            if(cell[generateRow(start)][generateCol(start)].getLadder() == null
                && cell[generateRow(start)][generateCol(start)].getSnake() == null ) {
                cell[generateRow(start)][generateCol(start)].setLadder(new Ladder(start, end));
            }
            ladderCount++;
        }
    }

    public int getFinalPosition(int position)
    {
        int row= generateRow(position);
        int col= generateCol(position);
        int finalPosition= position;
        if(cell[row][col].getSnake() != null) {
            System.out.println("Snake bit at: " + position);
            finalPosition= cell[row][col].getSnake().getEnd();
        } else if (cell[row][col].getLadder()!=null) {
            System.out.println("Climbed ladder at: " + position);
            finalPosition= cell[row][col].getLadder().getEnd();
        }
        return finalPosition;
    }
}
