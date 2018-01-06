import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Search Insert Position 
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * Example :
 * 
 * Input: [1,3,5,6], 5  -> Output: 2
 * Input: [1,3,5,6], 2  -> Output: 1
 * Input: [1,3,5,6], 7  -> Output: 4
 * Input: [1,3,5,6], 0  -> Output: 0
 *
 */
public class A6_01_SearchInsertPosition {
	
	@Test
	public void test1(){
		Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
	}
	
	@Test
	public void test4(){
		Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
	}
	
	@Test
	public void test5(){
		Assert.assertEquals(0, searchInsert(new int[]{1}, 1));
	}
	
	@Test
	public void test6(){
		Assert.assertEquals(3, searchInsert(new int[]{3,5,7,9,10}, 8));
		
	}
	
	@Test
	public void test7(){
		Assert.assertEquals(1, searchInsert(new int[]{1,3}, 2));
	}
	
	@Test
	public void test8(){
		Assert.assertEquals(0, searchInsert(new int[]{1,3}, 0));
	}
	
	private static int searchInsert(int[] nums, int target){
		return new Solution1().searchInsert(nums, target);
	}
	
	static class Solution1{
		public int searchInsert(int[] nums, int target) {
			int L = 0;
			int R = nums.length -1;
			
			while(L<R){
				int M = (L+R)/2;
				if(target > nums[M]){
					L = M+1;
				}else{
					R = M;
				}
			}
			
			return target > nums[L] ? L+1 : L; 
	    }
	}
	
	//bad 
	static class Solution2{
		public int searchInsert(int[] nums, int target) {
			return searchInsert(nums, target, 0, nums.length-1);
	    }
			
		private int searchInsert(int[] nums, int target, int start, int end) {
			if(end<0) return 0;
			if(start>=end) return nums[end]>=target ? end : end+1;
			
			int mid = (start + end)/2;
//			System.out.println(String.format("range:%d~%d , mid=%d", start, end, mid));
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] > target){
				return searchInsert(nums, target, start, mid-1);
			}else{
				return searchInsert(nums, target, mid+1, end);
			}
		}
	}
	
}
