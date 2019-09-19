package Nineteen;

public class GameFactoryDice implements GameFactory {
    @Override public Game getGame() {
        return new DiceGame();
    }
}
