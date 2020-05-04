class NumberComplementKotlin476 {
    /*
    0000 ... 0101 ==> 5
    1111 ... 1111 ==> Int.MAX_VALUE

    1111 ... 1000 and
    0000 ... 0101
    0000 ... 0000 ==> 0

    1111 ... 1000 inv
    0000 ... 0111

    0000 ... 0101 inv
    1111 ... 1010

    0000 ... 0111 and
    1111 ... 1010
    ==
    0000 ... 0010 ==> 2


    fun findComplement(num: Int): Int {
        var flag = Int.MAX_VALUE
        while (flag.and(num) != 0) {
            flag = flag.shl(1)
        }
        return (flag.inv()).and(num.inv())
    }
     */


    /*
    0000 ... 0101 ==> 5 (leadingZero = 32-3 = 29) inv
    1111 ... 1010
     */
    fun findComplement(num: Int): Int {
        val leadingZero = Integer.numberOfLeadingZeros(num)
        return num.inv().shl(leadingZero).shr(leadingZero)
    }
}

/*
    /** Shifts this value left by the [bitCount] number of bits. */
    public infix fun shl(bitCount: Int): Int
    /** Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with copies of the sign bit. */
    public infix fun shr(bitCount: Int): Int
    /** Shifts this value right by the [bitCount] number of bits, filling the leftmost bits with zeros. */
    public infix fun ushr(bitCount: Int): Int
    /** Performs a bitwise AND operation between the two values. */
    public infix fun and(other: Int): Int
    /** Performs a bitwise OR operation between the two values. */
    public infix fun or(other: Int): Int
    /** Performs a bitwise XOR operation between the two values. */
    public infix fun xor(other: Int): Int
    /** Inverts the bits in this value. */
    public fun inv(): Int
 */