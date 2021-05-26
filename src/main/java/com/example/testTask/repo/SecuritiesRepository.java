package com.example.testTask.repo;

import com.example.testTask.models.Securities;
import org.springframework.data.repository.CrudRepository;

public interface SecuritiesRepository extends CrudRepository<Securities, Integer> {

}
