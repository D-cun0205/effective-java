package com.refectoring.effectivejava.ref._18_middle_man._03_replace_subclass_with_delegate;

public class PremiumDelegation {

    private Booking booking;
    private PremiumExtra extra;

    public PremiumDelegation(Booking booking, PremiumExtra extra) {
        this.booking = booking;
        this.extra = extra;
    }

    public boolean hasTalkback() {
        return this.booking.show.hasOwnProperty("talkback");
    }

    public double basePrice(double result) {
        return this.extra.getPremiumFee() + result;
    }

    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.booking.isPeakDay();
    }
}
