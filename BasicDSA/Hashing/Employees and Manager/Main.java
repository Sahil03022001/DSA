import java.io.*;
import java.util.*;

class Solution {

	int rec(HashMap<String, Integer> ans, Map<String, HashSet<String>> map, String ceo){

		if(!map.containsKey(ceo)){
			ans.put(ceo, 0);
			return 1;
		}

		int count = 0;
		for(String emp : map.get(ceo)){
			count += rec(ans, map, emp);
		}

		ans.put(ceo, count);
		return count + 1;
	}
    public void EmpUnderManager(Map<String, String> emp)
	{
		String ceo = "";
		Map<String, HashSet<String>> map = new HashMap();
		
		for(String employee : emp.keySet()){
			
			String manager = emp.get(employee);

			if(manager.equals(employee)){
				ceo = manager;
				continue;
			}
		
			if(!map.containsKey(manager)){
				HashSet<String> newSet = new HashSet();
				newSet.add(employee);
				map.put(manager, newSet);
			}else{
				HashSet<String> set = map.get(manager);
				set.add(employee);
				map.put(manager, set);
			}
		}

		HashMap<String, Integer> ans = new HashMap();
		rec(ans, map, ceo);

		for(String s : ans.keySet()){
			System.out.println(s + " " + ans.get(s));
		}
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}