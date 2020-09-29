package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	String[] strr = new String[3];
	int[] num = new int[3];
	
	public void input() {
		Scanner input = new Scanner(System.in);

	    for (int i = 0; i < strr.length; i++)
	    {
	        System.out.println("Please enter String");
	        strr[i] = input.nextLine();
	    }
	}
	
	public void output() {
		System.out.println("prefix string is "+longestCommonPrefix(strr));
	}
	
	public void input1() {
		Scanner input = new Scanner(System.in);
		System.out.println("Exercise 2");
	    for (int i = 0; i < num.length; i++)
	    {
	        System.out.println("Please enter number");
	        num[i] = input.nextInt();
	    }
	}
	
	public void output1() {
		System.out.println("num is "+subsets(num));
	}
	
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	 public static List<List<Integer>> subsets(int[] nums) {
		    List<List<Integer>> output = new ArrayList();
		    output.add(new ArrayList<Integer>());

		    for (int num : nums) {
		      List<List<Integer>> newSubsets = new ArrayList();
		      for (List<Integer> curr : output) {
		        newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
		      }
		      for (List<Integer> curr : newSubsets) {
		        output.add(curr);
		      }
		    }
		    return output;
		  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test1 t = new Test1();
		t.input();
		t.output();
		
		t.input1();
		t.output1();
		
		
		
//		String[] str = {"flower","flow","flight"};
//		
//		System.out.println(longestCommonPrefix(str));
//		
//		int [] in = {1,2,3};
//		
//		System.out.println(subsets(in));
	}

}
