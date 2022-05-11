package com.match.mmr.services;


public class Calculator {

    public static double expectedScore(double playerOneRating, double playerTwoRating) {
        return 1/(1+ Math.pow(10, (playerOneRating - playerTwoRating)/400));
    }

    public static double kFactor(double score, double expectedScore) {
        return (score - expectedScore)*10;
    }
}
