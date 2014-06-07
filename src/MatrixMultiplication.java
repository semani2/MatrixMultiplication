import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MatrixMultiplication {
	
	
	public static long standard_time=0;
	public static long standard_count =0;
	
	
		public void standard_matrix_multiplication()
		{
			long startTime =0;
			long no_of_digits =0;
			standard_count = 0;
			
			//code
			System.out.println("Standard Matrix Multiplication");
		      int m, n, p, q, sum = 0, c, d, k;
		 
		      Scanner in = new Scanner(System.in);
		     // System.out.println("Enter the number of digits in number");
		     // no_of_digits = in.nextLong();
		   //   System.out.println("Enter the number of rows or columns");
		    //  m = in.nextInt();
		      m = 16;
		      n = m;
		 
		      int first_matrix[][] = new int[m][n];
		 
		   //   System.out.println("Enter the elements of first matrix");
		 
		      for ( c = 0 ; c < m ; c++ ){
		         for ( d = 0 ; d < n ; d++ )
		         {
		        	// System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
		            first_matrix[c][d] = (int)(Math.random()*1000);
		         }
		      }
		     // System.out.println("Enter the number of rows and columns of second matrix");
		      p = m;
		      q = m;
		      long endTime = 0;
		      if ( n != p )
		         System.out.println("Matrices with entered orders can't be multiplied with each other.");
		      else
		      {
		         int second_matrix[][] = new int[p][q];
		         int product_matrix[][] = new int[m][q];
		 
		         //System.out.println("Enter the elements of second matrix");
		 
		         for ( c = 0 ; c < p ; c++ ){
		            for ( d = 0 ; d < q ; d++ ){
		            	//System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
		               second_matrix[c][d] = (int)(Math.random()*1000);
		               
		            }
		         }
		         startTime = System.nanoTime(); 
		         for ( c = 0 ; c < m ; c++ )
		         {
		            for ( d = 0 ; d < q ; d++ )
		            {   
		               for ( k = 0 ; k < p ; k++ )
		               {
		                  sum = sum + first_matrix[c][k]*second_matrix[k][d];
		                  standard_count++;
		               }
		 
		               product_matrix[c][d] = sum;
		               sum = 0;
		            }
		         }
		         endTime = System.nanoTime();
		 
		  /*      
		   *  
		   *  System.out.println("Product of entered matrices:-");
		 
		         for ( c = 0 ; c < m ; c++ )
		         {
		            for ( d = 0 ; d < q ; d++ )
		               System.out.print(multiply[c][d]+"\t");
		 
		            System.out.print("\n");
		         } */
		      }
		      
		      standard_time = endTime-startTime;
			//System.out.println("Standard Multiplication Took "+(endTime - startTime) + " ns"); 
			
		}
		
	
		
		
		public static void main(String args[]) throws NumberFormatException, IOException
		{
			
			/*
			while(true)
			{
				
			System.out.println("What do u wish to do ");
			System.out.println("1.Run matrix multiplication");
			System.out.println("2.Exit");
			Scanner in = new Scanner(System.in);
			int choice = in.nextInt();
			
			switch(choice)
			{
			case 1:
			MatrixMultiplication m = new MatrixMultiplication();
			
			m.standard_matrix_multiplication();
			System.out.println("Standard Matrix Multilplication(ns) :"+(standard_time));
			System.out.println("Standard Matrix Multilplication :"+(standard_time/1000000000.0));
			System.out.println("Standards Matrix Multiplication count :"+standard_count);
			break;
			case 2:
				System.exit(0);
				break;
			}
			
			} */
			for(int i=0;i<50;i++)
			{
				MatrixMultiplication m = new MatrixMultiplication();
				m.standard_matrix_multiplication();
				System.out.println("Standard Matrix Multilplication(ns) :"+(standard_time));
				System.out.println("Standard Matrix Multilplication :"+(standard_time/1000000000.0));
				System.out.println("Standards Matrix Multiplication count :"+standard_count);
				
			}
		}
		
}
