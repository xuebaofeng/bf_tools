package com.xue.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Baofeng Xue at 2015/12/28 20:34.
 */
public class Update extends Base {

	static Logger logger = LoggerFactory.getLogger(Update.class);

	public static void main(String[] args) throws SQLException{

		Connection connection = getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement("update benchmark set name=? where id=?");
		for(int i = 1; i < 1_000_000; i++){
			logger.debug("{}", i);
			statement.setString(1, "test" + i);
			statement.setLong(2, i);
			statement.addBatch();

			if(i % 100 == 0){
				statement.executeBatch();
				statement.clearBatch();
			}
		}
		statement.executeBatch();
		statement.close();
		connection.commit();
		connection.close();
	}

}
