package com.example.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源抽象实现类(获取数据源对应的key)
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	private int dataSourceMasterSize;
	
	private int dataSourceSlaveSize;
	
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceType();
    }
    
    public void init(){
    	DynamicDataSourceHolder.dataSourceMasterSize = dataSourceMasterSize;
    	DynamicDataSourceHolder.dataSourceSlaveSize = dataSourceSlaveSize;
	}

	public int getDataSourceMasterSize() {
		return dataSourceMasterSize;
	}

	public void setDataSourceMasterSize(int dataSourceMasterSize) {
		this.dataSourceMasterSize = dataSourceMasterSize;
	}

	public int getDataSourceSlaveSize() {
		return dataSourceSlaveSize;
	}

	public void setDataSourceSlaveSize(int dataSourceSlaveSize) {
		this.dataSourceSlaveSize = dataSourceSlaveSize;
	}
}
