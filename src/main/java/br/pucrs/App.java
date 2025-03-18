package br.pucrs;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    static int m1_count = 0;
    static int m2_count = 0;

    static long m1_time = 0;
    static long m2_time = 0;

    public static void main( String[] args )
    {
        System.out.println( "testing methods..." );


    }

    public static int[] populateArrayWithRandomNumbers(int x) {
            int[] array = new int[x]; 
            Random random = new Random();

            for (int i = 0; i < x; i++) {
                array[i] = random.nextInt(100);
            }
            return array;
        }

    long maxVal1(long A[], int n) {  
        long max = A[0];
        for (int i = 1; i < n; i++) {  

            m1_count++;
            if( A[i] > max ) 
            max = A[i];
        }
        return max;
        }

    long maxVal2(long A[], int init, int end) {  
        m2_count++;

        if (end - init <= 1)
            return Math.max(A[init], A[end]);  
        else {
            int m = (init + end)/2;
            long v1 = maxVal2(A,init,m);   
            long v2 = maxVal2(A,m+1,end);  
            return Math.max(v1,v2);
            }
    }
}
