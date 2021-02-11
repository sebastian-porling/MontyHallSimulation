public class SimulatorResult{
    private final int switches;
    private final int stays;
    private final int simulations;
    private final int doors;
    
    public SimulatorResult(int switches, int stays, int simulations, int doors){
        this.switches = switches;
        this.stays = stays;
        this.simulations = simulations;
        this.doors = doors;
    }

    /**
     * Calculates the percentage
     * @param term [int] the term to be divided.
     * @param divider [int] the divisor.
     * @return the percentage.
     */
    private String percentage(int term, int divider){
        divider = divider == 0 ? 1 : divider;
        double res = ((double) term / divider)*100;
        return " ("+String.format("%.2f", res)+"%)";
    }

    /**
     * Creates a string consisting the results of the simulation.
     * @return the result of the simulation.
     */
    public String toString(){
        String winnerText = stays == switches ?
                "Both wins!" : switches > stays ?
                "Switching wins!" : "Staying wins!";
        return "Number of simulations: " + simulations + "\n" +
                "Number of doors: " + doors + "\n" +
                "Number of wins while staying: " + stays  +
                percentage(stays, simulations) + "\n" +
                "Number of wins while switching: " + switches +
                percentage(switches, simulations) + "\n" +
                winnerText;
    }
}
