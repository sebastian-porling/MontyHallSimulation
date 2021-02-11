# Monty Hall Simulation
This is a simulation of the Monty Hall Problem created by [Sebastian Porling](http://porling.me)

## Build and Execute
I've included JAR executable so you don't have to build/compile the program.
But if you want to build/compile it anyways here is how you do it:

```bash
1. javac *.java
2. java Main [number of simulations] [number of doors]
   ex. java Main 1000 3
```
The arguments are optional, if no arguments have been entered the simulator will run with the default values of 10000 simulations and 3 doors.

If you don't want to build you can just execute the JAR:

```bash
java -jar MontyHallSimulation [number of simulations] [number of doors]
```

If you are using linux or have a bash terminal you can run the bash script which will run four different simulations:
```
sh multiple_simulations.sh
```

## Example output
As it is randomized we will get different results everytime, but an example of running 10000 simulations and 3 doors can look like this:

```
Number of simulations: 10000
Number of doors: 3
Number of wins while staying: 3260 (32.60%)
Number of wins while switching: 6740 (67.40%)
Switching wins!
```