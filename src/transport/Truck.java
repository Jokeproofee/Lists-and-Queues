package transport;

public class Truck extends Transport implements Competing {

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println("Грузовой автомобиль начал движение");
    }

    @Override
    public void finishTheMovement() {
        System.out.println("Грузовой автомобиль закончил движение");
    }

    @Override
    public double pitStop() {
        System.out.println("Пит-стоп для грузового автомобиля " + getBrand() + " " + getModel());
        return 0;
    }

    @Override
    public double bestLapTime() {
        System.out.println("Лучший круг для грузового автомобиля " + getBrand() + " " + getModel());
        return 0;
    }

    @Override
    public int maximumSpeed() {
        System.out.println("Максимальная скорость грузового автомобиля " + getBrand() + " " + getModel());
        return 0;
    }

    @Override
    public String toString() {
        return "{Брэнд: " + getBrand() +
                " / Модель: " + getModel() +
                " / Объем двигателя: " + getEngineVolume() + " литра}";
    }

    @Override
    public boolean passDiagnostics() {
        return false;
    }

    @Override
    public void repair() {
        System.out.println("Грузовик " + getBrand() + getModel() + " отремонтирован.");
    }
}