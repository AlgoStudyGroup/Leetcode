#### Summary
A direct application of the Binary Search algorithm.

#### Complexity
* Time complexity: O(log n).
* Space complexity: O(1).

#### Template of Binary Search (in C++)
```
// Return the index if the target value could be found in the array,
// otherwise, return -1;
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
``` 

#### Other variants

1. Left bound. Find the first index i such that arr[i] == target, otherwise return -1.

* Using half-closed interval [L, R).
```
int left_bound_binary_Search(vector<int> arr, int target) {
    int left = 0, right = arr.size();
    while(left < right) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == target)  {
            right = mid;
        }
        else if (arr[mid] > target){
        	right = mid;
    	}
        else if (arr[mid] < target){
            left = mid + 1;
        }
    }

    if (left >= arr.size()) return -1;
    return (arr[left] == target ? left : -1);
}
```

* Using closed inteval [L, R]
```
int left_bound_binary_Search(vector<int> arr, int target) {
    int left = 0, right = arr.size() - 1;
    while(left <= right) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == target)  {
            right = mid - 1;
        }
        else if (arr[mid] > target){
        	right = mid - 1; 
    	}
        else if (arr[mid] < target){
            left = mid + 1;
        }
    }

    if (left >= arr.size()) return -1;
    return (arr[left] == target ? left : -1);
}
```

2. Right bound. Find the last index i such that arr[i] == target, otherwise return -1.

* Using half-closed interval [L, R).
```
int right_bound_binary_Search(vector<int> arr, int target) {
    int left = 0, right = arr.size();
    while(left < right) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == target)  {
            left = mid + 1;
        }
        else if (arr[mid] > target){
        	right = mid - 1;
    	}
        else if (arr[mid] < target){
            left = mid + 1;
        }
    }
    if (left == 0) return -1;
    else return (arr[left - 1] == target ? (left - 1) : -1);
}
```

* Using closed inteval [L, R]
```
int right_bound_binary_Search(vector<int> arr, int target) {
    int left = 0, right = arr.size() - 1;
    while(left <= right) {
        int mid = (right - left) / 2 + left;
        if (arr[mid] == target)  {
            left = mid + 1;
        }
        else if (arr[mid] > target){
        	right = mid - 1; 
    	}
        else if (arr[mid] < target){
            left = mid + 1;
        }
    }

    if (right < 0) return -1;
    return (arr[right] == target ? right : -1);
}
```


These templates are also available [here](https://github.com/jinshendan/Leetcode/tree/master/Template/Maths/Binary-Search).


#### Remarks
* Use
```
mid = (right - left) / 2 + left
```
instead of
```
mid = (left + right) / 2
```
to avoid any overflow in intermediare calculation.