namespace TDDMicroExercises.TurnTicketDispenser
{
    public class TurnTicket
    {
        private readonly int _turnNumber;

        public TurnTicket(int turnNumber)
        {
            _turnNumber = turnNumber;
        }

        public int TurnNumber
        {
            get { return _turnNumber; }
        }
    }
}