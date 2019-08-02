package Nineteen;

public class Test19 {
    static void playGame(GameFactory gameFactory){
        Game game = gameFactory.getGame();
        game.play();
    }
    public static void main(String[] args) {
        playGame(new GameFactoryCoin());
        playGame(new GameFactoryDice());
    }
}
