package com.refectoring.effectivejava.ref._18_middle_man._03_replace_subclass_with_delegate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Booking {

    protected Show show;

    protected LocalDateTime time;

    protected PremiumDelegation premiumDelegation;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    public static Booking createBooking(Show show, LocalDateTime time) {
        return new Booking(show, time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        Booking booking = new Booking(show, time);
        booking.premiumDelegation = new PremiumDelegation(new Booking(show, time), extra);
        return booking;
    }

    public boolean hasTalkback() {
        return (this.premiumDelegation != null) ? this.premiumDelegation.hasTalkback() :
            this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return (this.premiumDelegation != null) ? this.premiumDelegation.basePrice(result) : result;
    }

    public boolean hasDinner() {
        return (this.premiumDelegation != null) ? this.premiumDelegation.hasDinner() : false;
    }

}
