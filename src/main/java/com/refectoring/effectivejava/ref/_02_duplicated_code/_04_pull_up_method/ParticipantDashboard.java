package com.refectoring.effectivejava.ref._02_duplicated_code._04_pull_up_method;

import java.io.IOException;

public class ParticipantDashboard extends Dashboard {

    public void printUsernames(int eventId) throws IOException {
        super.printUsernames(eventId);
    }
}
