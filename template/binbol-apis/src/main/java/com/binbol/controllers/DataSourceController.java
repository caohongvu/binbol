package com.binbol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binbol.TenantContext;
import com.binbol.entities.DataSource;
import com.binbol.services.DataSourceService;

@Controller
public class DataSourceController {
    @Autowired
    private DataSourceService dataSourceService;

    @RequestMapping(path = "/datasource", method= RequestMethod.POST)
    public ResponseEntity<?> createDataSource(@RequestBody DataSource datasource) {
        TenantContext.getInstance().setCurrentTenant(null);
        dataSourceService.save(datasource);
        return ResponseEntity.ok(datasource);
    }
    
    @RequestMapping(path = "/datasource", method= RequestMethod.GET)
    public ResponseEntity<?> createDataSource() {
        return ResponseEntity.ok(dataSourceService.getAll());
    }
}
