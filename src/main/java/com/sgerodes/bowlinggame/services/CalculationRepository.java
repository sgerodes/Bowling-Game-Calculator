package com.sgerodes.bowlinggame.services;

import com.sgerodes.bowlinggame.models.db.CalculationPersistenceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends CrudRepository<CalculationPersistenceModel, Long> {
}
