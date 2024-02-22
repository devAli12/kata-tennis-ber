public class WinPlayer1GameState implements GameState {

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        return "Win for " + namePlayer1;
    }

    @Override
    public GameState playerOneScored() {
        return null;
    }

    @Override
    public GameState playerTwoScored() {
        return null;
    }
}
