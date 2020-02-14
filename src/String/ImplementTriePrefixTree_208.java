package String;

public class ImplementTriePrefixTree_208 {
    private  Node root;

    public void Trie() {
        root = new Node();//构造函数 一创造就创建root
    }

    private int getIndex(char c){
        return c - 'a';//26个children分别代表a-b。a-1,b-2，以此类推
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){//一个一个查word的每个字符在不在
            if(node.children[getIndex(c)] == null)//不在的话就在对应的children节点插入
                node.children[getIndex(c)] = new Node();
            node = node.children[getIndex(c)];//到下一个children
        }
        node.isEnd = true;//插入完word，在最后一个字符处改end状态，标注为一个单词
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            node = node.children[getIndex(c)];
            if(node == null)
                return false;
        }
        return node.isEnd;//查到最后一个字符，说明字符都在树里，返回是否存在这个单词
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            node = node.children[getIndex(c)];
            if(node == null)
                return false;
        }
        return true;//prefix是只要存在就可以，不需要判断isEnd
    }
}

class Node{
    Node[] children;
    boolean isEnd;

    public Node(){
        this.children = new Node[26];//每个node有26个子node代表a-b
        this.isEnd = false;//默认无单词
    }
}