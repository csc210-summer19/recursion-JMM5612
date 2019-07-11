/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Joe Muscolino
 */
public class RecursionFun {
 

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
    return comboHelper(n, k);
  }
  private int comboHelper(int n, int k) {
	  if (k == 1) {
		  return n;
	  }
	  if (n == k) {
		  return 1;
	  }else {
		  return comboHelper(n -1, k-1) + comboHelper(n -1, k);
	  }
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	String s = "";
    return commaHelper(n, s);
  }
  private String commaHelper(int n, String s) {
	  String lastThree = Integer.toString(n);
	  lastThree = lastThree.substring(lastThree.length() - 3);
	  if (n < 1000 && s.compareTo("") == 0) {
		  String ret = Integer.toString(n);
		  return ret;
	  }
	  if (n / 10 < 1) {
		  s = s + lastThree;
		  return s;
	  }
	  if (n / 1000 > 0) {
		  int comma = n / 1000;
		  s += Integer.toString(comma);
		  s = s + ",";
		  System.out.println(s);
		  commaHelper(n = n / 1000, s);
	  }
	  System.out.println(s);
	  return s;
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length);
  }

  private void reverseArray(int[] x, int index, int len) {
    if (index >= len - 1) {
    	return;
    }
    int temp;
    
    temp = x[index];
    x[index] = x[len - 1];
    x[len - 1] = temp;
    
    reverseArray(x, index + 1, len - 1);
    
  }

  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	int max = a[0];
	int min = a[0];
	return range(a, max, min, 0);
  }
  public int range(int[] a, int max, int min, int pos) {
	  if (a.length == 1) {
		  return 0;
	  }
	  if (pos == a.length) {
		  return max - min;
	  }
	  
	  if (a[pos] >= max) {
		  max = a[pos];
	  }
	  if (a[pos] <= min) {
		  min = a[pos];
	  }
	  
	  
	  return range(a, max, min, pos + 1);
  }

  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	return sortedHelper(nums, 0);
    	
  }
  
  public boolean sortedHelper(int[] nums, int index) {
	  if (nums.length == 0 || nums.length == 1) {
		  return true;
	  }
	  if (index == nums.length - 1) {
		  return true;
	  }
	  if(nums[index] <= nums[index + 1]) {
		  return sortedHelper(nums, index + 1);
	  } else {
		  return false;
	  }
  }

  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
	  return count(search, strs, 0);
  }
  
  public boolean count(String search, String[] strs, int pos) {
	  if (pos == strs.length) {
		  return false;
	  }
	  if (strs[pos].contentEquals(search)) {
		  return true;
	  }
	  return count(search, strs, pos + 1);
  }
}
