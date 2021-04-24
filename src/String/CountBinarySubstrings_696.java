package String;

public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        int prev = 0;
        int curr = 1;

        int ans = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i-1)){
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 1;
            }
            else
                curr ++;
        }

        ans += Math.min(curr, prev);//最后那个substring
        return ans;
    }
}
//关键是想明白 对于00111的string，符合的subarray个数为0/1的重复数较小的那个次数
