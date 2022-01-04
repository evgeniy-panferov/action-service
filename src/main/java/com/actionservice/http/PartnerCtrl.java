package com.actionservice.http;


import com.actionservice.model.Partner;
import com.actionservice.model.dto.telegram.PartnerDto;
import com.actionservice.repository.partner.PartnerDAOImpl;
import com.actionservice.util.PartnerUtil;
import lombok.RequiredArgsConstructor;
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

    @GetMapping
    public List<Partner> getAll() {
        return partnerDAO.findAll();
    }

    @GetMapping("/{categoryId}")
    public List<PartnerDto> getPartnerByCategoryId(@PathVariable Long categoryId) {
        return PartnerUtil.toDtos(partnerDAO.findByCategoryId(categoryId));
    }
}
