import java.security.Provider;
import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    public ArrayList<Vehicle> vehicles = new ArrayList<>();
    public ArrayList<Servicable> services =  new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public void run() {
        while (true) {
            System.out.println("1. Print all vehicles\n" +
                    "2. Add new car\n" +
                    "3. Add new bus\n" +
                    "4. Show total yearly insurance fees\n" +
                    "5. Show vehicles older than N years\n" +
                    "6. Perform service for all vehicles\n" +
                    "7. Quit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    if (vehicles.isEmpty()) {
                        throw new IllegalArgumentException("No vehicles in the fleet");
                    } else {
                        for(int i=0; i<vehicles.size(); i++) {
                            System.out.println(vehicles.get(i).toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter the model of the car: ");
                    String modelCar = input.next();
                    System.out.println("Enter the year of the car: ");
                    int yearCar = input.nextInt();
                    System.out.println("Enter the baseprice of the car: ");
                    double basepriceCar = input.nextDouble();
                    System.out.println("Enter the number of the doors: ");
                    int doors = input.nextInt();
                    Car car = new Car(modelCar, yearCar, basepriceCar, doors);
                    vehicles.add(car);
                    services.add(car);
                    break;
                case 3:
                    System.out.println("Enter the model of the bus: ");
                    String modelBus = input.next();
                    System.out.println("Enter the year of the bus: ");
                    int yearBus = input.nextInt();
                    System.out.println("Enter the baseprice of the bus:");
                    double basepriceBus = input.nextDouble();
                    System.out.println("Enter the passenger capacity of the bus: ");
                    int passengerCapacity = input.nextInt();
                    Bus bus = new Bus(modelBus, yearBus, basepriceBus, passengerCapacity);
                    vehicles.add(bus);
                    services.add(bus);
                    break;
                case 4:
                    for (int i = 0; i < vehicles.size(); i++) {
                        System.out.println(vehicles.get(i).calculateInsuranceFee());
                    }
                    break;
                case 5:
                    System.out.println("Enter the current year and N: ");
                    int currentYear = input.nextInt();
                    int N = input.nextInt();
                    for (int i = 0; i < vehicles.size(); i++) {
                        if (vehicles.get(i).getAge(currentYear) > N) {
                            System.out.println(vehicles.get(i).toString());
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < services.size(); i++) {
                        services.get(i).performService();
                    }
                    break;
                case 7:
                    System.out.print("See you next time!!!");
                    return;
            }
        }
    }
    public static void main(String[] args) {
        new FleetApp().run();
    }
}
