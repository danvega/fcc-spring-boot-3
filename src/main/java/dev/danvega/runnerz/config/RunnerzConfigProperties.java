package dev.danvega.runnerz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("runnerz")
public record RunnerzConfigProperties(
        /*
         * The Url of the frontend application to manage runs
         */
        @DefaultValue("http://localhost:3000") String frontendUrl
) {
}
