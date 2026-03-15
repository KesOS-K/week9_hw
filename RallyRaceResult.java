package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName, String location){
        this.raceName = raceName;
        this.location = location;
        this.results = new HashMap<>(); // Inithialize map
    }

    public String getRaceName(){
        return this.raceName;
    }

    public String getLocation(){
        return this.location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points){
        this.results.put(driver, position); // Put into the results
        driver.addPoints(points); // Add in driver's function
    }

    @Override
    public int getDriverPoints(Driver driver){
        int position = results.get(driver);

        // Turn position to points the player get
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            default: return 0;
        }
    }

    @Override
    public List<Driver> getResults() {
        /*
        Return the list based on position because the HashMap doesn't have order
            entrySet() and stream() -> make it easier to manipulate
            sorted() and comparingByValue() make sure it is in order
            then getKey to only get names of players
            finally we return a list using collect(Collection.toList())
        */ 
        return results.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}


