
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class MatrixMultiplicationKaratsuba {
	public static long standard_time=0;
	public static long standard_count =0;
	
	public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }
	
		public void standard_matrix_multiplication()
		{
			long startTime =0;
			long no_of_digits =0;
			//code
			System.out.println("Standard Matrix Multiplication");
		      int m, n, p, q, c, d, k;
		      BigInteger sum = new BigInteger("0");
		      Random random = new Random();
		      Scanner in = new Scanner(System.in);
		      System.out.println("Enter the number of digits in number");
		      no_of_digits = in.nextLong();
		      System.out.println("Enter the number of rows or columns");
		      m = in.nextInt();
		      n = m;
		 
		      BigInteger first[][] = new BigInteger[m][n];
		 
		   //   System.out.println("Enter the elements of first matrix");
		 
		      for ( c = 0 ; c < m ; c++ ){
		         for ( d = 0 ; d < n ; d++ )
		         {
		        	// System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
		            first[c][d] = new BigInteger((int) no_of_digits,random);
		         }
		      }
		     // System.out.println("Enter the number of rows and columns of second matrix");
		      p = m;
		      q = m;
		 
		      if ( n != p )
		         System.out.println("Matrices with entered orders can't be multiplied with each other.");
		      else
		      {
		         BigInteger second[][] = new BigInteger[p][q];
		         BigInteger multiply[][] = new BigInteger[m][q];
		 
		         //System.out.println("Enter the elements of second matrix");
		 
		         for ( c = 0 ; c < p ; c++ ){
		            for ( d = 0 ; d < q ; d++ ){
		            	//System.out.println("Enter the value of cell ("+(c+1)+","+(d+1)+")");
		               second[c][d] = new BigInteger((int) no_of_digits,random);
		               
		            }
		         }
		         startTime = System.nanoTime(); 
		         for ( c = 0 ; c < m ; c++ )
		         {
		            for ( d = 0 ; d < q ; d++ )
		            {   
		               for ( k = 0 ; k < p ; k++ )
		               {
		                //  sum = sum + first[c][k]*second[k][d];
		                  sum = sum.add(karatsuba(first[c][k],second[k][d]));
		                  standard_count++;
		               }
		 
		               multiply[c][d] = sum;
		               sum = new BigInteger("0");
		            }
		         }
		 
		  /*       System.out.println("Product of entered matrices:-");
		 
		         for ( c = 0 ; c < m ; c++ )
		         {
		            for ( d = 0 ; d < q ; d++ )
		               System.out.print(multiply[c][d]+"\t");
		 
		            System.out.print("\n");
		         } */
		      }
		      long endTime = System.nanoTime();
		      standard_time = endTime-startTime;
			//System.out.println("Standard Multiplication Took "+(endTime - startTime) + " ns"); 
			
		}
		
	
		
		
		public static void main(String args[]) throws NumberFormatException, IOException
		{
			MatrixMultiplicationKaratsuba m = new MatrixMultiplicationKaratsuba();
			
			m.standard_matrix_multiplication();
			System.out.println("Standard Matrix Multilplication :"+standard_time);
			System.out.println("Standards Matrix Multiplication count :"+standard_count);
			
		}
		

}
