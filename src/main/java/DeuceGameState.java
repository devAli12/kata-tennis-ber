public class DeuceGameState implements GameState {

    @Override
    public String asString(String namePlayer1, String name) {
        return "Deuce";
    }

    @Override
    public GameState playerOneScored() {
        return new AdvantagePlayer1GameState();
    }

    @Override
    public GameState playerTwoScored() {
        return new AdvantagePlayer2GameState();
    }
}
