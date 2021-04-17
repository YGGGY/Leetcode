package Stack;

public class RemoveAllAdjacentDuplicatesInString_II_1209 {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque();

        for(char ch : s.toCharArray()){
            if(stack.isEmpty())
                stack.push(new Pair<Character, Integer>(ch, 1));
            else{
                if(ch == stack.peek().getKey()){
                    int count = stack.peek().getValue();
                    stack.pop();
                    if(count + 1 < k)
                        stack.push(new Pair<Character,Integer>(ch, count+1));
                }
                else
                    stack.push(new Pair<Character,Integer>(ch, 1));
            }
        }

        String ans = "";
        while(!stack.isEmpty()){
            Pair<Character, Integer> letter = stack.pop();
            for(int i = 0; i < letter.getValue(); i++){
                ans = letter.getKey() + ans;
            }
        }
        return ans;
    }
}
