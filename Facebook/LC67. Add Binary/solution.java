//my solution
/***
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int m = a.length();
        int n = b.length();
        
        int size = Math.min(m,n);
        int i = m-1;
        int j = n-1;
        int carry = 0;
        int sum = 0;
        
        while(i >=0 || j >= 0){
            int A = i > 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int B = j > 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            //int sum = Integer.parseInt(a.charAt(i)) + Integer.parseInt(b.charAt(j)) + carry;
            sum = A + B + carry;
            carry = sum/2;
            sb.append(Integer.toString(sum % 2));
            if(i>0) i--;
            if(j>0) j--;
        }
        StringBuilder reverseStr = sb.reverse();
        return sb.toString();
    }
}
*/



public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
