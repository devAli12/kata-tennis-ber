public class EvenGameState implements GameState {

    private final int points;

    private final RunningScoreNameMapper scoreNameMapper;

    public EvenGameState(int points) {
        this.points = points;
        scoreNameMapper = new RunningScoreNameMapper();
    }

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        return scoreNameMapper.mapScore(points) + "-All";
    }

    @Override
    public GameState playerOneScored() {

        final int incrementedPointsPlayer1 = points + 1;

        if (incrementedPointsPlayer1 == 4) {
            return new AdvantagePlayer1GameState();
        }

        return new UnevenGameState(incrementedPointsPlayer1, points);
    }

    @Override
    public GameState playerTwoScored() {

        final int incrementedPointsPlayer2 = points + 1;

        if (incrementedPointsPlayer2 == 4) {
            return new AdvantagePlayer2GameState();
        }

        return new UnevenGameState(points, incrementedPointsPlayer2);
    }
}
