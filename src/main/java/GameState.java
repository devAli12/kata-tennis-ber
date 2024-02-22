public interface GameState {

    String asString(String namePlayer1, final String name);

    GameState playerOneScored();

    GameState playerTwoScored();
}
