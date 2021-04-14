package SystemDesign;
import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> lists; //stack里存各个list的listIterator

    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!lists.empty()){
            if(!lists.peek().hasNext()){//栈顶这个list遍历完了，pop出来
                lists.pop();
            }
            else{ //栈顶这个list里还有元素
                NestedInteger x = lists.peek().next();
                if(x.isInteger()){ //如果list里的下一个元素是int，就返回true
                    lists.peek().previous();//注意把iterator调回去
                    return true;
                }
                lists.push(x.getList().listIterator());//如果list里下一个元素是个list，就把这个list的listIterator压回stack
            }
        }
        return false;
    }
}

public interface NestedInteger {

    // return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
 }