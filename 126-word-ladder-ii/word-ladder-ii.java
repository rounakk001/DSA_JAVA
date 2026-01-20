

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!dict.contains(endWord)) return ans;

        Map<String, List<String>> parent = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();

        bfs(beginWord, dict, parent, level);

        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, parent, level, path, ans);

        return ans;
    }

    void bfs(String begin, Set<String> dict,
             Map<String, List<String>> parent,
             Map<String, Integer> level) {

        Queue<String> q = new LinkedList<>();
        q.add(begin);
        level.put(begin, 0);

        for (String w : dict) parent.put(w, new ArrayList<>());
        parent.put(begin, new ArrayList<>());

        while (!q.isEmpty()) {
            String word = q.poll();
            int curLevel = level.get(word);

            for (String next : neighbors(word, dict)) {
                parent.get(next).add(word);
                if (!level.containsKey(next)) {
                    level.put(next, curLevel + 1);
                    q.add(next);
                }
            }
        }
    }

    void dfs(String word, String begin,
             Map<String, List<String>> parent,
             Map<String, Integer> level,
             List<String> path,
             List<List<String>> ans) {

        path.add(word);

        if (word.equals(begin)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
        } else {
            for (String p : parent.get(word)) {
                if (level.get(word) == level.get(p) + 1) {
                    dfs(p, begin, parent, level, path, ans);
                }
            }
        }

        path.remove(path.size() - 1);
    }

    List<String> neighbors(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                arr[i] = c;
                String nw = new String(arr);
                if (dict.contains(nw)) res.add(nw);
            }
            arr[i] = old;
        }
        return res;
    }
}
