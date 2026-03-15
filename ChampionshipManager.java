package main;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<Driver>();
    private List<RallyRaceResult> races = new ArrayList<RallyRaceResult>();
    private static int totalDrivers;
    private static int totalRaces;

    // Private constructor making sure only creating instance inside
    private ChampionshipManager() {};

    public static ChampionshipManager getInstance(){
        if (instance == null) {
            instance = new ChampionshipManager(); // Create instance in the fiirst time
        }
        return instance;
    }

    /*
    Getters for totalDrivers and totalRaces and races
    */
    public static int getTotalDrivers(){
        return totalDrivers;
    }

    public static int getTotalRaces(){
        return totalRaces;
    }

    public List<RallyRaceResult> getRaces(){
        return races;
    }

    public void registerDriver(Driver driver){
        this.drivers.add(driver);
        ChampionshipManager.totalDrivers += 1;
    }

    public void addRaceResult(RallyRaceResult result){
        this.races.add(result);
        ChampionshipManager.totalRaces += 1;
    }

    public List<Driver> getDriverStandings(){
        List<Driver> standings = new ArrayList<>(drivers);
        standings.sort((a, b) -> b.getPoints() - a.getPoints()); // Order the points from highest to lowest
        return standings;
    }

    public static Driver getLeadingDriver(){
        return getInstance().getDriverStandings().get(0); // Return the first one in the list
    }

    public static int getTotalChampionshipPoints(){
        int total = 0;
        // Go through points of every driver and sum
        for (Driver driver : getInstance().drivers){
            total += driver.getPoints();
        }
        return total;
    }
}
