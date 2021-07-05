package com.actionservice.repository.action;

import com.actionservice.model.Action;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class ActionDAOImpl implements ActionDao {

    private final CrudActionRepository crudActionRepository;

    @Override
    public List<Action> findAll() {
        log.info("ActionRepositoryImpl findAll");
        return crudActionRepository.findAll();
    }

    @Override
    public List<Action> saveAll(List<Action> actions) {
        log.info("ActionRepositoryImpl saveAll - {}", actions);
        return crudActionRepository.saveAll(actions);
    }

    @Override
    public Action save(Action action) {
        return crudActionRepository.save(action);
    }
}
