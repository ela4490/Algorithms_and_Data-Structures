/* Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order. You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0]

Constraints:
2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each integer in nums will appear twice, only two integers will appear once.
    
Link: https://leetcode.com/problems/single-number-iii/ */

public class Solution {
	
    public int[] singleNumber(int[] nums) {
		int xor = 0;
		
        for(int num: nums) {
			xor ^= num;
		}
		
        int elWithLowestBitSet = Integer.highestOneBit(xor);

		int[] ans = new int[2];

		for(int num: nums) {
			// Column where the bit is unset
			if((elWithLowestBitSet & num) == 0) {
				ans[0] ^= num;
			} else {
				// Column where the bit is set
				ans[1] ^= num;
			}
		}
        
		return ans;
	}
}