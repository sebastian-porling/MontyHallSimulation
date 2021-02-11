public class Main {

    /**
     * The main program that gathers user input from arguments, if they exists, otherwise uses default values.
     * Then run the simulation and print the result.
     * @param args First argument is the number of simulations [int], second argument is the number of doors [int],
     *             both can be ignored.
     */
    public static void main(String[] args) {
        int numberOfSimulations = 10000, numberOfDoors = 3;
        if (args.length > 0) numberOfSimulations = getNumberOfSimulations(args[0]);
        if (args.length > 1) numberOfDoors = getNumberOfDoors(args[1]);
        try{
            final Simulator simulator = new Simulator(numberOfSimulations, numberOfDoors);
            final SimulatorResult result = simulator.simulate();
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets the number of simulation to run from user input, or 10000 if parsing fails.
     * @param text [String] Text to be parsed to an integer.
     * @return [int] Parsed value or default value of 10000.
     */
    private static int getNumberOfSimulations(String text){
        int numberOfSimulations = Math.abs(parseString(text, 10000, "simulations"));
        if (numberOfSimulations < 1){
            numberOfSimulations = 10000;
            System.out.println("The number of simulations can't be less than 1");
            System.out.println("Proceeding with 10000 simulations...");
        }
        return numberOfSimulations;
    }

    /**
     * Gets the number of doors from user input, or three if parsing fails.
     * @param text [String] Text to be parsed to an integer.
     * @return [int] Parsed value or default value of three.
     */
    private static int getNumberOfDoors(String text){
        int numberOfDoors = parseString(text, 3, "doors");
        if (numberOfDoors < 3){
            numberOfDoors = 3;
            System.out.println("The number of doors can't be less than three!");
            System.out.println("Proceeding with three doors...");
        }
        return numberOfDoors;
    }

    /**
     * Parses the string to an integer, if it fails we use the default value.
     * @param text [String] text to be parsed.
     * @param defaultValue [int] Default value of parsing fails.
     * @param toParse [String] The thing we are parsing.
     * @return [int] the parsed text or default value.
     */
    private static int parseString(String text, int defaultValue, String toParse){
        try{
            return Integer.parseInt(text);
        }catch (Exception e){
            System.out.println("Couldn't parse the number of " + toParse + ", using the default value instead...");
            return defaultValue;
        }
    }
}
