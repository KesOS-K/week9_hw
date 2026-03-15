package main;

abstract class RallyCar{
    // Attibutes
    private String make;
    private String model;
    private int horsepower;

    // Constructor
    public RallyCar(String make, String model, int horsepower){
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.model;
    }

    public int getHorsepower(){
        return this.horsepower;
    }

    public abstract double calculatePerformance(); // needed to be implemented
}