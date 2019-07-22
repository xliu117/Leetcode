class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}



///KMP
//KMP (Knuth-Morris-Pratt) 
/***
Intuition

As before, we want to find whether B exists in A+A. The KMP algorithm is a textbook algorithm that does string matching in linear time, which is faster than brute force.

Algorithm

The algorithm is broken up into two steps, building the shifts table (or failure table), and using it to find whether a match exists.

The shift table tells us about the largest prefix of B that ends here. More specifically, B[:shifts[i+1]] == B[i - shifts[i+1] : i] is the largest possible prefix of B ending before B[i].

To build the shift table, we use a dynamic programming approach, where all previously calculated values of shifts are correct. Then, left will be the end of the candidate prefix of B, and right will be the end of the candidate section that should match the prefix B[0], B[1], ..., B[left]. Call positions (left, right) "matching" if the prefix ending at B[left] matches the same length string ending at B[right]. The invariant in our loop will be that (left - 1, right - 1) is matching by the end of each for-block.

In a new for-block, if (left, right) is matching (ie. (left - 1, right - 1) is matching from before, plus B[left] == B[right]), then we know the shift (right - left) is the same number as before. Otherwise, when (left, right) is not matching, we need to find a shorter prefix.

Our strategy is to find a matching of (left2, right) where left2 < left, by finding matchings (left2 - 1, right - 1) plus checking B[left2] == B[right]. Since (left - 1, right - 1) is a matching, by transitivity we want to find matchings (left2 - 1, left - 1). The largest such left2 is left2 = left - shifts[left]. We repeatedly check these left2's in greedy order from largest to smallest.

To find a match of B in A+A with such a shift table ready, we employ a similar strategy. We maintain a matching (match_len - 1, i - 1), where these positions correspond to strings of length match_len that end at B[match_len - 1] and (A+A)[i-1] respectively.

Now when trying to find the largest length matching for (A+A) at position i, it must be at most (match_len - 1) + 1, where the quantity in brackets is the largest length matching to position i-1.

Again, our strategy is to find a matching (match_len2 - 1, i - 1) plus check that B[match_len2] == (A+A)[i]. Similar to before, if B[match_len] != (A+A)[i], then because (match_len - 1, i - 1) was a matching, by transitivity (match_len2 - 1, match_len - 1) must be a matching, of which the largest is found by match_len2 = match_len - shifts[match_len]. We also repeatedly check these match_len's in order from largest to smallest.

If at any point in this algorithm our match length is N, we've found B in A+A successfully.
*/
    
    
    class Solution {
    public boolean rotateString(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }
}

Time Complexity: O(N)O(N), where NN is the length of A.

Space Complexity: O(N)O(N), to create the shift table shifts.
