/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursion
class Solution {
    public TreeNode str2tree(String s) {
        //corner case
        if(s == null || s.length() == 0){
            return null;
        }
        int firstParen = s.indexOf("(");//find the index of the first occurrence of character in the give string.
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0,firstParen));
        
        //deal with the single node situation
        TreeNode cur = new TreeNode(val);
        if(firstParen == -1) return cur;
        
        
        int start = firstParen, leftParenCount = 0;
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == '(') leftParenCount++;
            else if(s.charAt(i) == ')')leftParenCount--;
            
            if(leftParenCount == 0 && start == firstParen){
                cur.left = str2tree(s.substring(start+1, i));
                start = i + 1;
            }else if(leftParenCount == 0){
                cur.right = str2tree(s.substring(start+1,i));
            }
        }
        return cur;
        
        
    }
}
