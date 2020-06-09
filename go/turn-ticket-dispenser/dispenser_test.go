package turnticket

import "testing"

func TestTicketDispenser(t *testing.T) {
	t.Run("Do something", func(t *testing.T) {
		d := TicketDispenser{}
		d.GetTurnTicket()
	})
}
