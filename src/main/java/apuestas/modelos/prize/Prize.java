package apuestas.modelos.prize;

public class Prize implements IPrize {

    double prizeAmount;

    public Prize(){
        this.prizeAmount = 0;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public void updatePrizeAmount(double newPrizeAmount){
        this.prizeAmount = this.prizeAmount + newPrizeAmount;
    }

}
