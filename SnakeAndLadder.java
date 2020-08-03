import java.util.Random;

class SnakeAndLadder {

    public static void main(String[] args) {
        // calling a function to decide the number of player and play the game.
        playingAGame(2);
    }

    // function to start and play the game.
    public static void playingAGame(int numOfPlayers) {

        int[] playersPositions = new int[numOfPlayers];

        // calling a function to set the starting position as 0.
        settingStartingPositions(playersPositions);

        int bestPlacedPosition = 0;

        int numOfRounds = 0;

        while (bestPlacedPosition < 100) {
            numOfRounds++;

            // calling a function to move positions.
            playingARound(playersPositions);
            // displaying players current position
            currentPositions(playersPositions, numOfRounds);

            for (int i = 0; i < playersPositions.length; i++) {
                if (bestPlacedPosition < playersPositions[i]) {
                    bestPlacedPosition = playersPositions[i];
                }
            }
        }

        // calling a function to decide who won.
        playerWhoWon(playersPositions);

    }

    // function to decide who won the game.
    public static void playerWhoWon(int[] playersPositions) {
        int champion = 1;
        int championPosition = playersPositions[0];
        for (int i = 0; i < playersPositions.length; i++) {
            if (championPosition < playersPositions[i])
                champion = i + 1;
        }
        System.out.println("player" + champion + " WON THE GAME");
    }

    // function to print the current position of the player.
    public static void currentPositions(int[] playersPositions, int numOfRounds) {
        for (int i = 0; i < playersPositions.length; i++) {
            System.out.println("player" + (i + 1) + " after " + numOfRounds + " dice played the current position is: "
                    + playersPositions[i]);
        }
        System.out.println();
    }

    // function to decide the players moving position.
    public static int[] playingARound(int[] playersPositions) {
        int currentPosition = 0;
        for (int i = 0; i < playersPositions.length; i++) {
            currentPosition = movingPosition(playersPositions[i]);
            if (currentPosition <= 100) {
                playersPositions[i] = currentPosition;
            }
            if (playersPositions[i] < 0) {
                playersPositions[i] = 0;
            }
        }
        return playersPositions;
    }

    // function to set players starting position as zero.
    public static int[] settingStartingPositions(int[] playersPositions) {
        for (int i = 0; i < playersPositions.length; i++) {
            playersPositions[i] = 0;
        }
        return playersPositions;
    }

    // function to get an output after the die is rolled.
    public static int rollTheDie() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    // function to get which type of move should be played.
    public static int typeOfMove() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    // function ot decide the type of move.
    public static int movingPosition(int playerPosition) {
        int rolledDie = rollTheDie();

        int moveType = typeOfMove();

        if (moveType == 1) {
            playerPosition += rolledDie;
            movingPosition(playerPosition);
        } else if (moveType == 2) {
            playerPosition -= rolledDie;
        }
        return playerPosition;
    }
}