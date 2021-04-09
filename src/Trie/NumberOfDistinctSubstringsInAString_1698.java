package Trie;

public class NumberOfDistinctSubstringsInAString_1698 {
    public int countDistinct(String s) {
        int count = 0;
        Node root = new Node();
        for(int i = 0; i < s.length(); i++){ //每个字符为开头，建trie树，有新的不存在的children就说明是个新substring
            Node curr = root;
            for(int j = i; j < s.length(); j++){
                if(curr.children[s.charAt(j) - 'a'] == null){
                    curr.children[s.charAt(j) - 'a'] = new Node();
                    count ++;
                }
                curr = curr.children[s.charAt(j) - 'a'];
            }
        }
        return count;
    }
}

class Node{
    Node[] children = new Node[26];
}