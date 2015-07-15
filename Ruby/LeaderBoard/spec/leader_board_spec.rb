require_relative '../leader_board'
describe LeaderBoard do
  before :each do
    @driver_1 = Driver.new("Nico Rosberg", "DE")
    @driver_2 = Driver.new("Lewis Hamilton", "UK")
    @driver_3 = Driver.new("Sebastian Vettel", "DE")
    @driver_4 = SelfDrivingCar.new("1.2", "ACME")

    @race_1 = Race.new("Australian Grand Prix", [@driver_1, @driver_2, @driver_3])
    @race_2 = Race.new("Malaysian Grand Prix", [@driver_3, @driver_2, @driver_1])
    @race_3 = Race.new("Chinese Grand Prix", [@driver_2, @driver_1, @driver_3])
    @race_4 = Race.new("Fictional Grand Prix", [@driver_1, @driver_2, @driver_4])
    @race_5 = Race.new("Fictional Grand Prix", [@driver_4, @driver_2, @driver_1])
    @driver_4.algorithm_version = "1.3"
    @race_6 = Race.new("Fictional Grand Prix", [@driver_2, @driver_1, @driver_4])

    @sample_leader_board_1 = LeaderBoard.new([@race_1, @race_2, @race_3])
    @sample_leader_board_2 = LeaderBoard.new([@race_4, @race_5, @race_6])
  end
  
  context "#winner" do
    it "returns the driver with the most points" do
      expect(@sample_leader_board_1.driver_rankings.first).to eq("Lewis Hamilton")
    end
  end

  context "#driver_points" do
    it "returns the correct number of points for a driver" do
      expect(@sample_leader_board_2.driver_points["Lewis Hamilton"]).to eq(18 + 18 + 25)
    end
  end
end
