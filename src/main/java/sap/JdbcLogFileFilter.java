package sap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Baofeng on 7/28/2016.
 */
public class JdbcLogFileFilter {
	public static void main(String[] args) throws IOException{
		Stream<String> lines = Files.lines(Paths.get("c:/vm/jdbc.log"));
		lines.filter(l -> !l.contains("at org")
			&& !l.contains("at com.sun")
			&& !l.contains("at sun")
			&& !l.contains("at java")
			&& !l.contains("java.lang")
			&& !l.contains("at oracle")
			&& !l.contains("oracle.jdbc")
			&& !l.contains("at com.successfactors.platform.ui.filter")
			&& !l.contains("at com.successfactors.security.ui.filter")
			&& !l.contains("at com.successfactors.appsec")
			&& !l.contains("at com.successfactors.hris")
			&& !l.contains("at com.successfactors.perflog")
			&& !l.contains("at com.successfactors.datareplication")
			&& !l.contains("at com.successfactors.sca")
			&& !l.contains("at com.successfactors.i18n")
			&& !l.contains("at com.successfactors.platform.dao.util.QueryBuilder")
			&& !l.contains("at com.successfactors.platform.dao.util.JdbcTemplate")
			&& !l.contains("at com.successfactors.platform.dao.impl.oracle.OracleSystemDAO.getSysConfig")
			&& !l.contains("at com.successfactors.legacy.service.impl.GetSysConfigV2Impl")
			&& !l.contains(".doFilter(")
			&& !l.contains("_$$_javassist_")
		)
			.forEach(System.out::println);
	}
}
