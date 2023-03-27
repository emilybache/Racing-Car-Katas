# Racing Car Leaderboard
This is an implementation of a Racing Car Leaderboard in Rust. The project provides functionality to manage drivers, self-driving cars, and races, and to generate driver rankings based on the results of the races.

## Prerequisites
* Rust: Make sure you have Rust and Cargo installed. If not, follow the instructions [here](https://www.rust-lang.org/tools/install)

## Build
To build the project, navigate to the project directory and run the following command:

```sh
cargo build
```

## Run Tests
To run the test suite, execute the following command in the project directory:

```sh
cargo test
```

## Documentation
To generate documentation for the project, run the following command:

```sh
cargo doc --open
```

This will create and open the documentation in your default web browser.

## Usage
To use the Racing Car Leaderboard in your Rust project, add it as a dependency in your Cargo.toml file:

```toml
[dependencies]
leaderboard = { path = "path/to/leaderboard" }
```

Then, you can use the Driver, SelfDrivingCar, Race, and Leaderboard structs in your Rust code:

```rust
use leaderboard::{Driver, SelfDrivingCar, Race, Leaderboard};

fn main() {
    let driver1 = Driver::new("Driver 1", "Country 1");
    let driver2 = Driver::new("Driver 2", "Country 2");
    let driver3 = Driver::new("Driver 3", "Country 3");

    let race1 = Race::new("Race 1", &[&driver1, &driver2, &driver3]);
    let race2 = Race::new("Race 2", &[&driver3, &driver1, &driver2]);

    let leaderboard = Leaderboard::new(&[race1, race2]);

    let driver_rankings = leaderboard.driver_rankings();

    for (index, driver_name) in driver_rankings.iter().enumerate() {
        println!("{}. {}", index + 1, driver_name);
    }
}
```

Remember to replace "path/to/leaderboard" with the actual path to the leaderboard project directory.