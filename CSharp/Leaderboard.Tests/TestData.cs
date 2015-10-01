namespace TDDMicroExercises.LeaderBoard.Tests
{
    public class TestData
    {
        public static Driver Driver1;
        public static Driver Driver2;
        public static Driver Driver3;
        public static SelfDrivingCar Driver4;
        public static Race Race1;
        public static Race Race2;
        public static Race Race3;
        public static Race Race4;
        public static Race Race5;
        public static Race Race6;
        public static Leaderboard SampleLeaderboard1;
        public static Leaderboard SampleLeaderboard2;

        static TestData()
        {
            Driver1 = new Driver("Nico Rosberg", "DE");
            Driver2 = new Driver("Lewis Hamilton", "UK");
            Driver3 = new Driver("Sebastian Vettel", "DE");
            Driver4 = new SelfDrivingCar("1.2", "Acme");

            Race1 = new Race("Australian Grand Prix", Driver1, Driver2, Driver3);
            Race2 = new Race("Malaysian Grand Prix", Driver3, Driver2, Driver1);
            Race3 = new Race("Chinese Grand Prix", Driver2, Driver1, Driver3);
            Race4 = new Race("Fictional Grand Prix 1", Driver1, Driver2, Driver4);
            Race5 = new Race("Fictional Grand Prix 2", Driver4, Driver2, Driver1);
            Driver4.AlgorithmVersion = "1.3";
            Race6 = new Race("Fictional Grand Prix 3", Driver2, Driver1, Driver4);

            SampleLeaderboard1 = new Leaderboard(Race1, Race2, Race3);
            SampleLeaderboard2 = new Leaderboard(Race4, Race5, Race6);
        }
    }
}