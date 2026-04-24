import java.util.*;

class Solution {
    class Pair {
        int value, index;
        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1, result);

        List<Integer> res = new ArrayList<>();
        for (int num : result) res.add(num);
        return res;
    }

    private void mergeSort(Pair[] arr, int left, int right, int[] result) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);

        merge(arr, left, mid, right, result);
    }

    private void merge(Pair[] arr, int left, int mid, int right, int[] result) {
        List<Pair> temp = new ArrayList<>();

        int i = left, j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j].value < arr[i].value) {
                rightCount++;
                temp.add(arr[j++]);
            } else {
                result[arr[i].index] += rightCount;
                temp.add(arr[i++]);
            }
        }

        while (i <= mid) {
            result[arr[i].index] += rightCount;
            temp.add(arr[i++]);
        }

        while (j <= right) {
            temp.add(arr[j++]);
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }
}
