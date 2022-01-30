package com.actionservice.service.partners;

import com.actionservice.model.Category;
import com.actionservice.model.Coupon;
import com.actionservice.model.Partner;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
public class CheckSumPartner {

    private Long admitadId;

    private String name;

    private String imageUrl;

    private List<Coupon> coupons;

    private Set<Category> categories;

    private String description;

    private Boolean exclusive;

    public static CheckSumPartner convert(Partner partner) {

        var checkSumPartner = new CheckSumPartner();

        checkSumPartner.setAdmitadId(partner.getAdmitadId());
        checkSumPartner.setName(partner.getName());
        checkSumPartner.setImageUrl(partner.getImageUrl());
        checkSumPartner.setCoupons(partner.getCoupons());
        checkSumPartner.setCategories(partner.getCategories());
        checkSumPartner.setDescription(partner.getDescription());
        checkSumPartner.setExclusive(partner.getExclusive());
        return checkSumPartner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckSumPartner that = (CheckSumPartner) o;

        if (admitadId != null ? !admitadId.equals(that.admitadId) : that.admitadId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return exclusive != null ? exclusive.equals(that.exclusive) : that.exclusive == null;
    }

    @Override
    public int hashCode() {
        int result = admitadId != null ? admitadId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (exclusive != null ? exclusive.hashCode() : 0);
        return result;
    }
}
