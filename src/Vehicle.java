import static java.lang.Math.abs;

abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen=1;
    private String model;
    private int year;
    private double basePrice;
    public Vehicle(String model, int year, double basePrice) {
        this.id=idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }
    int getId() {
        return id;
    }
    String getModel() {
        return model;
    }
    int getYear() {
        return year;
    }
    double getBasePrice() {
        return basePrice;
    }
    public void setModel(String model) {
       if(model==null || model.isEmpty()) {
           throw new IllegalArgumentException("Model cannot be empty");
       }
       else this.model=model;
    }
    public void setYear(int year) {
        if(year>=1750 && year<=2026){
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("Invalid year");
        }
    }
    public void setBasePrice(double basePrice) {
        if(basePrice>0){
            this.basePrice = basePrice;
        }
        else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
    public int getAge(int currentYear) {
        return abs(year-currentYear);
    }
    public abstract double calculateInsuranceFee();
    @Override
    public String toString(){
        return ("Vehicle id=" + id + ", model=" + model + ", year=" + year + ", basePrice=" + basePrice );
    }
}
