package com.binbol.services;

import java.util.List;

import com.binbol.entities.DataSource;

public interface DataSourceService {
	List<DataSource> getAll();
	DataSource save(DataSource datasource);
}
