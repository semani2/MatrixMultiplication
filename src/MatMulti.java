import java.lang.*;
import java.io.*;
class MatMulti extends Thread
{
        static int arr1[][];
        static int arr2[][];
        static int arr3[][];
        static int a=2;
        int row;
      
    	public static long multiplication_count =0;
    	public static long startTime =0;
    	public static long endTime = 0;
    	public static long time = 0;
        MatMulti(int i)
        {
        	multiplication_count =0;
                row=i;
                this.start();
               
        }
        public void run()
        {
        	
        		
                int i,j;
                for(i=0;i<a;i++)
                {
                        arr3[row][i]=0;
                        for(j=0;j<a;j++){
                        	
                                arr3[row][i]=arr3[row][i]+arr1[row][j]*arr2[j][i];
                           
                             
                                multiplication_count++;
                        }
                }
        }
        public static void main(String args[])
        {
        	for(int count =0 ;count<=9; count++)
        	{
                int i,j;
                long startTime1 =0 ;
                long endTime1 =0;
               // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                //System.out.print("Enter the order of Matrix : ");
                //try
                //{
                 //       a=Integer.parseInt(br.readLine());
                //}catch(Exception e){}
                a = 100;
                arr1=new int[a][a];
                arr2=new int[a][a];
                arr3=new int[a][a];
              //  System.out.println("Enter the First Matrix : ");
                for(i=0;i<a;i++)
                {
                        for(j=0;j<a;j++)
                        {
                                try
                                {
                                       arr1[i][j]= (int)(Math.random()*1000);
                                       // arr1[i][j]= 10;
                                }catch(Exception e){}
                        }
                }
              //  System.out.println("Enter the Second Matrix : ");
                for(i=0;i<a;i++)
                {
                        for(j=0;j<a;j++)
                        {
                                try
                                {
                                        arr2[i][j]=(int)(Math.random()*1000);
                                       // arr2[i][j] = 10;
                                }catch(Exception e){}
                        }
                }
                startTime1 = System.nanoTime();
                MatMulti mat[]=new MatMulti[a];
                for(i=0;i<a;i++)
                        mat[i]=new MatMulti(i);
               endTime1 = System.nanoTime();
                try
                {
                        for(i=0;i<a;i++)
                                mat[i].join();
                }catch(Exception e){}
               // System.out.println("Time in ns = "+time);
                //System.out.println("Time in sec = "+(time/1000000000.0));
                System.out.println("Took a time of :"+(endTime1-startTime1)+" ns");
                System.out.println("Took a time of :"+((endTime1-startTime1)/1000000000.0)+" s");
                
                System.out.println("Number of operations :"+multiplication_count);
              
          /*      		  System.out.println("OUTPUT :");
                for(i=0;i<a;i++){
                        for(j=0;j<a;j++){
                                System.out.print(arr3[i][j]+"   ");
                        }
           
                        
                       System.out.println("\n"); } */
        	}
        }
}
