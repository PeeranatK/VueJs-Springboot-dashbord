package com.example.backend;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestQuery extends JpaRepository<TestEntity, Integer> {
    // You can define additional query methods here if needed.

}
