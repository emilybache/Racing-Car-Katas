require_relative './driver'
require_relative './race'
class LeaderBoard
  def initialize(races)
    @races = races
  end

  def driver_results
    results = {}
    @races.each do |race|
      race.results.each do |driver|
        driver_name = race.driver_name driver
	points = race.points driver
	if results.has_key?(driver_name)
	  results[driver_name] = results[driver_name] + points
	else
	  results[driver_name] = race.points driver
	end
      end
    end
    
    return results
  end

  def driver_rankings
    results = driver_results
    sorted_results = {}
    results.each_key do |driver_name|
      sorted_results[results[driver_name]] = driver_name
    end
    results_list = sorted_results.values

    return results_list.reverse
  end
end
