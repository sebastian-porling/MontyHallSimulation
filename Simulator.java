public class Simulator {
    private final int numberOfSimulations;
    private final Doors doors;

    /**
     * Initializes the simulator with the number of simulations and the amount of doors.
     * @param numberOfSimulations [int] The amount of simulations to run.
     * @param numberOfDoors [int] The amount of doors to simulate on.
     * @throws Exception If the number of doors is less than three or number of simulations is less than one.
     */
    public Simulator(int numberOfSimulations, int numberOfDoors) throws Exception {
        if (numberOfDoors < 3) throw new Exception("Number of doors can't be less than three.");
        if (numberOfSimulations < 1) throw new Exception("Number of simulations can't be less than one.");
        this.numberOfSimulations = numberOfSimulations;
        this.doors = new Doors(numberOfDoors);
    }

    /**
     * Does the simulation with the amount of simulations and doors.
     * @return [SimulatorResult] object that can has the information about the simulation.
     */
    public SimulatorResult simulate(){
        int switches = 0, stays = 0, choice, shown;
        for (int simulation = 0; simulation < numberOfSimulations; simulation++) {
            doors.generateWinningDoor();
            choice = doors.pickDoor();
            shown = doors.pickShownDoor(choice);
            stays += doors.get(choice);
            switches += doors.get(doors.pickSwitchDoor(choice, shown));
        }
        return new SimulatorResult(switches, stays, numberOfSimulations, doors.amount);
    }

}
