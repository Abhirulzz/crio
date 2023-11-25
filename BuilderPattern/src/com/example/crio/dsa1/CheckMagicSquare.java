package com.example.crio.dsa1;

public class CheckMagicSquare {

	public static void main(String[] args) {
		
		int grid[][] = {{ 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }};
		
        String	check = checkMagicSquare(grid[0].length, grid);
        System.out.println("isMagicSquare "+ check);
	}
	
	static String checkMagicSquare(int n, int[][] grid) {
		
		int sumd1 = 0,sumd2=0;
        for (int i = 0; i < n; i++)
        {
          
            sumd1 += grid[i][i];
               sumd2 += grid[i][n-1-i];
        }
        
        if(sumd1!=sumd2)
            return "No";
        
        for (int i = 0; i < n; i++) {
               
               int rowSum = 0, colSum = 0;
               for (int j = 0; j < n; j++)
               {
                   rowSum += grid[i][j];
                   colSum += grid[j][i];
               }
               if (rowSum != colSum || colSum != sumd1)
                   return "No";
               
        }
        
            
        return "Yes";
    }
  	

}
