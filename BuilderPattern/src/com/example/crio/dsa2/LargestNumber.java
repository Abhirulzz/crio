package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	 public class CustomComparator implements Comparator<Integer>
		{

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (Math.abs(o1) < Math.abs(o2))
				return -1;
				else if  (Math.abs(o1) > Math.abs(o2))
				return 1;
				else if (Math.abs(o1) == Math.abs(o2))
				return 0;
				
				return 0;
			}
			
		}
	 
	 
	
	public static String largestNumber(Integer[] nums) {
		
		Arrays.sort(nums, (c, b) -> {
			System.out.println("b"+ String.valueOf(b).substring(0,1));
			System.out.println("c" + String.valueOf(c).substring(0,1));
        if(String.valueOf(b).substring(0,1) != String.valueOf(c).substring(0,1))
        {	
        	
            return (String.valueOf(b).substring(0,1).compareTo(String.valueOf(c).substring(0,1)));
        }
        return String.valueOf(b).substring(0,1).compareTo(String.valueOf(c).substring(0,1));
        });

		/*Arrays.sort(nums, (c, b) -> {
			if (c.length() != b.length()) {
				return (c.length() - b.length());
			}

			return c.compareTo(b);
		}); */
		
		System.out.println("lambda sort" + Arrays.toString(nums));
		
		Arrays.sort(nums, new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		    	String XY = String.valueOf(o1) + String.valueOf(o2);
		    	 
                // then append X at the end of Y
                String YX = String.valueOf(o2) + String.valueOf(o1);
 
                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
		    }
		});
		
		System.out.println("custome sort" + Arrays.toString(nums));
		
		StringBuilder builder = new StringBuilder();
		for(Integer s : nums) {
		    builder.append(s);
		}
		String str = builder.toString();

		return str;
	}
	
	/*public String largestNumber(String[] nums) {
		Arrays.sort(arr, new Comparator<Student>() {
			@Override
			public int compare(Student emp1, Student emp2) {

				int sum1 = 0;
				for (int i = 0; i < emp1.marks.length; i++) {
					sum1 += emp1.marks[i];
				}
				int sum2 = 0;
				for (int i = 0; i < emp2.marks.length; i++) {
					sum2 += emp2.marks[i];
				}

				int i = Integer.valueOf(sum1).compareTo(Integer.valueOf(sum2));

				if (i != 0) {
					return i * -1;
				}

				int j = emp1.name.compareTo(emp2.name);
				if (j != 0)
					return j;
				else {

					return Integer.valueOf(emp1.id).compareTo(Integer.valueOf(emp2.id));
				}

			}
		});

	} */

	
	
	public static void main(String[] args)
	{
		//int arr[] = new int[] {  -2, -3, 4, -1, -2, 1, 5, -3};
		int[] arr = {3, 30, 34, 5, 9};
		
		Integer sort[] = new Integer[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			sort[i] = arr[i];
		}
		
		System.out.println("Given Array is");
		System.out.println(Arrays.toString(arr));
		
		//long kandane =contigiousSequence(arr,arr.length);
		String large =largestNumber(sort);

		System.out.println("Kandane is" + large);
		//System.out.println(kandane);
	}


}
