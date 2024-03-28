package com.NSiTeam.WolframNS.config;

import com.NSiTeam.WolframNS.libraries.SimpleCalculations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibrariesConfig {

    @Bean
    public SimpleCalculations simpleCalculations() {
        return new SimpleCalculations();
    }

}
