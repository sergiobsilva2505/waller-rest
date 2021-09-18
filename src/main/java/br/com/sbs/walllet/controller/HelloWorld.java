package br.com.sbs.walllet.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorld {

    @JsonProperty("Message")
    private final String message = "Hello World! Wallet API-Rest application.";

    public HelloWorld() {
    }

}
