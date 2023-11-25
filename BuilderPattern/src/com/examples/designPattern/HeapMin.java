package com.examples.designPattern;

public class HeapMin {
	
	

		// Function to insert a new element into the min-heap
		public static void insertMinHeap(int[] heap, int size,
										int value)
		{
			// Add the new element to the end of the heap
			heap[size] = value;
			// Get the index of the last element
			int index = size;
			// Compare the new element with its parent and swap
			// if necessary
			while (index > 0
				&& heap[(index - 1) / 2] > heap[index]) {
				swap(heap, index, (index - 1) / 2);
				// Move up the tree to the parent of the current
				// element
				index = (index - 1) / 2;
			}
		}

		// Function to swap two elements in an array
		public static void swap(int[] arr, int i, int j)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		// Main function to test the insertMinHeap function
		public static void main(String[] args)
		{
			int[] heap = new int[6];
			int[] values = { 10, 7, 11, 5, 4, 13 };
			int size = 0;
			for (int i = 0; i < values.length; i++) {
				insertMinHeap(heap, size, values[i]);
				size++;
				System.out.print("Inserted " + values[i]
								+ " into the min-heap: ");
				for (int j = 0; j < size; j++) {
					System.out.print(heap[j] + " ");
				}
				System.out.println();
			}
		}
	}


