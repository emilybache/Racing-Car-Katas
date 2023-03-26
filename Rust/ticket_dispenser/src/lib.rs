// src/lib.rs
pub struct TicketDispenser;

impl TicketDispenser {
    pub fn get_turn_ticket(&self) -> TurnTicket {
        let mut turn_number_sequence = TurnNumberSequence::new();
        let new_turn_number = turn_number_sequence.get_next_turn_number();
        TurnTicket::new(new_turn_number)
    }
}

pub struct TurnNumberSequence {
    turn_number: usize,
}

impl TurnNumberSequence {
    pub fn new() -> Self {
        Self { turn_number: 0 }
    }

    pub fn get_next_turn_number(&mut self) -> usize {
        let next_turn_number = self.turn_number;
        self.turn_number += 1;
        next_turn_number
    }
}

pub struct TurnTicket {
    turn_number: usize,
}

impl TurnTicket {
    pub fn new(turn_number: usize) -> Self {
        Self { turn_number }
    }

    pub fn get_turn_number(&self) -> usize {
        self.turn_number
    }
}

// src/test.rs
#[cfg(test)]
mod tests {
    use super::{TicketDispenser, TurnTicket};

    #[test]
    fn foo() {
        let dispenser = TicketDispenser;
        let ticket = dispenser.get_turn_ticket();
        assert_eq!(ticket.get_turn_number(), 0);
    }
}
