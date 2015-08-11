require_relative '../turn_ticket'

describe TurnTicket do
  it "does something" do
    dispenser = TicketDispenser.new
    ticket = dispenser.get_turn_ticket
  end
end
