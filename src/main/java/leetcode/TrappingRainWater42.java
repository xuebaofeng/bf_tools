package leetcode;

import java.util.Arrays;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        TrappingRainWater42 s = new TrappingRainWater42();
        int i = s.trap(new int[]{4, 2, 3});
        System.out.println(i);
    }

    public int trap(int[] height) {
        Arrays.toString(new char[]{});
        Arrays.hashCode(new char[]{});
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                if (height[left] < leftMax) ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] < rightMax) ans += rightMax - height[right];
                right--;
            }
            System.out.println(ans);
        }
        return ans;
    }
}