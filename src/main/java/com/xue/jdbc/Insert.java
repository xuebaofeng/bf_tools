package com.xue.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Baofeng Xue at 2015/12/28 20:34.
 */
public class Insert extends Base {
	static Logger logger = LoggerFactory.getLogger(Insert.class);

	public static void main(String[] args) throws SQLException{

		Connection connection = getDataSource().getConnection();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select max(id) from benchmark");
		resultSet.next();
		long max = resultSet.getLong(1);

		for(long i = max + 1; i < 10_000_000; i++){
			logger.debug("{}", i);
			statement.addBatch("insert into benchmark values(" + i + ",'test" + i + "')");
			if(i % 100000 == 0){
				statement.executeBatch();
				statement.clearBatch();
			}
		}
		statement.executeBatch();
	}

}
