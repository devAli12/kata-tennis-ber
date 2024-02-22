import java.util.stream.IntStream;

public class TennisGame1 implements TennisGame {


    private final Player[] players = new Player[2];

    private final static int FIRST_PLAYER_INDEX=0;
    private final static int SECOND_PLAYER_INDEX=1;



    public TennisGame1(String player1Name, String player2Name) {
        this.players[FIRST_PLAYER_INDEX]=new Player(player1Name,0);
        this.players[SECOND_PLAYER_INDEX]=new Player(player2Name,0);
    }

    public void wonPoint(String playerName) {
        int playerIndex=getPlayerIndexOf(playerName);
        int currentScore=players[playerIndex].getScore();
        players[playerIndex].setScore(currentScore+1);
    }

    private int getPlayerIndexOf(String playerName) {
        return IntStream.range(0,players.length)
                .filter(i->players[i].getName().equalsIgnoreCase(playerName))
                .findFirst().orElseThrow(ArrayIndexOutOfBoundsException::new);
    }

    public String getScore() {
        int firstPlayerScore=players[FIRST_PLAYER_INDEX].getScore();
        int secondPlayerScore=players[SECOND_PLAYER_INDEX].getScore();
        String score = "";
        int tempScore=0;
        if (firstPlayerScore==secondPlayerScore)
        {
            score = getScoreWhenDuece(firstPlayerScore);
        }
        else if (firstPlayerScore>=4 || secondPlayerScore>=4)
        {
            score = getScoreWhenPointsGreaterThanFour(firstPlayerScore, secondPlayerScore);
        }
        else
        {
            score = getScore(firstPlayerScore, score, secondPlayerScore);
        }
        return score;
    }

    private static String getScore(int firstPlayerScore, String score, int secondPlayerScore) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1){
                tempScore = firstPlayerScore;
            }
            else {
                score +="-";
                tempScore = secondPlayerScore;
            }
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String getScoreWhenPointsGreaterThanFour(int firstPlayerScore, int secondPlayerScore) {
        String score;
        int minusResult = firstPlayerScore - secondPlayerScore;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String getScoreWhenDuece(int firstPlayerScore) {
        String score;
        switch (firstPlayerScore)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}