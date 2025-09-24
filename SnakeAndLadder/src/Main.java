import model.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Game game = new Game();
        game.setBoard(36, 5, 5);
        game.setDice(2);
        game.addPlayer(1, "Yousuf");
        game.addPlayer(2, "Harsh");
        game.addPlayer(3, "Salman");
        game.addPlayer(4, "Asif");
        game.startGame();

    }
}