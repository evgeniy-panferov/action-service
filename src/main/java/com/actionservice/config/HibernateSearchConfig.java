package com.actionservice.config;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateSearchConfig {

    @Bean
    public Analyzer russianAnalyzer() {
        return new RussianAnalyzer();
    }

}
