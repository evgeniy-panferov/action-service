package com.actionservice.service.fulltextsearch;

import com.actionservice.http.request.TgRequest;
import com.actionservice.model.Coupon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.engine.backend.analysis.AnalyzerNames;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponFullTextSearchService {

    private final EntityManager entityManager;

    @Transactional
    public List<Coupon> search(TgRequest request) {
        SearchSession session = Search.session(entityManager);

        SearchResult<Coupon> result = session.search(Coupon.class)
                .where(find -> find.match()
                        .fields("description", "name", "shortName")
                        .matching(request.getWord())
                        .analyzer(AnalyzerNames.DEFAULT))
                .fetch(50);

        return result.total().hitCount() == 0 ? Collections.emptyList() : result.hits();
    }
}
