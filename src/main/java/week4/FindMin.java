package week4;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Modified binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than the rightmost element, 
            // the minimum must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum must be in the left half, 
                // including mid since mid itself could be the minimum
                right = mid;
            }
        }
        
        // At the end of the loop, left == right and points to the minimum element
        return nums[left];
    }
}
