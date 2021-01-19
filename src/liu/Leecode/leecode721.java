package liu.Leecode;

import javax.jnlp.IntegrationService;
import java.util.*;

public class leecode721 {
    int n;
    int[] pre;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        n = accounts.size();
        pre = new int[n];
        init();
        Map<String, Integer> emailMap = new HashMap<String, Integer>();
        Map<String, String> nameMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            String name = accounts.get(i).get(0);
            for(int j = 1; j < accounts.get(i).size(); j++){
                nameMap.put(accounts.get(i).get(j),name);
                if(emailMap.containsKey(accounts.get(i).get(j))){
                    unio(emailMap.get(accounts.get(i).get(j)),i);
                }
                emailMap.put(accounts.get(i).get(j),i);
            }
        }
        Map<Integer,List<String>> result = new HashMap<>();
        for(String email : emailMap.keySet()){
            Integer index = emailMap.get(email);
            index = find(index);
            List<String> list = result.get(index);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(email);
            result.put(index,list);
        }
        List<List<String>> r = new ArrayList<>();
        for(Integer integer:result.keySet()){
            String name = accounts.get(integer).get(0);
            List<String> email = result.get(integer);
            email.sort(String::compareTo);
            List<String> t = new ArrayList<>();
            t.add(name);
            t.addAll(email);
            r.add(t);
        }

        return r;
    }

    private void init(){
        for(int i = 0; i < n; i++){
            pre[i] = i;
        }
    }

    private int find(int i){
        if(i != pre[i]){
            pre[i] = find(pre[i]);
        } return pre[i];
    }

    private void unio(int i,int j){
        pre[find(i)] = find(j);
    }
}
