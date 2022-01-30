package com.actionservice.http;


import com.actionservice.model.dto.telegram.PartnerDto;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.fulltextsearch.PartnerFullTextSearchService;
import com.actionservice.util.PartnerUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerCtrl {

    private final PartnerDAOImpl partnerDAO;
    private final PartnerFullTextSearchService searchService;

    @GetMapping
    public  ResponseEntity<List<PartnerDto>> getAll() {
        return new ResponseEntity<>(PartnerUtil.toDtos(partnerDAO.findAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartnerDto>> getPartnerByCategoryId(@PathVariable Long categoryId) {
        log.info("PartnerCtrl getPartnerByCategoryId - {}", categoryId);
        return new ResponseEntity<>(PartnerUtil.toDtos(partnerDAO.findByCategoryId(categoryId)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PartnerDto>> findCouponByString(String searchString) {
        log.info("PartnerCtrl findCouponByString - {}", searchString);
        return new ResponseEntity<>(PartnerUtil.toDtos(searchService.search(searchString)), HttpStatus.OK);
    }

}
