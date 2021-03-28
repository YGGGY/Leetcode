package String;

public class ReconstructOriginalDigitsFromEnglish_423 {
    public String originalDigits(String s) {
        int[] digits = new int[10];//代表了i数字多少次
        int[] count = new int[26];//字母出现次数
        for(char ch : s.toCharArray()){
            count[ch-'a'] ++;
        }

        digits[0] = count['z' - 'a'];
        digits[2] = count['w' - 'a'];
        digits[4] = count['u' - 'a'];
        digits[6] = count['x' - 'a'];
        digits[8] = count['g' - 'a'];
        digits[3] = count['h' - 'a'] - digits[8];
        digits[5] = count['f' - 'a'] - digits[4];
        digits[7] = count['s' - 'a'] - digits[6];
        digits[9] = count['i' - 'a'] - digits[5] - digits[6] - digits[8];
        digits[1] = count['n' - 'a'] - digits[7] - 2*digits[9];

        StringBuilder output = new StringBuilder();
        for(int i = 0; i <= 9; i++){
            for(int j = 0; j < digits[i]; j++)
                output.append(String.valueOf(i));
        }
        return output.toString();
    }
}

//沙雕题目一开始还没看懂，其实就是数每个字母出现多少次，看看能拼出多少个数字的单词
//先把0-9用英文写出来，观察哪些字母的出现能决定字母的出现
/*
u: 4
z: 0
x: 6
w: 2
g: 8
h: 3,8
f: 4,5
s: 6,7
再算1，9
 */