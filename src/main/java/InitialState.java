public class InitialState implements GameState {

    @Override
    public String asString(String namePlayer1, final String name) {
        return "Love-All";
    }

    @Override
    public GameState playerOneScored() {
        return new UnevenGameState(1, 0);
    }

    @Override
    public GameState playerTwoScored() {
        return new UnevenGameState(0, 1);
    }
}