# Telemetry System
This is an implementation of a Telemetry System in Rust. The project provides functionality to simulate a telemetry client-server communication system with diagnostic controls.

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
To use the Telemetry System in your Rust project, add it as a dependency in your Cargo.toml file:

```toml
[dependencies]
telemetry_system = { path = "path/to/telemetry_system" }
```

Then, you can use the TelemetryClient and TelemetryDiagnosticControls structs in your Rust code:

```rust
use telemetry_system::{TelemetryClient, TelemetryDiagnosticControls};

fn main() {
    let mut telemetry_client = TelemetryClient::new();
    telemetry_client.connect("example_connection_string");

    let mut diagnostic_controls = TelemetryDiagnosticControls::new();
    diagnostic_controls.check_transmission().unwrap();

    let diagnostic_info = diagnostic_controls.get_diagnostic_info();
    println!("{}", diagnostic_info);
}
```

Remember to replace "path/to/telemetry_system" with the actual path to the telemetry_system project directory.
