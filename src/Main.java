import driver.CategoryB;
import driver.CategoryC;
import driver.CategoryD;
import driver.Driver;
import transport.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryB <Car> driverB = new CategoryB<>("Сергей", true, 2);
        CategoryC <Truck> driverC = new CategoryC<>("Григорий", true, 4);
        CategoryD <Bus> driverD = new CategoryD<>("Станислав", true, 1);

        Sponsor sponsor1 = new Sponsor("BonAqua", 100_000);
        Sponsor sponsor2 = new Sponsor("Bridgestone", 200_000);

        Mechanic<Car> mechanic1 = new Mechanic<>("Сергей Иванов", "СТО 1");
        Mechanic<Truck> mechanic2 = new Mechanic<>("Максим Степанов", "СТО 1");
        Mechanic<Transport> mechanic3 = new Mechanic<>("Илья Волков", "СТО 1");

        Car car = new Car("Audi","A8 50 L TDI quattro",3.0);

        car.addDriver(driverB);
        car.addMechanic(mechanic1);
        car.addSponsor(sponsor1,sponsor2);
        Car car1 = new Car("BMW","Z8",3.0);
        Car car2 = new Car("Kia","Sportage 4",2.4);
        Car car3 = new Car("Hyundai","Avante",1.6);

        Bus bus = new Bus("Икарус","350",4.0);
        bus.addDriver(driverD);
        bus.addMechanic(mechanic3);
        bus.addSponsor(sponsor1);
        Bus bus1 = new Bus("Iveco","320",5.0);
        Bus bus2 = new Bus("Fiat","399",3.5);
        Bus bus3 = new Bus("Hyundai","Н350",4.8);

        Truck truck = new Truck("Mercedes-Benz","B-901" , 6.6);
        truck.addDriver(driverC);
        truck.addMechanic(mechanic2);
        truck.addSponsor(sponsor2);
        Truck truck1 = new Truck("Nissan", "399", 6.2);
        Truck truck2 = new Truck("Chevrolet","M700", 7.5);
        Truck truck3 = new Truck("Scania","T540", 8.7);


        List<Transport> transports = List.of(car,
                truck,
                bus);
        for (Transport transport : transports) {
            printInfo(transport);
        }

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCarToQueue(car1);
        serviceStation.addCarToQueue(car2);
        serviceStation.addTruckToQueue(truck1);
        serviceStation.addTruckToQueue(truck2);
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();
    }

    public static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю: {Брэнд: " + transport.getBrand() +
                " / Модель: " + transport.getModel() +
                " / Объем двигателя: " + transport.getEngineVolume() + " литра.}" );
        System.out.println("Информация по водителям: ");
        for (Driver<?> driver : transport.getDriverList()) {
            System.out.println(driver.getFullName() + " со стажем вождения " + driver.getExperience() + " года.");
        }
        System.out.println("Информация по механикам: ");
        for (Mechanic<?> mechanic : transport.getMechanicList()) {
            System.out.println(mechanic.getName() + " из компании " + mechanic.getCompany());
        }
        System.out.println("Информация по спонсорам: ");
        for (Sponsor sponsor : transport.getSponsorList()) {
            System.out.println(sponsor.getName() + " проспонсировал заезд на " + sponsor.getAmountOfSupport() + " рублей.");
        }
        System.out.println("###############");
    }


    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }
    private static void serviceTransport(Transport transport) {
        try {
            if (!transport.passDiagnostics()){
                throw new RuntimeException("Автомобиль: " + transport.getBrand() + " " + transport.getModel() + " не прошёл диагностику.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}