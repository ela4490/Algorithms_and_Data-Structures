/* Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Example 2:
Input: nums = [4,2,3,4]
Output: 4

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
    
Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/ */

class Solution {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if(nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=2; i<nums.length; i++){
            int left = 0;
            int right = i-1;
            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    result += (right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return result;
    }
}