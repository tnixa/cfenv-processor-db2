package org.terrence.testapp.jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Things, Long> {
    List<Things> findByName(String name);

    Iterable<Things> findAll();
}