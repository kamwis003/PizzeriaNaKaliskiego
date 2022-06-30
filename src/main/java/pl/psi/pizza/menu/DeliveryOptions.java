package pl.psi.pizza.menu;

import pl.psi.pizza.model.Delivery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOptions {
    public List<Delivery> getDeliveryList() {
        ArrayList<Delivery> delivery = new ArrayList<>();
        delivery.add(new Delivery("Loskoń", new BigDecimal("4.00")));
        delivery.add(new Delivery("Kapuściska", new BigDecimal("5.00")));
        delivery.add(new Delivery("Kaliskiego", new BigDecimal("5.00")));
        delivery.add(new Delivery("Wyżyny", new BigDecimal("5.00")));
        delivery.add(new Delivery("Fordon", new BigDecimal("6.00")));
        return delivery;
    }
}
