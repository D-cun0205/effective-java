package com.refectoring.effectivejava.ref._02_duplicated_code._03_slide_statements;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StudyDashboard {

    private void printParticipants(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));

        participants.forEach(System.out::println);
    }

    private void printReviewers() throws IOException {
        // 사용할 변수를 상단에 정의 해놓으면 코드 분리하기에 적합하지 않기 때문에 위 메서드처럼 사용 메서드 바로 윗줄에 정의한다
        Set<String> reviewers = new HashSet<>();
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        issue.getComments().forEach(c -> reviewers.add(c.getBody()));

        reviewers.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }
}
