package m1;

//Sneha

/*1) Prob Solving - BalancingTheBracket (only '(' and ')' ) . even if one of its position changed ang makes a balanced bracket means its valid.
for example: )( - valid bcoz if 1st index goes to last ,its ()
similarly )((())- valid ((()))
(()-invalid*/


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static int canBeBalanced(String s) {
        if (isBalanced(s)) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != j) {
                    String newS = s.substring(0, i) + s.substring(i + 1);
                    newS = newS.substring(0, j) + s.charAt(i) + newS.substring(j);
                    if (isBalanced(newS)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    public static List<Integer> isConvertibleData(List<String> dataset) {
        List<Integer> result = new ArrayList<>();
        for (String s : dataset) {
            result.add(canBeBalanced(s));
        }
        return result;
    }

    //*Main is not included.
kindly verify this code.
2) Java- Nutrtion food - inheritance and methodoverriding
abstract class Food {
    double proteins;
    double fats;
    double carbs;
    double tastyScore;
 
    public Food(double proteins, double fats, double carbs) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }
 
    public abstract void getMacroNutrients();
 
    abstract String getType();
    abstract String getItemName();
}
 
class Bread extends Food {
    int tastyScore = 8;
    String type = "vegetarian";
 
    public Bread(double proteins, double fats, double carbs) {
        super(proteins, fats, carbs);
    }
 
    @Override
    String getType() {
        return type;
    }
 
    @Override
    String getItemName() {
        return "A slice of bread";
    }
 
    @Override
    public void getMacroNutrients() {
        System.out.print(getItemName() + " contains ");
        System.out.println(proteins + " gms of protein, " + fats + " gms of fats, and " + carbs + " gms of carbohydrates.");
    }
}
 
class Egg extends Food {
    int tastyScore = 9;
    String type = "non-vegetarian";
 
    public Egg(double proteins, double fats, double carbs) {
        super(proteins, fats, carbs);
    }
 
    @Override
    String getType() {
        return type;
    }
 
    @Override
    String getItemName() {
        return "Eggs";
    }
 
    @Override
    public void getMacroNutrients() {
        System.out.print(getItemName() + " contain ");
        System.out.println(proteins + " gms of protein, " + fats + " gms of fats, and " + carbs + " gms of carbohydrates.");
    }
}

//Shusmitha

//shajina

//rumaisiya



//sowmiya
 
function description complete the function getspamEmails in the editor below. getspamEmails 
takes the following arguments: 	String subjects[n]:the subject of the email 	
String spam_words[k]:the spam words 	returns 	String[n]:the results of spam detection 
sample input 	2 	i paid him paid 	Summertime Sadness 	3 	I 	Sadness 	paid 
sample output 	spam 	not_spam

import java.util.ArrayList;
import java.util.List;

public class SpamDetector {
    public static List<String> getspamEmails(String[] subjects, String[] spam_words) {
        List<String> results = new ArrayList<>();
        for (String subject : subjects) {
            boolean isSpam = false;
            for (String spam_word : spam_words) {
                if (subject.contains(spam_word)) {
                    isSpam = true;
                    break;
                }
            }
            if (isSpam) {
                results.add("spam");
            } else {
                results.add("not_spam");
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String[] subjects = {"i paid him paid", "Summertime Sadness"};
        String[] spam_words = {"I", "Sadness", "paid"};

        List<String> results = getspamEmails(subjects, spam_words);
        for (String result : results) {
            System.out.println(result);
        }
    }
}