package br.pucrs;

import java.util.List;

public class App 
{
    private static int iterationCount = 0;

    public static void resetIterationCount() {
        iterationCount = 0;
    }

    public static int getIterationCount() {
        return iterationCount;
    }

    public static void main( String[] args )
    {
        System.out.println( "testing methods..." );

        System.out.println(((long) Math.pow(2, 31) - 1) * ((long) Math.pow(2, 31) - 1));
        System.out.println(multiply4(
            (long) Math.pow(2, 31) - 1,
            (long) Math.pow(2, 31) - 1,
            31L));
        System.out.println(getIterationCount());
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0, rightIndex = 0;
        List<Integer> merged = new java.util.ArrayList<>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }

        return merged;
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = mergeSort(list.subList(0, mid));
        List<Integer> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    public static long maxVal1(long A[], int n) {  
        long max = A[0];
        for (int i = 1; i < n; i++) {  
            // m1_count++;
            if( A[i] > max ) {
                max = A[i];
            }
        }
        return max;
    }

    public static long maxVal2(long A[], int init, int end) {  
        if (end - init <= 1) {
            return Math.max(A[init], A[end - 1]);  
        } else {
            int m = (init + end)/2;
            long v1 = maxVal2(A, init, m);   
            long v2 = maxVal2(A, m+1, end);  
            return Math.max(v1, v2);
        }
    }

    public static long multiply(long x, long y) {
        int n = Math.max(Long.toBinaryString(x).length(), Long.toBinaryString(y).length());
        return multiplyRecursive(x, y, n);
    }

    private static long multiplyRecursive(long x, long y, int n) {
        if (n <= 1) {
            return x * y;
        } else {
            int m = n / 2;
            long mask = (1L << m) - 1;

            long a = x >>> m;  // Higher half of x
            long b = x & mask;  // Lower half of x
            long c = y >>> m;  // Higher half of y
            long d = y & mask;  // Lower half of y

            long e = multiplyRecursive(a, c, m); // High part
            long f = multiplyRecursive(b, d, m); // Low part
            long g = multiplyRecursive(a, d, m); // Cross terms
            long h = multiplyRecursive(b, c, m); // Cross terms

            // Combine results
            return (e << (2 * m)) + ((g + h) << m) + f;
        }
    }

    public static long multiply4(long x, long y, long n){
        if (n == 1) return x * y;

        else{
            iterationCount++;

            long m = n/2;
            long a = x/(long) (Math.pow(2, m));
            long b = x % (long) (Math.pow(2, m));
            long c = y/(long) (Math.pow(2, m));
            long d = y % (long) (Math.pow(2, m));

            long e = multiply4(a, c, m);
            long f = multiply4(b, d, m);
            long g = multiply4(b, c, m);
            long h = multiply4(a, d, m);

            return (long) (Math.pow(2, 2 * m) * e) + ((long) Math.pow(2,m) * (g + h) + f );
        }
    }
}
