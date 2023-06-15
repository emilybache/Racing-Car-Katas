from typing import List, DefaultDict
from abc import ABC, abstractmethod
from collections import defaultdict


class AbstractDriver(ABC):

    @abstractmethod
    def get_name(self) -> str:
        pass


class Driver(AbstractDriver):
    def __init__(self, name: str, country: str):
        self.name = name
        self.country = country

    def get_name(self) -> str:
        return self.name


class SelfDrivingCar(AbstractDriver):
    def __init__(self, company: str, algorithm_version: str):
        self.company = company
        self.algorithm_version = algorithm_version

    def get_name(self):
        return "Self Driving Car - {} ({})".format(self.company, self.algorithm_version)


class AbstractRace(ABC):

    def __init__(self, name: str, results: List[AbstractDriver], points: List[int]):
        self.name = name
        self.results = results
        self._points = points

    @abstractmethod
    def points(self, driver) -> int:
        pass


class Race(AbstractRace):

    def __init__(self, name, results: List[AbstractDriver], points: List[int] = (25, 18, 15)):
        super().__init__(name, results, points)
        self.driver_names = [driver.get_name() for driver in self.results]

    def points(self, driver) -> int:
        return self._points[self.results.index(driver)] \
            if self._check_driver_in_points(driver) else 0

    def _check_driver_in_points(self, driver) -> bool:
        return driver in self.results and self.results.index(driver) < len(self._points)


class Leaderboard(object):

    def __init__(self, races: List[AbstractRace]):
        self.races = races
        self.total_driver_points = self.driver_points()

    def driver_points(self) -> DefaultDict:
        driver_points = defaultdict(int)
        for race in self.races:
            for driver in race.results:
                driver_points[driver.get_name()] += race.points(driver)
        return driver_points

    def driver_rankings(self) -> List:
        rankings = sorted(self.total_driver_points.items(), key=lambda x: x[1], reverse=True)
        return [name for (name, points) in rankings]

