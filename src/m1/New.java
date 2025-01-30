package m1;

JAVA: PROBLEM SOLVING
//create the groceryReceipt class that extends FGroceryReceiptBase above

//properties will be passed
//Prices-the list of items and their prices
//Discounts-the list of discounts for each item
//Function description
/* create GroceryReceipt class by extending the GroceryReceiptBase abstract class.
* Implement a Calculate function to create invoices. The function shoiuld return the item,
* quantity and the total price after the dixcount for every item in the grocery receipt
*
* sample input
* STDIN                             FUNCTION
* 3                                  n=3
* Apple 34                      [fruit,price per unit]=[["Apple",34],["Banana",14],["Orange",4]]
*
* Banana 14
* Orange 4
* 1                                  m=1
* Orange 10                    [fruit,percentage discount]=[["Orange",10]]
* 2                                  k=2
* Apple 2                      [fruit,units]=[["Apple",2],["Apple",5]]
*
* Apple 5
*
* sample output
* Apple 34.0 238.0
* the shopping list is 2 units Apple and 5 units Apple. 7 units of Apple
* cost 7*34=238 and there is no discount
class GroceryReceipt extends GroceryReceiptBase {
  
  public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
      super(prices, discounts);
  }
  
  @Override
  public List<Grocery> calculate(List<Node> shoppingList) {
      List<Grocery> receipt = new ArrayList<>();
      Map<String, Double> prices = getPrices();
      Map<String, Integer> discounts = getDiscounts();
      
      Map<String, Integer> itemCounts = new HashMap<>();
      for (Node item : shoppingList) {
          itemCounts.put(item.fruit, itemCounts.getOrDefault(item.fruit, 0) + item.count);
      }
      
      for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
          String fruit = entry.getKey();
          int count = entry.getValue();
          double pricePerUnit = prices.get(fruit);
          double discount = discounts.getOrDefault(fruit, 0);
          double totalPrice = count * pricePerUnit * (1 - discount / 100.0);
          
          receipt.add(new Grocery(fruit, pricePerUnit, totalPrice));
      }
      
      // Sort the receipt by fruit name
      receipt.sort(Comparator.comparing(g -> g.fruit));
      
      return receipt;
  }
}

JAVA: BASIC
class Result {
  /*
   * Complete the getMaximumScore function below
   * the function is expected to return a LONG_INTEGER
   * the function accepts following parameters:
   * 1. INTEGER_ARRAY arr
   * 2. INTEGER k
   * returns long_int: the maximum possible score after k operations
   * 1<=n<=10^5
   * 1<=arr[i]<=10^9
   * 1<=k<=10^5
   * sample input
   * STDIN                         FUNCTION
   * 4                        arr[] size,n=4
   * 4                        arr=[4,5,18,1]
   * 5
   * 18
   * 1
   * 3                            k=3
   * sample output 29
   * given an array arr of n integers
   * and an integer k perform k operations on the array
   * start with a score of 0
   * in one operation :
   * choose any element
   * add its value to the score
   * replace the element with the integer ceiling of one-third of its value
   * for ex, if the chosen element is 10, then 10 is added to the score, and 10 is replaced by ceil(10/3)=4
   */
  public static long getMaximumScore(List<Integer> arr, int k) {
      // Sort the array in descending order to maximize the sum
      //write your code here
  }
}   
public static long getMaximumScore(List<Integer> arr, int k) {
      // Use a max-heap to always get the maximum element efficiently        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      maxHeap.addAll(arr);                long maxScore = 0;
              for (int i = 0; i < k; i++) {
          int maxElement = maxHeap.poll();
          maxScore += maxElement;
          int newElement = (int) Math.ceil(maxElement / 3.0);
          maxHeap.add(newElement);
      }
      
      return maxScore;
  }
}


Sivaranjani M1 Questions

Q1)Java: Exchange Rate
Coding Overloading OOPS Java Polymorphism Easy
Question description
In the scope of Risk Management in global finance, you are tasked with implementing a class named
exchangeRate to optimize investments. This class should include three methods with the same label but
different arguments.
 
11 of 14
Note that method overloading allows a class to have multiple methods with the same name but different
argument lists.
Using method overloading, complete the implementation of the class exchangeRate with 3 methods.
1. public String rate(double localCurrency, String foreignCurrency) needs to process arguments like
rate(1, "Euro") and should return "1Euro".
2. public String rate(double localCurrency, double foreignCurrency) must return the sum (as exchange
rate approximation) when given inputs like rate(1.1,2.2). The resulting sum (like 3.3) should be
rounded off to two decimal places.
Rounding Rules: Use the BigDecimal class with RoundingMode.HALF_UP for rounding. Follow
these rounding rules:
3.765 => 3.77
3.7649 => 3.76
3.778 => 3.79
3. public String rate(String localCurrency, String foreignCurrency), should handle inputs like
rate("dollars,","yen") and return the concatenated string: "dollarsyen".
When code is submitted, the provided Solution class will test the add methods with different arguments.
INPUT FORMAT FOR CUSTOM TESTING
The first line contains an integer, n, the number of inputs.
Each of the next n lines contains 2 space-separated values.
SAMPLE CASE 0
Sample Input For Custom Testing
24
1
2 2
Sample Output
5.0
4.0
SAMPLE CASE 1
 
Sample Input For Custom Testing
31
Euro
dollars yen
5 7
Sample Output
1Euro
dollarsyen
12.0
Interviewer guidelines
SOLUTION
:Java 7
class exchangeRate {
   public String rate(double localCurrency, String foreignCurrency) {
       return String.valueOf((int) Math.round(localCurrency)) + foreignCurrency;
   }
 
   public String rate(String localCurrency, String foreignCurrency) {
       return localCurrency + foreignCurrency;
   }
 
   public String rate(double localCurrency, double foreignCurrency) {
       double sum = localCurrency + foreignCurrency;
       BigDecimal bd = new BigDecimal(Double.toString(sum));
       bd = bd.setScale(2, RoundingMode.HALF_UP);
       String result = bd.toString();
       if (result.endsWith(".00")) {
           result = result.substring(0, result.length() - 1);
       }
       return result;
   }
}
 
public class Solution {
   public static void main(String args[]) throws Exception {
       /* Enter your code here. Read input from STDIN. Print output to STDOUT */
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
       int n = Integer.parseInt(input);
       for (int i = 0; i < n; i++) {
           String[] entries = sc.nextLine().split(" ");
           Boolean isFirstEntryDouble = isFloat(entries[0]);
           Boolean isSecondEntryDouble = isFloat(entries[1]);
           exchangeRate currencyExchange = new exchangeRate();
           if (isFirstEntryDouble && isSecondEntryDouble) {
               System.out.println(currencyExchange.rate(Double.parseDouble(entries[0]), Double.parseDouble(entries[1])));
           } else {
               System.out.println(currencyExchange.rate(entries[0], entries[1]));
           }
       }
   }
 
   private static final Pattern DOUBLE_PATTERN = Pattern.compile(
           "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                   "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                   "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)" +
                   "(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
 
   public static boolean isFloat(String s) {
       return DOUBLE_PATTERN.matcher(s).matches();
   }
}

Q2)Get Minimum Operation Count
 
 
A string is beautiful if no two adjacent characters are either
the same, for example 'aa'.
adjacent in the alphabet, for example 'ef'.
The following operations can be performed on a string, s.
Choose any index i (0 ≤ i < |s|) and change s[i] to any lowercase English letter.
Find the minimum number of operations required to make the string beautiful.
Function Description
Complete the function getMinimumOperationCount in the editor below.
getMinimumOperationCount has the following parameter:
s: a string
 
Returns
int: the minimum number of operations required to make s beautiful
 
 
 
Example 1:
 
Input:  s = "abdde"Output: 2 Explanation:      String s is not beautiful because:
      'dd' violates constraint 1, no two adjacent characters are the same.'ab' and 'de' violate constraint 2, no two adjacent characters are adjacent in the alphabet.      The string can be converted into a beautiful string after 2 operations. One solution is below:
      Choose i=1 and change s[i] to 'z', s becomes "azdde".Choose i=3 and change s[i] to 'k', s becomes "azdke" which is beautiful.      Note: There are many other solutions such as "ardze", "axdke", etc.
            It can be shown that 2 is the minimum number of operations required so return 2.
      
 
Constraints:
 2 ≤ |s| ≤ 10^5
The string s contains only lowercase English letters.

Answer:

import java.util.Scanner;

public class Main {

    public static int getMinimumOperationCount(String s) {
        // Initialize the operation count
        int operations = 0;
        
        // Iterate through the string (except the last character)
        for (int i = 0; i < s.length() - 1; i++) {
            // Check if the current and next characters are the same
            if (s.charAt(i) == s.charAt(i + 1)) {
                operations++;
                // Change the next character (just pretend to change it)
                continue;
            }
            
            // Check if the current and next characters are adjacent in the alphabet
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 1) {
                operations++;
                // Change the next character (just pretend to change it)
                continue;
            }
        }
        
        // Return the total number of operations
        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input string
        String input = scanner.nextLine();
        
        // Call the method and get the result
        int output = getMinimumOperationCount(input);
        
        // Output the result
        System.out.println(output);
        
        scanner.close();
    }
}

Note :"chatgpt give this answer for 2nd question but i am not sure about this "
	
	1) java 
//input format for custom testing -the first line contains two space-separated integers, n, and m, the count of personal and buisness loan applicants respectively
//the second line contains space-separated integers that represent the loans of clients.
//the third line contains space - seprated integrs that represent the loans of buisnesses

/*sample  input case 0
4 4
2348 929 1284 5543
3117 5196 3352 7068

sample output case 0
Loans for clients processed
Loans for buisnesses processed
Average loan amount for clients is 2526.00
Maximum loan amount amongst clients is 5543
Minimum loan amount amongst clients is 929
Average loan amount for businesses is 4583.25
Maximum loan amongst businesses is 7068
Minum loan amongst businesses is 3117

sample test case 1
5 3
1500 3000 4500
1000 2000

sample test case 2
4 4
1000 2000 0 3000
4000 0 5000 6000

sample test acse 3
5 3
1500 3000 4500
1000 2000 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;


interface Bank{
  void assignLoans(int[] loans);
  void averageLoan();
  void maxLoan();
  void minLoan();
}
class PersonalLoanDept implements Bank{
  int clients;
  List<Integer> loanAmounts = new ArrayList<>();
  public PersonalLoanDept(int n){
      this.clients = n;
  }
  public void assignLoans(int [] loans){
      for(int a:loans){
          loanAmounts.add(a);
      }    

              System.out.println("Loans for clients processed");

  }
  public void averageLoan(){
      double sum = 0.0; int len = loanAmounts.size();
      for(int a: loanAmounts){
          sum += a;
      }
      System.out.println("Average loan amount for clients is " + String.format("%.2f", sum/len));
  }
  public void maxLoan(){
      int max = 0;
      for(int a: loanAmounts){
          if(a>max){
              max = a;
          }
      }
      System.out.println("Maximum loan amount amongst clients is "+(max));
  }
  public void minLoan(){
      int min = 100000000;
      for(int a:loanAmounts){
          if(a<min){
              min = a;
          }
      }
      System.out.println("Minimum loan amount amongst clients is "+(min));
  }
}
class BusinessLoanDept implements Bank{
  int businesses;
  public BusinessLoanDept(int n){
      this.businesses =n;
  }

  List<Integer> loanAmounts = new ArrayList<>();
  public void assignLoans(int[] loans){
      for(int a: loans){
          loanAmounts.add(a);
          }
              System.out.println("Loans for businesses processed");

      } 
  public void averageLoan(){
      double sum =0.0; int len = loanAmounts.size();
      for(int a:loanAmounts){
          sum+= a;
      }
      System.out.println("Average loan amount for businesses is "+  String.format("%.2f", sum/len));
  }
  public void maxLoan(){
      int max = -1000000000;
      for(int a:loanAmounts){
          if(a> max){
              max =a;
          }
      }
      System.out.println("Maximum loan amongst businesses is "+(max));
  }
  public void minLoan(){
      int min= 1000000000;
      for(int a: loanAmounts){
          if(a<min){
              min = a;
          }
      }
      System.out.println("Minimum loan amongst businesses is "+(min));
  }
}


public class BankSystem {
  public static void main(String args[] ) throws Exception {
      Scanner sc = new Scanner(System.in);

      String[] count = sc.nextLine().split(" ");

      PersonalLoanDept p = new PersonalLoanDept(Integer.parseInt(count[0]));
      BusinessLoanDept b = new BusinessLoanDept(Integer.parseInt(count[1]));

      count = sc.nextLine().split(" ");

      int[] loansClients = new int[count.length];
      for (int i=0; i<count.length; i++) {
          loansClients[i] = Integer.parseInt(count[i]);
      }
      p.assignLoans(loansClients);

      count = sc.nextLine().split(" ");
      int[] loansBusinesses = new int[count.length];
      for (int i=0; i<count.length; i++) {
          loansBusinesses[i] = Integer.parseInt(count[i]);
      }
      b.assignLoans(loansBusinesses);

      p.averageLoan();
      p.maxLoan();
      p.minLoan();

      b.averageLoan();
      b.maxLoan();
      b.minLoan();
      sc.close();
  }
2) Problem solving 
class Result {

                  public static long countBalancedSubarrays(List<Integer> componentValue) {
                      long count = 0;
                      int n = componentValue.size();
                      
                      // Create a prefix sum array
                      int[] prefixSum = new int[n + 1];
                      prefixSum[0] = 0;
                      
                      for (int i = 1; i <= n; i++) {
                          prefixSum[i] = prefixSum[i - 1] + componentValue.get(i - 1);
                      }
                      
                      // Use a hashmap to store the frequency of prefix sums
                      Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
                      
                      for (int sum : prefixSum) {
                          if (prefixSumFrequency.containsKey(sum)) {
                              count += prefixSumFrequency.get(sum);
                          }
                          prefixSumFrequency.put(sum, prefixSumFrequency.getOrDefault(sum, 0) + 1);
                      }
                      
                      return count;
                  }
              }





Given a string array that contains n elements,each composed of lowercase English letters and q queries of the format l-r for each query ,determine how many strings starting from index l and ending at index r have vowels as the first and last character .Vowels are in{a,e,i,o,u}  

Function description: 

Complete the hasVowels function in the editor below.it must return an array of integer that represent the result of each query in the 

hasVowels ha sthe following parameters 

strarr string[]:an array of n strings 

query string[]:an array of q strings,each of which describes an intervel l-r using integers delimited by a dash 

Constraints: 

1<=n,q<=10 power 5 

1<=l<=r<=n 

1<= sizeof strArr[i] <=10the first line contains an integer ,n, that denotes the number of elements in strArr 

Each  line i of the n subsequent  lines (where 1<=i<=n)contains a string that describes strArr[i][i] 

the next line contains an integer,q,denoting the number of elements in query 

Each line j of the q subsequent lines(where) 

STDIN       funtions 

5    ->     strArr[] size n=5; 

aab   -> strArr=["aab","a","bcd","awe"] 

] 

a 

bcd 

awe 

bbbbbu 

2   -> query[] size n=2 

2-3 -> query = ["2-3","4-5"] 

4-5 

Sample output: 

1 

1 

Expalnation: 

 

n=5 

strArr=['aab','a','bcd','awe','bbbbbu'] 

q=2 

query=['2-3','4-5'] 

for the first query ,2-3 only the string ayt index 2 has a vowel as thefirst and last character .for the second query,4-5,only the 

 string at the index 4 has vowels as the first and last characters 

code: 

 

 

 
class Solution { 

    public static List<Integer> hasVowels(List<String> strArr, List<String> query) { 

        List<Integer> result = new ArrayList<>(); 

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')); 

 

        for (String q : query) { 

            String[] parts = q.split("-"); 

            int l = Integer.parseInt(parts[0]) - 1; 

            int r = Integer.parseInt(parts[1]) - 1; 

            int count = 0; 

 

            for (int i = l; i <= r; i++) { 

                String s = strArr.get(i); 

                if (!s.isEmpty() && vowels.contains(s.charAt(0)) && vowels.contains(s.charAt(s.length() - 1))) { 

                    count++; 

                } 

            } 

            result.add(count); 

        } 

        return result; 

         

    } 

 

 

 

 

 

given an interface termed Bank,list the following fiunctions: 

void assignLoans(int[] loans); 

void averageLoan(); 

void maxLoan(); 

voidminLoan(); 

2 classes  

personalLoanDept 

BusinessLoanDept 

implementing the bank interface .the specifications are 

class PersonalLoanDept  

include an integer-type array -loanAmounts.class with subsequent methods 

PersonalLoanDept(int clients): 

an empty array loanAmounts of clients length is initialized in class,wher 

clients is the count of loan recipients.the initial loan amount assigned is zero 

void assignLoans(int[] loans):the loans array is linked to loanAmounts. 

if the lengths of two array differ  ,as many values as possible are assigned,and then stop allocating more and print "Loans for clients processed 

void averageLoan(): 

    	displays the loan average in the pattern "Average loan amount for clients is {averageLoan}".the average computation shuld consider any 

    	any zero value present in loanAmounts and should be rounded to 2 decimal places 

    void maxLoan(): 

    	this diplays "Maximum loan amount amongst clients is {maximumLoan}" reflecting the largest loan. 

    void minLoan(): 

    	this displays "Minimum loan amongst clients is {minimumLoan}" reflecting the smallest loan given. 

    BusinessLoanDept classnecessities an int[] 

    		as a variable denoted loanAmounts and should implement methods: 

       BusinessLoanDept(int businesses):this initialises an empty array loanAmounts of length businesses which signifies the number of business erecipients 

       void assignLoans(int[] loans):this assigns loans array to loanAmounts.the system discontinues firther allocation 

       if the lengths of arrays do not match post the assifnment of possible values and 

       prints "Loans for businesses processed" 

       void averageLoan():this prints"Average loan amount for business is {averageLoan}".Any residual zero values in loanAmounts are include din teh average calculatio 

       void maxLoan():this prints "Maximum loan amongst businesses is{maximumLoan}" reflecting the highest loan. 

       void minLoan():this prints "Minimum loan amongst businesses is {minimumLoan}" reflecting the lowest loan value. 

 

Code: 

class PersonalLoanDept implements Bank { 

    private int[] loanAmounts; 

 

    public PersonalLoanDept(int clients) { 

        loanAmounts = new int[clients]; 

    } 

 

     

    public void assignLoans(int[] loans) { 

        int length = Math.min(loanAmounts.length, loans.length); 

        for (int i = 0; i < length; i++) { 

            loanAmounts[i] = loans[i]; 

         

        System.out.println("Loans for clients processed"); 

    } 

    } 

 

 

    public void averageLoan() { 

        double sum = 0; 

        for (int loan : loanAmounts) { 

            sum += loan; 

        } 

        double average = sum / loanAmounts.length; 

        System.out.printf("Average loan amount for clients is %.2f%n", average); 

    } 

 

    public void maxLoan() { 

        int max = Integer.MIN_VALUE; 

        for (int loan : loanAmounts) { 

            if (loan > max) { 

                max = loan; 

            } 

        } 

        System.out.println("Maximum loan amount amongst clients is " + max); 

    } 

 

    public void minLoan() { 

        int min = Integer.MAX_VALUE; 

        for (int loan : loanAmounts) { 

            if (loan < min) { 

                min = loan; 

            } 

        } 

        System.out.println("Minimum loan amount amongst clients is " + min); 

    } 

} 

 

class BusinessLoanDept implements Bank { 

    private int[] loanAmounts; 

 

    public BusinessLoanDept(int businesses) { 

        loanAmounts = new int[businesses]; 

    } 

 

    @Override 

    public void assignLoans(int[] loans) { 

        int length = Math.min(loanAmounts.length, loans.length); 

        for (int i = 0; i < length; i++) { 

            loanAmounts[i] = loans[i]; 

        } 

        System.out.println("Loans for businesses processed"); 

    } 

 

     

    public void averageLoan() { 

        double sum = 0; 

        for (int loan : loanAmounts) { 

            sum += loan; 

        } 

        double average = sum / loanAmounts.length; 

        System.out.printf("Average loan amount for businesses is %.2f%n", average); 

    } 

     

    public void maxLoan() { 

        int max = Integer.MIN_VALUE; 

        for (int loan : loanAmounts) { 

            if (loan > max) { 

                max = loan; 

            } 

        } 

        System.out.println("Maximum loan amount amongst businesses is " + max); 

    } 

 

    public void minLoan() { 

        int min = Integer.MAX_VALUE; 

        for (int loan : loanAmounts) { 

            if (loan < min) { 

                min = loan; 

            } 

        } 

        System.out.println("Minimum loan amount amongst businesses is " + min); 

    } 

} 









Substring: import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
	/*Complete the commonSubString' function below
	the function accepts following parameters:
		1.STRING_ARRAY a
		2. STRING_ARRAY b
		*/
	public static void commonSubstring(List<String> a, List<String> b) {
	
		for (int i = 0; i < a.size(); i++) {
            String strA = a.get(i);
            String strB = b.get(i);
            boolean found = false;
            for (char ch : strA.toCharArray()) {
                if (strB.indexOf(ch) != -1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
	
	}
}
public class Main {
	public static void main(String[] args)
	throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader (System.in));
		
		int aCount = Integer.parseInt(bufferedReader.readLine().trim());
		List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
			
			try {
				
				return bufferedReader.readLine();
				
				
			    } catch (IO Exception ex) {
			    	
			    	
				    throw new RuntimeException(e);
				    
				    
			        }
			
			
		    })
				
				.collect(toList());
				int bCount = Integer.parseInt(bufferedReader.readLine().trim());
				List<String> b = IntStream.range(0,bCount).mapToObj(i -> {
					try {
						return bufferedReader.readLine();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				})
						.collect(toList());
				Result.commonSubstring(a, b);
				bufferedReader.close();
}
}
Method Overloading:
 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
{ 
class BMW {
    public void reverseGear() {
        System.out.println("Reverse Gear is Applied...");
    }
 
    public void switchOnHeadlights() {
        System.out.println("Headlights turned on...");
    }
 
    public void topSpeed() {
        System.out.println("TopSpeed of BMW is 200 kmph");
    }
}
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BMW b = new BMW();
        for (int i = 0; i < 3; i++) {
            String name = sc.nextLine();
            if (name.equals("reverseGear")) {
                b.reverseGear();
            } else if (name.equals("switchOnHeadlights")) {
                b.switchOnHeadlights();
            } else if (name.equals("topSpeed")) {
                b.topSpeed();
            }
        }
        sc.close();
    }
}







JAVA


/*example
n=5
m=4
pos=[3,0,1,4]
		
		assigned numbers per round
		
		pos[i]       assignamets
		pos[0]=3     [3,2,1,0,1]
		pos[1]=0     [0,1,2,3,4]
		pos[2]=1     [1,0,1,2,3]
		pos[3]=4     [4,3,2,1,0]
				
				
the max values each child will shout=[4,3,2,3,4]
 
 
input formate
the first line contains an integer, n, that denotes the num of childern
* the next line contains an integer, m, that denotes the num of rounds
* each line i of the m subsequent lines contains an integer the describes pos[i]
		
		funtionDescription
		complete the funtoin maxValue in the editior with following parameters
		
		int n: num of childern
		int pos[m]: the position the teacher will call during the m rounds
		
		return
		int[n]:values each child will shout
		
		
		constraints
		1<=n<=10^5
		1<=m<=10^5
		0<=pos[i]<=n-1
		
		
		sample input
		
		STDIN    Function
		-----    --------
		5        n=5
		3        pos[] sizem=3
		2        pos=[2,0,3]
		0
		3
		
		
		sample output
		3
		2
		2
		3
		4
		
		
		explanation
	
		
		here n=5
		m=3 and pos=[2,0,3]
		
		the 1st round, numbres assigned=[2,1,0,1,1]
		2nd =[0,1,2,3,4]
		3rd=[3,2,1,0,1]
				*/
 
//**************SOULUTION*************************
 
 
import java.io.*;
import java.util.*;
import java.util.stream.*;
 
class Result {
    public static List<Integer> maxValue(int n, List<Integer> pos) {
        int[] maxValues = new int[n];
        int leftMost = Collections.min(pos);
        int rightMost = Collections.max(pos);
 
        for (int i = 0; i < n; i++) {
            maxValues[i] = Math.max(Math.abs(leftMost - i), Math.abs(rightMost - i));
        }
 
        return Arrays.stream(maxValues).boxed().collect(Collectors.toList());
    }
}
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int posCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> pos = IntStream.range(0, posCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
 
        List<Integer> result = Result.maxValue(n, pos);
        bufferedWriter.write(result.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n");
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
 
 
PROBLEM SOLVING
 
 
/*
	 * attribute Vector<Line>List_of_lines which stores a list of lines
	
	constructor with parameter vector<line> to initialize the list
	of lines attributes
	method: line getLineWithMaxLength() which returns the 1st longest line from the list of lines
	method: vector <line> getLinesStartingFromPoint(point p) which returns a list of all the lines
	starting from the given point p
	
	note:the code stub reads input and calls method
	
	
			/*
			 * input formate:
			 * the first line contains an int n -number of lines
			 * next n lines are the coordinates for each line in the foramt[x[1]y[1]
			 * x[2]y[2]], wwhere (x[1],y[1]) is the starting point and (x[2],y[2]) is the endpoint of line.
			 * the last line is the starting point for comparision format:[x,y]
	
	
	sample input
	
	
	STDIN              Function
	-----              ----------
	4                  number of lines n = 4
	3 8 13 14          (x1, y1, x2, y2)[0] = 3, 8, 13, 14
	8 4 3 12           (x1, y1, x2, y2)[1] = 8, 4, 3, 12
		-7 -4 17 6   (x1, y1, x2, y2)[2] = -7, -4, 17, 6
	     7 3 1 2     (x1, y1, x2, y2)[3] = 7, 3, 1, 2
	     8 4          starting point(x,y)= 8, 4
	     
	     
	    sample  output
	     
	     Longest Line --> Start:(-7.0, -4.0) End:(17.0, 6.0)
	     Length: 26.00
	     All the Lines starting from point:(8.0, 4.0)
	     Start:(8.0, 4.0)  End: (3.0, 12.0)
 
 
	*/
	
	
	//************SOLUTION**********************
	
	import java.util.Scanner;
	import java.util.Vector;
	import java.text.DecimalFormat;
 
	class Point {
	    private double x;
	    private double y;
 
	    Point(double x, double y) {
	        this.x = x;
	        this.y = y;
	    }
 
	    public double getX() {
	        return x;
	    }
 
	    public double getY() {
	        return y;
	    }
 
	    public void setX(double x) {
	        this.x = x;
	    }
 
	    public void setY(double y) {
	        this.y = y;
	    }
 
	    public static double distance(Point p1, Point p2) {
	        double distance = Math.sqrt(
	            Math.pow(p2.getY() - p1.getY(), 2) +
	            Math.pow(p2.getX() - p1.getX(), 2)
	        );
	        return distance;
	    }
 
	    public String toString() {
	        return "(" + this.x + ", " + this.y + ")";
	    }
	}
 
	class Line {
	    private Point start;
	    private Point end;
 
	    Line(Point start, Point end) {
	        this.start = start;
	        this.end = end;
	    }
 
	    public Point getStart() {
	        return start;
	    }
 
	    public void setStart(Point start) {
	        this.start = start;
	    }
 
	    public Point getEnd() {
	        return end;
	    }
 
	    public void setEnd(Point end) {
	        this.end = end;
	    }
 
	    public double getLineLength() {
	        return Point.distance(start, end);
	    }
 
	    public String toString() {
	        return "Start: " + this.start + " End: " + this.end;
	    }
	}
 
	interface ListOfLines {
	    Vector<Line> getLinesFromStartingPoint(Point p);
	    Line getLineWithMaxLength();
	}
 
	class LineList implements ListOfLines {
	    private Vector<Line> list_of_lines;
 
	    LineList(Vector<Line> lines) {
	        this.list_of_lines = lines;
	    }
 
	    public Vector<Line> getLinesFromStartingPoint(Point p) {
	        Vector<Line> result = new Vector<>();
	        for (Line line : list_of_lines) {
	            if (line.getStart().getX() == p.getX() && line.getStart().getY() == p.getY()) {
	                result.add(line);
	            }
	        }
	        return result;
	    }
 
	    public Line getLineWithMaxLength() {
	        Line maxLine = null;
	        double maxLength = 0;
	        for (Line line : list_of_lines) {
	            double length = line.getLineLength();
	            if (length > maxLength) {
	                maxLength = length;
	                maxLine = line;
	            }
	        }
	        return maxLine;
	    }
	}
 
	public class Solution {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int nLines = Integer.parseInt(sc.nextLine());
	        Vector<Line> lines = new Vector<>();
 
	        for (int i = 0; i < nLines; i++) {
	            String[] input = sc.nextLine().split(" ");
	            double x1 = Double.parseDouble(input[0]);
	            double y1 = Double.parseDouble(input[1]);
	            double x2 = Double.parseDouble(input[2]);
	            double y2 = Double.parseDouble(input[3]);
 
	            Point p1 = new Point(x1, y1);
	            Point p2 = new Point(x2, y2);
	            Line line = new Line(p1, p2);
	            lines.add(line);
	        }
 
	        String[] input = sc.nextLine().split(" ");
	        double point_x1 = Double.parseDouble(input[0]);
	        double point_y1 = Double.parseDouble(input[1]);
	        Point startingPoint = new Point(point_x1, point_y1);
 
	        LineList myList = new LineList(lines);
	        Line maxLine = myList.getLineWithMaxLength();
	        System.out.println("Longest Line --> " + maxLine);
	        double length = maxLine.getLineLength();
	        DecimalFormat df = new DecimalFormat("#.00");
	        System.out.println("Length: " + df.format(length));
 
	        Vector<Line> starting_lines = myList.getLinesFromStartingPoint(startingPoint);
	        System.out.println("All the Lines starting from point: " + startingPoint);
	        for (Line line : starting_lines) {
	            System.out.println(line);
	        }
	    }
	}
	
	
	
	
	
	
	
	
	

 


