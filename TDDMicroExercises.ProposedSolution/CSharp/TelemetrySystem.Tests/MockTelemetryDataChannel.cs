using System;

namespace TDDMicroExercises.OneSolution.TelemetrySystem.Tests
{
    public class MockTelemetryDataChannel : IDataChannel
    {
        private string _extectedSendMessage;
        private string _actualSendMessage;
        private int _sendCallsCount = 0;

        private string _receiveReturnValue;
        private int _receiveCallsCount = 0;

        public void SetExpectedCallToSend(string extectedSendMessage)
        {
            _extectedSendMessage = extectedSendMessage;
        }

        public void SetExpectedCallToReceive(string returnValue)
        {
            _receiveReturnValue = returnValue;
        }

        public void Verify()
        {
            if (_sendCallsCount != 1)
            {
                throw new ArgumentOutOfRangeException("Send calls count", _sendCallsCount, "expected 1.");
            }

            if (_extectedSendMessage != _actualSendMessage)
            {
                throw new ArgumentOutOfRangeException("Send argument", _actualSendMessage, "expected '" + _extectedSendMessage + "'.");
            }

            if (_receiveCallsCount != 1)
            {
                throw new ArgumentOutOfRangeException("Receive calls count", _receiveCallsCount, "expected 1.");
            }
        }

        void IDataChannel.Send(string message)
        {
            _sendCallsCount += 1;
            _actualSendMessage = message;
        }

        string IDataChannel.Receive()
        {
            _receiveCallsCount += 1;
            return _receiveReturnValue;
        }
    }
}