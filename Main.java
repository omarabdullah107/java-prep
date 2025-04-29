class Main {
    // Array manipulation recap and they are considered leetcode.
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int[] maxNum = { 4, 17, 2, 99, 23 };
        // reverse(nums);
        // System.out.println(maximum(maxNum));
        // System.out.println(evenSum(nums));
        System.out.println(oddNumCounter(nums));
    }

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
}