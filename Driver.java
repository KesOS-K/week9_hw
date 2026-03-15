package main;

public class Driver {
    // Attributes
    private String name;
    private String country;
    private int points;
    private RallyCar car;

    // Constructor
    public Driver(String name, String country, RallyCar car){
        this.name = name;
        this.country = country;
        this.car = car;
        this.points = 0; // Initial points
    }

    public String getName(){
        return this.name;
    }

    public String getCountry(){
        return this.country;
    }

    public int getPoints(){
        return points;
    }

    public RallyCar getCar(){
        return this.car;
    }

    public void setCar(RallyCar new_car){
        this.car = new_car;
    }

    public void addPoints(int new_points){
        points += new_points;
    }
}


