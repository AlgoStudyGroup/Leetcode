object Solution {
  def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
    // number of people who trust same people
    val beTrusteds = Array.fill[Int](N)(0)
    // people who trust other or others
    val doTrusts = Array.fill[Boolean](N)(false)

    for (t <- trust) {
      // doTrust "trust" beTrusted
      val beTrusted = t(1)
      val doTrust = t(0)
      beTrusteds(beTrusted - 1) += 1
      doTrusts(doTrust - 1) = true
    }

    doTrusts
      .zip(beTrusteds)
      .zipWithIndex
      .find {
        case ((doTrust: Boolean, beTrusted: Int), _: Int) => !doTrust && beTrusted == N - 1
      }
      .map(_._2 + 1)
      .getOrElse(-1)
  }
}
