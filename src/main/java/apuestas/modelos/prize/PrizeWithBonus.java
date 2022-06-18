package apuestas.modelos.prize;

public class PrizeWithBonus implements IPrize{

    double prizeAmount;

    public PrizeWithBonus(){
        this.prizeAmount = 0;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public void updatePrizeAmount(double newPrizeAmount){
        this.prizeAmount = this.prizeAmount + (newPrizeAmount * 1.25);
    }

}
