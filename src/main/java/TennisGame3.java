import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private String resultOfPlayer1;
    private String resultOfPlayer2;

    public TennisGame3(String resultOfPlayer1, String resultOfPlayer2) {
        this.resultOfPlayer1 = resultOfPlayer1;
        this.resultOfPlayer2 = resultOfPlayer2;
    }

    public String getScore() {
        if (isRegularScore()) {
            return getRegularResult();
        } else {
            return getSpecialResult();
        }
    }

    private boolean isRegularScore() {
        return scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6);
    }

    private String getRegularResult() {
        String[] results = {"Love", "Fifteen", "Thirty", "Forty"};
        String score = results[scorePlayer1];
        return (scorePlayer1 == scorePlayer2) ? score + "-All" : score + "-" + results[scorePlayer2];
    }

    private String getSpecialResult() {
        if (scorePlayer1 == scorePlayer2) {
            return "Deuce";
        }
        String score = (scorePlayer1 > scorePlayer2) ? resultOfPlayer1 : resultOfPlayer2;
        return (Math.abs((scorePlayer1 - scorePlayer2) )== 1) ? "Advantage " + score : "Win for " + score;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            scorePlayer1++;
        } else {
            scorePlayer2++;
        }
    }
}

