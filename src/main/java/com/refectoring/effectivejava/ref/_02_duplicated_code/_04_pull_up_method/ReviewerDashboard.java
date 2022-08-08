package com.refectoring.effectivejava.ref._02_duplicated_code._04_pull_up_method;

import java.io.IOException;

public class ReviewerDashboard extends Dashboard {

    /*
        매개변수화(parameterized) 후에 메소드 올리기

        public void printReviewers() throws IOException {
            GitHub gitHub = GitHub.connect();
            GHRepository repository = gitHub.getRepository("whiteship/live-study");
            GHIssue issue = repository.getIssue(30);

            Set<String> reviewer = new HashSet<>();
            issue.getComments().forEach(c -> reviewer.add(c.getUserName()));

            reviewer.forEach(System.out::println);
        }

        위 코드를 매개변수화하여 printReviewers 메서드 에서는 매개변수화한 메서드를 호출하는 한 줄만 작성하고
        매개변수화한 메서드에 printReviewers 메서드 안에서 사용하는 코드를 옮기는 행위

    */
    public void printReviewers() throws IOException {
        printUsernames(30);
    }

}
