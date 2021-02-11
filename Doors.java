import java.util.Random;

class Doors {
    private final Random generator = new Random();
    private int[] doors;
    final int amount;

    /**
     * Initializes the doors used for the monthy hall problem.
     * @param numberOfDoors [int] Number of doors to generate.
     * @throws Exception if the number of doors is less than three.
     */
    Doors(int numberOfDoors) throws Exception {
        if (numberOfDoors < 3) throw new Exception("The amount of doors can't be less than three.");
        this.amount = numberOfDoors;
        this.doors = new int[numberOfDoors];
    }

    /**
     * Picks a random door.
     * @return [int] Number of a random door.
     */
    int pickDoor(){
        return this.generator.nextInt(doors.length);
    }

    /**
     * Generates a array of doors and puts out a random winning door.
     * The array consists of 0s indicating a loss, if there is a 1 it indicate a win.
     */
    void generateWinningDoor(){
        this.doors = new int[doors.length];
        this.doors[pickDoor()] = 1;
    }

    /**
     * Picks a door to be shown, that isn't already been chosen or is the winning door.
     * @param choice [int] The chosen door.
     * @return [int] Door to be shown.
     */
    int pickShownDoor(int choice){
        int shown;
        do shown = pickDoor(); while (doors[shown] == 1 || choice == shown);
        return shown;
    }

    /**
     * Picks a new door that hasn't been chosen.
     * @param firstChoice [int] The first chosen door.
     * @param shown [int] The shown door.
     * @return [int] new unpicked door.
     */
    int pickSwitchDoor(int firstChoice, int shown){
        if (doors.length == 3) return doors.length - firstChoice - shown;
        int switchChoice;
        do switchChoice = pickDoor(); while (switchChoice == firstChoice || switchChoice == shown);
        return switchChoice;
    }

    /**
     * Gets the value of the door at the given index.
     * @param  [int] the door to fetch.
     * @return [int] the value of the door, 1 if win else 0.
     */
    int get(int index) {
        return doors[index];
    }
}
