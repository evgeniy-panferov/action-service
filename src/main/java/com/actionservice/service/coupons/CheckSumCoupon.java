package com.actionservice.service.coupons;

import com.actionservice.model.Coupon;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class CheckSumCoupon {

    private Long id;

    private Long admitadId;

    private String name;

    private String status;

    private String description;

    private List<String> regions;

    private String discount;

    private String species;

    private String promocode;

    private String framesetLink;

    private String gotoLink;

    private String shortName;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    private String imageUrl;


    static CheckSumCoupon convert(Coupon coupon){
        var obj = new CheckSumCoupon();

         obj.setAdmitadId(coupon.getAdmitadId());
         obj.setName(coupon.getName());
         obj.setStatus(coupon.getStatus());
         obj.setDescription(coupon.getDescription());
         obj.setRegions(coupon.getRegions());
         obj.setDiscount(coupon.getDiscount());
         obj.setSpecies(coupon.getSpecies());
         obj.setPromocode(coupon.getPromocode());
         obj.setFramesetLink(coupon.getFramesetLink());
         obj.setGotoLink(coupon.getGotoLink());
         obj.setShortName(coupon.getShortName());
         obj.setDateStart(coupon.getDateStart());
         obj.setDateEnd(coupon.getDateEnd());
         obj.setImageUrl(coupon.getImageUrl());

        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckSumCoupon that = (CheckSumCoupon) o;
        return Objects.equals(id, that.id) && Objects.equals(admitadId, that.admitadId) && Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(description, that.description) && Objects.equals(regions, that.regions) && Objects.equals(discount, that.discount) && Objects.equals(species, that.species) && Objects.equals(promocode, that.promocode) && Objects.equals(framesetLink, that.framesetLink) && Objects.equals(gotoLink, that.gotoLink) && Objects.equals(shortName, that.shortName) && Objects.equals(dateStart, that.dateStart) && Objects.equals(dateEnd, that.dateEnd) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, admitadId, name, status, description, regions, discount, species, promocode, framesetLink, gotoLink, shortName, dateStart, dateEnd, imageUrl);
    }
}
