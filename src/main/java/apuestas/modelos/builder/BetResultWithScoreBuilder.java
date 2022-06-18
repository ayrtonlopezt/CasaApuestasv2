package apuestas.modelos.builder;

public class BetResultWithScoreBuilder implements IBetResultWithScoreBuilder {

    private int betCode;
    private String matchResult;
    private int scoreATeam;
    private int scoreBTeam;

    public BetResultWithScoreBuilder(int betCode) {
        this.betCode = betCode;
    }

    public BetResultWithScoreBuilder withMatchResult(String matchResult) {
        this.matchResult = matchResult;
        return this;
    }

    public BetResultWithScoreBuilder withScoreATeam(int scoreATeam) {
        this.scoreATeam = scoreATeam;
        return this;
    }

    public BetResultWithScoreBuilder withScoreBTeam(int scoreBTeam) {
        this.scoreBTeam = scoreBTeam;
        return this;
    }

    public BetResultWithScore build() {
        BetResultWithScore betResultWithScore = new BetResultWithScore();
        betResultWithScore.setBetCode(this.betCode);
        betResultWithScore.setMatchResult(this.matchResult);
        betResultWithScore.setScoreATeam(this.scoreATeam);
        betResultWithScore.setScoreBTeam(this.scoreBTeam);
        return betResultWithScore;
    }

}
