package org.trade4life.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trade4life.core.model.RegionModel;

@Repository
public interface RegionRepository extends CrudRepository<RegionModel, Long> {
}
