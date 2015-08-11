class TurnTicket
  def initialize turn_number
    @turn_number = turn_number
  end
end

class TurnNumberSequence

  @@turn_number = -1
  
  def self.next_turn_number
    @@turn_number += 1

    @@turn_number
  end
end

class TicketDispenser
  def get_turn_ticket
    new_turn_number = TurnNumberSequence.next_turn_number
    new_turn_ticket = TurnTicket.new(new_turn_number)

    new_turn_ticket
  end
end
