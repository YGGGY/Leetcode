package HashMap;
import java.util.*;

public class InsertDeleteGetRandom_380 {
    class RandomizedSet {
        HashMap<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            dict = new HashMap();
            list = new ArrayList();
        }

        /** Inserts a value to the set.
         Returns true if the set did not already contain the specified element.
         Returns false if the set already contain the specified element*/
        public boolean insert(int val) {
            if(dict.containsKey(val))   return false;

            dict.put(val, list.size());//element-index
            list.add(list.size(), val);//index-element
            return true;
        }

        /** Removes a value from the set.
         Returns true if the set contained the specified element.
         Returns false if the set did not contain the specified element*/
        public boolean remove(int val) {
            if(!dict.containsKey(val))   return false;

            //use last element to replace val
            int lastElement = list.get(list.size()-1);
            int index = dict.get(val);
            list.set(index, lastElement);
            dict.put(lastElement,index);

            list.remove(list.size()-1);//delete the last one in list
            dict.remove(val);//delete val in HashMap
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int temp = rand.nextInt(list.size());
            return list.get(temp);
        }
    }

}

//用HashMap的话，insert和delete都是O(1)，但是因为没有index，做不了random
//用ArrayList的话，insert和random都是O(1)，但是delete要O(n)，因为要遍历一遍找val在哪
//所以两个都用，HashMap:   element - index
//            ArrayList: index - element
