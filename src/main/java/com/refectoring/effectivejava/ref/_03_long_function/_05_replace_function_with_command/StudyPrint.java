package com.refectoring.effectivejava.ref._03_long_function._05_replace_function_with_command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class StudyPrint {

    private int totalNumberOfEvents;

    private List<Participant> participants;

    public StudyPrint(int totalNumberOfEvents, List<Participant> participants) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        this.participants = participants;
    }

    public void execute() throws IOException {
        try (
                FileWriter fileWriter = new FileWriter("participants.md");
                PrintWriter writer = new PrintWriter(fileWriter)
        ) {
            participants.sort(Comparator.comparing(Participant::username));
            writer.print(header(participants.size()));

            participants.forEach(p -> {
                String markdownHomework = getMarkdownForParticipant(p);
                writer.print(markdownHomework);
            });
        }
    }

    private String getMarkdownForParticipant(Participant p) {
        String markdownHomework = String.format("| %s %s | %.2f%% |\n",
                p.username(),
                checkMark(p),
                p.getRate(this.totalNumberOfEvents));
        return markdownHomework;
    }

    private String header(int totalNumberOfParticipants) {
        StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) | ", totalNumberOfParticipants));

        for (int index = 1; index <= this.totalNumberOfEvents; index++) {
            header.append(String.format(" %d주차 |", index));
        }

        header.append(" 참석율 |\n");
        header.append("| --- ".repeat(Math.max(0, this.totalNumberOfEvents + 2)));
        header.append("|\n");
        return header.toString();
    }

    private String checkMark(Participant p) {
        StringBuilder line = new StringBuilder();
        for (int i = 1; i <= this.totalNumberOfEvents; i++) {
            if (p.homework().containsKey(i) && p.homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }

}
