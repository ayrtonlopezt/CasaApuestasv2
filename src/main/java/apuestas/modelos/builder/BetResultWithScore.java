package apuestas.modelos.builder;

public class BetResultWithScore {

    private int betCode;
    private String matchResult;
    private int scoreATeam;
    private int scoreBTeam;

    public BetResultWithScore() {
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public int getScoreATeam() {
        return scoreATeam;
    }

    public void setScoreATeam(int scoreATeam) {
        this.scoreATeam = scoreATeam;
    }

    public int getScoreBTeam() {
        return scoreBTeam;
    }

    public void setScoreBTeam(int scoreBTeam) {
        this.scoreBTeam = scoreBTeam;
    }

    public int getBetCode() {
        return betCode;
    }

    public void setBetCode(int betCode) {
        this.betCode = betCode;
    }

}
