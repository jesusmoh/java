package io.github.jesusmoh;

import java.time.LocalDate;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        var app = Javalin.create(/* config */)
                .get("/servlet", ctx -> ctx.result("Hello World " + LocalDate.now()))
                .start(7070);
    }
}