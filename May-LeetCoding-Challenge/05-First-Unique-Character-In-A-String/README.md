# First Unique Character in a String

https://leetcode.com/problems/first-unique-character-in-a-string/, Easy

Strategies:

- Hash table

## Hash Table

Create a hash table, iterate all the characters of input `s`, save the character
as the key and a list of its amount & its first index as the value. Then we
iterate the hash table, for the first key whose amount is 1, return its index.
We should pay attention to the keys' order in the hash map, to see if is in
order of input `s` or in alphabetic order. The hash table can be created as
below in Python:

```python
letters_dict = {}
for idx, letter in enumerate(s):
    if letter in letters_dict:
        letters_dict[letter][0] += 1
    else:
        letters_dict[letter] = [1, idx]
```

Complexity:

- Time complexity: O(S)
- Space complexity: O(1)

where S is the number of `s`.
