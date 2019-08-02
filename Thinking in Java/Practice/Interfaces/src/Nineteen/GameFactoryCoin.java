package Nineteen;

public class GameFactoryCoin implements GameFactory {
    @Override public Game getGame() {
        return new CoinGame();
    }
}
