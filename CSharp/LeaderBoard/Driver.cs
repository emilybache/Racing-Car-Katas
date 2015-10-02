namespace TDDMicroExercises.LeaderBoard
{
    public class Driver
    {
        public Driver(string name, string country)
        {
            Name = name;
            Country = country;
        }

        public string Name { get; }
        public string Country { get; }

        public override int GetHashCode()
        {
            return Name.GetHashCode()*31 + Country.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj is Driver))
            {
                return false;
            }
            var other = (Driver) obj;
            return Name.Equals(other.Name) && Country.Equals(other.Country);
        }
    }
}