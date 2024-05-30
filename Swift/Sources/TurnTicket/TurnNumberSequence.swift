import Foundation

public class TurnNumberSequence {
    private static var _turnNumber = 0

    public static func getNextTurnNumber() -> Int {
        _turnNumber += 1

        return _turnNumber
    }
}
