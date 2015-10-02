using System.Collections.Generic;

namespace TDDMicroExercises.LeaderBoard
{
    public class Leaderboard
    {
        private readonly List<Race> _races = new List<Race>();

        public Leaderboard(params Race[] races)
        {
            _races.AddRange(races);
        }

        public Dictionary<string, int> DriverResults()
        {
            var results = new Dictionary<string, int>();
            foreach (var race in _races)
            {
                foreach (var driver in race.Results)
                {
                    var driverName = race.GetDriverName(driver);
                    var points = race.GetPoints(driver);
                    if (results.ContainsKey(driverName))
                    {
                        results[driverName] = results[driverName] + points;
                    }
                    else
                    {
                        results.Add(driverName, 0 + points);
                    }
                }
            }
            return results;
        }

        public List<string> DriverRankings()
        {
            var results = DriverResults();
            var resultsList = new List<string>(results.Keys);
            resultsList.Sort();
            return resultsList;
        }
    }
}