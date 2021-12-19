package com.actionservice.http;


import com.actionservice.model.Partner;
import com.actionservice.repository.partner.PartnerDAOImpl;
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
    public List<Partner> getAll(){
        return partnerDAO.findAll();
    }

    @GetMapping("/{id}")
    public List<Partner> getPartnerByCategoryId(@PathVariable Long id){
        return partnerDAO.findByCategoryId(id);
    }
}
