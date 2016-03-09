package general;

import java.util.Arrays;

// our main class becomes a file but the main method is still found
public class BruteForceThreeSumZero {
	public static void main(String[] args) {

		// int[] nums = {2,-6,5,4,7,1,-2,0};
		int[] nums = { 3, -2, -1, 4, 2, 0 };

		int count = 0;

		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				for (int k = j + 1; k < nums.length; k++) {

					if (nums[i] + nums[j] + nums[k] == 0) {

						count++;
						System.out.println("conbination :" + nums[i] + ", " + nums[j] + ", " + nums[k]);
					}
				}

			}

		}
	}
}