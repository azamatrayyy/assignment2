public class Bus extends Vehicle {
    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }
    private int passengerCapacity;
    int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        if(passengerCapacity <= 0){
            throw new IllegalArgumentException("Passenger capacity must be a positive integer");
        }
        else {
            this.passengerCapacity = passengerCapacity;
        }
    }
    public void performService() {
        System.out.println("Service: fixed motor and engine");
    }
    public int getServiceIntervalKm() {
        return 23000;
    }
    @Override
    public double calculateInsuranceFee() {
        return super.getBasePrice() * 0.05 + passengerCapacity * 100;
    }
    @Override
    public String toString(){
        return super.toString() + ", Passenger Capacity= " + passengerCapacity;
    }
}
