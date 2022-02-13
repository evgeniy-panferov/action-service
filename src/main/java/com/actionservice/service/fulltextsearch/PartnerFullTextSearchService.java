package com.actionservice.service.fulltextsearch;

import com.actionservice.model.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFullTextSearchService {

    private final EntityManager entityManager;

    public List<Partner> search(String searchString) {
        SearchSession session = Search.session(entityManager);

        SearchResult<Partner> result = session.search(Partner.class).where(find -> find.match()
                .fields("description", "name")
                .matching(searchString)
                .analyzer(AnalyzerNames.DEFAULT))
                .fetch(50);

        return result.total().hitCount() == 0 ? Collections.emptyList() : result.hits();
    }
}
