package apuestas.modelos.builder;

public class Director {

    public BetOnlyResult makeBetOnlyResult(int betCode, String matchResult) {
        BetOnlyResultBuilder betOnlyResultBuilder = new BetOnlyResultBuilder(betCode);
        BetOnlyResult betOnlyResult = betOnlyResultBuilder.withMatchResult(matchResult).build();
        return betOnlyResult;
    }

    public BetResultWithScore makeBetResultWithScore(int betcode, String matchResult, int scoreATeam, int scoreBTeam) {
        BetResultWithScoreBuilder betResultWithScoreBuilder = new BetResultWithScoreBuilder(betcode);
        BetResultWithScore betResultWithScore = betResultWithScoreBuilder.withMatchResult(matchResult).withScoreATeam(scoreATeam).withScoreBTeam(scoreBTeam).build();
        return betResultWithScore;
    }

}
