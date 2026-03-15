package main;

public class AsphaltCar extends RallyCar{
    private double downforce;

    public AsphaltCar(String make, String model, int horsepower, double downforce){
        super(make, model, horsepower);
        this.downforce = downforce;
    }

    public double getDownforce(){
        return this.downforce;
    }

    // Personal answer
    @Override
    public double calculatePerformance(){
        return this.downforce * this.getHorsepower();
    }
}
