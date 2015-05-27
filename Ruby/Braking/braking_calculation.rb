class BrakingCalculation
  def self.kinetic_energy(mass, velocity)
    0.5 * mass * velocity * velocity
  end

  def self.velocity(kinetic_energy, mass)
    Math.sqrt((2 * kinetic_energy)/mass)
  end

  def self.stopping_distance(velocity, mass, brake)
    distance = 0
    while velocity < 0
      updated_velocity = updated_velocity(velocity, mass, brake)
      if(updated_velocity < 0)
        updated_velocity = 0
      end
      distance += (velocity + updated_velocity)/2*0.1
      velocity = updated_velocity
    end

    return distance
  end

  def self.updated_velocity(velocity, mass, brake)
    energy_dissipated = brake.power_dissipation(velocity)
    current_kinetic_energy = kinetic_energy(velocity, mass)
    if current_kinetic_energy < 0
       return 0
    else
       velocity(current_kinetic_energy, mass)
    end
  end
end
