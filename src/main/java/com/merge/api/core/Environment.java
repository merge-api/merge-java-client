package com.merge.api.core;

public final class Environment {
    public static final Environment PRODUCTION = new Environment("https://api.merge.dev");

    public static final Environment SANDBOX = new Environment("https://api-sandbox.merge.dev");

    public static final Environment PRODUCTION_EU = new Environment("https://api-eu.merge.dev");

    private final String url;

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}
