package com.actionservice.http;


import com.actionservice.model.dto.telegram.PartnerDto;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.service.fulltextsearch.PartnerFullTextSearchService;
import com.actionservice.util.PartnerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerCtrl {

    private final PartnerDAOImpl partnerDAO;
    private final PartnerFullTextSearchService searchService;

    @GetMapping
    public List<PartnerDto> getAll() {
        return PartnerUtil.toDtos(partnerDAO.findAll());
    }

    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartnerDto>> getPartnerByCategoryId(@PathVariable Long categoryId) {
        return new ResponseEntity<>(PartnerUtil.toDtos(partnerDAO.findByCategoryId(categoryId)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PartnerDto>> findCouponByString(String searchString) {
        return new ResponseEntity<>(PartnerUtil.toDtos(searchService.search(searchString)), HttpStatus.OK);
    }

}
