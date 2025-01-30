//swetha.

package m1;

import java.util.Objects;

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




//Question 1. LongestEvenWord

class Result 
{
    public static String longestEvenWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestEvenWord = "00";
        
        for (String word : words) {
            if (word.length() % 2 == 0 && word.length() > longestEvenWord.length()) {
                longestEvenWord = word;
            }
        }
        
        return longestEvenWord;
    }
}

public class Solution
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter=new BufferedWriter(new FilWriter(System.getenv("OUTPUT_PATH")));
		
		String sentence=bufferedReader.readLine();
		String result =Result.longestEvenWord(sentence);
		
		bufferedWriter.write(result);
bufferedWriter.newLine();
		
		bufferedReader.close();
		bufferedWriter.close();
		
	}
}



//Shruthilaya




1)PROBLEM SOLVING: Pass the Baton

There are n friends standing in a line, each numbered from 1 through n inclusive. The first one, friend 1, holds a baton. Each second, the baton is passed to the next friend in line. Once it reaches the end of the line, the direction of passing reversed and passing continues. Determine who pass and who will receive the baton at a given time.

Example
friends = 4 
time=5

Friends are numbered 1 through 4. Friend 1 holds the baton at time 0. At time 1, it is passed to friend 2. Over 5 seconds, the baton is passed as 1->2->3->4->3->2. The friend passing the baton at time 5 is friend 3. The friend receiving the baton is friend 2 Return [3, 2].

Function Description
Complete the function batonPass in the editor below. The function must return an integer array.

batonPass has the following parameters 
int friends: the number of friends
int time: the time to report who on the baton

Sample Case 0
Sample Input For Custom Testing
STDIN     Function 
-----     ---------
5         friends=5
3         time = 3

Sample Output
3
4

Explanation
From time 0 to time 3 the baton passes 1->2->3->4. The baton is passed from friend 3 to friend 4 at time 3.

Sample Case 1
Sample Input For Custom Testing
3
6
Sample Output
2
3
Explanation
The baton is passed as 1->2->3->2->1->2->3. It is passed from friend 3 to friend 4 at time 3.

1)Ans:
public static List<Integer> batonPass(int friends,long time){   
        List<Integer> ans = new ArrayList<>();
        int oddEven = 1, count = 0;
 
        while (true) {
            if ((oddEven & 1) != 0) { // odd cycle
                if (count == 0) {
                    for (int i = 0; i < friends; i++) {
                        count++;
                        if (time == count) {
                            if (i != friends - 1) {
                                ans.add(i + 1);
                                ans.add(i + 2);
                                return ans;
                            } else {
                                ans.add(i + 1);
                                ans.add(i);
                                return ans;
                            }
                        }
                    }
                } else {
                    for (int i = 1; i < friends; i++) {
                        count++;
                        if (time == count) {
                            if (i != friends - 1) {
                                ans.add(i + 1);
                                ans.add(i + 2);
                                return ans;
                            } else {
                                ans.add(i + 1);
                                ans.add(i);
                                return ans;
                            }
                        }
                    }
                }
                oddEven++;
            } else { // even cycle (reverse direction)
                for (int i = friends - 2; i >= 0; i--) {
                    count++;
                    if (time == count) {
                        if (i != 0) {
                            ans.add(i + 1);
                            ans.add(i);
                            return ans;
                        } else {
                            ans.add(i);
                            ans.add(i + 1);
                            return ans;
                        }
                    }
                }
                oddEven++;
            }
        }
    }

2) JAVA CORE: IRealEstate
A customer requested a real estate application to manage thier real esatate listings. they want 
        to have the ability to add remove upadte and retrieve listings based on specific criteria.
        create a new class called RealEstateListing and implement the IRealEstateListing interface
        
        
add the following properties to the RealEstateListing class:
	ID(int)
	title(String)
	description(String)
	price(int)
	location(String)
	create another class call RealEstateApp and implement the IRealEstateApp interface
	Declare a private field within the RealEstateApp class called listings, which is a List<IrealEstateListing>.
	 implement the following methods within within the RealEstateApp class
	 
	 1. addListing(IrealEstateListing):add the listing to listings
	 2. removeListing(int listingID):if a listing with this ID exists,remove it from listings
	 3. updateListing(IRealEstateListing):update the listing with a matching ID to the values in the parameter object
 	 4. getListings(): return listings
	 5. getListingsByLocation(String location): return a new list of the listings that match the location parameter
	 6.getListingsByPriceRange(int minPrice,int maxPrice). return a new list of the listings whose price falls within the specified range,inclusive

	Example : there are 2 RealEstateListing objects,with Id,Title,Description, price,Location.
	1 Serene-Haven Spacious-3-bedroom-home 209 Green-Valley
	2 Luxury-Oasis Elegant-4-bedroom-villa-with-a-private-pool 440 Riverside-City
	
	filter by this location.
	Riverside-city
	
	filter for this price range.
	182 399
	
	output:
		All Listings:
			ID: 1, Title:Serene-Haven, price:209,, Location:Green-valley
			ID: 2,Title:Luxury-Oasis, Price:440,Location:Riverside-City
		Listings in Riverside-City:
			ID: 2, Title: luxury-Oasis, Price:440
		Listings By Price Range(182-399):
			ID: 1,Title: Serene-Haven,Price:209 
2) Ans:
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
	private int ID;
    private String title;
    private String description;
    private int price;
    private String location;

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
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
    public void updateListing(IRealEstateListing listing) {
        for (int i = 0; i < listings.size(); i++) {
            if (listings.get(i).getID() == listing.getID()) {
                listings.set(i, listing);
                break;
            }
        }
    }

    @Override
    public List<IRealEstateListing> getListings() {
        return listings;
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




//swathi

import java.util.Vector;

public class LineList implements LineListinterface {
    private Vector<Line> list_of_lines;
 
    public LineList(Vector<Line> list_of_lines) {
        this.list_of_lines = list_of_lines;
    }
 
    @Override
    public Line getLineWithMaxLength() {
        if (list_of_lines.isEmpty()) {
            return null;
        }
 
        Line longestLine = list_of_lines.get(0);
        for (Line line : list_of_lines) {
            if (line.getLength() > longestLine.getLength()) {
                longestLine = line;
            }
        }
        return longestLine;
    }
 
    @Override
    public Vector<Line> getLinesStartingFromPoint(Point p) {
        Vector<Line> linesStartingFromPoint = new Vector<>();
        for (Line line : list_of_lines) {
            if (line.getStartPoint().equals(p)) {
                linesStartingFromPoint.add(line);
            }
        }
        return linesStartingFromPoint;
    }
}
 
//Shortest substring


class Result
{
public static int findMinLength(String s) {
    int n = s.length();
    boolean[] visited = new boolean[26];
    Arrays.fill(visited, false);
    int len = 0;
    for (int i = 0; i < n; i++) {
        if (visited[s.charAt(i) - 'a']) {
            for (int j = n - 1; j >= i; j--) {
                if (visited[s.charAt(j) - 'a']) {
                    len = j - i + 1;
                    break;
                } else {
                    visited[s.charAt(j) - 'a'] = true;
                }
            }
            break;
        } else {
            visited[s.charAt(i) - 'a'] = true;
        }
    }
    return len;
}
 
public static int findShortestSubstring(String s) {
    int ans = findMinLength(s);
    s = new StringBuilder(s).reverse().toString();
    ans = Math.min(ans, findMinLength(s));
    return ans;
}
 
}
 


//snegitha

Problem solving: count valid words
From the given string the valid words should satisfy the condition 
1)word length should at least be 3
2)At least one vowel and consonants
3)words should be alphanumeric.
 
solution:
import java.util.Arrays;
import java.util.List;
 
public class example {
	public static int countValidWords(String s) {
        List<String> words = Arrays.asList(s.split("\\s+"));
        int count = 0;
 
       for (String word : words) {
            if (isValid(word)) {
                count++;
            }
        }
 
       return count;
    }
    public static boolean isValid(String str) {
        if (str.length() < 3) {
            return false;
        }
 
       boolean vowel = false;
        boolean cons = false;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            if (isvowel(c)) {
                vowel = true;
            } else if (Character.isLetter(c)) {
                cons = true;
            }
        }
        return vowel && cons;
    }
 
   public static boolean isvowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
 
	public static void main(String[] args) {
		String s="This is Form16 submis$ion date";
		String t="Bob wins the game";
		System.out.println(countValidWords(s));
		System.out.println(countValidWords(t));
	   }
	}
Java : Inheritance
//Class car containing properties
// Class Car
public class Car {
    public int no_of_tires = 4;
    public String bodyType = "Plastic";
 
   public void reverseGear() {
        System.out.println("Reverse Gear is Applied...");
    }
 
   public void switchOnHeadlights() {
        System.out.println("Headlights turned on...");
    }
}
 
// Class BMW extending Car
public class BMW extends Car {
    public String modelName = "X3";
 
   public void topSpeed() {
        System.out.println("TopSpeed of BMW is 200 kmph");
    }
}





//Divya


1.)

In a school,there are n students who want to participate in an academic decathlon.
The teacher wants to select the maximum number of students possible.Each student has a certain skill level.
For the team to be uniform it is important that when the skill levels of its members are arranged in increasing order,
the difference between any two consecutive skill levels is either 0 or 1.Find the maximum team size the teacher can form
 
example:
skills = [10,12,13,9,14]
 
valid teams,sorted are{9,10}, and {12,13,14}.These teams have sizes 2 and 3 respectively,
so themaximum team size is 3
 
Function Description:
	Complete the function findMaxTeamSize in the editor
	findMaxTeamSize has the following parameter:
		int skills[n]:the skill levels of each student.
 
Returns
int:the maximum posible size of the team
 
constraints
1<=n<=10^5
1<=skill[i]<=10^9
 
Input Format For Custom Testing:
 
The first line contains an integer ,n, the number of elements in skills.
Each line i of the n subsequent lines(where 0<=i<n) contains an integer,skills[i].
 
Sample Case 0
Sample Input 0
 
STDIN    Function
-----    --------
4 ->     skills[] size n =4
4 ->     skills =[4,13,2,3]
13
2
3
 
Sample Output 
3
 
explanation:
these are two valid teams possible:{2,3,4} and{13}.These have team sizes of 3 and 1,respectively
 
 
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
     * Complete the 'findMaxTeamSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY skills as parameter.
     */
 
    public static int findMaxTeamSize(List<Integer> skills) {
    // Write your code here
    Collections.sort(skills);
    int maxTeamSize = 0;
    for(int i = 0; i< skills.size(); i++){
        int currentTeamSize =1;
        for(int j =i+1;j<skills.size();j++){
            if(skills.get(j)-skills.get(i)<=1){
                currentTeamSize++;
            }else{
                break;
            }
        }
         maxTeamSize = Math.max(maxTeamSize,currentTeamSize);   
        }
        return maxTeamSize;
    } 
}
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int skillsCount = Integer.parseInt(bufferedReader.readLine().trim());
 
        List<Integer> skills = IntStream.range(0, skillsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
 
        int result = Result.findMaxTeamSize(skills);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}
 
check this code in java 8 version
 
 
***************ANS*******
 
import java.io.*;
import java.util.*;
import java.util.stream.*;
 
class Result {
 
    public static int findMaxTeamSize(List<Integer> skills) {
        Collections.sort(skills);
        int maxTeamSize = 0;
        int currentTeamSize = 1;
 
        for (int i = 1; i < skills.size(); i++) {
            if (skills.get(i) - skills.get(i - 1) <= 1) {
                currentTeamSize++;
            } else {
                maxTeamSize = Math.max(maxTeamSize, currentTeamSize);
                currentTeamSize = 1;
            }
        }
        maxTeamSize = Math.max(maxTeamSize, currentTeamSize);
 
        return maxTeamSize;
    }
}
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
 
        int skillsCount = Integer.parseInt(bufferedReader.readLine().trim());
 
        List<Integer> skills = IntStream.range(0, skillsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
 
        int result = Result.findMaxTeamSize(skills);
 
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
 
        bufferedReader.close();
        bufferedWriter.close();
    }
}

2.)
 
Customer requested a real estate application to manager .They want to have the ability to add,remove,update, and retrive 
listing based on specific critirea.
create a new class called RealEstateListing and implemet the IRealEstateListingInteface.
Add the following properties to the realestatelisting class:
 
ID(int)
title(String)
description(STring)
price(int)
location(string)
 
 
Create another class called RealEstateApp and implement the IRealEstateApp interface
Declare a private fiels within realestateapp class called listings, which is a list<IRealEstateListing>
 
Implement the following methods
addListings(IRealEstateListing) 
removeListing(int listingID)
updateListings(IRealEstateListing)
getListings()
getListingsByLocation(String Location)
getlistingsBypriceRange(int minPrice,int maxPrice)
 
 
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
 
}
 
class RealEstateApp implements IRealEstateApp {
 
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
 
 
***************ANSWER*************
 
 
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
    private int ID;
    private String title;
    private String description;
    private int price;
    private String location;
 
    @Override
    public void setID(int ID) {
        this.ID = ID;
    }
 
    @Override
    public int getID() {
        return ID;
    }
 
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
 
    @Override
    public String getTitle() {
        return title;
    }
 
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
 
    @Override
    public String getDescription() {
        return description;
    }
 
    @Override
    public void setPrice(int price) {
        this.price = price;
    }
 
    @Override
    public int getPrice() {
        return price;
    }
 
    @Override
    public void setLocation(String location) {
        this.location = location;
    }
 
    @Override
    public String getLocation() {
        return location;
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
    public void updateListing(IRealEstateListing listing) {
        for (int i = 0; i < listings.size(); i++) {
            if (listings.get(i).getID() == listing.getID()) {
                listings.set(i, listing);
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
            if (listing.getPrice() >= minPrice && listing.getPrice() <= maxPrice) {
                result.add(listing);
            }
        }
        return result;
    }
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