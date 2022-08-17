package com.refectoring.effectivejava.ref._13_loops._01_replace_loop_with_pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    void twitterHandle() {
        Author dcun = new Author("ms", null);
        Author captain = new Author("naver", "captain");
        assertEquals(List.of("captain"), Author.TwitterHandles(List.of(dcun, captain), "naver"));
    }
}