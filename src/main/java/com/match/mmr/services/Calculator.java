package com.match.mmr.services;


import com.match.mmr.model.Team;

public class Calculator {

    public static double expectedScore(double playerOneRating, double playerTwoRating) {
        return 1/(1+ Math.pow(10, (playerOneRating - playerTwoRating)/400));
    }

    public static double kFactor(double score, double expectedScore) {
        return (score - expectedScore)*10;
    }

    public static double avgTeamRating(Team team) {
        return (team.getPlayerOne().getRating() + team.getPlayerTwo().getRating())/2;
    }

    public static double changeInRating(Team one, Team two) {
        return kFactor(one.isWin()? 1: 0, expectedScore(avgTeamRating(one), avgTeamRating(two)));
    }

    public static double rating(double playerRating, double change, boolean isWin) {
        return isWin ? playerRating + change : playerRating - change;
    }
}
