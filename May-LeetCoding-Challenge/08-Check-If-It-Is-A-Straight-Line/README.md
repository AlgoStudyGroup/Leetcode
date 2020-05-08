# Check if it is a Straight Line

https://leetcode.com/problems/check-if-it-is-a-straight-line/, Easy

Strategy:

- Straight forward, compute the slope, if all points have the same slope with the first point, then they are in a straight line.

## Solution

- Step 1: Compute the slope of first two points

- Step 2: Make a loop for other points, compute the slope of all other points with the first point, if they have the same slope then return true, otherwise return false.

## Complexity

We need just one loop, so Time complexity is *O(n)*