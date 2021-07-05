package com.actionservice.repository.action;

import com.actionservice.model.Action;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionDao {

    List<Action> findAll();

    List<Action> saveAll(List<Action> actions);

    Action save(Action action);
}
