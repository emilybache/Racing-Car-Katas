import unittest

from turn_ticket import TicketDispenser

class TicketDispenserTest(unittest.TestCase):

    def test_do_something(self):
        dispenser = TicketDispenser()
        ticket = dispenser.getTurnTicket()


if __name__ == "__main__":
	unittest.main()