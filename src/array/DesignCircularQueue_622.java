package array;

public class DesignCircularQueue_622 {
    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if(this.count == this.capacity)
            return false;
        else{
            int index = (this.head + this.count) % capacity;
            this.queue[index] = value;
            this.count ++;
            return true;
        }
    }

    public boolean deQueue() {
        if(count == 0)
            return false;
        else{
            this.head = (this.head + 1) % this.capacity;
            this.count --;
            return true;
        }
    }

    public int Front() {
        if(this.count == 0)
            return -1;
        else
            return this.queue[this.head];
    }

    public int Rear() {
        if(this.count == 0)
            return -1;
        else{
            int index = (this.head + this.count - 1) % this.capacity;
            return this.queue[index];
        }
    }

    public boolean isEmpty() {
        if(this.count == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if(this.count == this.capacity)
            return true;
        else
            return false;
    }
}
