package org.trade4life.stealer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.trade4life.stealer.model.PlatformModel;

@Repository
public interface PlatformRepository extends CrudRepository<PlatformModel, Long> {
}
