package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.api.HistoryOutputModel;
import com.sgerodes.bowlinggame.models.db.HistoryPersistenceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends CrudRepository<HistoryPersistenceModel, Long> {
}
