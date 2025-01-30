package m1;

3.
//Abstract class Food
abstract class Food {
  // Nutritional values as instance variables
  double proteins;
  double carbohydrates;
  double fats;
  // Abstract method to display details with nutritional parameters
  abstract void displayDetails(double proteins, double carbohydrates, double fats);
}
//Class Egg that extends Food
class Egg extends Food {
  int tasteCount;
  String type;
  // Constructor for Egg that initializes nutritional values
  public Egg(double proteins, double carbohydrates, double fats) {
      // Initialize nutritional values using parameters
      this.proteins = proteins;
      this.carbohydrates = carbohydrates;
      this.fats = fats;
      this.tasteCount = 7;
      this.type = "non-vegetarian";
  }
  // Overriding displayDetails to print nutritional values
  @Override
  void displayDetails(double proteins, double carbohydrates, double fats) {
      System.out.println("Egg has " + proteins + "g of proteins, " +
              carbohydrates + "g of carbs, " + fats + "g of fats.");
  }
}
//Class Bread that extends Food
class Bread extends Food {
  int tasteCount;
  String type;

  // Constructor for Bread that initializes nutritional values
  public Bread(double proteins, double carbohydrates, double fats) {
      // Initialize nutritional values using parameters
      this.proteins = proteins;
      this.carbohydrates = carbohydrates;
      this.fats = fats;
      this.tasteCount = 8;
      this.type = "vegetarian";
  }
  // Overriding displayDetails to print nutritional values
  @Override
  void displayDetails(double proteins, double carbohydrates, double fats) {
      System.out.println("Bread has " + proteins + "g of proteins, " +
              carbohydrates + "g of carbs, " + fats + "g of fats.");
  }
}
-----------------------

You need to give the input of array ...which have elements like { S1 error, S2 success,S2 error,S2 error, S1 error,S2 error,S1 error}.....it should be given into the method.....and 
When the any server shows error more than 3 times it should be replaced

Example.. ...you can see the above example....which have S2 error 3 times and it will  replaced with same id ...so now replacement count is +1....then next S1 server error hit 3 time count ...so now it should be replaced ....so now the replacement count is 2 ......in the same way ...  We should see for each and every element in the array .....and at last replacement count will be printed ..
Only the error server will be calculated
------------------------------------------------------------------------------------------

jAVA BASICS:

package aran1;
import java.util.*;
import java.io.*;

class Edge {
  public final int fromNode;       
  public final int toNode;     
  private Edge(int fromNode, int toNode) {
      this.fromNode = fromNode;
      this.toNode = toNode;
  }

  // Factory method to create an instance of the class
  public static Edge createEdge(int fromNode, int toNode) {
      return new Edge(fromNode, toNode);
  }
  // Overridden equals method to compare two Edge objects by their values
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Edge)) return false;
      Edge edge = (Edge) o;
      return fromNode == edge.fromNode && toNode == edge.toNode;
  }

  // Overridden hashCode method to ensure correct behavior in hash-based collections
  @Override
  public int hashCode() {
      return Objects.hash(fromNode, toNode);
  }

  // Overridden toString method to output the edge in the desired format
  @Override
  public String toString() {
      return "From node: " + fromNode + " to node: " + toNode;
  }

  // Optionally, a compareTo method if needed for sorting (not requested in the problem)
  public int compareTo(Edge edge) {
      if (this.fromNode != edge.fromNode) {
          return Integer.compare(this.fromNode, edge.fromNode);
      }
      return Integer.compare(this.toNode, edge.toNode);
  }
}

public class Solution2{
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
      String arr[];
      int numberOfQueries = Integer.parseInt(br.readLine().trim());
      StringBuilder sb = new StringBuilder();
      // Using HashSet to store unique edges
      HashSet<Edge> set = new HashSet<>();
      // Reading the queries and processing edges
      for (int i = 1; i <= numberOfQueries; i++) {
          arr = br.readLine().trim().split(" ");
          int u = Integer.parseInt(arr[0]),
              v = Integer.parseInt(arr[1]);
          Edge edge = Edge.createEdge(u, v);

          // If the edge is already in the set, skip it
          if (set.contains(edge)) {
              continue;
          }
          // Add the edge to the set and append its string representation
          set.add(edge);
          sb.append(edge.toString()).append("\n");
      }
      // Output the number of unique edges
      out.println(set.size());
      // Output all unique edges in the required format
      out.println(sb.toString());
      out.flush();
      out.close();
  }
}
---------------------------------

//Design a class Edge to represent an edge of a directed graph. The classs should override the //following functions such as any two edge objects can be compared by value.
//Edge createEdge...a factory method to create an instance of the class.
//boolean equals: an overriden mfunction to check if the current and passed objects attributes are same.
//int compareto(Edge edge): an overriden function
//int hashcode an of to compute hash code for an object to support storing in hash tables
//String tostring(): public static Edge createEdge(int fromNode, int toNode) {
     // return "From node: " <this.fromNode> "to node:" <this.toNode>"  ";
//The firstline contains integer, numberofQueries the number of edges.
//Each i of the next numberOfQueries lines contains 2 space seperated integers , from nodeand to node respectively.
//SI : 4
//1 3 
//1 2
//2 1
//1 3 
//output:
------------------------------------------------------------------------------------------------------
2.PROBLEM SOLVING:

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

public class Solution {
  public static void main(String[] args) {
      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

          // Read the number of words
          int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

          // Read the words into a list
          List<String> words = IntStream.range(0, wordsCount)
                  .mapToObj(i -> {
                      try {
                          return bufferedReader.readLine();
                      } catch (IOException ex) {
                          throw new RuntimeException(ex);
                      }
                  })
                  .collect(Collectors.toList());

          // Count similar pairs and write the result
          long result = Result.countSimilarPairs(words);
          bufferedWriter.write(String.valueOf(result));
          bufferedWriter.newLine();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (NumberFormatException e) {
          System.err.println("Invalid input format. Please enter a valid integer for the number of words.");
      }
  }
}

-----------------------------------------------------------------------------------------------------
2nd Question 
This code is based on Method overloading.
In Main class 
public static void main(String[]args){
 here they had add all the  method and printed the output 
method-1-no parameter
method-2-int value as parameter
method-3-String as parameter
}

class method{
created variable as gn in the qn
created constructor
method-1 
public int somemethodname(){
 add the above variable 
and return the int variable.
}
method-2
public int somemethodname(int x){
add the above variable with x and return the int variable.
}
method-3
public int somemethodname(String x){
convert the string to integer
And add the converted integer with all variable.
return the int variable 
}
---------------------------------------------------------------------------
1st Question

input=0082663 
output=8662003
here,
we get the number as string and also we have to return the numbers as string.
this number if had even we have to exchange it's position and also max number is at front followed by min number.
          if had odd number we should not change it's position leave as it is.
In above input,
   0-even parity bit need to change it's position min value so it is at last.
   0-same procedure
   8-even parity bit need to change it's position max value so it is at frst.
   2-even parity bit need to change it's position min value so it is before 0.
   6-even parity bit need to change it's position min value so it is before 2.
   6-same procedure
   3-odd parity bit doesn't want to change it's position.


Ans:-


//Online Java Compiler
//Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
  public static String s(String n){
  List<Character> l=new ArrayList<>();
  for(int i=0;i<n.length();i++){
      int w=n.charAt(i);
      if(w%2==0){
          l.add(n.charAt(i));
      }
  }
  Collections.sort(l,Collections.reverseOrder());
  String x="";
  int k=0;
  for(int i=0;i<n.length();i++)
  {
          int a=n.charAt(i);
          
          if(a%2==0)
          {
              x+=l.get(k++);
          }
          else{
              x+=n.charAt(i);
          }
  }
  return x;
  }
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String n=sc.nextLine();
      
      System.out.println(s(n));
  }
}




4 Q1)
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
   * Complete the 'canBeEqualized' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY firstStrings
   *  2. STRING_ARRAY secondStrings
   */

  public static List<String> canBeEqualized(List<String> firstStrings, List<String> secondStrings) {
   //Write your code here


}

public class Solution 
{
  public static void main(String[] args) {

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
       int firstStringsCount = Integer.parseInt(bufferedReader.readLine().trim());
      List<String> firstStrings = IntStream.range(0, firstStringsCount).mapToObj(i -> {
           try {
               return bufferedReader.readLine();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
       })
           .collect(toList());

       int secondStringsCount = Integer.parseInt(bufferedReader.readLine().trim());

       List<String> secondStrings = IntStream.range(0, secondStringsCount).mapToObj(i -> {
           try {
               return bufferedReader.readLine();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
       })
           .collect(toList());

       List<String> result = Result.canBeEqualized(firstStrings, secondStrings);

       bufferedWriter.write(
          result.stream()
              //.collect(joining("\n"))
          + "\n"
);

      bufferedReader.close();
      bufferedWriter.close();
}
}

Q2)
//using method overloading complete the implementation allows a class to have multiple methods with the same name but different arguments lists.

//using method overloading complete implementation of the class exchangeRate with 3 methods.

1.public String rate (double local currency,String foreign currency )needs to process arguments likerate(1,"euro") and shoud return "1Euro".

2.public String rate(double localCurrency,double foreignCurrency)must return the sum when given inputs like rate(1.1,2.2).the resulting sum(like 3.3) should be rounded off to two decimal paces.

3)public String rate(String localCurrency,String FireignCurrency) should add inputs like rate("dollars"."yen") and return the concatenated string:dollarsyen
//the first line contains an integer n the num of inputs.                                                 


import java.io.*; 
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class exchangeRate{

      
}
public class Solution {
  public static void main(String args[] ) throws Exception {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT */
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      int n = Integer.parseInt(input);
      for(int i=0; i<n; i++) {
          String[] entries = sc.nextLine().split(" ");
           Boolean isFirstEntryDouble = isFloat(entries[0]);
          Boolean isSecondEntryDouble = isFloat(entries[1]);
          exchangeRate currencyExchange = new exchangeRate();
         if(isFirstEntryDouble && isSecondEntryDouble){
             System.out.println(localCurrency+ForeignCurrency);        System.out.println(currencyExchange.rate(Double.parseDouble(entries[0]), Double.parseDouble(entries[1])));
          }else {
        System.out.println(currencyExchange.rate(entries[0], entries[1]));
           }
       }
   }
   private static final Pattern DOUBLE_PATTERN = Pattern.compile(
   "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
   "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
   "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
   "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

public static boolean isFloat(String s)
{
   return DOUBLE_PATTERN.matcher(s).matches();
}


1.calculator question:

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
qn 1

There are n data entries stored in the cache.Each entry is of the form {timestamp,key,value}
example:
cache_entires=[["03:00:23","le3f08w","101"],["12:45:36","ef41t56l","243"],["21:09:31","ko0e51j8","809"]]
queries[[ef41t56l,"12:45:36"]]

output:243 integer list

if the timestamp and key in cache entries matches with queries  , print the value from cache entries in sorted form.


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
   * Complete the 'getQueryAnswers' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. 2D_STRING_ARRAY cache_entries
   *  2. 2D_STRING_ARRAY queries
   */

  public static List<Integer> getQueryAnswers(List<List<String>> cache_entries, List<List<String>> queries) {
  // Write your code here{
}

public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int cache_entriesRows = Integer.parseInt(bufferedReader.readLine().trim());
      int cache_entriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

      List<List<String>> cache_entries = new ArrayList<>();

      IntStream.range(0, cache_entriesRows).forEach(i -> {
          try {
              cache_entries.add(
                  Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                      .collect(toList())
              );
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
      });

      int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
      int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

      List<List<String>> queries = new ArrayList<>();

      IntStream.range(0, queriesRows).forEach(i -> {
          try {
              queries.add(
                  Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                      .collect(toList())
              );
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
      });

      List<Integer> result = Result.getQueryAnswers(cache_entries, queries);

      bufferedWriter.write(
          result.stream()
              .map(Object::toString)
              .collect(joining("\n"))
          + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
  }
}
Ans:


public static List<Integer> getQueryAnswers(List<List<String>> cache_entries, List<List<String>> queries) {
  Map<String, Integer> cacheMap = new HashMap<>();
  
  
  for (List<String> entry : cache_entries) {
      String key = entry.get(1) + ":" + entry.get(0);
      cacheMap.put(key, Integer.parseInt(entry.get(2)));
  }
  
  List<Integer> result = new ArrayList<>();
  

  for (List<String> query : queries) {
      String queryKey = query.get(0) + ":" + query.get(1);
      if (cacheMap.containsKey(queryKey)) {
          result.add(cacheMap.get(queryKey));
      }
  }
  
 
  result.sort(Collections.reverseOrder());
  
  return result;
}
qn 2

create a class realestateListing and irealestatelsiting interface 

add the following in the class 

id(int
title string
description string
price int 
location string

create another class called realestateapp implemnts irealestateapp interface

create methods 
addListing(irealestateListing)
removeListing(int lisitingId)
updateListing(IrealestateListing)
getListing() returns lisitngs
getlisitngByLocation(String location)
getLisitngByPricerange(int minPrice,int maxPrice) price falls within inclusive range 



import java.io.*;
import java.util.*;

interface IRealEstateListing {
  void setID(int ID);
  int getID();
  void setTitle(String title);
  String getTitle();
  void setDescription(String description);
  String getDescription();
  void setPrice(int price);
  int getPrice();
  void setLocation(String location);
  String getLocation();
}

interface IRealEstateApp {
  void addListing(IRealEstateListing listing);
  void removeListing(int listingID);
  void updateListing(IRealEstateListing listing);
  List<IRealEstateListing> getListings();
  List<IRealEstateListing> getListingsByLocation(String location);
  List<IRealEstateListing> getListingsByPriceRange(int minPrice, int maxPrice);
}

class RealEstateListing implements IRealEstateListing {
//write your code here 
should add getter setter here
}


class RealEstateApp implements IRealEstateApp {
  
//Write your code here
  
}

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(System.out);

      IRealEstateApp app = new RealEstateApp();
      int lCount = Integer.parseInt(br.readLine().trim());
      for (int i = 1; i <= lCount; i++) {
          String[] a = br.readLine().trim().split(" ");
          IRealEstateListing e = new RealEstateListing();
          e.setID(Integer.parseInt(a[0]));
          e.setTitle(a[1]);
          e.setDescription(a[2]);
          e.setPrice(Integer.parseInt(a[3]));
          e.setLocation(a[4]);
          app.addListing(e);
      }

      out.println("All Listings:");
      List<IRealEstateListing> allListings = app.getListings();
      for (IRealEstateListing listing : allListings) {
          out.println("ID: " + listing.getID() + ", Title: " + listing.getTitle() + ", Price: " + listing.getPrice() + " , Location: " + listing.getLocation());
      }

      String[] b = br.readLine().trim().split(" ");
      String location = b[0];
      out.println("Listings in " + location + ":");
      List<IRealEstateListing> listingsByLocation = app.getListingsByLocation(location);
      for (IRealEstateListing listing : listingsByLocation) {
          out.println("ID: " + listing.getID() + ", Title: " + listing.getTitle() + ", Price: " + listing.getPrice());
      }

      String[] c = br.readLine().trim().split(" ");
      int minPrice = Integer.parseInt(c[0]);
      int maxPrice = Integer.parseInt(c[1]);
      List<IRealEstateListing> getListingsByPriceRange = app.getListingsByPriceRange(minPrice, maxPrice);
      out.println("Listings By Price Range (" + minPrice + " - " + maxPrice + "):");
      for (IRealEstateListing item : getListingsByPriceRange) {
          out.println("ID: " + item.getID() + ", Title: " + item.getTitle() + ", Price: " + item.getPrice());
      }

      out.flush();
      out.close();
  }
}

Ans:

class RealEstateListing implements IRealEstateListing {
  
  int id;
  String title;
  String description;
  int price;
  String location;
  
  public int getId()
  {
      return id;
  }
  public void setId()
  {
      this.id=id;
      
  }
  
   public String getTitle()
  {
      return title;
  }
  public void setTitle()
  {
      this.id=id;
      
  }
  public String getDescription()
  {
      return description;
  }
  public void setDescription()
  {
      this.description=description;
      
  }
  
   public int getPrice()
  {
      return price;
  }
  public void setPrice()
  {
      this.price=price;
      
  }
    public String getLocation()
  {
      return location;
  }
  public void setLocation()
  {
      this.location=location;
      
  }
 
}

class RealEstateApp implements IRealEstateApp {
  private List<IRealEstateListing> listings = new ArrayList<>();

  @Override
  public void addListing(IRealEstateListing listing) {
      listings.add(listing);
  }

  @Override
  public void removeListing(int listingID) {
      listings.removeIf(listing -> listing.getID() == listingID);
  }

  @Override
  public void updateListing(IRealEstateListing updatedListing) {
      for (int i = 0; i < listings.size(); i++) {
          if (listings.get(i).getID() == updatedListing.getID()) {
              listings.set(i, updatedListing);
              break;
          }
      }
  }

  @Override
  public List<IRealEstateListing> getListings() {
      return new ArrayList<>(listings);
  }

  @Override
  public List<IRealEstateListing> getListingsByLocation(String location) {
      List<IRealEstateListing> result = new ArrayList<>();
      for (IRealEstateListing listing : listings) {
          if (listing.getLocation().equalsIgnoreCase(location)) {
              result.add(listing);
          }
      }
      return result;
  }

  @Override
  public List<IRealEstateListing> getListingsByPriceRange(int minPrice, int maxPrice) {
      List<IRealEstateListing> result = new ArrayList<>();
      for (IRealEstateListing listing : listings) {
          int price = listing.getPrice();
          if (price >= minPrice && price <= maxPrice) {
              result.add(listing);
          }
      }
      return result;
  }
}



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
5   
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

//Abstract Employee class with Engineer and Manager subclasses
package E;

abstract class Employee {
  abstract void setSalary(int salary);
  abstract int getSalary();
  abstract void setGrade(String grade);
  abstract String getGrade();

  void label() {
      System.out.println("Employee's data:");
  }
}

class Engineer extends Employee {
  private int salary;
  private String grade;

  @Override
  void setSalary(int salary) {
      this.salary = salary;
  }

  @Override
  int getSalary() {
      return salary;
  }

  @Override
  void setGrade(String grade) {
      this.grade = grade;
  }

  @Override
  String getGrade() {
      return grade;
  }
}

class Manager extends Employee {
  private int salary;
  private String grade;

  @Override
  void setSalary(int salary) {
      this.salary = salary;
  }

  @Override
  int getSalary() {
      return salary;
  }

  @Override
  void setGrade(String grade) {
      this.grade = grade;
  }

  @Override
  String getGrade() {
      return grade;
  }
}
------------------------------


//Main method given there itself...

Q1.
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

public class Solution {
  public static void main(String[] args) {
      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {

          // Read the number of words
          int wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

          // Read the words into a list
          List<String> words = IntStream.range(0, wordsCount)
                  .mapToObj(i -> {
                      try {
                          return bufferedReader.readLine();
                      } catch (IOException ex) {
                          throw new RuntimeException(ex);
                      }
                  })
                  .collect(Collectors.toList());

          // Count similar pairs and write the result
          long result = Result.countSimilarPairs(words);
          bufferedWriter.write(String.valueOf(result));
          bufferedWriter.newLine();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (NumberFormatException e) {
          System.err.println("Invalid input format. Please enter a valid integer for the number of words.");
      }
  }
}


________________________________________________________________
Q2.
import java.util.*;
import java.io.*;

class Edge {
  public final int fromNode;       
  public final int toNode;     

  private Edge(int fromNode, int toNode) {
      this.fromNode = fromNode;
      this.toNode = toNode;
  }

  // Factory method to create an instance of the class
  public static Edge createEdge(int fromNode, int toNode) {
      return new Edge(fromNode, toNode);
  }

  // Overridden equals method to compare two Edge objects by their values
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Edge)) return false;
      Edge edge = (Edge) o;
      return fromNode == edge.fromNode && toNode == edge.toNode;
  }

  // Overridden hashCode method to ensure correct behavior in hash-based collections
  @Override
  public int hashCode() {
      return Objects.hash(fromNode, toNode);
  }

  // Overridden toString method to output the edge in the desired format
  @Override
  public String toString() {
      return "From node: " + fromNode + " to node: " + toNode;
  }

  // Optionally, a compareTo method if needed for sorting (not requested in the problem)
  public int compareTo(Edge edge) {
      if (this.fromNode != edge.fromNode) {
          return Integer.compare(this.fromNode, edge.fromNode);
      }
      return Integer.compare(this.toNode, edge.toNode);
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter out = new PrintWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String arr[];
      int numberOfQueries = Integer.parseInt(br.readLine().trim());

      StringBuilder sb = new StringBuilder();

      // Using HashSet to store unique edges
      HashSet<Edge> set = new HashSet<>();

      // Reading the queries and processing edges
      for (int i = 1; i <= numberOfQueries; i++) {
          arr = br.readLine().trim().split(" ");
          int u = Integer.parseInt(arr[0]),
              v = Integer.parseInt(arr[1]);
          Edge edge = Edge.createEdge(u, v);

          // If the edge is already in the set, skip it
          if (set.contains(edge)) {
              continue;
          }
          // Add the edge to the set and append its string representation
          set.add(edge);
          sb.append(edge.toString()).append("\n");
      }

      // Output the number of unique edges
      out.println(set.size());
      // Output all unique edges in the required format
      out.println(sb.toString());

      out.flush();
      out.close();
  }
}

//Design a class Edge to represent an edge of a directed graph. The classs should override the //following functions such as any two edge objects can be compared by value.
//Edge createEdge...a factory method to create an instance of the class.
//boolean equals: an overriden mfunction to check if the current and passed objects attributes are same.
//int compareto(Edge edge): an overriden function
//int hashcode an of to compute hash code for an object to support storing in hash tables
//String tostring(): public static Edge createEdge(int fromNode, int toNode) {
     // return "From node: " <this.fromNode> "to node:" <this.toNode>"  ";
//The firstline contains integer, numberofQueries the number of edges.
//Each i of the next numberOfQueries lines contains 2 space seperated integers , from nodeand to node respectively.
//SI : 4
//1 3 
//1 2
//2 1
//1 3 
//output:


Answers :


1)
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
   * Complete the 'getNetProfit' function below.
   *
   * The function is expected to return a LONG_INTEGER_ARRAY.
   * The function accepts STRING_ARRAY events as parameter.
   */

  public static List<Long> getNetProfit(List<String> events) {
      Map<String, Long> buyPrices = new HashMap<>();
      Map<String, Long> currentPrices = new HashMap<>();
      List<Long> results = new ArrayList<>();
      long totalProfit = 0;

      for (String event : events) {
          String[] elements = event.split(" ");
          String action = elements[0];

          if (action.equalsIgnoreCase("BUY")) {
              String item = elements[1];
              long price = Long.parseLong(elements[2]);
              buyPrices.put(item, price);
              currentPrices.put(item, price);
          } else if (action.equalsIgnoreCase("SELL")) {
              String item = elements[1];
              long sellPrice = Long.parseLong(elements[2]);
              if (buyPrices.containsKey(item)) {
                  long buyPrice = buyPrices.get(item);
                  totalProfit += (sellPrice - buyPrice);
                  currentPrices.remove(item);
                  buyPrices.remove(item); // Item is sold, remove it
              }
          } else if (action.equalsIgnoreCase("CHANGE")) {
              String item = elements[1];
              long newPrice = Long.parseLong(elements[2]);
              if (currentPrices.containsKey(item)) {
                  currentPrices.put(item, newPrice);
              }
          } else if (action.equalsIgnoreCase("QUERY")) {
              results.add(totalProfit);
          }
      }
      return results;
  }
}
public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int eventsCount = Integer.parseInt(bufferedReader.readLine().trim());

      List<String> events = IntStream.range(0, eventsCount).mapToObj(i -> {
          try {
              return bufferedReader.readLine();
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
      })
          .collect(toList());
      //System.out.println(events.size());
      List<Long> result = Result.getNetProfit(events);

      bufferedWriter.write(
          result.stream()
              .map(Object::toString)
              .collect(joining("\n"))
          + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
  }
}


2) 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

abstract class Employee{
  abstract void setSalary(int salary);
  abstract int getSalary();
  abstract void setGrade(String grade);
  abstract String getGrade();
  public void label(){
      System.out.println("Employee's data:");
  }
}
class Engineer extends Employee{
  private int salary;
  private String grade;
  public Engineer(){
      
  }
  public void setSalary(int salary){
      this.salary=salary;
  }
  public int getSalary(){
      return salary;
  }
  public void setGrade(String grade){
      this.grade=grade;
  }
  public String getGrade(){
      return grade;
  }

}
class Manager extends Employee{
  private int salary;
  private String grade;
  public Manager(){
      
  }
  public void setSalary(int salary){
      this.salary=salary;
  }
  public int getSalary(){
      return salary;
  }
  public void setGrade(String grade){
      this.grade=grade;
  }
  public String getGrade(){
      return grade;
  }

}

public class Solution {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String sub = sc.nextLine();
      int n = Integer.parseInt(sub);
      for(int i=0;i<n;i++){
          String[] input = sc.nextLine().split(" ");
          if(input[0].equals("ENGINEER")){
              Engineer e = new Engineer();
              e.setSalary(Integer.parseInt(input[2]));
              e.setGrade(input[1]);
              e.label();
              System.out.println("GRADE : " + e.getGrade());
              System.out.println("SALARY : " + e.getSalary());
          }
          if(input[0].equals("MANAGER")){
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


Answers: 

1)
int count=1;
      while(true){
          System.out.println(arr + " "+count);
          int tocheck = arr.get(0);
          if(arr.get(0)<arr.get(1)){
              int temp = arr.remove(0);
              arr.add(temp);
          }
          else{
              count++;
              int temp = arr.remove(1);
              arr.add(temp);
          }
          if(count==k){
              break;
          }
      }
      return arr.get(0);
  }
------------------------------------
2)

Implement getter setter

Answers :

1) 
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
   * Complete the 'getJSONDiff' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING json1
   *  2. STRING json2
   */

  

}
public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String json1 = bufferedReader.readLine();

      String json2 = bufferedReader.readLine();

      List<String> result = Result.getJSONDiff(json1, json2);

      bufferedWriter.write(
          result.stream()
              .collect(joining("\n"))
          + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
  }
}

2)
import java.util.*;
class Encrypter{
  
  static String name;
  
  Encrypter(String name){
  this.name = name;
  }
  
  static String getName(){
      return name;        
  }
  
  
      // create getEncryptedName method and call the method
		return input string in reverese to lowercase if true
		throw exception if false 
          }
      }

class Validator {
  public boolean validate(String name) {
      for (int i = 0; i < name.length(); i++) {
          char ch = name.charAt(i);
          
          if (ch != ' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))) {
              return false;
          }
      }
      
      return true;
  }
}

public class Solution {
  private static final Scanner INPUT_READER = new Scanner(System.in);
  
  public static void main(String[] args) {
      String name = INPUT_READER.nextLine();
      
      Encrypter enc = new Encrypter(name);
      
      try {
          enc.getEncryptedName();
      } catch (Exception e) {
          System.out.println(e);
      }
  }
} 

Answers: 

1)
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
System.out.println(currencyExchange.rate(Double.parseDouble(entries[0]),
Double.parseDouble(entries[1])));
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
1)package basic;


import java.util.Scanner;

import java.util.Scanner;

abstract class Calculator {

  abstract int add(int a, int b);

}

/*

* Write the implementations of Adder and Multiplier classes.

*/

class Adder extends Calculator{

	@Override

	int add(int a,int b) {

		System.out.println("Adding integers: "+a+" "+b);

		return a+b;

	}

}

class Multiplier extends Calculator{

	@Override

	int add(int a,int b) {

		return b;

	}

	public int multiply(int a,int b,Calculator cal) {

		int i=1;

		int sum=a;

		while(i<b) {

			sum=cal.add(sum, a);

			i++;

		}

		return sum;

	}

}

public class CalculatorQn {

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


--------------------------------------------------------------------------------
2)package DSA;
public class VowelQn {
  
  public static void main(String[] args) {
      String word = "abcd";
      Result result = makeVowelConsonantEqual(word);
      
      if (result != null) {
         // System.out.println("Modified Word: " + result.modifiedWord);
          System.out.println(result.operationsCount);
      } else {
          //System.out.println("Already balanced or no modification possible.");
      }
  }
  
  private static Result makeVowelConsonantEqual(String word) {
      int vowelCount = 0;
      int consonantCount = 0;

      // Count vowels and consonants
      for (char c : word.toCharArray()) {
          if (isVowel(c)) {
              vowelCount++;
          } else {
              consonantCount++;
          }
      }

      if (vowelCount == consonantCount) {
          return new Result(word, 0); // Already balanced, 0 operations needed
      }

      char[] chars = word.toCharArray();
      int operationsCount = 0;

      // Determine if we need more vowels or consonants
      if (vowelCount > consonantCount) {
          for (int i = 0; i < chars.length && vowelCount != consonantCount; i++) {
              if (isVowel(chars[i])) {
                  chars[i] = 'b'; // Replace vowel with consonant
                  vowelCount--;
                  consonantCount++;
                  operationsCount++;
              }
          }
      } else {
          for (int i = 0; i < chars.length && vowelCount != consonantCount; i++) {
              if (!isVowel(chars[i])) {
                  chars[i] = 'a'; // Replace consonant with vowel
                  consonantCount--;
                  vowelCount++;
                  operationsCount++;
              }
          }
      }

      return new Result(new String(chars), operationsCount);
  }
  
  private static boolean isVowel(char c) {
      return "aeiouAEIOU".indexOf(c) != -1;
  }

  // Helper class to store the result with word and operation count
  private static class Result {
      String modifiedWord;
      int operationsCount;

      Result(String modifiedWord, int operationsCount) {
          this.modifiedWord = modifiedWord;
          this.operationsCount = operationsCount;
      }
  }
}
--------------------------------------------------------------------------------------
3)// Abstract class Food

abstract class Food {

  // Nutritional values as instance variables

  double proteins;

  double carbohydrates;

  double fats;

  // Abstract method to display details with nutritional parameters

  abstract void displayDetails(double proteins, double carbohydrates, double fats);

}

//Class Egg that extends Food

class Egg extends Food {

  int tasteCount;

  String type;

  // Constructor for Egg that initializes nutritional values

  public Egg(double proteins, double carbohydrates, double fats) {

      // Initialize nutritional values using parameters

      this.proteins = proteins;

      this.carbohydrates = carbohydrates;

      this.fats = fats;

      this.tasteCount = 7;

      this.type = "non-vegetarian";

  }

  // Overriding displayDetails to print nutritional values

  @Override

  void displayDetails(double proteins, double carbohydrates, double fats) {

      System.out.println("Egg has " + proteins + "g of proteins, " +

              carbohydrates + "g of carbs, " + fats + "g of fats.");

  }

}

//Class Bread that extends Food

class Bread extends Food {

  int tasteCount;

  String type;

  // Constructor for Bread that initializes nutritional values

  public Bread(double proteins, double carbohydrates, double fats) {

      // Initialize nutritional values using parameters

      this.proteins = proteins;

      this.carbohydrates = carbohydrates;

      this.fats = fats;

      this.tasteCount = 8;

      this.type = "vegetarian";

  }

  // Overriding displayDetails to print nutritional values

  @Override

  void displayDetails(double proteins, double carbohydrates, double fats) {

      System.out.println("Bread has " + proteins + "g of proteins, " +

              carbohydrates + "g of carbs, " + fats + "g of fats.");

  }

}

//Main method

-----------------------------------------------------------------------------------
4)class Result {

  public static int countFaults(int n, List<String> logs) {
      // Map to track consecutive errors for each server
      Map<String, Integer> errorCount = new HashMap<>();
      int replacements = 0;

      for (String log : logs) {
          // Split each log entry to extract server id and status
          String[] parts = log.split(" ");
          String serverId = parts[0];
          String status = parts[1];

          if (status.equals("error")) {
              // Increment error count for the server
              errorCount.put(serverId, errorCount.getOrDefault(serverId, 0) + 1);

              // Check if server has reached 3 consecutive errors
              if (errorCount.get(serverId) == 3) {
                  // Replace the server and reset its error count
                  replacements++;
                  errorCount.put(serverId, 0);
              }
          } else {
 // Reset error count on a successful request
              errorCount.put(serverId, 0);
          }
      }

      return replacements;
  }
}
--------------------------------------------------------------------------------------
5)Input-> n = 4, strings = {"aabbb", "abba", "abbcd", "abc"} → Output: 2
Input-> n = 3, strings = {"abc", "ccba", "abbb"} → Output: 2
example:"aabbb" becomes "ab","abba" becomes "ab","abbcd"becomes"abcd","abc"becomes"abc".
just count the same Strings in the list.output=2.
"abc" becomes "abc","abba" becomes "ab","abbb" becomes "ab".output=2.
get input from the user & Create a list and insert the strings.
-------------------------------------------------------------------------------------
6)package CountDuplicate;

import java.util.HashMap;
import java.util.Scanner;

public class Count {
	
	    public static void main(String[] args) {
	    	Scanner sc=new Scanner(System.in);
	        String input =sc.nextLine();
	        int result = countDuplicates(input);
	        System.out.println(result);
	    }

	    public static int countDuplicates(String input) {
	        // HashMap to store the frequency of each character
	        HashMap<Character, Integer> charCountMap = new HashMap<>();
	        
	        // Count the frequency of each character in the string
	        for (int i = 0; i < input.length(); i++) {
	            char currentChar = input.charAt(i);
	            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
	        }
	        
	        // Count the number of characters that have more than one occurrence
	        int duplicateCount = 0;
	        for (int count : charCountMap.values()) {
	            if (count > 1) {
	                duplicateCount++;
	            }
	        }
	        
	        return duplicateCount;
	    }
	}

------------------------------------------------------------------------------------
7)
Input:2
    4  1
    2  2
Output:5.0
     4.0
Gokila’s Question:
1.Car Simulation with Method Overriding
You are tasked with implementing a class hierarchy to model a basic car simulation. The Car class should have methods to simulate different actions such as running, accelerating, and showing the car's speed. A specific type of car, BMW, extends the Car class and inherits its methods. Your goal is to implement a solution where different actions are executed based on user input.
Requirements:
1.	Create a Car class with the following methods: 
o	run(): This method should output "running".
o	accelerateStart(): This method should output "accelerating start".
o	speed(): This method should output "car running at 20km/hr".
2.	Create a BMW class that extends the Car class. This class can inherit the methods of Car and doesn't need to modify them for now. However, in the future, you may need to add more BMW-specific functionality.
3.	Create a Main class that contains a main method. The program should: 
o	Create an instance of the BMW class.
o	Prompt the user for input (i.e., "run", "accelerate", or "speed").
o	Based on the input, the program should call the corresponding method on the BMW object.
o	Output the result of the method call.
Input:
The user can provide one of the following inputs:
•	"run"
•	"accelerate"
•	"speed"
Output:
The program should output:
•	"running" when the user enters "run".
•	"accelerating start" when the user enters "accelerate".
•	"car running at 20km/hr" when the user enters "speed"
//Base class 'Car'
class Car {
  // Method to simulate the car running
  public void run() {
      System.out.println("running");
  }

  // Method to simulate the car accelerating
  public void accelerateStart() {
      System.out.println("accelerating start");
  }

  
}

//BMW class that extends Car
class BMW extends Car {
//Method to show the car's speed
  public void speed() {
      System.out.println("car running at 20km/hr");
  }
  // BMW can use the methods from Car without needing to override them
  // But we can add any BMW-specific behavior if needed (not required in this case)
}

//Main class to test the functionality
public class Main {
  public static void main(String[] args) {
      // Create a BMW object
      BMW b = new BMW();

      // Simulate user input (in a real program this could come from a scanner or UI input)
      String input = "run";  // Replace this with "accelerate" or "speed" to test other cases

      // Check the input and call the appropriate method on the BMW object
      if (input.equals("run")) {
          b.run();  // Calls the run() method from the Car class
      } else if (input.equals("accelerate")) {
          b.accelerateStart();  // Calls the accelerateStart() method from the Car class
      } else if (input.equals("speed")) {
          b.speed();  // Calls the speed() method from the Car class
      }
  }
}


2.Problem Statement:
You are given an array of log entries where each entry is a string consisting of a server ID and its corresponding status (either success or error). The log entries are sorted in the order they occur.
You need to determine how many times a server has been replaced due to consecutive errors. Specifically:
•	If a server encounters the status error more than 3 times in a row, it is considered to have failed and needs to be replaced.
•	A server should be reset to 0 error count after each replacement.
•	A server's error count should be reset to 0 if it logs a success.
The function will take the following inputs:
•	An integer n representing the number of log entries.
•	A list of n strings, each containing the server ID and its status.
Objective:Write a function countFaults(int n, List<String> logs) that returns the total number of replacements made for all servers in the log.
Input:
•	An integer n (1 ≤ n ≤ 10^5) - the number of log entries.
•	A list of n strings, each representing a log entry in the format "ServerID status", where ServerID is a string (e.g., "S1", "S2") and status is either success or error.
Output:
•	The function should return an integer, the total count of replacements.
Example:
Input:
javaCopy codeint n = 7;
List<String> logs = Arrays.asList("S1 error", "S2 success", "S2 error", "S2 error", "S1 error", "S2 error", "S1 error");
Output:
2

public static int countFaults(int n, List<String> logs) {
     // Map to track consecutive errors for each server
     Map<String, Integer> errorCount = new HashMap<>();
     int replacements = 0;

     for (String log : logs) {
         // Split each log entry to extract server id and status
         String[] parts = log.split(" ");
         String serverId = parts[0];
         String status = parts[1];

         if (status.equals("error")) {
             // Increment error count for the server
             errorCount.put(serverId, errorCount.getOrDefault(serverId, 0) + 1);

             // Check if server has reached 3 consecutive errors
             if (errorCount.get(serverId) == 3) {
                 // Replace the server and reset its error count
                 replacements++;
                 errorCount.put(serverId, 0);
             }
         } else {
// Reset error count on a successful request
             errorCount.put(serverId, 0);
         }
     }

     return replacements;
 }
}
1.Balance Vowels and Consonants in a String
You are given a string containing only lowercase alphabetical characters. Your task is to balance the number of vowels and consonants in the string by incrementing characters to the next letter of the alphabet. However, if a character is 'z', it cannot be incremented.
Task:
Write a Java program to determine the minimum number of operations required to balance the number of vowels and consonants in a given string. In each operation, you can increment a character to the next character in the alphabet (i.e., 'a' → 'b', 'b' → 'c', ..., 'y' → 'z').
•	Vowels are: a, e, i, o, u.
•	Consonants are all other alphabetic characters.
If there are more vowels than consonants, you can only convert vowels to consonants. If there are more consonants than vowels, you can only convert consonants to vowels. The string should be balanced when the number of vowels equals the number of consonants.
Your program should:
1.	Count the number of vowels and consonants in the string.
2.	If there are more vowels than consonants, convert vowels to consonants by incrementing them to the next character.
3.	If there are more consonants than vowels, convert consonants to vowels by incrementing them to the next character.
4.	The program should continue until the number of vowels equals the number of consonants.
5.	Do not increment 'z' to 'a'.
Input:
•	A string s containing only lowercase English alphabets (1 ≤ |s| ≤ 100).
Output:
•	The program should return an integer representing the minimum number of operations required to balance the number of vowels and consonants in the string.
Example:
Input 1:
abcd
Output 1:
1 

package DSA;
public class VowelQn {
  
  public static void main(String[] args) {
      String word = "abcd";
      Result result = makeVowelConsonantEqual(word);
      
      if (result != null) {
         // System.out.println("Modified Word: " + result.modifiedWord);
          System.out.println(result.operationsCount);
      } else {
          //System.out.println("Already balanced or no modification possible.");
      }
  }
  
  private static Result makeVowelConsonantEqual(String word) {
      int vowelCount = 0;
      int consonantCount = 0;

      // Count vowels and consonants
      for (char c : word.toCharArray()) {
          if (isVowel(c)) {
              vowelCount++;
          } else {
              consonantCount++;
          }
      }

      if (vowelCount == consonantCount) {
          return new Result(word, 0); // Already balanced, 0 operations needed
      }
      char[] chars = word.toCharArray();
      int operationsCount = 0;

      // Determine if we need more vowels or consonants
      if (vowelCount > consonantCount) {
          for (int i = 0; i < chars.length && vowelCount != consonantCount; i++) {
              if (isVowel(chars[i])) {
                  chars[i] = 'b'; // Replace vowel with consonant
                  vowelCount--;
                  consonantCount++;
                  operationsCount++;
              }
          }
      } else {
          for (int i = 0; i < chars.length && vowelCount != consonantCount; i++) {
              if (!isVowel(chars[i])) {
                  chars[i] = 'a'; // Replace consonant with vowel
                  consonantCount--;
                  vowelCount++;
                  operationsCount++;
              }
          }
      }

      return new Result(new String(chars), operationsCount);
  }
  
  private static boolean isVowel(char c) {
      return "aeiouAEIOU".indexOf(c) != -1;
  }

  // Helper class to store the result with word and operation count
  private static class Result {
      String modifiedWord;
      int operationsCount;

      Result(String modifiedWord, int operationsCount) {
          this.modifiedWord = modifiedWord;
          this.operationsCount = operationsCount;
      }
  }
}

2.Inheritance Question:
abstract class Employee {
  int salary;
  String grade;
  
  abstract int getSalary();
  abstract void setSalary(int salary);
  abstract String getGrade();
  abstract void setGrade(String grade);
  
  void label() {
      System.out.println("Employee data:");
  }
}

class Engineer extends Employee {
  int getSalary() {
      return salary;
  }

  void setSalary(int salary) {
      this.salary = salary;
  }

  String getGrade() {
      return grade;
  }

  void setGrade(String grade) {
      this.grade = grade;
  }
}

class Manager extends Employee {
  int getSalary() {
      return salary;
  }

  void setSalary(int salary) {
      this.salary = salary;
  }

  String getGrade() {
      return grade;
  }

  void setGrade(String grade) {
      this.grade = grade;
  }
}

public class Employeemgmt {
  public static void main(String[] args) {
      Engineer engineer = new Engineer();
      engineer.setSalary(60000);
      engineer.setGrade("A");
      
      Manager manager = new Manager();
      manager.setSalary(100000);
      manager.setGrade("B");
      
      engineer.label();
      System.out.println("Engineer Salary: " + engineer.getSalary());
      System.out.println("Engineer Grade: " + engineer.getGrade());

      manager.label();
      System.out.println("Manager Salary: " + manager.getSalary());
      System.out.println("Manager Grade: " + manager.getGrade());
  }
}

PROBLEM SOLVING : String JSON
import java.util.*;
import java.util.Scanner;

public class JSONDiff {
  public static List<String> getJSONDiff(String json1, String json2) {
      Map<String, String> map1 = parseJSON(json1);
      Map<String, String> map2 = parseJSON(json2);
      List<String> diffKeys = new ArrayList<>();

      for (String key : map1.keySet()) {
          if (map2.containsKey(key) && !map1.get(key).equals(map2.get(key))) {
              diffKeys.add(key);
          }
      }

      Collections.sort(diffKeys);
      return diffKeys;
  }

  private static Map<String, String> parseJSON(String json) {
      Map<String, String> map = new HashMap<>();
      String[] keyValuePairs = json.replaceAll("[{}\"]", "").split(",");

      for (String pair : keyValuePairs) {
          String[] keyValue = pair.split(":");
          if (keyValue.length == 2) {
              map.put(keyValue[0].trim(), keyValue[1].trim());
          }
      }

      return map;
  }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter the first JSON string:");
      String json1 = scanner.nextLine();
      System.out.println("Enter the second JSON string:");
      String json2 = scanner.nextLine();
      List<String> diff = getJSONDiff(json1, json2);
      if (diff.isEmpty()) {
          System.out.println("No differences found.");
      } else {
          System.out.println("Differences found in the following keys: " + diff);
      }

      scanner.close();
  }
}

JAVA BASIC : Movie Library management
import java.util.ArrayList;
import java.util.List;

interface IFilm {
  void setTitle(String title);
  String getTitle();
  void setDirector(String director);
  String getDirector();
  void setYear(int year);
  int getYear();
}

class Details implements IFilm {
  private String title;
  private String director;
  private int year;

  public Details(String title, String director, int year) {
      this.title = title;
      this.director = director;
      this.year = year;
  }

  @Override
  public String getTitle() {
      return title;
  }

  @Override
  public void setTitle(String title) {
      this.title = title;
  }

  @Override
  public String getDirector() {
      return director;
  }

  @Override
  public void setDirector(String director) {
      this.director = director;
  }

  @Override
  public int getYear() {
      return year;
  }

  @Override
  public void setYear(int year) {
      this.year = year;
  }

  @Override
  public String toString() {
      return title + " - " + director + " (" + year + ")";
  }
}

interface Library {
  void addFilm(Details film);
  String getFilm();
  List<Details> remove(String title);
  List<Details> search(String query);
  int getTotalCount();
}

class FilmLibrary implements Library {
  private List<Details> films;
  private int totalCount;

  public FilmLibrary() {
      films = new ArrayList<>();
      totalCount = 0;
  }

  @Override
  public void addFilm(Details film) {
      films.add(film);
      totalCount++;
  }

  @Override
  public String getFilm() {
      if (films.isEmpty()) {
          return "No films in the library.";
      }
      return films.toString();  // No extra code, just returning the list's string representation
  }

  @Override
  public List<Details> remove(String title) {
      List<Details> removedFilms = new ArrayList<>();
      for(Details film:films) {
          if (film.getTitle().equalsIgnoreCase(title)) {
              removedFilms.add(film);
              totalCount--;
              
          }
         
      }
      return removedFilms;
  }

  @Override
  public List<Details> search(String query) {
      List<Details> searchResults = new ArrayList<>();
      for (Details film : films) {
          if (film.getTitle().toLowerCase().contains(query.toLowerCase()) ||
              film.getDirector().toLowerCase().contains(query.toLowerCase())) {
              searchResults.add(film);
          }
      }
      return searchResults;
  }

  @Override
  public int getTotalCount() {
      return totalCount;
  }
}

public class Movie {
  public static void main(String[] args) {
      FilmLibrary library = new FilmLibrary();

      library.addFilm(new Details("Inception", "Christopher Nolan", 2010));
      library.addFilm(new Details("The Dark Knight", "Christopher Nolan", 2008));
      library.addFilm(new Details("Interstellar", "Christopher Nolan", 2014));

      System.out.println("All Films in the Library:");
      System.out.println(library.getFilm());

      System.out.println("Total Films: " + library.getTotalCount());

      List<Details> removedFilms = library.remove("Interstellar");
      System.out.println("\nRemoved Films:");
      for (Details removedFilm : removedFilms) {
          System.out.println(removedFilm);
      }

      System.out.println("\nRemaining Films in the Library:");
      System.out.println(library.getFilm());

      List<Details> searchResults = library.search("Dark");
      System.out.println("\nSearch Results for 'Dark':");
      for (Details film : searchResults) {
          System.out.println(film);
      }

      System.out.println("\nTotal Films after Removal: " + library.getTotalCount());
  }
}
Question:
1.Priority thread

2.Question
import java.util.Scanner;

abstract class Food {
  double proteins;
  double carbohydrates;
  double fats;

  abstract void displayDetails(double proteins, double carbohydrates, double fats);
}

class Egg extends Food {
  int tasteCount;
  String type;

  public Egg(double proteins, double carbohydrates, double fats) {
      this.proteins = proteins;
      this.carbohydrates = carbohydrates;
      this.fats = fats;
      this.tasteCount = 7;
      this.type = "non-vegetarian";
  }

  @Override
  void displayDetails(double proteins, double carbohydrates, double fats) {
      System.out.println("Egg has " + proteins + "g of proteins, " +
              carbohydrates + "g of carbs, " + fats + "g of fats.");
  }
}

class Bread extends Food {
  int tasteCount;
  String type;

  public Bread(double proteins, double carbohydrates, double fats) {
      this.proteins = proteins;
      this.carbohydrates = carbohydrates;
      this.fats = fats;
      this.tasteCount = 8;
      this.type = "vegetarian";
  }

  @Override
  void displayDetails(double proteins, double carbohydrates, double fats) {
      System.out.println("Bread has " + proteins + "g of proteins, " +
              carbohydrates + "g of carbs, " + fats + "g of fats.");
  }
}

public class Nutrition {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter nutritional details for Egg:");
      System.out.print("Proteins (in grams): ");
      double eggProteins = scanner.nextDouble();
      System.out.print("Carbohydrates (in grams): ");
      double eggCarbs = scanner.nextDouble();
      System.out.print("Fats (in grams): ");
      double eggFats = scanner.nextDouble();

      Egg egg = new Egg(eggProteins, eggCarbs, eggFats);

      System.out.println("Enter nutritional details for Bread:");
      System.out.print("Proteins (in grams): ");
      double breadProteins = scanner.nextDouble();
      System.out.print("Carbohydrates (in grams): ");
      double breadCarbs = scanner.nextDouble();
      System.out.print("Fats (in grams): ");
      double breadFats = scanner.nextDouble();

      Bread bread = new Bread(breadProteins, breadCarbs, breadFats);

      System.out.println("\nNutritional details for Egg:");
      egg.displayDetails(egg.proteins, egg.carbohydrates, egg.fats);

      System.out.println("\nNutritional details for Bread:");
      bread.displayDetails(bread.proteins, bread.carbohydrates, bread.fats);

      scanner.close();
  }
}

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
   * Complete the 'getJSONDiff' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING json1
   *  2. STRING json2
   */
}
public class Solution {
  public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String json1 = bufferedReader.readLine();

      String json2 = bufferedReader.readLine();

      List<String> result = Result.getJSONDiff(json1, json2);

      bufferedWriter.write(
          result.stream()
              .collect(joining("\n"))
          + "\n"
      );

      bufferedReader.close();
      bufferedWriter.close();
  }
}
-----------------------------------

//Online Java Compiler
//Use this editor to write, compile and run your Java code online
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {

      String json1="{Hacker:rank,Hello:world}";
      String json2="{Hacker:ranked,Hello:world}";

      json1=json1.replace('{'+"","");
      json1=json1.replace('}'+"","");

      json2=json2.replace('{'+"","");
      json2=json2.replace('}'+"","");

      String[] s1=json1.split(",");
      String[] s2=json2.split(",");
      List<String> l=new ArrayList<>();
      HashMap<String,String> h1=new HashMap<>();
      HashMap<String,String> h2=new HashMap<>();

      for(int i=0;i<s1.length;i++)
      {
          String[] w1=s1[i].split(":");
          h1.put(w1[0],w1[1]);
      }

      for(int i=0;i<s2.length;i++)
      {
          String[] w1=s2[i].split(":");
          h2.put(w1[0],w1[1]);
      }
      for(Map.Entry<String,String> m:h1.entrySet())
      {
          if(h2.containsKey(m.getKey()))
          {
              if(!h2.get(m.getKey()).equals(m.getValue()))
              {
                  l.add(m.getKey());
              }
          }
      }
      for(String s:l)
      {
          System.out.println(s);
      }

  }
}

importjava.io.*;
importjava.util.*;
importjava.util.stream.*;
classResult{
//Methodtocountsimilarpairsofwords
publicstaticlongcountSimilarPairs(List<String>words){
longcount=0;
intn=words.size();
//Iteratethroughallpairsofwords
for(inti=0;i<n;i++){
for(intj=i+1;j<n;j++){
if(areSimilar(words.get(i),words.get(j))){
count++;
}
}
}
returncount;
}
answer for 2q

import java.io.*;
import java.math.*;
import java.security.*;import java.text.*;import java.util.*;import java.util.concurrent.*;import java.util.function.*;import java.util.regex.*;
import java.util.stream.*;import static java.util.stream.Collectors.joining;import static java.util.stream.Collectors.t…
JSON qn 


mportjava.io.*; importjava.util.*; importjava.util.stream.*; classResult{ //Methodtocountsimilarpairsofwords publicstaticlongcountSimilarPairs(List<String>words){ longcount=0; intn=words.size(); //Iteratethroughallpairsofwords for(inti=0;i<n;i++){ for(intj=i+1;j<n;j++){ if(areSimilar(wor…
String Manipulation 

package enums;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class DataEncryption  {

  int encryptionRatio;
  int baseEncryptionValue;

  public DataEncryption(int encryptionRatio,int baseEncryptionValue)
  {
      this.baseEncryptionValue = baseEncryptionValue;
      this.encryptionRatio = encryptionRatio;
  }

  public int encryptValue()
  {
      int encryptedValue = baseEncryptionValue + encryptionRatio;
      return encryptedValue;
  }

  public int encryptValue(int encryptionAdjustment)
  {
      int encryptedValue = (baseEncryptionValue + encryptionRatio) - encryptionAdjustment;

      return encryptedValue;
  }

  public int encrypValue(String encryptionAdjustment)
  {

    int adjustment = Integer.parseInt(encryptionAdjustment);

    int encryptedValue = (baseEncryptionValue + encryptionRatio) - adjustment;

      return encryptValue();
  }







}
public class Solution {
  public static void main(String args[] ) throws Exception {
      //reader and writer
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] values = bufferedReader.readLine().split(" ");

      //check if int array
      try{
          Integer.parseInt(values[0]);

          //System.out.println("Integer array");
          Integer[] ia = new Integer[values.length];
          for (int i = 0; i < values.length; i++){
              ia[i] = new Integer(values[i]);
          }
          DataEncryption dataEncryption = new DataEncryption(ia[0], ia[1]);

          bufferedWriter.write(
               dataEncryption.encryptValue() + " " 
     + dataEncryption.encryptValue(ia[2]) + " "             
     + dataEncryption.encryptValue(String.valueOf(ia[2]))
          );

          bufferedWriter.newLine();

          bufferedReader.close();
          bufferedWriter.close();

      } catch(NumberFormatException nfe){
          //then string array

          //System.out.println("String array");
          System.out.println();
      }
  }
}




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


public class Bank_System {
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
}
has context menu
package hari;

import java.util.*;

public class h1 {
  public static void main(String args[]) {
      List<String> results = new ArrayList<>();
      List<String> l1 = new ArrayList<>();
      l1.add("ab");
      l1.add("pqqrr");

      List<String> l2 = new ArrayList<>();
      l2.add("ba");
      l2.add("prrrr");
     
      int length=l1.get(0).length();
      for(int i=0;i<l1.size();i++)
      {
        length=Math.min(length, l1.get(i).length());
      }
      for (int i = 0; i < l1.size(); i++) {
          String str1 = l1.get(i);
          String str2 = l2.get(i);
         

          // Check if the strings can be made equal by a number of replacements equal to minLength
          if (canBeMadeEqualByNReplacements(str1, str2, length)) {
              results.add("YES");
          } else {
              results.add("NO");
          }
      }

      // Print the results
      for (String result : results) {
          System.out.println(result);
      }
  }

  private static boolean canBeMadeEqualByNReplacements(String str1, String str2, int allowedChanges) {
      // If lengths are not equal, they can't be made equal by a specified number of replacements
      if (str1.length() != str2.length()) {
          return false;
      }

      int countDifferences = 0;
      char s=0;
      // Count the number of differing characters
      for (int j = 0; j < str1.length(); j++) {
          if (str1.charAt(j) != str2.charAt(j))
          {
            if(s==0 ||s==str2.charAt(j))
            {
              countDifferences++;
              s=str2.charAt(j);
            }
              
              // If more differing characters than allowed, return false
              if (countDifferences > allowedChanges) {
                  return false;
              }
          }
      }

      // Return true if the number of differing characters is less than or equal to allowedChanges
      return countDifferences <= allowedChanges;
  }
}
abstract class Car
{
 protected boolean isSedan;
 protected String seats;
public Car(boolean isSedan, String seats) {
  super();
  this.isSedan = isSedan;
  this.seats = seats;
}
public boolean getIsSedan() {
  return this.isSedan;
}
public void setSedan(boolean isSedan) {
  this.isSedan = isSedan;
}
public String getSeats() {
  return this.seats;
}
public void setSeats(String seats) {
  this.seats = seats;
}

abstract public String getMileage();
public void printCar(String name)
{
  System.out.println("A"+name+"is"+(this.getIsSedan()?"":"not")+"Sedan,is"+this.getSeats()+"-seater,and has a mileage of around"+this.getMileage()+".");  
}
}
class WagonR extends Car
{
 private int mileage;
WagonR(int mileage)
{
  super(false,"4");
  this.mileage=mileage;
}
@Override
public String getMileage()
{
  return mileage+"kmpl";
}
}
class HondaCity extends Car
{
 private int mileage;
 public HondaCity(int mileage)
 {
   super(true,"4");
   this.mileage= mileage;
 }
 @Override
 public String getMileage()
 {
   return  mileage+"kmpl";
 }
}
class InnovaCrystal extends Car
{
 private int  mileage;
 public InnovaCrystal(int mileage) {
   super(false,"6");
   this.mileage= mileage;
 }
 @Override
 public String getMileage()
 {
   return mileage+"kmpl";
 }
}
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
}

class Bread extends Food {
int tastyScore = 8;
String type = "vegetarian";
public Bread(double proteins, double fats, double carbs) {
super(proteins, fats, carbs);
}

public void getMacroNutrients() {
    System.out.println("A single bread has "+this.proteins + " gms of protein, " +this.fats + " gms of fats, and " + this.carbs + " gms of carbohydrates.");
}

}
class Egg extends Food {
int tastyScore = 7;
String type = "non-vegetarian";
public Egg(double proteins, double fats, double carbs) {
super(proteins, fats, carbs);
}
public void getMacroNutrients() {
    System.out.println("An egg has "+this.proteins + " gms of protein, " +this.fats + " gms of fats, and " + this.carbs + " gms of carbohydrates.");
}
Given a pair of strings. The goal is to make them equal by doing one of the following operations at most once:
• Select two characters, char1 and char2, and replace all occurrences of chart in the first string with char
• Select two characters, char1 and char2, and replace all occurrences of chart in the second string with char2.
For example, the string "xxyz" can be converted to any of the following strings by performing the operation as mentioned above: "yyyz", "wyz",
"xxzz", "xxwz", etc. However, it cannot be converted to the string "yzy?" (Since all the occurrences of a character can be replaced by a single new character).
Note that doing both operations simultaneously is not allowed. For example, given two strings "xZ" and "zx", we can not convert both the x's in the respective strings to 'Z' to make them equal.

1\22
'Xtive", etc. However, it cannot be converted to the string "yzy?" (Since all the occurrences of a character can be replaced by a single new character),
Note that doing both operations simultaneously is not allowed. For elample, given two strings "x2" and "zx", we can not convert both the x's in the respective strings to 'z' to make them equal.
Given two arrays of n strings each, compare the strings present at the same indices in both the arrays and find if they can be made equal or not. Return an array of n strings, where the th element would be YESif the strings at index ican be equalized; otherwise, the answer is NO.
Example
Consider the array of strings to be:
identia
• firststrings = [aaa", "abbc", "zyz"]
• secondstrings = ['bbb", "cccc", "zyx"]
Let us compare the strings at each index:
• i = 0: firstStrings[0] = "aaa", secondStrings[0] = "bbb"

us compare the strings at each index:
• i = 0: firstStrings[0] = "aaa", secondStrings[0] = "bbb"
ALL
We can change all the occurrences of 'a' to 'b' in the first string in
this case. Therefore, the answer is "YES".
• i = 1: firstStrings[1] = "abbc", secondStrings[1] = "cccc"
There is no way in which wewsan make these strings identical.
Therefore, the answer is "NO".
• i = 2: firstStrings[2] = "zyz", secondStrings[2] = "zyx"
We can replace the only occurrence of 'x' in the second string with
Z' to make them identical. Therefore, the answer is "YES".
Hence, the answer corresponding to each pair of strings is ["YES," "NO,"
"YES"].
Function Description
Complete the function canBeEqualized in the editor below.
canBeEqualized has the following parameters: firstStrings[firstStrings[0]...firstStrings[n-1]]: an array of strings representing the first string of each pair
sernndStringslsernndStringsil cerondStringsin-117• an arrav nf

Returns
strings
string: an array of strings representing the answer to each pair of
Constraints
• 1≤1≤ 103
• 1 ≤ /firstStrings(i]/, /secondStrings[i] / ≤ 103
• All the strings consist of lowercase English characters only.

And the other one is nutrition question
