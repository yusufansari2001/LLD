import model.Game;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //Requirements
        //1)any number of players
        //2)any number of dices
        //3)size of board dynamic
        //4)Only one winner
        //5)We can select the number of snakes and ladders
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