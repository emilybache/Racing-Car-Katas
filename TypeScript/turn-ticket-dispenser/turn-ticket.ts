export default class TurnTicket {
	private turnNumber: number;

	constructor(turnNumber: number) {
		this.turnNumber = turnNumber;
	}

	public getTurnNumber() {
		return this.turnNumber;
	}
}
