package br.pucrs;

import java.util.List;
import java.math.BigInteger;

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
        if (end - init <= 1) {
            return Math.max(A[init], A[end - 1]);  
        } else {
            int m = (init + end)/2;
            long v1 = maxVal2(A, init, m);   
            long v2 = maxVal2(A, m+1, end);  
            return Math.max(v1, v2);
        }
    }

    public static BigInteger multiply(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength()); // Calculate the bit-length of the larger number
        return multiplyRecursive(x, y, BigInteger.valueOf(n));
    }
    
    private static BigInteger multiplyRecursive(BigInteger x, BigInteger y, BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return x.multiply(y);
        } else {
            BigInteger m = n.divide(BigInteger.TWO); // Use integer division for simplicity
            BigInteger a = x.shiftRight(m.intValue()); // Higher half of x
            BigInteger b = x.and(BigInteger.ONE.shiftLeft(m.intValue()).subtract(BigInteger.ONE)); // Lower half of x
            BigInteger c = y.shiftRight(m.intValue()); // Higher half of y
            BigInteger d = y.and(BigInteger.ONE.shiftLeft(m.intValue()).subtract(BigInteger.ONE)); // Lower half of y
    
            BigInteger e = multiplyRecursive(a, c, m); // High part of the result
            BigInteger f = multiplyRecursive(b, d, m); // Low part of the result
            BigInteger g = multiplyRecursive(a, d, m); // Cross terms
            BigInteger h = multiplyRecursive(b, c, m); // Cross terms
    
            // Combine the results
            return (e.shiftLeft(2 * m.intValue())).add((g.add(h)).shiftLeft(m.intValue())).add(f);
        }
    }
}
