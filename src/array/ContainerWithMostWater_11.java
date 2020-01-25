package array;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int max_area = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            max_area = Math.max(max_area, area);
            if(height[l] < height[r])//丢弃较矮的那个柱子
                l++;
            else
                r--;
        }
        return max_area;
    }
}

