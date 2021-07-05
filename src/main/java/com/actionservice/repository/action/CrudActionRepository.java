package com.actionservice.repository.action;

import com.actionservice.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudActionRepository extends JpaRepository<Action, Long> {
}
