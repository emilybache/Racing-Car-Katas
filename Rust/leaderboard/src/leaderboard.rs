use std::collections::HashMap;

#[derive(Clone, PartialEq, Eq, Hash)]
pub struct Driver {
    pub name: String,
    pub country: String,
}

impl Driver {
    pub fn new(name: &str, country: &str) -> Driver {
        Driver {
            name: name.to_string(),
            country: country.to_string(),
        }
    }
}

pub struct SelfDrivingCar {
    pub driver: Driver,
    pub algorithm_version: String,
}

impl SelfDrivingCar {
    pub fn new(algorithm_version: &str, company: &str) -> SelfDrivingCar {
        SelfDrivingCar {
            driver: Driver::new(algorithm_version, company),
            algorithm_version: algorithm_version.to_string(),
        }
    }
}

#[derive(Clone)]
pub struct Race {
    name: String,
    results: Vec<Driver>,
}

impl Race {
    pub fn new(name: &str, drivers: &[Driver]) -> Race {
        Race {
            name: name.to_string(),
            results: drivers.to_vec(),
        }
    }

    pub fn position(&self, driver: &Driver) -> usize {
        self.results.iter().position(|x| x == driver).unwrap()
    }

    pub fn get_points(&self, driver: &Driver) -> i32 {
        let points = [25, 18, 15];
        points[self.position(driver)]
    }

    pub fn get_results(&self) -> &[Driver] {
        &self.results
    }
}

pub struct Leaderboard {
    races: Vec<Race>,
}

impl Leaderboard {
    pub fn new(races: &[Race]) -> Leaderboard {
        Leaderboard {
            races: races.to_vec(),
        }
    }

    pub fn driver_results(&self) -> HashMap<String, i32> {
        let mut results = HashMap::new();
        for race in &self.races {
            for driver in race.get_results() {
                let driver_name = &driver.name;
                let points = race.get_points(driver);
                results
                    .entry(driver_name.to_string())
                    .and_modify(|e| *e += points)
                    .or_insert(points);
            }
        }
        results
    }

    pub fn driver_rankings(&self) -> Vec<String> {
        let mut results: Vec<(String, i32)> = self.driver_results().into_iter().collect();
        results.sort_unstable_by_key(|(_, points)| -points);
        results.into_iter().map(|(name, _)| name).collect()
    }
}
