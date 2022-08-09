package com.refectoring.effectivejava.ref._04_long_parameter_list._03_remove_flag_argument;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShipmentTest {

    @Test
    void deliveryDate() {
        LocalDate placeOn = LocalDate.of(2022, 8, 9);
        Order orderFromWA = new Order(placeOn, "WA");

        Shipment shipment = new Shipment();
        assertEquals(placeOn.plusDays(1), shipment.rushDeliveryDate(orderFromWA));
        assertEquals(placeOn.plusDays(2), shipment.regularDeliveryDate(orderFromWA));
    }
}
