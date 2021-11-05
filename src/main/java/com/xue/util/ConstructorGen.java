package com.xue.util;

/**
 * @author xuebaofeng  薛保锋
 */
public class ConstructorGen {
	public static void main(String[] args){
		String source = "private String attachid;\n" +
			"    private String productid;\n" +
			"    private String fileurl;\n" +
			"    private String filename;\n" +
			"    private String type;\n" +
			"    private Long sequence;\n" +
			"    private Date uploaddate;\n" +
			"    private String description;\n" +
			"    private String valid;\n" +
			"    private String filemd5;\n" +
			"    private Long filesize;\n" +
			"    private String l2supplierid;\n" +
			"    private String itemcode;";
		outConstructor(source);
		outFactory(source);
	}

	private static void outConstructor(String source){
		String[] lines = source.split("\n");
		for(int i = 0; i < lines.length; i++){
			String line = lines[i];
			String trim = line.trim();
			if(trim.startsWith("/") || trim.length() == 0) continue;
			String[] words = trim.split(" ");
			StringBuilder builder = new StringBuilder(words[2]);
			Character c = builder.charAt(0);
			builder.deleteCharAt(builder.length() - 1);
			String lowerWord = builder.toString();
			builder.deleteCharAt(0);
			String lower = c.toString();
			String upper = lower.toUpperCase();
			builder.insert(0, upper);
			StringBuilder result = new StringBuilder();
			System.out.println(result
				.append("        ")
				.append(lowerWord)
				.append(" = po.get")
				.append(builder)
				.append("();")
				.toString());
		}
	}

	private static void outFactory(String source){
		String[] lines = source.split("\n");
		for(int i = 0; i < lines.length; i++){
			String line = lines[i];
			String trim = line.trim();
			if(trim.startsWith("/") || trim.length() == 0) continue;
			String[] words = trim.split(" ");
			StringBuilder builder = new StringBuilder(words[2]);
			Character c = builder.charAt(0);
			builder.deleteCharAt(builder.length() - 1);
			String lowerWord = builder.toString();
			builder.deleteCharAt(0);
			String lower = c.toString();
			String upper = lower.toUpperCase();
			builder.insert(0, upper);
			StringBuilder result = new StringBuilder();
			System.out.println(result
				.append("po.set")
				.append(builder)
				.append("(")
				.append(lowerWord)
				.append(");")
				.toString());
		}
	}
}
