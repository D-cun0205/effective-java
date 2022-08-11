package com.refectoring.effectivejava.ref._06_mutable_data._02_separate_query_from_modifier;

public class Billing {

    private Customer customer;

    private EmailGateway emailGateway;

    public Billing(Customer customer, EmailGateway emailGateway) {
        this.customer = customer;
        this.emailGateway = emailGateway;
    }

    public double getTotalOutstanding() {
        return customer.getInvoices().stream()
                .map(Invoice::getAmount)
                .reduce((double) 0, Double::sum);
    }

    private void sendBill() {
        emailGateway.send(formatBill(customer));
    }

//    public double getTotalOutstandingAndSendBill() {
//        double result = customer.getInvoices().stream()
//                .map(Invoice::getAmount)
//                .reduce((double) 0, Double::sum);
//        sendBill();
//        return result;
//    }
//
//    private void sendBill() {
//        emailGateway.send(formatBill(customer));
//    }

    private String formatBill(Customer customer) {
        return "sending bill for " + customer.getName();
    }
}
