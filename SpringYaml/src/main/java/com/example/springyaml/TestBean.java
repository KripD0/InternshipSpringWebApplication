package com.example.springyaml;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class TestBean {

    private String name;
    private String version;

    @Value("${realise}")
    private String realise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRealise() {
        return realise;
    }

    public void setRealise(String realise) {
        this.realise = realise;
    }

    @PostConstruct
    public void TestMethod() {
        System.out.println("Name: " + name + ", version: " + version + ", realise: " + realise);
    }
}
