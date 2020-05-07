# Ransom Note

https://leetcode.com/problems/ransom-note/, Easy

Strategies:

- Hash table

## Hash Table

Create a hash table, iterate all the characters of magazine, save the character
as the key and its amount as the value. Then we iterate ransomNote, check if
character lookup can be found in the hash table with the enough amount.

Complexity:

- Time complexity: O(M + R)
- Space complexity: O(1) (O(26) since magazine contains only lowercase letters.)

where M is the number of magazine and R is the number of ransomNote.
