package com.binbol.services.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binbol.entities.DataSource;
import com.binbol.repository.DataSourcesRepository;
import com.binbol.services.DataSourceCacheService;
import com.binbol.services.DataSourceService;

@Service
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	DataSourcesRepository datasourceRepo;
	
	@Override
	public List<DataSource> getAll() {
		return datasourceRepo.findAll();
	}

	@Override
	public DataSource save(DataSource datasource) {
		datasourceRepo.save(datasource);
		DataSourceCacheService.getInstance().put(datasource.getTenantId(), datasource);
		return datasource;
	}
	
	private void loadAllDatasourceToCache() {
		List<DataSource> datasources = getAll();
		for(DataSource datasource : datasources) {
			DataSourceCacheService.getInstance().put(datasource.getTenantId(), datasource);
		}
	}
	
	@PostConstruct
	private void init() {
		loadAllDatasourceToCache();
	}

}
