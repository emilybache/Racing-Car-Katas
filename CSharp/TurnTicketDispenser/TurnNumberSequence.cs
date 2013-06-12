namespace TDDMicroExercises.TurnTicketDispenser
{
    public static class TurnNumberSequence
    {
        private static int _turnNumber = 0;

        public static int GetNextTurnNumber()
        {
            return _turnNumber++;
        }
    }
}
