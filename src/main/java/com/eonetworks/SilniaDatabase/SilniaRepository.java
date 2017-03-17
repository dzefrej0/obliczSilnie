package com.eonetworks.SilniaDatabase;

import org.springframework.data.repository.CrudRepository;

public interface SilniaRepository extends CrudRepository<SilniaDB, Integer> {

    public SilniaDB findByNumber(Integer number);

}
