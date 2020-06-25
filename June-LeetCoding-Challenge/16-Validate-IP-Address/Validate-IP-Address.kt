class ValidateIPAddressKotlin468 {
    fun validIPAddress(IP: String): String {
        if (IP.isEmpty() || IP.length < 6) {
            return "Neither"
        }
        val str5 = IP.substring(0, 6)
        return when {
            str5.contains(".") -> {
                val strArray4 = IP.split(".")
                if (strArray4.size == 4) {
                    strArray4.forEach {
                        if (!isIpV4(it)) {
                            return "Neither"
                        }
                    }
                    "IPv4"
                } else {
                    "Neither"
                }
            }
            str5.contains(":") -> {
                val strArray8 = IP.split(":")
                if (strArray8.size == 8) {
                    strArray8.forEach {
                        if (!isIpV6(it)) {
                            return "Neither"
                        }
                    }
                    "IPv6"
                } else {
                    "Neither"
                }
            }
            else -> "Neither"
        }
    }

    private val validIpV4String = "0123456789"

    private fun isIpV4(string: String): Boolean {
        if (string.length in 1..3) {
            string.forEach {
                if (!validIpV4String.contains(it, ignoreCase = true)) {
                    return false
                }
            }
            if (string.toInt() !in 0..255) {
                return false
            }
            if (string[0] == '0' && string.length > 1) {
                return false
            }
            return true
        }
        return false
    }

    private val validIpV6String = "0123456789abcdef"

    private fun isIpV6(string: String): Boolean {
        if (string.length in 1..4) {
            string.forEach {
                if (!validIpV6String.contains(it, ignoreCase = true)) {
                    return false
                }
            }
            return true
        }
        return false
    }
}

fun main() {
    val str = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
    println(str.split(":").size)
}