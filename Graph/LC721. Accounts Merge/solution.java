class Solution{
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        
        for(List<String> account: accounts){
            String name = "";
            for(String email:account){
                if(name ==""){
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email,name);
            }
        }
        
        
        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for(String email : graph.keySet()){
            if(!seen.contains(email)){
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while(!stack.empty()){
                   String node = stack.pop();
                    component.add(node);
                    for(String nei : graph.get(node)){
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0,emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
}


/***
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
}
class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}*/
