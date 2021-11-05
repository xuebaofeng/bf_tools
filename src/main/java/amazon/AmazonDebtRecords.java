package amazon;

import java.util.*;

public class AmazonDebtRecords {

	List<String> minimumDebtMembers(List<debtRecord> records){
		Map<String, Integer> map = new HashMap();
		for(debtRecord d: records){
			map.put(d.borrower, map.getOrDefault(d.borrower, 0) - d.amount);
			map.put(d.lender, map.getOrDefault(d.lender, 0) + d.amount);
		}

		int min = Integer.MAX_VALUE;
		List<String> ans = new ArrayList();
		for(Map.Entry<String, Integer> e: map.entrySet()){
			int v = e.getValue();
			if(v < min){
				ans.clear();
				ans.add(e.getKey());
				min = v;
			}else if(v == min){
				ans.add(e.getKey());
			}
		}

		Collections.sort(ans);

		if(min >= 0){
			ans.clear();
			ans.add("Nobody has a negative balance");
		}

		return ans;
	}

	class debtRecord {
		String borrower = "";
		String lender = "";
		int amount = 0;

		debtRecord(){
		}

		debtRecord(String borrower, String lender, int amount){
			this.borrower = borrower;
			this.lender = lender;
			this.amount = amount;
		}
	}
}
