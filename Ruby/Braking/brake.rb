class Brake
  
  def initialize(strategy)
    @strategy = strategy
  end
  
  def set_peak_force new_value
    PEAK_FORCE = new_value
  end

  def peak_force
    PEAK_FORCE
  end

  def power_dissipation velocity
    if @strategy.nil?
      if velocity < 60
        @strategy = SteadyBrakingStrategy.new
      elsif velocity < 120
        @strategy = IntervalBrakingStrategy.new
      else
        @strategy = FailingBrakingStrategy.new
      end
    end
 
    @strategy.power_dissipation(velocity, self)
  end

  def force_at_brake_level percentage_of_peak_force
    PEAK_FORCE * percentage_of_peak_force
  end

  private
  PEAK_FORCE = 30
end
