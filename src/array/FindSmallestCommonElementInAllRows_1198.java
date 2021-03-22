package array;

public class FindSmallestCommonElementInAllRows_1198 {
    public int smallestCommonElement(int[][] mat) {
        int current = 0;
        int count = 0;
        int n = mat.length;
        int m = mat[0].length;
        int[] position = new int[n]; //记录每个row遍历到的那个数的index
        while(true){
            for(int i = 0; i < n; i++){
                //找这row里>=current的数
                while(position[i] < m && mat[i][position[i]] < current)
                    position[i] ++; //往后找
                if(position[i] >= m)
                    return -1; //找不到了

                //找到了
                if(mat[i][position[i]] != current){
                    current = mat[i][position[i]];
                    count = 1;
                }
                else{
                    count ++;
                    if(count == n)
                        return current;
                }
            }
        }
    }
}

//计算每个数出现的次数，次数为n的数中，最小的就是答案
//计算次数可以用hashmap做，虽然time是O(mn)，但这样space会比较大
//in-place的做法：
//用一个数current记录当前最小的candidate，在每行里找>=current的数，用postion[i]来记录每行找到哪一个数了
//==current是最好的；<current说明肯定不行，别的row没这么小的；>current就刷新current，使这个数来当candidate
//Time: O(mn)
//Space:O(n)