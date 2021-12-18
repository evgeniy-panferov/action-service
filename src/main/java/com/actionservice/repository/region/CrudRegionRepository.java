package com.actionservice.repository.region;

import com.actionservice.model.Region;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudRegionRepository extends JpaRepository<Region, String> {

}
