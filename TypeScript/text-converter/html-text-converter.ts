import { readFileSync } from 'fs';

export default class HtmlTextConverter {
	private fullFilenameWithPath: string;

	constructor(fullFilenameWithPath: string) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public convertToHtml(): string {

		const text = readFileSync(this.fullFilenameWithPath).toString();

		function stashNextCharacterAndAdvanceThePointer() {
			const c = text.charAt(i);
			i += 1;
			return c;
		}

		function addANewLine() {
			const line = convertedLine.join('');
			html.push(line);
			convertedLine = [];
		}

		function pushACharacterToTheOutput() {
			convertedLine.push(characterToConvert);
		}

		let i = 0;
		const html: string[] = [];
		let convertedLine: string[] = [];
		let characterToConvert = stashNextCharacterAndAdvanceThePointer();
		while (i <= text.length) {

			switch (characterToConvert) {
				case '<':
					convertedLine.push('&lt;');
					break;
				case '>':
					convertedLine.push('&gt;');
					break;
				case '&':
					convertedLine.push('&amp;');
					break;
				case '\n':
					addANewLine();
					break;
				default:
					pushACharacterToTheOutput();
			}

			characterToConvert = stashNextCharacterAndAdvanceThePointer();
		}

		addANewLine();
		return html.join('<br />');
	}

	public getFilename() {
		return this.fullFilenameWithPath;
	}
}
