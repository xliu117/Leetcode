class Solution{

  
  public class UF{
      public HashMap<Integer, Integer> root;
      root = new HashMap<>();
      for(Integer nodeLabel : hash){
           root.put(nodeLabel, nodeLabel);
      }
  }
  
  public int find(int nodeLabel){
      while(nodeLabel
