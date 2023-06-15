import unittest

from leaderboard import *

# Test Data found via http://en.wikipedia.org/wiki/2015_Formula_One_season
driver1 = Driver(name="Nico Rosberg", country="DE")
driver2 = Driver(name="Lewis Hamilton", country="UK")
driver3 = Driver(name="Sebastian Vettel", country="DE")
driver4 = SelfDrivingCar(algorithm_version="1.2", company="Acme")

race1 = Race("Australian Grand Prix", [driver1, driver2, driver3])
race2 = Race("Malaysian Grand Prix", [driver3, driver2, driver1])
race3 = Race("Chinese Grand Prix", [driver2, driver1, driver3])
race4 = Race("Fictional Grand Prix", [driver1, driver2, driver4])
race5 = Race("Fictional Grand Prix", [driver4, driver2, driver1])
driver4.algorithm_version = "1.3"
race6 = Race("Fictional Grand Prix", [driver2, driver1, driver4])

race7 = Race("Charity race", [driver2, driver1, driver4], points=[0, 0, 0])
race8 = Race("Charity race", [driver2, driver1, driver4, driver3], points=[10, 8, 5])

sample_leaderboard1 = Leaderboard(races=[race1, race2, race3])
sample_leaderboard2 = Leaderboard(races=[race4, race5, race6])


class LeaderboardTest(unittest.TestCase):

    def test_winner(self):
        ranking = sample_leaderboard1.driver_rankings()
        self.assertEquals("Lewis Hamilton", ranking[0])

    def test_driver_points(self):
        driver_points = sample_leaderboard1.driver_points()
        self.assertEquals(18 + 18 + 25, driver_points["Lewis Hamilton"])
        self.assertEquals(15 + 25 + 15, driver_points["Sebastian Vettel"])
        self.assertEquals(25 + 15 + 18, driver_points["Nico Rosberg"])

        driver_points = sample_leaderboard2.driver_points()
        self.assertEquals(15 + 25 + 15, driver_points["Self Driving Car - Acme (1.3)"])
        self.assertEquals(18 + 18 + 25, driver_points["Lewis Hamilton"])
        self.assertEquals(25 + 15 + 18, driver_points["Nico Rosberg"])


class RaceTest(unittest.TestCase):

    def test_driver_points(self):
        self.assertEquals(25, race1.points(driver1))
        self.assertEquals(18, race1.points(driver2))
        self.assertEquals(15, race1.points(driver3))

        self.assertEquals(25, race2.points(driver3))
        self.assertEquals(18, race2.points(driver2))
        self.assertEquals(15, race2.points(driver1))

        self.assertEquals(25, race3.points(driver2))
        self.assertEquals(18, race3.points(driver1))
        self.assertEquals(15, race3.points(driver3))

        # test with a driver not classified
        self.assertEquals(0, race4.points(driver3))

        # charity race: race with different points
        self.assertEquals(0, race7.points(driver1))

        # race with 4 drivers and three points
        self.assertEquals(10, race8.points(driver2))
        self.assertEquals(8, race8.points(driver1))
        self.assertEquals(5, race8.points(driver4))
        self.assertEquals(0, race8.points(driver3))


if __name__ == "__main__":
    unittest.main()
