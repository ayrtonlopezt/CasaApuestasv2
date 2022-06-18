package apuestas;

import apuestas.modelos.Match;
import apuestas.modelos.SoccerTeam;
import apuestas.modelos.builder.*;
import apuestas.modelos.prize.IPrize;
import apuestas.modelos.prize.Prize;
import apuestas.modelos.prize.PrizeWithBonus;
import apuestas.modelos.singleton.DbConnection;
import apuestas.modelos.singleton.DbReadNames;
import apuestas.modelos.singleton.connectionProperties.IConnectionProperties;
import apuestas.modelos.singleton.connectionProperties.MySQLConnectionProperties;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        String matchResult;
        int query = 0;
        int scoreATeam = 0;
        int scoreBTeam = 0;
        int betCode = 1;
        double prizeAmount = 20.00;
        double finalPrizeAmount;

        DbReadNames dbReadNames = new DbReadNames();                                            //Principio de Responsabilidad Única
        Scanner read = new Scanner(System.in);

        SoccerTeam aTeam = new SoccerTeam();
        SoccerTeam bTeam = new SoccerTeam();
        Match match = new Match();

        IPrize prize = new Prize();
        IPrize prizeWithBonus = new PrizeWithBonus();

        Director director = new Director();

        IConnectionProperties connectionProperties = new MySQLConnectionProperties();           //Principio de Sustitución de Liskov
        Connection connection = DbConnection.getConnection(connectionProperties);

        for (int i = 1; i < 11; i++){
            aTeam.setNameTeam(dbReadNames.getTeamName(connection, i));
            i++;
            bTeam.setNameTeam(dbReadNames.getTeamName(connection, i));

            System.out.println("Los equipos son:\t" + aTeam.getNameTeam() + " vs " + bTeam.getNameTeam());

            System.out.println("Escriba 1 si solo desea apostar por el resultado del partido, escriba 2 si desea apostar el resultado junto al score");
            query = read.nextInt();
            if (query == 1) {
                System.out.println("Escriba el nombre del equipo ganador, o en caso de Empate escribalo: ");
                matchResult = read.next();
                BetOnlyResult betOnlyResult = director.makeBetOnlyResult(betCode, matchResult);
                match.setSoccerATeam(aTeam);
                match.setSoccerBTeam(bTeam);
                match.setScoreATeam();
                match.setScoreBTeam();
                betCode++;
                System.out.println("Partido:\t" + match.getSoccerATeam().getNameTeam() + " vs " + match.getSoccerBTeam().getNameTeam());
                System.out.println("Resultado\t" + match.getScoreATeam() + " vs " + match.getScoreBTeam());
                if(matchResult.equals(match.getMatchResult())) {
                    System.out.println("Acertó el resultado! Pase a cobrar su premio a caja, gracias.");
                    prize.updatePrizeAmount(prizeAmount);
                } else {
                    System.out.println("Mala suerte, no acertó al resultado :c");
                }
            }else if (query == 2) {
                System.out.println("Escriba el nombre del equipo ganador, o en caso de Empate escribalo: ");
                matchResult = read.next();
                System.out.println("Escriba el contador de goles del equipo " + aTeam.getNameTeam());
                scoreATeam = read.nextInt();
                System.out.println("Escriba el contador de goles del equipo " + bTeam.getNameTeam());
                scoreBTeam = read.nextInt();
                BetResultWithScore betResultWithScore = director.makeBetResultWithScore(betCode, matchResult, scoreATeam, scoreBTeam);
                match.setSoccerATeam(aTeam);
                match.setSoccerBTeam(bTeam);
                match.setScoreATeam();
                match.setScoreBTeam();
                betCode++;
                System.out.println("Partido:\t" + match.getSoccerATeam().getNameTeam() + " vs " + match.getSoccerBTeam().getNameTeam());
                System.out.println("Resultado\t" + match.getScoreATeam() + " vs " + match.getScoreBTeam());
                if(matchResult.equals(match.getMatchResult()) && scoreATeam == match.getScoreATeam() && scoreBTeam == match.getScoreBTeam()) {
                    System.out.println("Acertó el resultado! Pase a cobrar su premio a caja, gracias.");
                    prizeWithBonus.updatePrizeAmount(prizeAmount);
                } else {
                    System.out.println("Mala suerte, no acertó al resultado :c");
                }
            }
        }

        finalPrizeAmount = prize.getPrizeAmount() + prizeWithBonus.getPrizeAmount();
        System.out.println(prize.getPrizeAmount());
        System.out.println(prizeWithBonus.getPrizeAmount());
        System.out.println("Su ganancia total es: " + finalPrizeAmount );

    }



}
