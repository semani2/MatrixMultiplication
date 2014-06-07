import java.io.*;  
public class multiply  
{  
      public static int a[][]=new int[2000][2000];      
      public  static int b[][]=new int[2000][2000];      
      public static int c[][]=new int[2000][2000];        
           
    
       void display(int a[][],int n)  
       {  
          int i,j;  
          for(i=0;i<n;i++)  
          {   
              System.out.println("");  
              for(j=0;j<n;j++)  
            System.out.print("\t"+a[i][j]);  
          }  
          System.out.println("\n");  
       }  
  
       void add(int a[][],int b[][],int c[][],int n)  
       {  
          int i,j;  
          for(i=0;i<n;i++)  
            for(j=0;j<n;j++)  
            c[i][j]=a[i][j]+b[i][j];  
       }  
   
       void sub(int a[][],int b[][],int c[][],int n)  
       {  
          int i,j;  
          for(i=0;i<n;i++)  
           for(j=0;j<n;j++)  
            c[i][j]=a[i][j]-b[i][j];  
       }  
  
       void submatrix(int a[][],int msb,int lsb,int b[][],int size)  
       {   
          int i,j;  
          for(i=0;i<size/2;i++)  
           for(j=0;j<size/2;j++)  
            b[i][j]=a[(size/2*msb)+i][(size/2*lsb)+j];  
       }  
   
       void join(int x[][],int a[][],int b[][],int c[][],int d[][],int size)  
       {  
          int i,j;  
          for(i=0;i<size/2;i++)  
           for(j=0;j<size/2;j++)  
            x[i][j]=a[i][j];  
          for(i=0;i<size/2;i++)  
           for(j=size/2;j<size;j++)  
            x[i][j]=b[i][j-(size/2)];  
          for(i=size/2;i<size;i++)  
           for(j=0;j<size/2;j++)  
            x[i][j]=c[i-(size/2)][j];  
          for(i=size/2;i<size;i++)  
           for(j=size/2;j<size;j++)  
            x[i][j]=d[i-(size/2)][j-(size/2)];  
       }  
  
       void strasson(int x[][],int y[][],int z[][],int size)  
       {  
           int s1[][]=new int[16][16];int s2[][]=new int[16][16];int s3[][]=new int[16][16];  
           int s4[][]=new int[16][16];int s5[][]=new int[16][16];int s6[][]=new int[16][16];  
           int s7[][]=new int[16][16];  
       int a[][]=new int[16][16];int b[][]=new int[16][16];int c[][]=new int[16][16];  
           int d[][]=new int[16][16];int e[][]=new int[16][16];int g[][]=new int[16][16];  
           int f[][]=new int[16][16];  
           int h[][]=new int[16][16];int i[][]=new int[16][16];int j[][]=new int[16][16];  
           int k[][]=new int[16][16];int l[][]=new int[16][16];  
           int m[][]=new int[16][16];int n[][]=new int[16][16];  
           if(size>1)  
           {  
       submatrix(x,0,0,a,size);  
           submatrix(x,0,1,b,size);  
           submatrix(x,1,0,c,size);  
           submatrix(x,1,1,d,size);  
           submatrix(y,0,0,e,size);  
           submatrix(y,0,1,f,size);  
           submatrix(y,1,0,g,size);  
           submatrix(y,1,1,h,size);  
             
               sub(f,h,m,size/2);          //f-h  
               strasson(a,m,s1,size/2);    //s1  
               add(a,b,m,size/2);          //a+b  
               strasson(m,h,s2,size/2);  
               add(c,d,m,size/2);          //c+d  
               strasson(m,e,s3,size/2);  
               sub(g,e,m,size/2);          //g-e  
               strasson(d,m,s4,size/2);  
               add(a,d,m,size/2);          //a+d  
               add(e,h,n,size/2);          //e+h  
               strasson(m,n,s5,size/2);  
               sub(b,d,m,size/2);          //b-d  
               add(g,h,n,size/2);          //g+h  
               strasson(m,n,s6,size/2);  
               sub(a,c,m,size/2);          //a-c  
               add(e,f,n,size/2);          //e+f  
               strasson(m,n,s7,size/2);  
               add(s5,s6,i,size/2);  
               add(i,s4,i,size/2);  
               sub(i,s2,i,size/2);     //i  
               add(s1,s2,j,size/2);    //j  
               add(s3,s4,k,size/2);    //k  
               add(s5,s1,l,size/2);  
               sub(l,s7,l,size/2);  
               sub(l,s3,l,size/2);     //l  
               join(z,i,j,k,l,size);  
       }  
        else   
            z[0][0]=x[0][0]*y[0][0];  
       }  
 
     
     public static void main(String args[])throws IOException  
       {  
           int n;  
          // System.out.println("Enter the order of matrix");  
          // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
          // n=Integer.parseInt(br.readLine()); 
           n= 256;
           for(int i=0; i<n; i++)
           {
           for(int j=0; j<n; j++)
           {
           //System.out.print("Enter the value of cell("+(i+1)+","+(j+1)+"): ");
           	a[i][j] = (int)(Math.random()*100);
           	//a[i][j] = 10;
           }
           }
           for(int i=0; i<n; i++)
           {
           for(int j=0; j<n; j++)
           {
           //System.out.print("Enter the value of cell("+(i+1)+","+(j+1)+"): ");
           	b[i][j] = (int)(Math.random()*100);
           	//a[i][j] = 10;
           }
           }
           multiply m=new multiply();  
         //  m.input(m.a,n);  
         //  m.display(m.a,n);  
         //  m.input(m.b,n);  
         //  m.display(m.b,n); 
           long startTime = System.nanoTime();
           m.strasson(m.a,m.b,m.c,n);  
           long endTime = System.nanoTime();
           System.out.println("Time in ns:" +(endTime-startTime));
           System.out.println("Time in s:" +((endTime-startTime)/1000000000.0));
          // m.display(m.c,n);  
       }  
}  