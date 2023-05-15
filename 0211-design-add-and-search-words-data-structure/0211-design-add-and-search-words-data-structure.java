class WordDictionary {
    private class TrieNode {
        boolean isWord;
        TrieNode[] next;

        TrieNode() {
            isWord = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode head;
    private int longest;

    public WordDictionary() {
        head = new TrieNode();
        longest = 0;
    }
    
    // O(m) time | O(m) space
    // m = word length
    public void addWord(String word) {
        TrieNode iter = head;
        for (char ch : word.toCharArray()) {
            int c = ch - 'a';
            if (iter.next[c] == null)
                iter.next[c] = new TrieNode();
            iter = iter.next[c];
        }
        iter.isWord = true;
        // search optimization
        longest = Math.max(longest, word.length());
    }
    
    public boolean search(String word) {
        if (word.length() > longest) return false;
        return dfs(word, 0, head);
    }

    // Best: O(m) time | O(1) space     -> for defined word
    // Worst: O(26^m) time | O(m) space -> for completely undefined word "......"
    private boolean dfs(String word, int start, TrieNode node) {
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (TrieNode nextNode : node.next) {
                    if (nextNode == null) continue;
                    if (dfs(word, i + 1, nextNode)) return true;
                }
                return false;
            }
            else {
                int c = ch - 'a';
                if (node.next[c] == null) return false;
                node = node.next[c];
            }
        }
        return node.isWord;
    }
}