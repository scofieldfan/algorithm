package com.fan.dream.algorithm.array;

import java.util.*;

public class LeetCodeArray {

    public static void main(String[] args) {

        LeetCodeArray lc977 = new LeetCodeArray();
//        int[] array = {-4, -1, 0, 3, 10};
//        System.out.println(Arrays.toString(lc977.sortedSquares(array)));
//        int[] array2 = {-7, -3, 2, 3, 11};
//        System.out.println(Arrays.toString(lc977.sortedSquares(array2)));
        //  int[] array3 = {1, 2, 3, 4, 5, 6, 7};
        //   System.out.println(Arrays.toString(lc977.rotate(array3, 3)));
        //System.out.println(lc977.removeOuterParentheses("(()())(())"));
        //System.out.println(lc977.removeOuterParentheses("(()())(())(()(()))"));
        //System.out.println(lc977.removeOuterParentheses("()()"));

        /*
        int[][] testCase1 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        int[][] output = lc977.flipAndInvertImage(testCase1);
        Util.printMatrix(output);
        */
        Set<Integer> list = new HashSet<>();
        int[] case1 = {18, 29, 38, 59, 98, 100, 99, 98, 90};
        int[] case2 = {3, 2, 1, 3};
        int[] case3 = {2, 1, 2, 5, 3, 2};
        int[] case4 = {5, 1, 5, 2, 5, 3, 5, 4};
        //System.out.println(lc977.p[1,2,3,3]eakIndexInMountainArray(case1));
        //System.out.println(lc977.selfDividingNumbers(1, 22));
        lc977.qsort(case1, 0, case1.length - 1);
        lc977.qsort(case2, 0, case2.length - 1);
        lc977.qsort(case3, 0, case3.length - 1);
        lc977.qsort(case4, 0, case4.length - 1);
        System.out.println(Arrays.toString(case1));
        System.out.println(Arrays.toString(case2));
        System.out.println(Arrays.toString(case3));
        System.out.println(Arrays.toString(case4));
    }

    /**
     * https://leetcode-cn.com/problems/subdomain-visit-count/
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : cpdomains) {

            String[] inputs = str.split(" ");
            int domainTimes = Integer.parseInt(inputs[0]);
            for (int i = 0; i < inputs[1].length(); i++) {
                if (inputs[1].charAt(i) == '.') {
                    String subStr = inputs[1].substring(i, inputs[1].length());
                    int times = map.get(subStr) == null ? 0 : map.get(subStr);
                    times += domainTimes;
                    map.put(subStr, times);
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (String key : map.keySet()) {
            ret.add(map.get(key) + " " + map.get(key));
        }
        return ret;
    }

    /**
     * leetcode 977
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] map = new int[10001];
        for (int i = 0; i < A.length; i++) {
            map[Math.abs(A[i])] += 1;
        }
        int[] result = new int[A.length];
        int j = 0;
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                result[j++] = i * i;
            }
        }
        return result;
    }

    /**
     * 将数组中的偶数排在前面，奇数排在后面 leetcode 905 https://leetcode-cn.com/problems/sort-array-by-parity/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[start++] = A[i];
            } else {
                result[end--] = A[i];
            }
        }
        return result;
    }

    /**
     * 移除数组的重复项 https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
     *
     * @param nums
     * @return
     */

    public int removeDuplicates(int[] nums) {
        int index = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                nums[index++] = nums[i];
            }
            last = nums[i];
        }
        return index + 1;
    }


    /**
     * 旋转数组 https://leetcode-cn.com/problems/rotate-array/
     *
     * @param nums
     * @param k
     */
    public int[] rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k - nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * https://leetcode-cn.com/problems/jewels-and-stones/
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int[] map = new int[256];
        for (int i = 0; i < J.length(); i++) {
            map[J.charAt(i)] = 1;
        }
        int ret = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map[S.charAt(i)] == 1) {
                ret++;
            }
        }
        return ret;
    }

    /**
     * https://leetcode-cn.com/problems/remove-outermost-parentheses/
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {

        if (S == null || S == "") {
            return "";
        }
        int count = 0;
        char[] inputs = S.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputs.length; i++) {
            char currentChar = inputs[i];
            if (currentChar == '(') {
                if (count > 0) {
                    sb.append(currentChar);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    sb.append(currentChar);
                }
            }
        }
        return sb.toString();
    }

    /**
     * @param A
     * @return
     */

    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int[] rows = A[i];
            for (int j = 0; j < rows.length / 2; j++) {
                int temp = 1 - rows[j];
                rows[j] = 1 - rows[rows.length - j - 1];
                rows[rows.length - 1 - j] = temp;
            }
            if (rows.length % 2 != 0) {
                int mid = rows.length / 2;
                rows[mid] = 1 - rows[mid];
            }
        }
        return A;
    }

    /**
     * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
     */

    public int peakIndexInMountainArray(int[] A) {

        int start = 0;
        int end = A.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] > A[mid + 1] && A[mid - 1] > A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    /**
     * https://leetcode-cn.com/problems/self-dividing-numbers/
     */

    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            String num = String.valueOf(i);
            boolean isDivide = true;
            for (char c : num.toCharArray()) {
                if (c == '0' || i % (c - '0') != 0) {
                    isDivide = false;
                    break;
                }
            }
            if (isDivide) {
                list.add(i);
            }

        }
        return list;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            boolean isDivide = true;
            int num = i;
            if (num >= 10) {
                while (num > 0) {
                    int tmp = num % 10;
                    if (tmp == 0 || i % tmp != 0) {
                        isDivide = false;
                        break;
                    } else {
                        num = num / 10;
                    }
                }
                if (isDivide) {
                    list.add(i);
                }
            } else {
                list.add(i);
            }

        }
        return list;
    }


    /**
     * https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
     *
     * @param A
     * @return
     */
    public int repeatedNTimes(int[] A) {
        return findMidNumber(A, 0, A.length - 1);
    }

    public int findMidNumber(int[] A, int start, int end) {
        int mid = partition(A, start, end);
        int index = (int) Math.ceil((A.length - 1) / 2);
        if (mid == index) {
            return A[mid];
        } else if (mid < index) {
            return findMidNumber(A, mid + 1, end);
        } else {
            return findMidNumber(A, start, mid - 1);
        }
    }

    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public void qsort(int[] A, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = partition(A, start, end);
        qsort(A, start, mid - 1);
        qsort(A, mid + 1, end);
    }
}
