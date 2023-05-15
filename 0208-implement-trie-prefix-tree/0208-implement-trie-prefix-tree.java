import java.util.*;

class TrieNode {
  boolean isEnd;
  HashMap < String, TrieNode > children;

  public TrieNode() {
    isEnd = true;
    children = new HashMap < String, TrieNode > ();
  }
}
class Trie {
  private TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0, L = word.length(); i < L; i++) {
      if (current.children.containsKey(Character.toString(word.charAt(i))) == false) {
        current.children.put(Character.toString(word.charAt(i)), new TrieNode());
        current.children.get(Character.toString(word.charAt(i))).isEnd = false;
      }
      current = current.children.get(Character.toString(word.charAt(i)));
    }
    current.isEnd = true;

  }

  public boolean search(String word) {
    TrieNode current = root;

    for (int i = 0; i < word.length(); i++) {
      if (current.children.containsKey(Character.toString(word.charAt(i))) == true) {
        current = current.children.get(Character.toString(word.charAt(i)));
      } else {
        return false;
      }
    }
    return current.isEnd;
  }

  public boolean startsWith(String prefix) {
    TrieNode current = root;

    for (int i = 0; i < prefix.length(); i++) {
      if (current.children.containsKey(Character.toString(prefix.charAt(i))) == true) {
        current = current.children.get(Character.toString(prefix.charAt(i)));
      } else {
        return false;
      }
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */