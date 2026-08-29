package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public int[][] threeSum(int[] nums) {
        List<int[]> resultList = new ArrayList<>();
        
        // Sort the array first
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i to avoid reporting the same triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Two pointers moving inward from both ends
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[j], nums[k]});
                    
                    // Carefully skipping over duplicate values for j and k
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++; // We need a larger sum
                } else {
                    k--; // We need a smaller sum
                }
            }
        }
        
        return resultList.toArray(new int[0][]);
    }
}
