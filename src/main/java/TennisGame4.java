public class TennisGame4 implements TennisGame {

    private GameState gameState = new InitialState();
    private final String nameOfPlayer1;
    private final String nameOfPlayer2;

    public TennisGame4(String nameOfPlayer1, String nameOfPlayer2) {
        this.nameOfPlayer1 = nameOfPlayer1;
        this.nameOfPlayer2 = nameOfPlayer2;
    }

    @Override
    public void wonPoint(String playerName) {
        if (nameOfPlayer1.equals(playerName)) {
            gameState = gameState.playerOneScored();
        } else if (nameOfPlayer2.equals(playerName)) {
            gameState = gameState.playerTwoScored();
        }
    }

    @Override
    public String getScore() {
        return gameState.asString(nameOfPlayer1, nameOfPlayer2);
    }
}