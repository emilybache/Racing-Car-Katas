class Brake
  
  def initialize(strategy)
    @strategy = strategy
  end
  
  def set_peak_force new_value
    @@peak_force = new_value
  end

  def peak_force
    @@peak_force
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
  @@peak_force = 30
end
