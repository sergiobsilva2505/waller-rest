package br.com.sbs.walllet.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("Message")
    private final String indexMessage = "Hello World! Wallet API-Rest application.";

    public Message() {

    }
}
