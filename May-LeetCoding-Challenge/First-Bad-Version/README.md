#### Summary
A direct application of the Binary Search algorithm.


#### Template of Binary Search [Pseudo Code]
```
int binary_search(int[] arr, int target){
	int left = ..., right = ... ;
	while (...){
		int mid = (right - left) / 2 + left;
		if (arr[mid] == target){
			...
		}
		else if (arr[mid] < target){
			left = ...
		}
		else if (arr[mid] > target){
			right = ...
		}
	}
	return ...
}
```

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
* 