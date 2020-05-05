# Number Complement

https://leetcode.com/problems/number-complement/, Easy

Strategy:

- Bitwise manipulation

## Analysis

Let `c(x)` denote the complement number of `x`. For any number `x`, `y`, we have
`(x xor y) xor x = y`.

Thus, it sufficies to compute `x xor c(x)`, which is in form of `(1 << i) - 1`.
Note that `i` is also the position of the most significant bit (MSB) in the binary
representation of `x`.

## Remarks

Overflow. The greatest signed 32-bit integer is 2147483647. Its binary
representation is:

    0111 1111 1111 1111 1111 1111 1111 1111

The form `(1 << i)` mentioned above in this case is -2147483648:

    1000 0000 0000 0000 0000 0000 0000 0000

In this case, some arithmetic comparison won't work. So you need to be careful
when shifting bits of `i`. Here is a counterexample in C++:

```cpp
int findComplement(int num) {
    int i = 1;
    // runtime error: left shift of negative value -2147483648
    while (i <= num) i <<= 1;
    return (i - 1) ^ num;
}
```

There are two ways to avoid the situation: 1) using 64-bit integer to compute
the mask; 2) avoid going further than the most significant bit of input `num`.

Use 64-bit integer (long):

```cpp
int findComplement(int num) {
    long i = 1;
    while (i <= num) i <<= 1;
    return (i - 1) ^ num;
}
```

Avoid going further than the most significant bit of input `num`:

```cpp
int findComplement(int num) {
    int i = 1;
    while (i < num) i = (i << 1) + 1;
    return i ^ num;
}
```

## Resources

- Wikipedia: [Bit manipulation](https://en.wikipedia.org/wiki/Bit_manipulation)
- Wikipedia: [Bitwise operation](https://en.wikipedia.org/wiki/Bitwise_operation)
