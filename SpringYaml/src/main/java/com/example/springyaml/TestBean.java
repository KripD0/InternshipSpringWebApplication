package com.example.springyaml;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
@ToString
public class TestBean {

    private String name;
    private String version;

    @Value("${realise}")
    private String realise;

    @PostConstruct
    public void TestMethod() {
        System.out.println("Name: " + name + ", version: " + version + ", realise: " + realise);
    }


}
