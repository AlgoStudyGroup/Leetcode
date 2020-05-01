// An example of binary search.
// Return the index if the target value could be found in the array, otherwise, return -1;

int binary_search(vector<int> arr, int target) {
    int left = 0, right = arr.size() - 1;
    while(left <= right) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == target)  {
            return mid;
        }
        else if (arr[mid] > target){
            right = mid - 1;
        }
        else if (arr[mid] < target){
            left = mid + 1;
        }
    }
    return -1;
}
