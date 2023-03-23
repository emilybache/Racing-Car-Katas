# Tire Pressure Monitoring System Kata

This is an implementation of the Tire Pressure Monitoring System Kata in Rust. The project simulates a tire pressure monitoring system with an Alarm struct that checks the tire pressure using a Sensor struct.

## Prerequisites

- [Rust](https://www.rust-lang.org/tools/install) programming language installed on your system

## Building the Project

To build the project, navigate to the project's root directory and run the following command:

```sh
cargo build
```

This will compile the project and create an executable in the target/debug directory.

## Running the Project
Since this is a library project without a main executable, you can't directly run the project. However, you can use the library in another Rust project by adding the following to the `Cargo.toml` file of the other project:

```toml
[dependencies]
tire_pressure_monitoring_system = { path = "path/to/tire_pressure_monitoring_system" }
```

Then, you can use the `Alarm` and `Sensor` structs from the `tire_pressure_monitoring_system` crate in your Rust code.

## Running Tests
To run the tests for the project, navigate to the project's root directory and run the following command:

```sh
cargo test
```

This will execute all tests in the project and display the test results.

## Generating Documentation
To generate the documentation for the project, navigate to the project's root directory and run the following command:

```sh
cargo doc --open
```

This will generate the documentation and open it in your default web browser.