package com.binbol;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.jdbc.DataSourceBuilder;

import com.binbol.entities.DataSource;
import com.binbol.services.DataSourceCacheService;

public class TenantContext {
	private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();
	private static TenantContext tenantContext = null;
	private TenantContext() {};
	
	public static TenantContext getInstance() {
		if(tenantContext == null) {
			tenantContext = new TenantContext();
		}
		return tenantContext;
	}
	public void setCurrentTenant(Object tenant) {
		if(tenant != null) {
			Map<Object, Object> resolvedDataSources = new HashMap<>();
			String tenantId = String.valueOf(tenant);
			DataSource dataSource = DataSourceCacheService.getInstance().get(tenantId);
			if(dataSource != null) {
				DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
				dataSourceBuilder.driverClassName(dataSource.getDriverClass())
						.url(dataSource.getUrl()).username(dataSource.getUsername()).password(dataSource.getPassword());
				resolvedDataSources.put(tenantId, dataSourceBuilder.build());
				MultitenantDataSource.getInstance().setTargetDataSources(resolvedDataSources);
				MultitenantDataSource.getInstance().afterPropertiesSet();
			}
			
			currentTenant.set(tenant);
		}
		
	}

	public Object getCurrentTenant() {
		return currentTenant.get();
	}
}
