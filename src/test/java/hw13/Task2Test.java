package hw13;

import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {
    Task2 task2 = new Task2();
    int[] nums = new int[]{-3, 2, 0, 10, 4, -5};

    @Test
    public void sortedSquares1() {
        task2.sortedSquares(nums);
        assertEquals(0, nums[0]);
    }

    @Test
    public void sortedSquares2() {
        task2.sortedSquares(nums);
        assertEquals(100, nums[nums.length - 1]);
    }
}