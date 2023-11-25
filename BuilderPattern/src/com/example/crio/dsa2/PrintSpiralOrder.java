package com.example.crio.dsa2;

public class PrintSpiralOrder {
	
	public static void main(String args[]) {
        
        int n = 4;
        int result[][] = spiralMatrixII(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        int rotate90[][] = rotate(result,n);

        System.out.println();    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rotate90[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int n) {
    	
    	int[][] result = new int [n][n];
    	int counter =1;
    	int top=0,left=0,right=n-1,bottom=n-1;
    	
    	while(counter <= n*n)
    	{
    	
    	for (int i =left; i <= right; i++)
    	{
    		
    		result[top][i] = counter;
    		counter++;
    	}
    	top++;
    	
    	
    	for (int i =top; i <= bottom; i++)
    	{
    		
    		result[i][right] = counter;
    		counter++;
    	}
    	right--;
    	
    	for (int i =right; i >= left ; i--)
    	{
    		
    		result[bottom][i] = counter;
    		counter++;
    	}
    	bottom--;
    	
    	for (int i =bottom; i >= top ; i--)
    	{
    		
    		result[i][left] = counter;
    		counter++;
    	}
    	left++; 
    	}
    	
    	return result;
       
    }
    
	static int[][] rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer; //1
			int last = n - 1 - layer; //3
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top (1,2)
				/*01 - 20   first i  last-off first
				 20 - 32   last-off first  last last-off
				 32 - 13	last last-off  i last
				 13 - 01   i last first i */

				// left -> top
				matrix[first][i] = matrix[last - offset][first]; // 00 - 30

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset]; //30 - 33

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last]; //33  33 -03

				// top -> right
				matrix[i][last] = top; // right <- saved top 03  03 - 00
			}
			
	/*
	 * (00) 01 02 03
	 * 10 11 12 13
	 * 20 21 22 23
	 * 30 31 32 33
	 
		30 20 10 00
		31 21 11 01
		32 22 12 02
		33 23 13 03
		
		*/
			
/*   00 - 03
	 03 - 33
	 33 - 30
	 30 - 00
	 
	 00 - 30 
	 30 - 33
	 33 - 03
	 03 - 00
	 
	 01 - 20   first i  last-off first
	 20 - 32   last-off first  last last-off
	 32 - 13	last last-off  i last
	 13 - 01   i last first i
	 
	 01 -13   first i  i last
	 13- 32   i +offset  last - offset
	 32 -20   last - offset  -offset i
	 20 -01   last -offset  - first i
	 
	 
	 
	 */
	 
	
	 

		}

		return matrix;
	}

}
