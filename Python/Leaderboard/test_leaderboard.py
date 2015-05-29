import unittest

from leaderboard import *

# Test Data found via http://en.wikipedia.org/wiki/2015_Formula_One_season
driver1 = Driver(name="Nico Rosberg", country="DE")
driver2 = Driver(name="Lewis Hamilton", country="UK")
driver3 = Driver(name="Sebastian Vettel", country="DE")
driver4 = SelfDrivingCar(algorithm_version = "1.2", company="Acme")

race1 = Race("Australian Grand Prix", [driver1, driver2, driver3])
race2 = Race("Malaysian Grand Prix", [driver3, driver2, driver1])
race3 = Race("Chinese Grand Prix", [driver2, driver1, driver3])
race4 = Race("Fictional Grand Prix", [driver1, driver2, driver4])
race5 = Race("Fictional Grand Prix", [driver4, driver2, driver1])
driver4.algorithm_version = "1.3"
race6 = Race("Fictional Grand Prix", [driver2, driver1, driver4])

sample_leaderboard1 = Leaderboard(races=[race1, race2, race3])
sample_leaderboard2 = Leaderboard(races=[race4, race5, race6])

class LeaderboardTest(unittest.TestCase):

    def test_winner(self):
        self.assertEquals("Lewis Hamilton", sample_leaderboard1.driver_rankings()[0])

    def test_driver_points(self):
    	self.assertEquals(18+18+25, sample_leaderboard1.driver_points()["Lewis Hamilton"])

class RaceTest(unittest.TestCase):

    def test_driver_points(self):
        self.assertEquals(25, race1.points(driver1))
        self.assertEquals(18, race1.points(driver2))
        self.assertEquals(15, race1.points(driver3))

if __name__ == "__main__":
    unittest.main()