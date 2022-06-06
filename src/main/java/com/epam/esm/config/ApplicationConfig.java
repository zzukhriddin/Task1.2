package com.epam.esm.config;

import com.epam.esm.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {"classpath:application.properties",
        "classpath:application-dev.properties",
        "classpath:application-prod.properties"})
@ComponentScan(basePackages = { "com.epam.*" })
@Profile("prod")
public class ApplicationConfig {

    @Bean
    public GiftCertificateService giftService() {
        return new GiftCertificateService();
    }

    @Autowired
    private Environment environment;

    public void getActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - " + profileName);
        }
    }
}
