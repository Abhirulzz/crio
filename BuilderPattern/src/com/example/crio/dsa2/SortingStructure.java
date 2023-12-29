package com.example.crio.dsa2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;



class Student {
    int id;
    String name;
    int marks[] = new int[5];

    public Student(int id, String name, int marks[]) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
    }
}

class SortingStructure {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int res[] = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }
    
    

   // 1 Alan 45 56 21 32 74

    //2 Fabien 95 94 93 92 91

   // 3 Gamora 85 65 54 65 76

    static int[] marksSort(int n, Student arr[]) {
    	 int id[] = new int[n];

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

    for (int j = 0; j < n; j++)
    {
               
             id[j] = arr[j].id;
         
     }

 return id;
     }
    
}


