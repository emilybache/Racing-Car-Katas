package tddmicroexercises.leaderboard;

class SelfDrivingCar extends Driver {

    private String algorithmVersion;

    SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    String getName() {
        return String.format("Self Driving Car - %s (%s)", this.getCountry(), this.getAlgorithmVersion());
    }

    private String getAlgorithmVersion() {
        return algorithmVersion;
    }

    void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

}
