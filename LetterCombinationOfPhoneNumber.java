import java.util.*;

public class LetterCombinationOfPhoneNumber {

//    Map<String, List<String>> numValueMap = new HashMap<>();
//
//    public List<String> letterCombinations(String digits) {
//        numValueMap.put("2", new ArrayList<>(){{add("a"); add("b"); add("c"); }});
//        numValueMap.put("3", new ArrayList<>(){{add("d"); add("e"); add("f"); }});
//        numValueMap.put("4", new ArrayList<>(){{add("g"); add("h"); add("i"); }});
//        numValueMap.put("5", new ArrayList<>(){{add("j"); add("k"); add("l"); }});
//        numValueMap.put("6", new ArrayList<>(){{add("m"); add("n"); add("o"); add("p"); }});
//        numValueMap.put("7", new ArrayList<>(){{add("q"); add("r"); add("s"); }});
//        numValueMap.put("8", new ArrayList<>(){{add("t"); add("u"); add("v"); }});
//        numValueMap.put("9", new ArrayList<>(){{add("w"); add("x"); add("y"); add("z"); }});
//        List<String> strings = new ArrayList<>();
//        strings.addAll(perm("", digits));
//        return strings;
//    }
//
//    List<String> perm(String prefix, String digits) {
//        List<String> strings = new ArrayList<>();
//        if(prefix.length() == digits.length()) {
//            strings.add(prefix);
//            return strings;
//        }
//        String currDigit = String.valueOf(digits.charAt(prefix.length()));
//        for(String s: numValueMap.get(currDigit)) {
//            strings.addAll(perm(prefix.concat(s), digits));
//        }
//        return strings;
//    }
//
//    public static void main(String[] args) {
//        String s = "23";
//        System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations(s).toString());
//    }

}
