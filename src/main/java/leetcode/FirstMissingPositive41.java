package leetcode;

public class FirstMissingPositive41 {
    public static void main(String[] args) {
        FirstMissingPositive41 s = new FirstMissingPositive41();
        int i = s.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) if (nums[i] <= 0) nums[i] = len + 1;
        for (int i = 0; i < len; i++) {
            int v = Math.abs(nums[i]);
            if (v <= len)
                nums[v - 1] = -nums[v - 1];
        }
        for (int i = 0; i < len; i++) if (nums[i] > 0) return i + 1;
        return len + 1;
    }
}