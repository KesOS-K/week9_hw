package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers){
        // Get sum of poiints and devided by size
        int total = 0;
        for (Driver driver : drivers){
           total += driver.getPoints();
        }
        return (double) total / drivers.size();
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        Map<String, Integer> countryPoints = new HashMap<>();
        
        // Calculate the sum of every country
        for (Driver driver : drivers) {
            String country = driver.getCountry();
            if (countryPoints.containsKey(country)) {
                    // If there is already a country
                    countryPoints.put(country, countryPoints.get(country) + driver.getPoints());
            } else {
                    // If not then create one
                    countryPoints.put(country, driver.getPoints());
            }
            
                
        }
        // Find the country with the highest point
        String bestCountry = null;
        int bestPoints = 0;
        for (Map.Entry<String, Integer> entry : countryPoints.entrySet()) {
            if (entry.getValue() > bestPoints) {
                bestPoints = entry.getValue();
                bestCountry = entry.getKey();
            }
        }
        
        return bestCountry;
    }

    public static int getTotalRacesHeld(){
        return ChampionshipManager.getTotalRaces();
    }
}
