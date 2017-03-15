package com.eonetworks.SilniaDatabase;

import org.springframework.data.repository.CrudRepository;

public interface SilniaRepository extends CrudRepository<SilniaBD, Long> {

    public SilniaBD findByNumber(Integer number);

}
