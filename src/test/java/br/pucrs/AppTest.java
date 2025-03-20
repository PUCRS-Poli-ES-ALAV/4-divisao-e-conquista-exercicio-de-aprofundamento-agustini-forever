package br.pucrs;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @org.junit.jupiter.api.Test
    public void testMergeSortWithRandomIntegers() {
        int[] sizes = {32, 2048, 1048576};
        for (int size : sizes) {
            List<Integer> randomList = new java.util.ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                randomList.add(random.nextInt(100));
            }

            App.resetIterationCount(); // Reset iteration count before sorting
            long startTime = System.nanoTime();
            List<Integer> sortedList = App.mergeSort(randomList);
            long endTime = System.nanoTime();

            // Verify the list is sorted
            for (int i = 1; i < sortedList.size(); i++) {
                assertTrue(sortedList.get(i - 1) <= sortedList.get(i));
            }

            System.out.println("Size: " + size);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println("Iterations: " + App.getIterationCount());
        }
    }

    @org.junit.jupiter.api.Test
    public void testMaxVal1() {
        int[] sizes = {32, 2048, 1048576};
        for (int size : sizes) {
            long randomArray[] = new long[size];
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(100);
            }

            App.resetIterationCount(); // Reset iteration count before finding max
            long startTime = System.nanoTime();
            long maxVal = App.maxVal1(randomArray, size);
            long endTime = System.nanoTime();

            // Verify the max value is correct
            long expectedMax = java.util.Arrays.stream(randomArray).max().orElseThrow();
            assertTrue(maxVal == expectedMax);

            System.out.println("Size: " + size);
            System.out.println("Max Value: " + maxVal);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println("Iterations: " + App.getIterationCount());
        }
    }

    @org.junit.jupiter.api.Test
    public void testMaxVal2() {
        int[] sizes = {32, 2048, 1048576};
        for (int size : sizes) {
            long randomArray[] = new long[size];
            Random random = new Random();
    
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(100);
            }
    
            App.resetIterationCount(); // Reset iteration count before finding max
            long startTime = System.nanoTime();
            // Change 'size' to 'size - 1' to use the correct 0-based indexing
            long maxVal = App.maxVal2(randomArray, 0, size - 1);
            long endTime = System.nanoTime();
    
            // Verify the max value is correct
            long expectedMax = java.util.Arrays.stream(randomArray).max().orElseThrow();
            assertTrue(maxVal == expectedMax);
    
            System.out.println("Size: " + size);
            System.out.println("Max Value: " + maxVal);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println("Iterations: " + App.getIterationCount());
        }
    }

    @org.junit.jupiter.api.Test
    public void testMultiply() {
        long[][] testCases = {
            {15, 15, 4}, 
            {65535, 65535, 16}, 
        };

        for (long[] testCase : testCases) {
            BigInteger x = BigInteger.valueOf(testCase[0]);
            BigInteger y = BigInteger.valueOf(testCase[1]);

            App.resetIterationCount(); 
            long startTime = System.nanoTime();
            BigInteger result = App.multiply(x, y);
            long endTime = System.nanoTime();

            BigInteger expected = x.multiply(y);
            assertTrue(result.equals(expected));

            System.out.println("X: " + x + ", Y: " + y);
            System.out.println("Result: " + result);
            System.out.println("Expected: " + expected);
            System.out.println("Time taken (ns): " + (endTime - startTime));
            System.out.println("Iterations: " + App.getIterationCount());
        }
    }
}
