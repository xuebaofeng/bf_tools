package com.xue.jdbc;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import javax.sql.DataSource;

/**
 * @author Baofeng Xue at 2015/12/28 20:50.
 */
public class Base {
	protected static DataSource getDataSource(){
		BoneCPConfig config = new BoneCPConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost/stock");
		BoneCPDataSource dataSource = new BoneCPDataSource(config);
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		dataSource.setDriverClass("org.postgresql.Driver");
		return dataSource;
	}
}
