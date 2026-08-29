package week4;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // Hash map to store prefix-sum frequencies
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        
        // Initialize the "empty prefix" base case
        prefixSumCounts.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if we have seen a prefix sum that equals (currentSum - k)
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            // Add the current prefix sum to the map
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
