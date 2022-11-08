package transport;

public class Bus extends Transport implements Competing {

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void finishTheMovement() {
        System.out.println("Автобус закончил движение");
    }

    @Override
    public double pitStop() {
        System.out.println("Пит-стоп для автобуса " + getBrand() + " " + getModel());
        return 0;
    }

    @Override
    public double bestLapTime() {
        System.out.println("Лучший время круга для автобуса " + getBrand() + " " + getModel());
        return 0;
    }

    @Override
    public int maximumSpeed() {
        System.out.println("Максимальная скорость автобуса " + getBrand() + " " + getModel());
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
        System.out.println("Автобус " + getBrand() + getModel() + " в диагностике не требуется");
        return true;
    }

    @Override
    public void repair() {
        System.out.println("Автобус " + getBrand() + getModel() + " отремонтирован.");
    }
}