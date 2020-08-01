import java.util.Random;

class SnakeAndLadder {

    public static void main(String[] args) {
        playingARound(3);
    }

    //function to decide the players moving position.
    public static void playingARound(int numOfPlayers) {

        int[] playersPositions = new int[numOfPlayers];

        // calling a function to set the starting position as 0.
        settingStartingPositions(playersPositions);

        // calling a function to roll the die.
        int rolledDie = rollTheDie();

        int moveType = typeOfMove();

        if (moveType == 1) {
            System.out.println("player stayed in the same position");
        } else if (moveType == 2) {
            System.out.println("it's ladder so player moves " + rolledDie + " steps forward");
        } else {
            System.out.println("it's snake so player moves " + rolledDie + " steps backward");
        }
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

    //function to decide the type of move.
    public static int typeOfMove() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }
}
