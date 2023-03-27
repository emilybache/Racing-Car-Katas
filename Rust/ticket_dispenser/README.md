# Turn Ticket Dispenser
This is a Rust implementation of a Turn Ticket Dispenser. The project simulates a ticket dispenser system that assigns sequential turn numbers to customers.

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
To use the Turn Ticket Dispenser in your Rust project, add it as a dependency in your Cargo.toml file:

```toml
[dependencies]
turn_ticket_dispenser = { path = "path/to/turn_ticket_dispenser" }
```

Then, you can use the TicketDispenser, TurnNumberSequence, and TurnTicket structs in your Rust code:

```rust
use turn_ticket_dispenser::{TicketDispenser, TurnNumberSequence, TurnTicket};

fn main() {
    let ticket_dispenser = TicketDispenser;
    let turn_ticket = ticket_dispenser.get_turn_ticket();
    println!("Turn number: {}", turn_ticket.get_turn_number());
}
```

Remember to replace "path/to/turn_ticket_dispenser" with the actual path to the turn_ticket_dispenser project directory.