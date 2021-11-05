package com.xue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Baofeng Xue on 2/20/2017.
 */
public class Main {
	public static void main(String[] args) throws Exception{
		String fileName = "src\\main\\resources\\RBPFacade.java";
		String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		String[] split = content.split(";");
		int count = 0;
		List<String> methods = new ArrayList<>();
		for(String s: split){
			s = removeJavaDoc(s);
			s = format(s);
			if(!isMethod(s)) continue;
			if(isNotConcern(s)) continue;
			methods.add(s);
			count++;
		}

		methods.sort((o1, o2) -> {
			String[] split1 = o1.split(" ");
			String[] split2 = o2.split(" ");
			return split1[1].compareTo(split2[1]);
		});

		for(String method: methods){
			System.out.println(method);
		}
		System.out.println(count);
	}

	private static boolean isNotConcern(String s){
		if(s.toLowerCase().contains("userid")) return false;
		if(s.toLowerCase().contains("baseuser")) return false;
		if(s.toLowerCase().contains("targetuser")) return false;
		if(s.toLowerCase().contains("personid")) return true;
		if(s.toLowerCase().contains("baseperson")) return true;
		if(s.toLowerCase().contains("targetperson")) return true;
		if(s.toLowerCase().contains("dimension")) return true;
		if(s.toLowerCase().contains("loadpermissionrecords")) return true;
		if(s.contains("purgeCache")) return true;
		if(s.contains("isAssociatedWithTargetPopulation")) return true;
		if(s.contains("getPermissionSpec")) return true;
		if(s.contains("getRoleIdsByPermission")) return true;
		if(s.contains("getDynamicGroupsByFields")) return true;
		if(s.contains("updateRBPGroupSmartFilter")) return true;
		if(s.contains("getRoleIdsRuleIdsMap(Set<Long> roleIds)")) return true;
		if(s.contains("addPermissionRole")) return true;
		if(s.contains("updatePermissionRole")) return true;
		if(s.contains("deletePermissionRole")) return true;
		if(s.contains("getPermissionRolesBySubDomainTemplateId")) return true;
		if(s.contains("getPermissionRoleByRoleName")) return true;
		if(s.contains("getPermissionGroupsBySubdomain")) return true;
		if(s.contains("getPermissionsBySubDomain")) return true;
		if(s.contains("getRuleIdsByRelationship")) return true;
		if(s.contains("searchPermissionRoles")) return true;
		if(s.contains("searchDynamicGroups")) return true;
		if(s.contains("getPermissionRoleAccessUsers")) return true;
		if(s.contains("getDynamicGroupMemberUsers")) return true;
		if(s.contains("getOpenFields")) return true;
		if(s.toLowerCase().contains("()")) return true;
		return false;
	}

	private static String format(String s){
		s = s.replace("\n", "");
		while(s.contains("  ")){
			s = s.replace("  ", " ");
		}
		s = s.trim();
		return s;
	}

	private static String removeJavaDoc(String s){
		int begin = s.indexOf("/**");
		int end = s.indexOf("*/");
		if(begin == -1) return s;
		String javaDoc = s.substring(begin, end + 2);
		String replace = s.replace(javaDoc, "");
		return replace;
	}

	private static boolean isMethod(String s){
		if(s.startsWith("package")) return false;
		if(s.startsWith("import")) return false;
		if(s.contains("interface")) return false;
		if(s.length() <= 1) return false;
		return true;
	}
}
