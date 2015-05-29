package tddmicroexercises.leaderboard

class Driver(val name: String, val country: String) {}

class SelfDrivingCar(var algorithmVersion: String, val company: String) extends Driver(algorithmVersion, company)
