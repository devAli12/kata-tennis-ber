public class UnevenGameState implements GameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    private final RunningScoreNameMapper scoreNameMapper;

    public UnevenGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
        scoreNameMapper = new RunningScoreNameMapper();
    }

    @Override
    public String asString(String namePlayer1, final String name) {
        return String.format("%s-%s", scoreNameMapper.mapScore(pointsPlayer1), scoreNameMapper.mapScore(pointsPlayer2));
    }

    @Override
    public GameState playerOneScored() {

        final int incrementedPointsPlayer1 = pointsPlayer1 + 1;

        if (incrementedPointsPlayer1 == 4 && pointsPlayer1 != incrementedPointsPlayer1) {
            return new WinPlayer1GameState();
        }

        if (incrementedPointsPlayer1 == pointsPlayer2) {
            if (incrementedPointsPlayer1 >= 3) {
                return new DeuceGameState();
            }
            return new EvenGameState(incrementedPointsPlayer1);
        }

        return new UnevenGameState(incrementedPointsPlayer1, pointsPlayer2);
    }

    @Override
    public GameState playerTwoScored() {

        final int incrementedPointsPlayer2 = pointsPlayer2 + 1;

        if (incrementedPointsPlayer2 == 4 && pointsPlayer1 != incrementedPointsPlayer2) {
            return new WinPlayer2GameState();
        }

        if (incrementedPointsPlayer2 == pointsPlayer1) {
            if (incrementedPointsPlayer2 >= 3) {
                return new DeuceGameState();
            }
            return new EvenGameState(incrementedPointsPlayer2);
        }

        return new UnevenGameState(this.pointsPlayer1, incrementedPointsPlayer2);
    }
}
