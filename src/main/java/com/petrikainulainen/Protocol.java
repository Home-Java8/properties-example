package com.petrikainulainen;

public enum Protocol {

    HTTP("http", "http://"),
    HTTPS("https", "https://"),
    UNDEFINED("", "");

    Protocol(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
