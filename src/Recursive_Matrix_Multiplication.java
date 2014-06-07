import java.util.Scanner;


public class Recursive_Matrix_Multiplication {
	public static int sum;
	public static int result[][]; 
	public void matMult(int a[][],int b[][],int c[][],int n){
		result = c;
	     int i=0,j=0,k=0;
	     int order = n;
	    if(i<n) //row of first matrix
	    {
	      if(j<n) //column of second matrix
	      {
	         if(k<n)
	         {
	             sum=sum+a[i][k]*b[k][j];
	             k++;
	             matMult(a,b,result,order);
	         }
	         result[i][j]=sum;
	             sum=0;
	             k=0;
	             j++;
	             matMult(a,b,result,order);
	      }
	        j=0;
	        i++;
	        matMult(a,b,result,order);
	    }
	}
	
	public static void Main(String args[])
	{
		int[][] multiply;
		long startTime =0;
		//code
		System.out.println("Recursive Matrix Multiplication");
	      int m, n, p, q, c, d, k;
	 
	      Scanner in = new Scanner(System.in);
	      System.out.println("Enter the number of rows or columns");
	      m = in.nextInt();
	      n = m;
	 
	      int[][] first = new int[m][n];
	 
	   //   System.out.println("Enter the elements of first matrix");
	 
	      for ( c = 0 ; c < m ; c++ ){
	         for ( d = 0 ; d < n ; d++ )
	         {
	        	// System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
	            first[c][d] = (int)(Math.random()*1000);
	         }
	      }
	     // System.out.println("Enter the number of rows and columns of second matrix");
	      p = m;
	      q = m;
	      int[][] second = new int[p][q];
	       multiply = new int[m][q];
	      if ( n != p )
	         System.out.println("Matrices with entered orders can't be multiplied with each other.");
	      else
	      {
	        
	 
	         //System.out.println("Enter the elements of second matrix");
	 
	         for ( c = 0 ; c < p ; c++ ){
	            for ( d = 0 ; d < q ; d++ ){
	            	//System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
	               second[c][d] = (int)(Math.random()*1000);
	               
	            }
	         }
	      }
	    
	     new Recursive_Matrix_Multiplication().matMult(first,second,multiply,m);
	    System.out.println("Product of entered matrices:-");
		 int x,y=0;
        for ( x = 0 ; x < m ; x++ )
        {
           for ( y = 0 ; y < q ; y++ )
              System.out.print(result[x][y]+"\t");

           System.out.print("\n");
        }  
	}

}
