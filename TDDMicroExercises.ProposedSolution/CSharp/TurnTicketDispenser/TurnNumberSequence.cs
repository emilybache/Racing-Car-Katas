namespace TDDMicroExercises.OneSolution.TurnTicketDispenser
{
    public class TurnNumberSequence : ITurnNumberSequence
    {
        public static readonly TurnNumberSequence GlobalTurnNumberSequence = new TurnNumberSequence();
        
        private int _turnNumber = 0;

        public int GetNextTurnNumber()
        {
            return _turnNumber++;
        }
    }
}
