package ohtu;

public class TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOneName)
            playerOneScore += 1;
        else if (playerTwoName == playerName)
            playerTwoScore += 1;
    }

    public String resolveEvenScore() {
        boolean scoresAreFourOrOver = playerOneScore >= 4;

        if (scoresAreFourOrOver) {
            return "Deuce";
        }
        return resolveScoreName(playerOneScore) + "-All";
    }

    public String resolveScoreNamesBeyondFour() {
        int scoreDifference = playerOneScore - playerTwoScore;
        switch (scoreDifference) {
        case 1:
            return "Advantage " + playerOneName;
        case 2:
        case 3:
        case 4:
            return "Win for " + playerOneName;
        case -1:
            return "Advantage " + playerTwoName;
        case -2:
        case -3:
        case -4:
            return "Win for " + playerTwoName;
        default:
            return resolveEvenScore();
        }
    }

    public String resolveScoreName(int score) {
        switch (score) {
        case 0:
            return "Love";
        case 1:
            return "Fifteen";
        case 2:
            return "Thirty";
        case 3:
            return "Forty";
        default:
            return "";
        }
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore) {
            return resolveEvenScore();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return resolveScoreNamesBeyondFour();
        }
        return resolveScoreName(playerOneScore) + "-" + resolveScoreName(playerTwoScore);
    }
}