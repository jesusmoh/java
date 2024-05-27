package io.github.jesusmoh.zproduct.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class Ping {

    private static final Logger LOG = Logger.getLogger(Ping.class.getName());

    @GetMapping
    public String ping() {
        LOG.info("Ping-----");
        return "pong";
    }
}
