import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Main {
    // Array manipulation recap and they are considered leetcode.
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        int[] numsDESC = { 5, 4, 3, 2, 1 };
        int[] maxNum = { 4, 17, 2, 99, 23 };
        int[] duplicatesTrue = { 1, 3, 2, 1 };
        int[] duplicatesFalse = { 1, 3, 2, 4 };
        // reverse(nums);
        // System.out.println(maximum(maxNum));
        // System.out.println(evenSum(nums));
        // System.out.println(oddNumCounter(nums));
        // System.out.println(greaterThanTen(maxNum));
        // System.out.println(average(nums));
        // System.out.println(minimumNum(maxNum));
        // System.out.println(secondLargestNum(maxNum));
        // System.out.println(isSortedAscending(numsDESC));
        // System.out.println(containsDuplicate(duplicatesTrue));
        int[] resultOfTwoSum = twoSum(nums, 5);
        // System.out.println(Arrays.toString(resultOfTwoSum));

        int[] mapRes = twoSumHash(nums, 5);
        for (int number : mapRes) {
            System.out.println(number + " ");
        }

        System.out.println(longSubStringHash("null"));
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

    // Write a function that takes an array of integers and returns the smallest
    // number in the array.
    public static int minimumNum(int[] maxNum) {
        int min = maxNum[0];
        for (int i = 0; i < maxNum.length; i++) {
            if (min > maxNum[i]) {
                min = maxNum[i];
            }
        }
        return min;
    }

    // MEDIUM MODE

    // Problem: Find the Second Largest Number
    public static int secondLargestNum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secMax = max;
                max = nums[i];
            } else if (nums[i] > secMax && nums[i] < max) {
                secMax = nums[i];
            }
        }
        return secMax;
    }

    // Write a Java method that checks if a given array is sorted in ascending
    // order.

    public static boolean isSortedAscending(int[] nums) {
        boolean state = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                state = true;
            }
        }
        return state;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /*
     * Question: "Two Sum"
     * Given an array of integers nums and an integer target,
     * return the indices of the two numbers such that they add up to target.
     * 
     * 
     * Input: nums = [2, 7, 11, 15], target = 9
     * Output: [0, 1]
     * Explanation: Because nums[0] + nums[1] == 9
     * 
     */

    // using nested loop (brute force)
    public static int[] twoSum(int[] nums, int target) {
        int[] indArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indArr[0] = i;
                    indArr[1] = j;
                    return indArr;
                }
            }
        }
        return indArr;
    }

    // using hashmap more faster and efficient
    public static int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[] { map.get(res), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /*
     * Problem: Longest Substring Without Repeating Characters
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     */

    // using nested loop not efficient way
    public static int longSubString(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            String temp = "";

            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);

                if (temp.indexOf(currentChar) != -1) {
                    break; // Repeating character found, break the inner loop
                }

                temp += currentChar;
                maxLength = Math.max(maxLength, temp.length());
            }
        }

        return maxLength;
    }

    // efficient approach using hashSet
    public static int longSubStringHash(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If character is not in the set, add it and update max length
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                // If character is duplicate, remove from left and shrink window
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

}