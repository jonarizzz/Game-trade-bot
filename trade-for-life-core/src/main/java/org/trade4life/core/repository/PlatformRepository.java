package org.trade4life.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trade4life.core.model.PlatformModel;

@Repository
public interface PlatformRepository extends CrudRepository<PlatformModel, Long> {
}
