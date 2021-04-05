package Math;

public class GlobalAndLocalInversions_775 {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int min = n+1;
        for(int i = n-1; i >= 2; i--){
            min = Math.min(A[i] , min);
            if(A[i-2] > min)
                return false;
        }
        return true;
    }
}
//只用考虑有么有global不是local的，即A[i] > A[j]且j-i > 2的情况
//A[i] > A[j]的话，A[i] > A[j:n] => A[i] > min(A[j:n])
//从后往前遍历，对min来说，A[i-2]一定要小于min，这样这个A[i-2]会小于min后的任何数，
//                      这个A[i-2]之后会成为新的min
