package com.alliander.catsapp.repositories;

import com.alliander.catsapp.domain.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

}
