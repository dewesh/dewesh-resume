import java.util.Stack;

public class ParanthesisValue {
    public int paranthesisValue(String pString){
        int totSum = 0;
        Stack<Character> mainStack = new Stack<Character>();
        Stack<Integer> valStack = new Stack<Integer>();
        for(int i = 0 ; i < pString.length() ; i++) {
            if(pString.charAt(i) == '(') {
                mainStack.push(pString.charAt(i));
            }
            if(pString.charAt(i) == ')' && mainStack.peek() == '(') {
                mainStack.pop();
                valStack.push(1);
                mainStack.push('-');
                continue;
            }
            if(pString.charAt(i) == ')' && mainStack.peek() == '-') {
                int temp = 0;
                while(mainStack.peek() == '-') {
                    mainStack.pop();
                    temp += valStack.pop();
                }
                if(!mainStack.isEmpty() && mainStack.peek() == '(') {
                    mainStack.pop();
                    valStack.push(temp*2);
                    mainStack.push('-');
                }
            }
        }
        if(mainStack.size() == 1 && mainStack.peek() == '-') {
            return mainStack.pop();
        }
        return totSum;
    }

    public static void main(String[] args) {
        String s = "(())()((()))";
        System.out.println(new ParanthesisValue().paranthesisValue(s));
    }
}
