package com.omarE505.DependencyInjection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("com")
public class OmarConstructorConfig {
    private final String username;
    private final String password;
    private final String jdbcurl;

    public OmarConstructorConfig(String username, String password, String jdbcurl) {
        this.username = username;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }
}
