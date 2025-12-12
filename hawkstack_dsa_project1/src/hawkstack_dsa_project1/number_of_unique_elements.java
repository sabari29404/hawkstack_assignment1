package hawkstack_dsa_project1;

import java.util.ArrayList;
import java.util.Arrays;

public class number_of_unique_elements {
	public static void main(String[] args) {
		/*		
				Problem: Given a list of integers, return the number of unique elements.
				Example: [1,2,2,3,4,4] → 4
				Edge case: Empty list → 0
		*/		
				int nums[]= {1,2,2,3,4,4};
				
				if(nums.length>0) {
					int result[] = chk(nums);
					System.out.println(Arrays.toString(result));
					System.out.println("number of unique elements: "+result.length);
				}
				else {
					System.out.println("number of unique elements: "+0);
				}
			}
			
			public static int[] chk(int nums[]) {
				
				Arrays.sort(nums);
				ArrayList<Integer> arr=new ArrayList<>();
				
				for(int i=0; i<nums.length-1; i++) {
					if(nums[i]!=nums[i+1]) {
						arr.add(nums[i]);
					}
				}
				
				arr.add(nums[nums.length-1]);
				
				int result[]=new int[arr.size()];
				
				for(int i=0; i<arr.size(); i++) {
					result[i]=arr.get(i);
				}
				return result;
		
	}
}
