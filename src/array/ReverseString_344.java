package array;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int length = s.length;
        int left = 0, right = length-1;

        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    //two pointer
    //time complexity O(n), space complexity O(1)
}
