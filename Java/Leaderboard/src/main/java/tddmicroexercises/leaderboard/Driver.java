package tddmicroexercises.leaderboard;

public class Driver {

    private final String name;
    private final String country;

    Driver(String name, String country) {
        this.name = name;
        this.country = country;
    }

    String getName() {
        return name;
    }

    String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }

    @Override
    public String toString() {
        return name;
    }
}
