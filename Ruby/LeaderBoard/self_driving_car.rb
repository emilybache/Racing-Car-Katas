require_relative './driver'
class SelfDrivingCar < Driver
  attr_accessor :algorithm_version
  def initialize(algorithm_version, company)
    super
    @algorithm_version = algorithm_version
    @company = company
  end
end
