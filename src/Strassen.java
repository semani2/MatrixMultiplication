//STRASSEN'S MATRIX MULTIPLICATION
import java.io.*;
public class Strassen
{
	public long startTime1 = 0;
	public long endTime1 =0;
	public int flag = 0;
public static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
public Strassen() throws IOException
{
	
	
	flag = 0;
	 long strassen_time =0;
	long strassens_count =0 ;	
int n;
int[][] a, b, c;
//System.out.print("Enter the number or rows or colums: ");
//n = Integer.parseInt(br.readLine());
n = 256;
a = new int[n][n];
b = new int[n][n];
c = new int[n][n];

for(int i=0; i<n; i++)
{
for(int j=0; j<n; j++)
{
//System.out.print("Enter the value of cell("+(i+1)+","+(j+1)+"): ");
	a[i][j] = (int)(Math.random()*1000);
	//a[i][j] = 10;
}
}
//System.out.print("\n\n\5nEnter values for 2nd Matrix:\n");
for(int i=0; i<n; i++)
{
for(int j=0; j<n; j++)
{
//System.out.print("Enter the value of cell ("+(i+1)+","+(j+1)+"): ");
	b[i][j] = (int)(Math.random()*1000);
	//b[i][j] = 10;
}
}
//System.out.print("\n\nBy Strassen Matrix Multiplication method:\n");

c = strassenMatrixMultiplication(a, b);
endTime1 = System.nanoTime();
//endTime1= System.nanoTime();
strassen_time = endTime1 - startTime1;
System.out.println("Time in ns = "+strassen_time);
System.out.println("Time in sec = "+(strassen_time/1000000000.0));
//printArray(c);
}
public int [][] strassenMatrixMultiplication(int [][] A, int [][] B)
{
if(flag ==0 )
{
	startTime1 = System.nanoTime();
	flag = 1;
}

int n = A.length;
int [][] result = new int[n][n];
if((n%2 != 0 ) && (n !=1))
{
int[][] a1, b1, c1;
int n1 = n+1;
a1 = new int[n1][n1];
b1 = new int[n1][n1];
c1 = new int[n1][n1];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
{
a1[i][j] =A[i][j];
b1[i][j] =B[i][j];
}
c1 = strassenMatrixMultiplication(a1, b1);
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] =c1[i][j];
return result;
}
if(n == 1)
{
result[0][0] = A[0][0] * B[0][0];
}
else
{
int [][] A11 = new int[n/2][n/2];
int [][] A12 = new int[n/2][n/2];
int [][] A21 = new int[n/2][n/2];
int [][] A22 = new int[n/2][n/2];
int [][] B11 = new int[n/2][n/2];
int [][] B12 = new int[n/2][n/2];
int [][] B21 = new int[n/2][n/2];
int [][] B22 = new int[n/2][n/2];
divideArray(A, A11, 0 , 0);
divideArray(A, A12, 0 , n/2);
divideArray(A, A21, n/2, 0);
divideArray(A, A22, n/2, n/2);
divideArray(B, B11, 0 , 0);
divideArray(B, B12, 0 , n/2);
divideArray(B, B21, n/2, 0);
divideArray(B, B22, n/2, n/2);
int [][] P1 = strassenMatrixMultiplication(addMatrices(A11, A22), addMatrices(B11, B22));
int [][] P2 = strassenMatrixMultiplication(addMatrices(A21, A22), B11);
int [][] P3 = strassenMatrixMultiplication(A11, subtractMatrices(B12, B22));
int [][] P4 = strassenMatrixMultiplication(A22, subtractMatrices(B21, B11));
int [][] P5 = strassenMatrixMultiplication(addMatrices(A11, A12), B22);
int [][] P6 = strassenMatrixMultiplication(subtractMatrices(A21, A11), addMatrices(B11, B12));
int [][] P7 = strassenMatrixMultiplication(subtractMatrices(A12, A22), addMatrices(B21, B22));
int [][] C11 = addMatrices(subtractMatrices(addMatrices(P1, P4), P5), P7);
int [][] C12 = addMatrices(P3, P5);
int [][] C21 = addMatrices(P2, P4);
int [][] C22 = addMatrices(subtractMatrices(addMatrices(P1, P3), P2), P6);
copySubArray(C11, result, 0 , 0);
copySubArray(C12, result, 0 , n/2);
copySubArray(C21, result, n/2, 0);
copySubArray(C22, result, n/2, n/2);
}

return result;
}
public int [][] addMatrices(int [][] A, int [][] B)
{
int n = A.length;
int [][] result = new int[n][n];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] = A[i][j] + B[i][j];
return result;
}
public int [][] subtractMatrices(int [][] A, int [][] B)
{
int n = A.length;
int [][] result = new int[n][n];
for(int i=0; i<n; i++)
for(int j=0; j<n; j++)
result[i][j] = A[i][j] - B[i][j];
return result;
}
public void divideArray(int[][] parent, int[][] child, int iB, int jB)
{
for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
{
child[i1][j1] = parent[i2][j2];
}
}
public void copySubArray(int[][] child, int[][] parent, int iB, int jB)
{
for(int i1 = 0, i2=iB; i1<child.length; i1++, i2++)
for(int j1 = 0, j2=jB; j1<child.length; j1++, j2++)
{
parent[i2][j2] = child[i1][j1];
}
}
public void printArray(int [][] array)
{
int n = array.length;
System.out.println();
for(int i=0; i<n; i++)
{
for(int j=0; j<n; j++)
{
System.out.print(array[i][j] + "\t");
}
System.out.println();
}
System.out.println();
}
public static void main(String[] args) throws IOException
{
//for(int i=0;i<10;i++)
new Strassen();
}
}