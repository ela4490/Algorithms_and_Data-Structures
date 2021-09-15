/* Given an integer array arr, return the length of a maximum size turbulent subarray of arr. A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray. More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.

Example 1:
Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

Example 2:
Input: arr = [4,8,12,16]
Output: 2

Example 3:
Input: arr = [100]
Output: 1

Constraints:
1 <= arr.length <= 4 * 10^4
0 <= arr[i] <= 10^9
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3976/ */

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
        if(arr.length < 2) {
            return arr.length;
        }
        
        int max = 1;
        int start = 0;
        int end = 0;
        int len = arr.length;
        
        while(start + 1 < len) {
            
            if(arr[start] == arr[start + 1]) {
                start++;
                continue;
            }
            
            end = start + 1;
            
            while(end + 1 < len && validate(arr, end)) {
                end++;
            }
            
            max = Math.max(max, end - start + 1);
            start = end;
        }
        
        return max;
    }
    
    private boolean validate(int[] arr, int k) {
        return ((arr[k] < arr[k + 1] && arr[k] < arr[k - 1]) || (arr[k] > arr[k + 1] && arr[k] > arr[k - 1]));
    }
}