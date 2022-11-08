package transport;

import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceStation {

    private Queue<Transport> queue = new ArrayDeque<>();

    private void addTransport(Transport transport) {
        queue.offer(transport);
    }

    public void addCarToQueue(Car car) {
        addTransport(car);
    }

    public void addTruckToQueue(Truck truck) {
        addTransport(truck);
    }

    public void technicalInspectionCar() {
        if (!queue.isEmpty()) {
            Transport transport = queue.poll();
            transport.repair();
        }
    }
}
