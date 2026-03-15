package main;


public class RallyChampionship 
{
    public static void main(String[] args) {

        // 1. Create instance
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // 2. Create Rally Car
        GravelCar gravelCar = new GravelCar("Toyota", "GR Yaris", 380, 20.0);
        AsphaltCar asphaltCar = new AsphaltCar("Hyundai", "i20 N", 380, 15.0);

        // 3. Create player and link to Rally Car
        Driver ogier = new Driver("Sébastien Ogier", "France", asphaltCar);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", gravelCar);
        Driver tanak = new Driver("Ott Tanak", "Estonia", gravelCar);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        // 4. Register players
        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        // 5. Create first match - Rally Finland
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla");
        race1.recordResult(ogier, 1, 25);
        race1.recordResult(tanak, 2, 18);
        race1.recordResult(rovanpera, 3, 15);
        race1.recordResult(neuville, 4, 12);
        manager.addRaceResult(race1);

        // 6. Demonstrate chaning car in the race
        ogier.setCar(gravelCar);
        neuville.setCar(gravelCar);

        // 7. Second match - Monte Carlo
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(rovanpera, 1, 25);
        race2.recordResult(neuville, 2, 18);
        race2.recordResult(ogier, 3, 15);
        race2.recordResult(tanak, 4, 12);
        manager.addRaceResult(race2);

        // 8. Display Standings
        int position = 1;
        for (Driver driver : manager.getDriverStandings()) {
            System.out.println(position + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
            position++;
        }

        // 9. Display Leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = ChampionshipManager.getLeadingDriver();
        System.out.println(leader.getName() + " with " + leader.getPoints() + " points");

        // 10. Display Statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDriverStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDriverStandings()));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        // 11. Display Results
        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaces()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int pos = 1;
            for (Driver driver : race.getResults()) {
                System.out.println("  Position " + pos + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
                pos++;
            }
            System.out.println();
        }

        // 12. Display car ratings (Random figures)
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}
