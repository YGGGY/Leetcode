package SystemDesign;
import java.util.*;

public class LRUCache_146 {
    //map来存key-node，node为double linedlist，每次加node加在head上，删node从tail，这样来更新新旧顺序
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        map = new HashMap();
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if(node != null){
            result = node.val;
            removeNode(node);
            addNode(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            removeNode(node);//删掉再加回去，用来更新使用顺序
            addNode(node);
        }
        else{//要put新的key-node，加新的node
            if(map.size() == capacity){//map满了,要删掉tail
                map.remove(dummyTail.prev.key);
                removeNode(dummyTail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node){
        Node nextNode = dummyHead.next;
        dummyHead.next = node;
        node.prev = dummyHead;
        node.next = nextNode;
        nextNode.prev = node;
    }

    private void removeNode(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}
