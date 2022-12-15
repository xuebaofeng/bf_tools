package com.xue.amazon;

import java.util.Arrays;
import java.util.List;

public class SecretFruitList {
	public static boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList){

		for(List<String> row: secretFruitList){
			for(int i = 0, j = 0; i < customerPurchasedList.size(); ){
				String f = row.get(j);
				if(f.equals("anything")){
					j++;
					i++;
				}
				if(!f.equals(customerPurchasedList.get(i))){
					i++;
				}else{
					j++;
					i++;
				}
				if(j == row.size())
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args){

		assert matchSecretLists(Arrays.asList(Arrays.asList("apple")), Arrays.asList("apple"));

		assert matchSecretLists(Arrays.asList(Arrays.asList("anything", "apple")),
			Arrays.asList("orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"));
	}
}
