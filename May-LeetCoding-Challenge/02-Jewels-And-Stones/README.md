# Jewels and Stones

https://leetcode.com/problems/jewels-and-stones/, Easy

Strategies:

- Brute-force
- Hash table

## Brute Force

Iterate all the stones and find out if the current stone is jewel. Count the
result found. A brute force solution can be done using character lookup
function in string. This is usually a builtin function in programming language.

Complexity:

- Time complexity: O(J * S)
- Space complexity: O(1)

where J is the number of jewels and S is the number of strones.

## Hash Table

Similiar to solution above, where we iterate all the stones and find out if the
current stone is jewel. Count the result found. However, we create a hash table
or hash set for character lookup here. Compared to brute-force solution, we
have an O(1) time complexity for the lookup.

Complexity:

- Time complexity: O(S)
- Space complexity: O(J)

where J is the number of jewels and S is the number of strones.
