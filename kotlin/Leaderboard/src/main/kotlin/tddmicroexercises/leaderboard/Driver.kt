package tddmicroexercises.leaderboard

open class Driver(val name: String, val country: String) {

    override fun hashCode(): Int {
        return name.hashCode() * 31 + country.hashCode()
    }

    override fun equals(any: Any?): Boolean {
        if (this === any) {
            return true
        }
        if (any == null || any !is Driver) {
            return false
        }
        val other = any as Driver?
        return this.name == other!!.name && this.country == other.country
    }
}
