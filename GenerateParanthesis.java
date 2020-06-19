import java.util.*;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        Set<String> parans = generateCombinations("", 0, n);
        List<String> result = new ArrayList<>();
        result.addAll(parans);
        return result;
    }
    public Set<String> generateCombinations(String prefix, int debt, int remaining) {
        Set<String> parans = new HashSet<>();
        StringBuilder s1 = new StringBuilder().append(prefix);
        StringBuilder s2 = new StringBuilder().append(prefix);
        if(remaining == 0 && debt == 0) {
            parans.add(prefix);
        }
        if(remaining > 0) {
            s1.append('(');
            parans.addAll(generateCombinations(s1.toString(), debt + 1, remaining -1));
        }
        if(debt > 0) {
            s2.append(')');
            parans.addAll(generateCombinations(s2.toString(), debt-1, remaining));
        }

        return parans;
    }

    public static void main(String[] args) {
        List<String> s = new GenerateParanthesis().generateParenthesis(3);
        System.out.println(Arrays.toString(s.toArray()));
    }
}
