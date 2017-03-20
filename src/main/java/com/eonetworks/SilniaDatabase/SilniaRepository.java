package com.eonetworks.SilniaDatabase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilniaRepository extends CrudRepository<SilniaDB, Long> {

    public SilniaDB findByNumber(Integer number);


}
