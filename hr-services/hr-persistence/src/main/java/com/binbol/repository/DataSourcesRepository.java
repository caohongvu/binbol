package com.binbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binbol.entities.DataSource;

@Repository
public interface DataSourcesRepository extends JpaRepository<DataSource, Integer> {

}
