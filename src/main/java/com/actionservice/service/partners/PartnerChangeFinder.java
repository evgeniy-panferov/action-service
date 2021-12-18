package com.actionservice.service.partners;

import com.actionservice.model.Partner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PartnerChangeFinder {

    static Set<Long> find(List<Partner> admitad, List<Partner> db) {

        List<CheckSumPartner> adm = admitad.stream()
                .map(CheckSumPartner::convert)
                .collect(Collectors.toList());

        List<CheckSumPartner> db1 = db.stream()
                .map(CheckSumPartner::convert)
                .collect(Collectors.toList());

        adm.removeAll(db1);

        return adm.stream()
                .map(CheckSumPartner::getAdmitadId)
                .collect(Collectors.toSet());

    }

}
