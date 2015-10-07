package java;

public class P033_SearchRotated {
	public int search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}
	public int search(int[] nums, int start, int end, int target) {
		if (target == nums[start])
			return start;
		if (target == nums[end])
			return end;
		if (start >= end - 1 || target < nums[start] && target > nums[end])
			return -1;
		int mid = (start + end) / 2;
		if (target == nums[mid])
			return mid;
		if (nums[mid] > nums[start]) { // first half is continuously increasing
			if (target < nums[start] || target > nums[mid]) {
				return search(nums, mid + 1, end - 1, target);
			} else {
				return search(nums, start + 1, mid - 1, target);
			}
		} else { // second half is continuously increasing
			if (target > nums[start] || target < nums[mid]) {
				return search(nums, start + 1, mid - 1, target);
			} else {
				return search(nums, mid + 1, end - 1, target);
			}
		}
	}
}
