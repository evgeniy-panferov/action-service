package com.actionservice.repository.region;

import com.actionservice.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRegionRepository extends JpaRepository<Region, String> {
}
