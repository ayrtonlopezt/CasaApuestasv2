package apuestas.modelos.builder;

public class BetOnlyResult {

    private int betCode;
    private String matchResult;
    public BetOnlyResult() {
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

    public int getBetCode() {
        return betCode;
    }

    public void setBetCode(int betCode) {
        this.betCode = betCode;
    }

}
