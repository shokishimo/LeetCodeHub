// Solution 1, using PriorityQueue
class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }

        return nums;
    }
}

// Solution 2, using merge sort
class Solution {
    public int[] sortArray(int[] nums) {
        // merge sort
        return mergeSort(nums, 0, nums.length-1);
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) return new int[] { nums[l] };
        int mid = (l+r)/2;
        int[] leftArr = margeSort(nums, l, mid);
        int[] rightArr = margeSort(nums, mid+1, r);

        int[] ans = new int[leftArr.length + rightArr.length];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < leftArr.length && right < rightArr.length) {
            if (leftArr[left] <= rightArr[right]) {
                ans[index] = leftArr[left];
                left++;
            } else {
                ans[index] = rightArr[right];
                right++;
            }
            index++;
        }

        while (left < leftArr.length) {
            ans[index] = leftArr[left];
            left++;
            index++;
        }

        while (right < rightArr.length) {
            ans[index] = rightArr[right];
            right++;
            index++;
        }

        return ans;
    }
}