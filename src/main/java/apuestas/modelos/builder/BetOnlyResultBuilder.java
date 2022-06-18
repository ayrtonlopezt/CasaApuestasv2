package apuestas.modelos.builder;

public class BetOnlyResultBuilder implements IBetOnlyResultBuilder {

    private int betCode;
    private String matchResult;

    public BetOnlyResultBuilder(int betCode){
        this.betCode = betCode;
    }

    public BetOnlyResultBuilder withMatchResult(String matchResult) {
        this.matchResult = matchResult;
        return this;
    }

    public BetOnlyResult build() {
        BetOnlyResult betOnlyResult = new BetOnlyResult();
        betOnlyResult.setBetCode(this.betCode);
        betOnlyResult.setMatchResult(this.matchResult);
        return betOnlyResult;
    }

}
