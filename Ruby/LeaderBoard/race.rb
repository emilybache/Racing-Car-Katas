require_relative './driver'
require_relative './self_driving_car'
class Race
  @@points = [25, 18, 15]

  def initialize(name, drivers)
    @name = name
    @results = drivers
    @driver_names = {}
    @results.each do |driver|
      driver_name = driver.name
      if driver.class == SelfDrivingCar
        driver_name = "Self Driving Car - " + driver.country + " (" + SelfDrivingCar(driver).algorithm_version + ")";
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
