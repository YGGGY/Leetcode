package array;

public class FindTheCelebrity_277 {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i<n; i++){
            if(knows(candidate, i))//如果candidate认识某个人，那这个candidate一定不会是celebrity
                candidate = i;//被认识的人有可能是celebrity
        }
        //检查candidate是否是celebrity
        for(int i=0; i<n; i++){
            //candidate不是celebrity的情况：candidate认识别人/有人不认识candidate
            if(i != candidate && (knows(candidate,i) || !knows(i, candidate)))
                return -1;
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    }
}
//第一个for循环找candidate的精妙之处在于，
//candidate前面check过的i，因为candidate不认识i，所以i一定不会是candidate，
//所以可以一路往下check，不需要从头开始重新check