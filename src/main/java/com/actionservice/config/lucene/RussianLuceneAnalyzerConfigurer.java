package com.actionservice.config.lucene;

import lombok.RequiredArgsConstructor;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class RussianLuceneAnalyzerConfigurer implements LuceneAnalysisConfigurer {

    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer(AnalyzerNames.DEFAULT).custom()
                .tokenizer(StandardTokenizerFactory.class)
                .tokenFilter(LowerCaseFilterFactory.class)
                .tokenFilter(ASCIIFoldingFilterFactory.class)
                .tokenFilter(SnowballPorterFilterFactory.class)
                .param("language", "Russian")
                .tokenFilter(StopFilterFactory.class)
                .param("ignoreCase", "true")
                .param("words", "russian_stop.txt")
                .param("format", "snowball");
    }
}
