// Collectng Woods
// Value to be subtracted from array elements to make sum of all elements equals K
// Given an integer K and an array, height[] where height[i] denotes the height of the ith tree in a forest. The task is to make a 
// cut of height X from the ground such that exactly K unit wood is collected. If it is not possible, then print -1 else print X.

// Input: height[] = {1, 2, 1, 2}, K = 2 
// Output: 1 
// Make a cut at height 1, the updated array will be {1, 1, 1, 1} and 
// the collected wood will be {0, 1, 0, 1} i.e. 0 + 1 + 0 + 1 = 2.

// Input: height = {1, 1, 2, 2}, K = 1 
// Output: -1  


import java.util.Arrays;

class CollectngWoods {
	static int[] height = new int[]{ 1, 2, 1, 2 };
	
	public static int woodCollected(int n, int m) {
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (height[i] - m <= 0)
				break;
			sum += (height[i] - m);
		}
		return sum;
	}

	public static int collectKWood(int n, int k) {
		Arrays.sort(height);

		int low = 0, high = height[n - 1];

		while (low <= high) {
			int mid = low + ((high - low) / 2);

			int collected = woodCollected(n, mid);

			if (collected == k)
				return mid;

			if (collected > k)
				low = mid + 1;

			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int k = 2;
		int n = height.length;
		System.out.print(collectKWood(n,k));
	}
}
