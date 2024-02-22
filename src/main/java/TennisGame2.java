
public class TennisGame2 implements TennisGame
{
    public int scorePlayer1 = 0;
    public int scorePlayer2 = 0;

    public String resultOfPlayer1 = "";
    public String resultOfPlayer2 = "";
    private String player1;
    private String player2;

    public TennisGame2(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(){
        String score = "";
        if (scorePlayer1 == scorePlayer2 && scorePlayer1 < 4) {
            score = translatePointsToScore(scorePlayer1) + "-All";
        } else if (scorePlayer1 > 0 && scorePlayer2 == 0) {
            score = translatePointsToScore(scorePlayer1) + "-Love";
        } else if (scorePlayer1 < 4 && scorePlayer2 < 4) {
            score = translatePointsToScore(scorePlayer1) + "-" + translatePointsToScore(scorePlayer2);
        }

        if (isDuece())
            score = "Deuce";

        if (hasAdvantage())
        {
            score = "Advantage "+playerWithHighestScore();
        }

        if (hasWinner())
        {
            score = "Win for "+playerWithHighestScore();
        }

        return score;
    }

    private boolean isDuece() {
        return scorePlayer1 == scorePlayer2 && scorePlayer1 >= 3;
    }

    private boolean hasAdvantage() {
        if (scorePlayer1 > scorePlayer2 && scorePlayer2 >= 3)
            return true;
        if (scorePlayer2 > scorePlayer1 && scorePlayer1 >= 3)
            return true;

        return false;

    }


    private boolean hasWinner() {
        if(scorePlayer1>=4 && scorePlayer2>=0 && (scorePlayer1-scorePlayer2)>=2 )
            return true;
        if(scorePlayer2>=4 && scorePlayer1>=0 && (scorePlayer2-scorePlayer1)>=2)
            return true;
        return false;
    }


    public void incrementScorePlayer1(int number){
       scorePlayer1+=number;
    }

    public void incrementScorePlayer2(int number){
        scorePlayer2+=number;
    }

    public void incrementScorePlayer1(){
        scorePlayer1++;
    }

    public void incrementScorePlayer2(){
        scorePlayer2++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            incrementScorePlayer1();
        else
            incrementScorePlayer2();
    }

    public String translatePointsToScore(int points){
        String score="";
        if (points==0)
            score = "Love";
        if (points==1)
            score = "Fifteen";
        if (points==2)
            score = "Thirty";
        if(points==3) score="Forty";

        return score;
    }

    private String playerWithHighestScore() {
        if (scorePlayer1 > scorePlayer2) {
            return "player1";
        } else {
            return "player2";
        }
    }
}