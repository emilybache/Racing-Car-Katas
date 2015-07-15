class LeaderBoard
  def initialize(races)
    @races = races
  end

  def driver_points
    driver_points = {}
    @races.each do |race|
      race.results.each do |driver|
        name = race.driver_name(driver)
        driver_points[name] = driver_points.fetch(name, 0) + race.points(driver) 
      end
    end

    return driver_points
  end

  def driver_rankings
    rankings = driver_points.sort_by{|name, points| points}.reverse
    return rankings.collect{|name, points| name}
  end
end

class Driver
  attr_reader :name, :country
  def initialize(name, country)
    @name = name
    @country = country
  end
end

class SelfDrivingCar < Driver
  attr_accessor :algorithm_version
  def initialize(algorithm_version, company)
    super
    @algorithm_version = algorithm_version
    @company = company
  end
end

class Race
  @@points = [25, 18, 15]

  def initialize(name, drivers)
    @name = name
    @results = drivers
    @driver_names = {}
    @results.each do |driver|
      driver_name = driver.name
      if driver.class == SelfDrivingCar
        driver_name = "Self Driving Car - " + driver.country + " (" + driver.algorithm_version + ")";
      end
      @driver_names[driver] = driver_name
    end
  end

  def position(driver)
    @results.index driver
  end

  def points(driver)
    @@points[position(driver)]
  end

  def results
    @results
  end

  def driver_name(driver)
    @driver_names[driver]
  end    
end
