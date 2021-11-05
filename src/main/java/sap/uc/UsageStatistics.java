package sap.uc;

import com.xue.util.FileHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

public class UsageStatistics {
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
	static LocalDateTime localDateTime = LocalDateTime.now();
	static Date m3 = Date.from(localDateTime.minusMonths(3).toInstant(ZoneOffset.UTC));
	static Date m6 = Date.from(localDateTime.minusMonths(6).toInstant(ZoneOffset.UTC));
	static Date m12 = Date.from(localDateTime.minusMonths(12).toInstant(ZoneOffset.UTC));

	public static void main(String[] args) throws ParseException{

		int c3 = 0;
		int c6 = 0;
		int c12 = 0;
		List<String> lines = FileHelper.readLines("C:\\SAPDevelop\\github\\baofeng.tools\\src\\main\\resources\\us-f.txt");
		System.out.println(lines.size());
		for(String line: lines){
			if(!line.contains("feature_id")) continue;
			line = line.split("\\(")[1];
			line = line.split("\\)")[0];
			line = line.split(" 20")[1];
			line = line.split(" ")[0];
			Date parse = simpleDateFormat.parse(line);
			if(parse.after(m3)){
				c3++;
			}

			if(parse.after(m6)){
				c6++;
			}

			if(parse.after(m12)){
				c12++;
			}
		}
		System.out.println(c3);
		System.out.println(c6);
		System.out.println(c12);
	}
}
