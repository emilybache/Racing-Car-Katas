class FailingBrakingStrategy
  def power_dissipation(velocity, brake)
    percent = (50 + Random.new(1234).rand(50))
    force = brake.force_at_brake_level(percent)*velocity
    brake.set_peak_force(brake.peak_force()*0.99) 
    
    force
  end
end
