package array;

public class SignOfTheProductOfAnArray_1822 {
    public int arraySign(int[] nums) {
        int minusCount = 0;
        boolean zero = false;
        for(int num: nums){
            if(num < 0)
                minusCount ++;
            else if(num == 0){
                zero = true;
                break;
            }

        }
        if(zero)
            return 0;
        else if(minusCount % 2 == 0)
            return 1;
        else
            return -1;
    }
}
