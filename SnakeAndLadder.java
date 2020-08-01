import java.util.Random;

class SnakeAndLadder {

    public static void main(String[] args) {
        playingARound(1);
    }

    // function to play the game.
    public static void playingARound(int numOfPlayers) {

        int[] playersPositions = new int[numOfPlayers];

        // calling a function to set the starting position as 0.
        settingStartingPositions(playersPositions);

        // calling a function to roll the die.
        rollTheDie();
    }

    // function to set players starting position as zero.
    public static int[] settingStartingPositions(int[] playersPositions) {
        for (int i = 0; i < playersPositions.length; i++) {
            playersPositions[i] = 0;
        }
        return playersPositions;
    }

    // function to decide the die toss
    public static int rollTheDie() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}
