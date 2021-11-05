package com.xue.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 删除重复字幕，保留最大的一个
 *
 * @author Baofeng
 */
public class SrtDuplicatedRemover {

	public static final String PATHNAME = "d:\\PortableApps\\SPlayerPortable\\Data\\Subtitles\\";
	public static final String langs[] = {"chn", "eng"};
	public static final int maxNumber = 5;
	private static final Logger logger = LoggerFactory.getLogger(SrtDuplicatedRemover.class);
	public static Set<String> identicalSet = new HashSet<>(20);

	static{
		logger.debug("初始化语言后缀");
		for(String lang: langs){
			identicalSet.add(lang);
			logger.debug(lang);
			for(int j = 1; j < maxNumber; j++){
				String key = lang + j;
				logger.debug(key);
				identicalSet.add(key);
			}
		}
		logger.debug("初始化语言后缀OK");
	}

	public static void main(String[] args) throws IOException{
		Map<String, File> map = new HashMap<>();
		File[] dir = new File(PATHNAME).listFiles();
		for(File file: dir){
			String name = file.getName();
			if(name.endsWith("delay")){
				logger.debug("delay需要删除");
				continue;
			}

			name = name.substring(0, name.lastIndexOf("."));

			String substring = name.substring(name.lastIndexOf(".") + 1, name.length());

			if(identicalSet.contains(substring)){
				logger.debug("文件包含语言后缀" + file.toString());
				name = name.substring(0, name.lastIndexOf("."));
			}

			if(map.get(name) == null){
				map.put(name, file);
			}else{
				File fileInMap = map.get(name);
				if(fileInMap.length() < file.length()){
					map.put(name, file);
				}
			}

		}

		logger.debug("唯一文件如下：");
		logger.debug(map.toString());

		for(File file: dir){

			if(!map.containsValue(file)){
				logger.debug("文件比较小，删除之");
				logger.debug(file.toString());
				file.delete();
			}else{
				logger.debug("文件最大，可能需要重命名");
				logger.debug(file.toString());

				String absolutePath = file.getAbsolutePath();
				absolutePath = absolutePath.replace(".chn1", "");
				absolutePath = absolutePath.replace(".chn2", "");
				absolutePath = absolutePath.replace(".chn", "");
				absolutePath = absolutePath.replace(".eng1", "");
				absolutePath = absolutePath.replace(".eng2", "");
				absolutePath = absolutePath.replace(".eng", "");
				file.renameTo(new File(absolutePath));
			}

		}

	}


}
