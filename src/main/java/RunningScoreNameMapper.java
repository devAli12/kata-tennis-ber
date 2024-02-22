public class RunningScoreNameMapper {

    public String mapScore(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
        }
        throw new IllegalArgumentException("<Score: " + score + ">");
    }

}
