package array;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] number = new int[10];
        for(int i= 0; i < secret.length(); i++){
            //string.charAt(i)提取string的i位的char
            //Character.getNumericValue()将char转化为对应的int，0-9转为int0-9，10之后是字母
            //这一步将string里的数字变成int的数字
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if(s==g) bulls++;
            else{
                if(number[s] < 0) cows++;// <0说明之前有guess过
                if(number[g] > 0) cows++;// >0说明之前secret有出现过
                number[s]++; //该位上的数在secret出现次数+1
                number[g]--; //该位上的数在guess出现次数+1
            }
        }
        return bulls+"A"+cows+"B";
    }

    //另一种写法，将string转成char
    public String getHint1(String secrets, String guesses) {
        int bulls = 0;
        int cows = 0;
        int[] number = new int[10];
        //String.toCharArray()将string转成char类型的array
        char[] secret = secrets.toCharArray();
        char[] guess = guesses.toCharArray();

        for(int i = 0; i < secret.length; i++){
            //将char里的数字变成int的数字
            int s = (secret[i] - '0');
            int g = (guess[i] - '0');
            if(s == g) bulls++;

            else{
                if(number[s] < 0) cows++;
                if(number[g] > 0) cows++;
                number[s]++;
                number[g]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}
