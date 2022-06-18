package apuestas.modelos;

import java.util.concurrent.ThreadLocalRandom;

public class Match {

    private SoccerTeam soccerATeam;
    private SoccerTeam soccerBTeam;
    private int scoreATeam;
    private int scoreBTeam;

    public Match(){
    }

    public Match(SoccerTeam soccerATeam, SoccerTeam soccerBTeam) {
        this.soccerATeam = soccerATeam;
        this.soccerBTeam = soccerBTeam;
    }

    public SoccerTeam getSoccerATeam() {
        return soccerATeam;
    }

    public void setSoccerATeam(SoccerTeam soccerATeam) {
        this.soccerATeam = soccerATeam;
    }

    public SoccerTeam getSoccerBTeam() {
        return soccerBTeam;
    }

    public void setSoccerBTeam(SoccerTeam soccerBTeam) {
        this.soccerBTeam = soccerBTeam;
    }

    public int getScoreATeam() {
        return scoreATeam;
    }

    public void setScoreATeam() {
        this.scoreATeam = ThreadLocalRandom.current().nextInt(0,9);
    }

    public int getScoreBTeam() {
        return scoreBTeam;
    }

    public void setScoreBTeam() {
        this.scoreBTeam = ThreadLocalRandom.current().nextInt(0,9);
    }

    public String getMatchResult() {
        if (this.scoreATeam > this.scoreBTeam) {
            return soccerATeam.getNameTeam();
        }else if (this.scoreATeam < this.scoreBTeam) {
            return soccerBTeam.getNameTeam();
        } else {
            return "Empate";
        }
    }
}
