require_relative './driver'
require_relative './race'
class LeaderBoard
  def initialize(races)
    @races = races
  end

  def driver_points
    driver_points = {}
    @races.each do |race|
      race.results.each do |driver|
        name = race.driver_name(driver)
        driver_points[name] += race.points(driver) 
      end
    end

    return driver_points
  end

  def driver_rankings
    rankings = driver_points.sort_by{|name, points| points}.reverse
    return rankings.collect{|name, points| names}
  end
end
