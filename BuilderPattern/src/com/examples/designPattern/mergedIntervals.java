package com.examples.designPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class  Interval{
	 int start;
	 int end;

	    public Interval(int s, int e)
	    {
	        this.start =s;
	        this.end=e;
	    }
	}

public class mergedIntervals {
	
	 public int[][] mergeIntervals(int[][] arr) {

         List<Integer> a=new ArrayList<>();
        Arrays.sort(arr, (c, b) -> Integer.compare(c[0], b[0]));
        a.add(arr[0][0]);
        a.add(arr[0][1]);
        for(int i=1;i<arr.length;i++){
            if(a.get(a.size()-1)<arr[i][0]){
                a.add(arr[i][0]);
                a.add(arr[i][1]);
            }else if(a.get(a.size()-1)<arr[i][1]){
                a.set(a.size()-1,arr[i][1]);
            }
        }
        int ans[][]=new int[a.size()/2][2];
        int k=0;
        for(int i=0;i<ans.length;i++){
            ans[i][0]=a.get(k++);
            ans[i][1]=a.get(k++);
        }
        return ans;

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new mergedIntervals().mergeIntervals(nums);

        for (int i = 0; i < results.length; ++i) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
    }
	


    public int[][] mergeIntervals(Interval arr[]) {

        Stack<Interval> stack =new Stack<>();
        

        Arrays.sort(arr,new Comparator<Interval>()
        {
            public int compare(Interval i1, Interval i2)
            {
                return i1.start -i2.start;
            }
        });
        stack.push(arr[0]);

        for(int i=1;i<arr.length;i++)
        {
            Interval top =stack.peek();
            if(top.end < arr[i].start)
            stack.push(arr[i]);
            else  if(top.end < arr[i].end)
            {
                top.end =arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
        int i =0;
        int[][] nums = new int[stack.size()][2];
        while(!stack.isEmpty())
        {
            Interval t =stack.pop();
            nums[i][0] = t.start;
            nums[i][1] = t.end;
            i++;

        }

        return nums;  
    }


   /* public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];
        Interval arr[] =new Interval[n];
        List<Interval> out =new ArrayList<Interval>();

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            arr[i]= new Interval(nums[i][0],nums[i][1]);
        }

        int[][] results = new mergedIntervals().mergeIntervals(arr);

        for (int i = 0; i < results.length; ++i) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
        
    }*/
}



