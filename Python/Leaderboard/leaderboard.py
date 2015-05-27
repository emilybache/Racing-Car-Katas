from collections import defaultdict


class Leaderboard(object):
    
    def __init__(self, races):
        self.races = races

    def driver_rankings(self):
        driver_points = defaultdict(int)
        for race in self.races:
            for driver in race.drivers:
                name = driver.name
                position = race.results.index(driver)
                if isinstance(driver, SelfDrivingCar):
                    name = race.driver_name(driver)
                
                driver_points[name] += Race.points[position]

        rankings = sorted(driver_points.items(), key=lambda x: x[1], reverse=True)
        return [name for (name, points) in rankings]

    def country_rankings(self):
        country_points = defaultdict(int)
        for race in self.races:
            for driver in race.drivers:
                name = driver.country
                if isinstance(driver, SelfDrivingCar):
                    continue
                position = race.results.index(driver)
                country_points[name] += Race.points[position]
            
        rankings = sorted(country_points.items(), key=lambda x: x[1], reverse=True)
        return [name for (name, points) in rankings]


class Driver(object):
    def __init__(self, name, country):
        self.name = name
        self.country = country

class SelfDrivingCar(Driver):
    def __init__(self, algorithm_version, company):
        Driver.__init__(self, None, company)
        self.algorithm_version = algorithm_version
        
class Race(object):

    points = [25, 18, 15]

    def __init__(self, name, drivers):
        self.name = name
        self.drivers = drivers
        self.driver_names = {}
        for driver in drivers:
            name = driver.name
            if isinstance(driver, SelfDrivingCar):
                name = "Self Driving Car - {} ({})".format(driver.country, driver.algorithm_version)
            self.driver_names[driver] = name
        self.results = []

    def driver_name(self, driver):
        return self.driver_names[driver]
