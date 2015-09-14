package java;

public class P211_AddSearchWord {
    TrieNode root = new TrieNode(); 
    // Adds a word into the data structure.
    public void addWord(String word) {
        root.insert(word); 
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.searchReg(word); 
    }

}
