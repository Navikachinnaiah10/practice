package m1;
//Navika

import java.util.ArrayList;
import java.util.List;

public class StorageEfficiency {
    public static int getMaximumStorageEfficiency(List<Integer> num_segments, long m) {
        int maxEfficiency = 0;
        for (int segment : num_segments) {
            int efficiency = (int) (m / segment);
            if (efficiency > maxEfficiency) {
                maxEfficiency = efficiency;
            }
        }
        return maxEfficiency;
    }

    public static void main(String[] args) {
        List<Integer> num_segments = new ArrayList<>();
        num_segments.add(10);
        num_segments.add(20);
        num_segments.add(30);
        long m = 100;
        System.out.println(getMaximumStorageEfficiency(num_segments, m));  // Output: 10
    }
}
or
import java.io.*;
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

    /*
     * Complete the 'getMaximumStorageEfficiency' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY num_segments
     *  2. LONG m
     */

    public static int getMaximumStorageEfficiency(List<Integer> num_segments, long m) {
        // Write your code here
        int maxEfficiency = 0;
        for (int segment : num_segments) {
            int efficiency = (int) (m / segment);
            if (efficiency > maxEfficiency) {
                maxEfficiency = efficiency;
            }
        }
        return maxEfficiency;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int num_segmentsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> num_segments = IntStream.range(0, num_segmentsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long m = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.getMaximumStorageEfficiency(num_segments, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
//kiran

M1: 
1st QUESTION:
Give  3 integer i, j,k a sequence sum to be thr value of i+(i+1)+(i+2)+......+j+(j-1)+(j-2)+.....+k 
(increment from i until it equals j , then decrement from j until it equals k)
Given values i,j,k calculate the sequence sum aas decribed
  
eg: 
  i=5
  j=9
  k=6
  
  sum all the values fron i to j and back to k: 5+6+7+8++9+8+7+6=56
  
  Functional description:
  Complete function getSequenceSum in editor
  
  getSumSequenceSum has:
   1. int i, int j, int k

   2. Return long : the value of sequenseSum

  Constraints:
  1.  -10^8 <=i ,j,k <= 10^8
  2.   i,k<=j
  

ANSWER:(ONLY THE ANSWER PART NOT FULL PROGRAM)
  class result{
  .....




  public static long getSequenceSum(int i, int j,intk){
  long sum=0; 
  for(int x=i; x<=j;x++){
  sum+=x;
  }
  for(int x=j-1;x>=k;x--){
  sum+=x;
  }
  return sum;
  }
  }



2ND QUESTION:

A software development team for Ecommerce company is working on billing software. They are given some product prices,
followed by discounts, and the number of items purchased by user.
abstract given a list of unique items with their prices, a list of unique items with thier discounts, and 
list of items purchased by user, generate the final invoice. The format for each 
item, price, total_price(total_price is calculated as sum_of_quality* price_of_item, and if a discount exixts, 
its substratced from it). There might be duplicates in the list of purchases.

This invoice list should be soreted in descending order of product name.class

GroceryReceipt class:
	Create the GroceryReceipt class that extends GrocerReceiptBase
	These properties will:
		1.prices- the list of items and prices
		2.discounts: the list of discounts for each item
		
		functional description:
			1. Create the GroceryReceipt class that extends GrocerReceiptBase abstract class
			2. Implement a Calculate function to create invoices. The function should return the item , 
                  quality, and the total price after the discount for every item in grocery receipt.
					
eg:
	It is given that banans, apples, oranges are priced at 10, 20, 5 .. 
	the discount on orange is 10% . The customer shopped list :
		banana -5
		orange(item)-2(quality)
		orange-1
		The final invoice is:
			banana-10(price)-50(total_price)
			orange - 5- 13.5
			normally an orange costs 5 per unit, but there is 10% discount .
                  For 3 units of orange, the gross price is 15, less 10% is 13.5
			
			
	
 import java.util.*;

 class Grocery {
     String fruit;
     double price, total;

     Grocery(String fruit, double price, double total) {
         this.fruit = fruit;
         this.price = price;
         this.total = total;
     }
 }

 class Node {
     String fruit;
     int count;

     public Node(String fruit, int count) {
         this.fruit = fruit;
         this.count = count;
     }
 }

 abstract class GroceryReceiptBase {
     protected Map<String, Double> prices;
     protected Map<String, Integer> discounts;

     public GroceryReceiptBase(Map<String, Double> prices, Map<String, Integer> discounts) {
         this.prices = prices;
         this.discounts = discounts;
     }

     public abstract List<Grocery> Calculate(List<Node> shoppingList);

     public Map<String, Double> getPrices() {
         return prices;
     }

     public Map<String, Integer> getDiscounts() {
         return discounts;
     }
 }


ANSWER:[

 class GroceryReceipt extends GroceryReceiptBase {

     public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
         super(prices, discounts);
     }

     @Override
     public List<Grocery> Calculate(List<Node> shoppingList) {
         Map<String, double[]> invoice = new HashMap<>(); // item -> [quantity, total_price]

         for (Node purchase : shoppingList) {
             String item = purchase.fruit;
             int quantity = purchase.count;
             double price = getPrices().getOrDefault(item, 0.0);
             double discount = getDiscounts().getOrDefault(item, 0);
             double totalPrice = quantity * price * (1 - discount / 100.0);
             invoice.putIfAbsent(item, new double[]{0, 0.0});
             invoice.get(item)[0] += quantity;
             invoice.get(item)[1] += totalPrice;
         }

         List<Map.Entry<String, double[]>> sortedInvoice = new ArrayList<>(invoice.entrySet());
         sortedInvoice.sort((a, b) -> a.getKey().compareTo(b.getKey())); // Sort in ascending order

         List<Grocery> result = new ArrayList<>();
         for (Map.Entry<String, double[]> entry : sortedInvoice) {
             String item = entry.getKey();
             double[] values = entry.getValue();
             result.add(new Grocery(item, getPrices().get(item), values[1]));
         }

         return result;
     }
 }

 ] END OF ANSWER
  public class Solution {
  
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ..........
     }
 }


  //jenifer

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

Ans: 

class Result  { 

 

public static long getMaximumScore(List<Integer> arr, int k) { 

PriorityQueue<Integer> maxHeap = new PriorityQueue<> 

(Collections.reverseOrder()); 

maxHeap.addAll(arr); 

 

long score = 0; 

for(int i =0;i<k;i++) { 

int maxElement = maxHeap.poll(); 

score +=maxElement; 

maxHeap.add((int) Math.ceil(maxElement / 3.0)); 

} 

return score; 

 

} 

PROBLEM SOLVING: Data Encryption 

You are required to customize a class ALL named DataEncryption, having the following attributes: encryptionRatio, baseEncryptionValue, and a method titled encryptValue(). The default encryptValue() function works by calculating the encrypted value as follows: encryptedValue = baseEncryptionValue + encryptionRatio 

Add more functionality to the existing method encryptValue() so that it accepts 

 

 

encryptedValue = baseEncryptionValue + encryptionRatio 

existing method encryptValue() so that it accepts a variable named encryptionAdjustment of integer data Type. 

Sample case 0-> 

Sample input : 

0 0 0 

Sample output : 

0 0 0 

Sample case 1-> 

sample input : 

10 12 4 

Sample output : 

22 18 18 

 

Ans: 

 

public class DataEncryption { 

    private int encryptionRatio; 

    private int baseEncryptionValue; 

 

    public DataEncryption(int encryptionRatio, int baseEncryptionValue) { 

        this.encryptionRatio = encryptionRatio; 

        this.baseEncryptionValue = baseEncryptionValue; 

    } 

 

    public int encryptValue(int encryptionAdjustment) { 

        int encryptedValue = baseEncryptionValue + encryptionRatio + encryptionAdjustment; 

        return encryptedValue; 

    } 

 

    public static void main(String[] args) throws IOException { 

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))); 

 
        
        

//sri

PROBLEM SOLVING:

Given a string,return the character that appears the maximum number of times in the string. 
The string will contain only ASCII characters from the ranges (a-z,A-Z,0-9), and case matters.
If there is a tie in the maximum number of times a character appearsin the string, 
return the character that appears first in the string.
  
Function description:
Complete the function maximumOccurringCharacter in the editor below:
  
It has the parameter String text:to be operated upon
  
Returns:
char: the most occurring character that appears first in the string.
  
Constraints:
10<= |text|<=10 power 4
all characters are alphanumeric in range (a-z,A-Z,0-9).
  
Sample input:
helloworld
sample output
l

ANSWER:

public static char maximumOccurringCharacter(String text) {
    int[] count = new int[128]; // ASCII characters range from 0 to 127
    char maxChar = text.charAt(0);
    int maxCount = 0;

    for (char c : text.toCharArray()) {
        count[c]++;
        if (count[c] > maxCount || (count[c] == maxCount && text.indexOf(c) < text.indexOf(maxChar))) {
            maxChar = c;
            maxCount = count[c];
        }
    }

    return maxChar;
}

JAVA:

Build on an abstract class and initialize an instance of each class with a variable.The program will test the implementation by retreiving the stored data.

The locked code in the editor does:
1.declares an abstract class named car with the implementations for getIsSedan() and 
getseats() methods and an abstract method named getMileage().

Function description:

1.create classes named WagonR,Hondacity,and Innovacrysta that all inherit from car class.
2.each class must have a constructor that receives one integer argument representing the mileage of
the car.
3.each class must implement a getMileAge() method which returns the string in form of 
'<mileage> kmpl' where <mileage> is the value provided to the constructor.

Constraints:
0<=type of car<=2
5<=mileage<=30

Sample input:
0 -> type of car to instantiate
22 ->mileage=22

Sample output:
A wagonR is not sedan,is 4-seater,,and has a 
mileage of 22 kmpl


Built in code:

abstract class Car
{
protected boolean isSedan;
protected String seats;

public Car(boolean isSedan, String seats) {
	super();
	this.isSedan = isSedan;
	this.seats = seats;
}
abstract public String getMileage();
public void printCar(String name)
{
System.out.println("A" +name+"is"+(this.getIsSedan()?"":
this.getSeats()+"seater and has a mileage of around"
+this.getMileage()+".");

}
}
Define classes for wagonR,innovacrysta,hondacity

ANSWER:

class WagonR extends Car {
private int mileage;

public WagonR(int mileage) {
    super(false, "4");
    this.mileage = mileage;
}

@Override
public String getMileage() {
    return mileage + " kmpl";
}
}

class HondaCity extends Car {
private int mileage;

public HondaCity(int mileage) {
    super(true, "4");
    this.mileage = mileage;
}

@Override
public String getMileage() {
    return mileage + " kmpl";
}
}

class InnovaCrysta extends Car {
private int mileage;

public InnovaCrysta(int mileage) {
    super(false, "6");
    this.mileage = mileage;
}

@Override
public String getMileage() {
    return mileage + " kmpl";
}
}


//durga


1)Java: Employee Profile

Question description

Implement the following classes:

1. abstract class Employee with the following methods:
* abstract void setSalary(int salary) method
* abstract int getSalary() method
* abstract void setGrade(String grade) method (grade of the employee in the organization)
* abstract String getGrade() method
* void label() method which prints "Employee's data:\n" (Concrete method, implementation is hidden
from end user)

2. class Engineer extending class Employee:
* private attribute int salary
* private attribute String grade
* implement the setter and getter methods from the parent class to set and get attributes (salary and
grade)

3. class Manager extending class Employee:
* private attribute int salary
* private attribute String grade
* implement the setter and getter methods from the parent class to set and get attributes (salary and
grade)
Note: The code stub handles input and calls the methods.

INPUT FORMAT FOR CUSTOM TESTING

The first line contains an integer, n, that denotes the number of employees to be instantiated.
Each line i of the n subsequent lines (where 0 ≤ i < n) contains 3 variables.
TYPE_OF_EMPLOYEE GRADE SALARY

SAMPLE CASE 0
Sample Input For Custom Testing
2 ENGINEER B
50000
MANAGER A 70000
Sample Output
Employee's data:
GRADE : B
SALARY : 50000
Employee's data:
GRADE : A
SALARY : 70000


SAMPLE CASE 1
Sample Input For Custom Testing
3 ENGINEER B
50000
MANAGER A 70000
MANAGER A 90000
Sample Output
Employee's data:
GRADE : B
SALARY : 50000
Employee's data:
GRADE : A
SALARY : 70000
Employee's data:
GRADE : A
SALARY : 90000


Interviewer guidelines
: Java 8
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//Write The Code Here
abstract class Employee {
   private int salary;
   private String grade;
 
   public abstract void setSalary(int salary);
   public abstract int getSalary();
   public abstract void setGrade(String grade);
   public abstract String getGrade();
 
   public void label() {
       System.out.println("Employee's data:");
   }
}
 
class Engineer extends Employee {
   private int salary;
   private String grade;
 
   public void setSalary(int salary) {
       this.salary = salary;
   }
 
   public int getSalary() {
       return salary;
   }
 
   public void setGrade(String grade) {
       this.grade = grade;
   }
 
   public String getGrade() {
       return grade;
   }
}
 
class Manager extends Employee {
   private int salary;
   private String grade;
 
   public void setSalary(int salary) {
       this.salary = salary;
   }
 
   public int getSalary() {
       return salary;
   }
 
   public void setGrade(String grade) {
       this.grade = grade;
   }
 
   public String getGrade() {
       return grade;
   }
}
 
public class Solution {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String sub = sc.nextLine();
       int n = Integer.parseInt(sub);
       for (int i = 0; i < n; i++) {
           String[] input = sc.nextLine().split(" ");
           if (input[0].equals("ENGINEER")) {
               Engineer e = new Engineer();
               e.setSalary(Integer.parseInt(input[2]));
               e.setGrade(input[1]);
               e.label();
               System.out.println("GRADE : " + e.getGrade());
               System.out.println("SALARY : " + e.getSalary());
           }
           if (input[0].equals("MANAGER")) {
               Manager e = new Manager();
               e.setSalary(Integer.parseInt(input[2]));
               e.setGrade(input[1]);
               e.label();
               System.out.println("GRADE : " + e.getGrade());
               System.out.println("SALARY : " + e.getSalary());
           }
       }
   }
}
 

Problem Solving :
//For practice use leet code question 2559
Count the number of vowel strings in range

Given an array of string strArr[] of size n ,determine if the string is a vowel string 
A string is called a vowel string if its starts with a vowel character and ends with a vowel character where vowel characters are 'a','e','i','o' and 'u'.
A List of query is provided where every query belongs to the inclusive range left and right and seperates based on "-". 
Complete the function hasVowels which returns an integer value that takescounts based on query.

Input Description:
The first line takes the length of the strArrCount
The next few line takes the array elements in string as strArr
The following line takes number of query as input 
The new lines takes queries with "-"  

output description:
The count of vowels strings based on the range of queries id return as the result.

Example:
Input: strArr = ["aab","a","bcd","awe","bbbbbbu"], queries = [2-3],[4-5]
Output: 1
	 1

Explanation: 
The strings starting and ending with a vowel are "a", "awe".
The answer to the query [2-3] is 1 (string "a).
to query [4-5,4] is 1 (string "awe")..
We return 	1
		1
sample Input
STDIN           Function
5         ->     strArr[] size n = 5
aab       ->     strArr = ["aab","a","bcd","awe","bbbbbbu"]
a
bcd
awe
bbbbbu
2         ->     query[] size n = 2
2-3       ->      query=["2-3",  "4-5"]
4-5


sample output
1
1


package com.m2;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result{
public static List<Integer> hasVowels(List<String> strArr, List<String> query){
	
        List<Integer> result = new ArrayList<>();
        for (String q : query) {
            String[] range = q.split("-");
            int start = Integer.parseInt(range[0]) - 1;
            int end = Integer.parseInt(range[1]) - 1;
            int count = 0;
            for (int i = start; i <= end; i++) {
                String s = strArr.get(i);
                if (isVowelString(s)) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    private static boolean isVowelString(String s) {
        return s.length() > 0 && isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
	
}
}

public class Solution{
public static void main(String[] args)	throws IOException{
	BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	
		int strArrCount = Integer.parseInt(bufferedReader.readLine().trim());
	
	List<String> strArr = IntStream.range(0, strArrCount).mapToObj(i->{
		try {
			return bufferedReader.readLine();	
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	})
			.collect(toList());
int queryCount = Integer.parseInt(bufferedReader.readLine().trim());
	
	List<String> query = IntStream.range(0, queryCount).mapToObj(i->{
		try {
			return bufferedReader.readLine();
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}).collect(toList());
	
	List<Integer> result = Result.hasVowels(strArr, query);
	bufferedWriter.write(
			result.stream()
			.map(Object::toString)
			.collect(joining("\n"))
			+"\n");
	bufferedReader.close();
	bufferedWriter.close();
}
}



//prathyusha

q1:
Library Structure
 
integer attribute number_of_books
  string attribute name 
  Map<String, Integer> bookGenres, map of genres to book count
 
we have to create class,add getter setters.
getter setters:
 
void setNumber_of_books(int number_of_books) method
void setName(string name) method
void setBookGenres(Map<String, Integer> bookGenres) method
 
ans:
 
class Library {
    private int number_of_books;
    private String name;
    private Map<String, Integer> bookGenres;
 
    public void setNumber_of_books(int number_of_books) {
        this.number_of_books = number_of_books;
    }
 
    public int getNumber_of_books() {
        return number_of_books;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setBookGenres(Map<String, Integer> bookGenres) {
        this.bookGenres = bookGenres;
    }
 
    public Map<String, Integer> getBookGenres() {
        return bookGenres;
    }
}
2.PROBLEM SOLVING:
COUNT SIMILAR PAIRS OF WORDS
package aran1;
import java.io.*;
import java.util.*;
import java.util.stream.*;
class Result {
    // Method to count similar pairs of words
    public static long countSimilarPairs(List<String> words) {
        long count = 0;
        int n = words.size();
        // Iterate through all pairs of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areSimilar(words.get(i), words.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
    // Method to check if two words are similar
    private static boolean areSimilar(String word1, String word2) {
        // Check if lengths are different
        if (word1.length() != word2.length()) {
            return false;
        }
        int differences = 0;
        // Count character differences
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differences++;
                // More than one difference means they are not similar
                if (differences > 1) {
                    return false;
                }
            }
}
        // They are similar if there is exactly one difference
        return differences == 1;
    }
}


//deepika

CALCULATOR:
	 
	SAMPLE INPUT:
	7
	4
 
 
	SAMPLE OUTPUT:
	Testing Addition
	Adding integers: 7 4
	Sum = 11
 
	Testing Multiplication
	Adding integers: 7 7
	Adding integers: 14 7
	Adding integers: 21 7
	Product = 28
 
	EXPLANATION
	in adder class the two numbers should be added and printed with
	Adding integers: a b
 
	in multiplier class it should call the method in adder class and should print
	Adding integers: a b repeatedly
 
	
 
	import java.util.Scanner;
 
	abstract class Calculator {
	    abstract int add(int a, int b);
	}
 
	/*
	 * Write the implementations of Adder and Multiplier classes.
	 */
 
	public class Solution {
	    private static final Scanner INPUT_READER = new Scanner(System.in);
	    private static final Calculator CALCULATOR = new Adder();
	    
	    private static void testAddition(int a, int b) {
	        System.out.println("Sum = " + CALCULATOR.add(a, b));
	    }
	    
	    private static void testMultiplication(int a, int b) {
	        System.out.println("Product = " + new Multiplier().multiply(a, b, CALCULATOR));
	    }
	    
	    public static void main(String[] args) {
	        int a = Integer.parseInt(INPUT_READER.nextLine());
	        int b = Integer.parseInt(INPUT_READER.nextLine());
	        
	        System.out.println("Testing Addition");
	        testAddition(a, b);
	        
	        System.out.println("\nTesting Multiplication");
	        testMultiplication(a, b);
	    }
	}
 
	Solution:
	import java.util.Scanner;
	abstract class Calculator {
	    abstract int add(int a, int b);
	}
 
	class Adder extends Calculator {
	    
	    public int add(int a, int b) {
	        int sum = a + b;
	        System.out.println("Adding integers: " + a + "  " + b);
	        return sum;
	    }
	}
 
	class Multiplier{
	    public int multiply(int a, int b, Calculator CALCULATOR) {
	        int c = 0;
	        for (int i = 0; i < b-1; i++) {
	            CALCULATOR.add(a+c,a);
			c+=a;
	        }
	        return (a+b);
	    }
	}
 
	public class Solution {
	    private static final Scanner INPUT_READER = new Scanner(System.in);
	    private static final Calculator CALCULATOR = new Adder();
	    
	    private static void testAddition(int a, int b) {
	        System.out.println("Sum = " + CALCULATOR.add(a, b));
	    }
	    
	    private static void testMultiplication(int a, int b) {
	        System.out.println("Product = " + new Multiplier().multiply(a, b, CALCULATOR));
	    }
	    public static void main(String[] args) {
	        int a = Integer.parseInt(INPUT_READER.nextLine());
	        int b = Integer.parseInt(INPUT_READER.nextLine());
	        
	        System.out.println("Testing Addition");
	        testAddition(a, b);
	        
	        System.out.println("\nTesting Multiplication");
	        testMultiplication(a, b);
	    }
	}
 
	
	2.
	
	movie
	
	import java.util.*;

	public class Watchlist {

	    public static long createCustomWatchlist(int[] duration, int[] rating, int limit) {
	        int n = duration.length;
	        List<Movie> movies = new ArrayList<>();
	        
	        for (int i = 0; i < n; i++) {
	            movies.add(new Movie(duration[i], rating[i]));
	        }
	        
	        // Sort movies by the product of duration and rating in descending order
	        movies.sort((a, b) -> Long.compare(b.duration * b.rating, a.duration * a.rating));
	        
	        long maxSum = 0;
	        for (int i = 0; i < limit; i++) {
	            maxSum += (long) movies.get(i).duration * movies.get(i).rating;
	        }
	        
	        return maxSum;
	    }

	    static class Movie {
	        int duration;
	        int rating;

	        Movie(int duration, int rating) {
	            this.duration = duration;
	            this.rating = rating;
	        }
	    }

	    public static void main(String[] args) {
	        int[] duration = {7, 8, 2, 1, 4};
	        int[] rating = {7, 8, 10, 4, 8};
	        int limit = 3;

	        System.out.println(createCustomWatchlist(duration, rating, limit));  // Output: 133
	    }
	}
