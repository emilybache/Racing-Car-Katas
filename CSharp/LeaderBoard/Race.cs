using System.Collections.Generic;

namespace TDDMicroExercises.LeaderBoard
{
    public class Race
    {
        private static readonly int[] Points = {25, 18, 15};
        private readonly Dictionary<Driver, string> _driverNames = new Dictionary<Driver, string>();
        private readonly string _name;

        public Race(string name, params Driver[] drivers)
        {
            _name = name;
            Results = new List<Driver>();
            Results.AddRange(drivers);

            foreach (var driver in Results)
            {
                var driverName = driver.Name;

                var drivingCar = driver as SelfDrivingCar;

                if (drivingCar != null)
                {
                    driverName = "Self Driving Car - " + drivingCar.Country + " (" +
                                 drivingCar.AlgorithmVersion + ")";
                }
                _driverNames.Add(driver, driverName);
            }
        }

        public List<Driver> Results { get; }

        public Dictionary<Driver, string> DriverNames
        {
            get {  return _driverNames; }
        }

        public int Position(Driver driver)
        {
            return Results.FindIndex(d => Equals(d, driver));
        }

        public int GetPoints(Driver driver)
        {
            return Points[Position(driver)];
        }

        public string GetDriverName(Driver driver)
        {
            return DriverNames[driver];
        }

        public override string ToString()
        {
            return _name;
        }
    }
}