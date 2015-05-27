"""
Sample data taken from wikipedia (eg http://en.wikipedia.org/wiki/2014_Formula_One_season)
"""
import unittest

from leaderboard import *

class LeaderboardTest(unittest.TestCase):

    def test_leaderboard(self):
        driver1 = Driver(name="Nico Rosberg", country="DE")
        driver2 = Driver(name="Lewis Hamilton", country="UK")
        driver3 = Driver(name="Sebastian Vettel", country="DE")
        race1 = Race("Australian Grand Prix", [driver1, driver2, driver3])
        race1.results = [driver1, driver2, driver3]
        race2 = Race("Malaysian Grand Prix", [driver1, driver2, driver3])
        race2.results = [driver3, driver2, driver1]
        race3 = Race("Chinese Grand Prix", [driver1, driver2, driver3])
        race3.results = [driver2, driver1, driver3]

        leaderboard = Leaderboard(races=[race1, race2, race3])

        self.assertEquals("Lewis Hamilton", leaderboard.driver_rankings()[0])




if __name__ == "__main__":
    unittest.main()