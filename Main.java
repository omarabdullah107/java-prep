class Main {
    // Array manipulation recap and they are considered leetcode.
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int[] maxNum = { 4, 17, 2, 99, 23 };
        // reverse(nums);
        // System.out.println(maximum(maxNum));
        // System.out.println(evenSum(nums));
        // System.out.println(oddNumCounter(nums));
        // System.out.println(greaterThanTen(maxNum));
        System.out.println(average(nums));
    }

    // EASY MODE FOR WARMUP
    public static void reverse(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int maximum(int[] maxNum) {
        int max = maxNum[0];
        for (int i = 0; i < maxNum.length; i++) {
            if (max < maxNum[i]) {
                max = maxNum[i];
            }
        }
        return max;
    }

    public static int evenSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }

    public static int oddNumCounter(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                counter += 1;
            }
        }
        return counter;
    }

    // Write a function that returns the number of elements in an array that are
    // greater than 10.
    public static int greaterThanTen(int[] nums) {
        int numCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 10) {
                numCounter += 1;
            }
        }
        return numCounter;
    }

    // "Find the average of all numbers in an array."
    public static int average(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum / nums.length;
    }

    // MEDIUM MODE

    // Problem: Find the Second Largest Number

}