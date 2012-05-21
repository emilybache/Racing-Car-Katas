using System;

namespace TDDMicroExercises.OneSolution.TurnTicketDispenser.Tests
{
    class MockTurnNumberSequence : ITurnNumberSequence
    {
        private int _expectedNextTurnNumber;
        private int _callsCount = 0;


        public void SetExpectedGetNextTurnNumber(int expectedNextTurnNumber)
        {
            _expectedNextTurnNumber = expectedNextTurnNumber;
        }

        public void Verify()
        {
            if (_callsCount != 1)
            {
                throw new ArgumentOutOfRangeException("GetNextTurnNumber call count", _callsCount, "expected 1.");
            }
        }

        int ITurnNumberSequence.GetNextTurnNumber()
        {
            _callsCount++;
            return _expectedNextTurnNumber;
        }


    }
}