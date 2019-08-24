//toposort+graph
class Solution {
    public String alienOrder(String[] words) {
        //1.corner cases
        if(words == null || words.length == 0){
            return "";
        }
        
        //initialize the graph and indegreemap
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegreeMap = new HashMap<>();
        
        //build the indegreemap(initial state)
        for(String word : words){
            for(char c : word.toCharArray()){
                inDegreeMap.put(c,0);
            }
        }
        
        
        //build the graph and the initial indegreemap
        for(int i = 0; i < words.length - 1; i++){
            String currWord = words[i];
            String nextWord = words[i+1];
            int minLength = Math.min(currWord.length(), nextWord.length());
            
            for(int j = 0; j < minLength; j++){
                char currChar = currWord.charAt(j);
                char nextChar = nextWord.charAt(j);
                if(currChar != nextChar){
                    graph.putIfAbsent(currChar, new HashSet<>());//adjacent list starting from currChar
                    Set<Character> set = graph.get(currChar);
                    if(!set.contains(nextChar)){//should pay attention here!
                        set.add(nextChar);
                        graph.put(currChar, set);
                        inDegreeMap.put(nextChar, inDegreeMap.getOrDefault(nextChar, 0) + 1); 
                    }
                    
                    break;
                }
            }
        }
        
        
        //BFS topoSort
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        //first pick our all the indegree == 0
        for(char key : inDegreeMap.keySet()){
            if(inDegreeMap.get(key) == 0){
                queue.offer(key);
            }
        }
        
        
        //BFS traversal to build result string 
        while(!queue.isEmpty()){
            char currChar = queue.poll();
            sb.append(currChar);
            
            if(graph.containsKey(currChar)){
                for(char nextChar : graph.get(currChar)){
                    inDegreeMap.put(nextChar, inDegreeMap.get(nextChar) - 1);
                    if(inDegreeMap.get(nextChar) == 0){
                        queue.offer(nextChar);
                    }
                }
            }
        }
        
        
         // check if input order is valid 
        if(sb.length() != inDegreeMap.size()){
            return "";
        }
        
        return sb.toString();
        
    }
}

