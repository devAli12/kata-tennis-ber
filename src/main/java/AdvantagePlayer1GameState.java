
public class AdvantagePlayer1GameState implements GameState {

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        return "Advantage " + namePlayer1;
    }

    @Override
    public GameState playerOneScored() {
        return new WinPlayer1GameState();
    }

    @Override
    public GameState playerTwoScored() {
        return new DeuceGameState();
    }
}
