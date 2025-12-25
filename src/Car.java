public class Car extends Vehicle {
    private int numberOfDoors;
    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }
    int getNumberOfDoors() {
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors) {
        if(numberOfDoors<=0){
            throw new IllegalArgumentException("Number of Doors must be a positive integer");
        }
        this.numberOfDoors = numberOfDoors;
    }
    public void performService() {
        System.out.println("Service: gas tank is filled.");
    }
    public int getServiceIntervalKm(){
        return 25000;
    }
    @Override
    public double calculateInsuranceFee() {
        return super.getBasePrice() * 0.08 + numberOfDoors * 100;
    }
    @Override
    public String toString() {
        return super.toString() + ", doors= " + numberOfDoors;
    }
}