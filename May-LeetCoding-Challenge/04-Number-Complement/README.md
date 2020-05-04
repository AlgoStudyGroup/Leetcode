# Number Complement

https://leetcode.com/problems/number-complement/, Easy

Strategy:

- Bitwise manipulation

## Analysis

Let c(x) denote the complement number of x. For any number x, y, we have (x xor y) xor x = y. 

Thus, it sufficies to compute x xor c(x), which is in form of (1 << i) - 1.
Note that i is also the position of the most significant 1 in the binary representation of x.