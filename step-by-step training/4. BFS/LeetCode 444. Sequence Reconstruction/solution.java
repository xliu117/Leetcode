///BFS+topological sort
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Set<Integer>[] kids = new Set[n + 1];
        int[] degrees = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            kids[i] = new HashSet<>();
        }
        int cnt = 0;
        for (List<Integer> seq : seqs) {
            cnt += seq.size();
            if (seq.size() >= 1 && (seq.get(0) <= 0 || seq.get(0) > n)) {
                return false;
            }
            for (int i = 1; i < seq.size(); ++i) {
                if (seq.get(i) <= 0 || seq.get(i) > n) {
                    return false;
                }
                if (!kids[seq.get(i - 1)].contains(seq.get(i))) {
                    kids[seq.get(i - 1)].add(seq.get(i));
                    ++degrees[seq.get(i)];
                }
            }
        }
        if (cnt < n) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (degrees[i] == 0) {
                q.offer(i);
            }
        }
        int idx = 0;
        while (q.size() == 1) {
            int ele = q.poll();
            if (org[idx++] != ele) {
                return false;
            }
            for (int next : kids[ele]) {
                --degrees[next];
                if (degrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return idx == n;
    }
}
