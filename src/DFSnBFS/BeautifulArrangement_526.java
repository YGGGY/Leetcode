package DFSnBFS;

public class BeautifulArrangement_526 {
    private int count = 0;
    public int countArrangement(int n) {
        if(n == 0)  return 0;

        recursion(n, 1, new boolean[n+1]);
        return count;
    }

    private void recursion(int n, int index, boolean[] used){
        if(index > n){ //最低level（basecase）：1~n的index都填完数了，满足条件，count+1
            count ++;
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!used[i] && (i % index == 0 || index % i == 0)){
                used[i] = true;
                recursion(n, index+1, used);
                used[i] = false;
            }
        }
    }
}
//对每个位置index（每一level），用每个数试（这个level每个可能项），这个数要是以前没用过的且满足题目条件

