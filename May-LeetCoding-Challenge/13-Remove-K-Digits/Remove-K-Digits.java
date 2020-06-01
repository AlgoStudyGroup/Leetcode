import java.util.Stack;

public class RemoveKDigits402 {
    public String removeKdigits(final String num, final int k) {
        if (num.length() == k) {
            return "0";
        }
        int currentK = k;
        Stack<Character> characterStack = new Stack<>();
        for (int index = 0; index < num.length(); index++) {
            final Character c = num.charAt(index);
            while (currentK > 0 && !characterStack.empty() && characterStack.peek() > c) {
                characterStack.pop();
                --currentK;
            }
            characterStack.push(c);
        }
        while (currentK > 0) {
            characterStack.pop();
            --currentK;
        }
        final StringBuilder result = new StringBuilder();
        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }
        result.reverse();
        if (result.length() == 1) {
            return result.toString();
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    /*
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        final StringBuilder result = new StringBuilder(num);

        for (int time = 1; time <= k; time++) {
            int index = 0;
            while (index < result.length() - 1 &&
            result.charAt(index) <= result.charAt(index + 1)) {
                ++index;
            }
            result.deleteCharAt(index);
        }

        if (result.length() == 1) {
            return result.toString();
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }
     */
}
