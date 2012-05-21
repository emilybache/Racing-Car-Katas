namespace TDDMicroExercises.OneSolution.TurnTicketDispenser
{
    public class TicketDispenser
    {
        ITurnNumberSequence turnNumberSequence;

        public TicketDispenser() : this(TurnNumberSequence.GlobalTurnNumberSequence)
        {
        }


        public TicketDispenser(ITurnNumberSequence turnNumberSequence)
        {
            this.turnNumberSequence = turnNumberSequence;
        }

        public TurnTicket GetTurnTicket()
        {
            int newTurnNumber = turnNumberSequence.GetNextTurnNumber();
            TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

            return newTurnTicket;
        }
    }
}
