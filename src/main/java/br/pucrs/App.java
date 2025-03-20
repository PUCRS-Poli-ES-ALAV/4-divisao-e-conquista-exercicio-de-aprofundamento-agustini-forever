package br.pucrs;

import java.math.BigInteger;
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
        if (init == end) {
            return A[init];  
        } else if (end - init == 1) {
            return Math.max(A[init], A[end]);
        } else {
            int m = (init + end)/2;
            long v1 = maxVal2(A, init, m);   
            long v2 = maxVal2(A, m, end);  
            return Math.max(v1, v2);
        }
    }

    public static BigInteger multiply(BigInteger x, BigInteger y) {
        // Determine bit length (n)
        int n = Math.max(x.bitLength(), y.bitLength());
        if (n <= 1) {
            return x.multiply(y);
        }
        
        // Calculate m = ceiling of n/2
        int m = (n + 1) / 2;
        
        // Divide numbers
        BigInteger mask = BigInteger.ONE.shiftLeft(m).subtract(BigInteger.ONE);
        BigInteger a = x.shiftRight(m);
        BigInteger b = x.and(mask);
        BigInteger c = y.shiftRight(m);
        BigInteger d = y.and(mask);
        
        // Recursive multiplication
        BigInteger e = multiply(a, c);
        BigInteger f = multiply(b, d);
        BigInteger g = multiply(b, c);
        BigInteger h = multiply(a, d);
        
        // Combine results
        BigInteger result = e.shiftLeft(2 * m)
                            .add((g.add(h)).shiftLeft(m))
                            .add(f);
        return result;
    }
}
