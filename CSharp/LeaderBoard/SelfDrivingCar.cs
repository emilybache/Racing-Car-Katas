namespace TDDMicroExercises.LeaderBoard
{
    public class SelfDrivingCar : Driver
    {
        public SelfDrivingCar(string algorithmVersion, string company) : base(algorithmVersion, company)
        {
            AlgorithmVersion = algorithmVersion;
        }

        public string AlgorithmVersion { get; set; }
    }
}