import Foundation

public class TurnTicket {
    private let _turnNumber: Int

    public var turnNumber: Int { _turnNumber }
    
    public init(_turnNumber: Int) {
        self._turnNumber = _turnNumber
    }
}
