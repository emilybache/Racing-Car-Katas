package tddmicroexercises.leaderboard;

public class SelfDrivingCar extends Driver
{

    private final String company;
    private String algorithmVersion;

    public SelfDrivingCar(String algorithmVersion, String company)
    {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    public String getAlgorithmVersion()
    {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion)
    {
        this.algorithmVersion = algorithmVersion;
    }

}
