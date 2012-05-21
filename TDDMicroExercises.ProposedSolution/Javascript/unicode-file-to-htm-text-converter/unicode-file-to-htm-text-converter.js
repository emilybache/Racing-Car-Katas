UnicodeFileToHtmTextConverter = function (textStream) {
	this._textStream = textStream;
};

UnicodeFileToHtmTextConverter.CreateFromFileBlob = function(fileBlob) {
	var textStream = new TextStream(fileBlob);
	return new UnicodeFileToHtmTextConverter(textStream);
};

UnicodeFileToHtmTextConverter.prototype = {

	convertToHtml: function () {

		var text = this._textStream.getText();
		var htmlLines = this._basicHtmlEncode(text);

		return htmlLines;
	},

	_basicHtmlEncode: function (source) {

		var stashNextCharacterAndAdvanceThePointer = function () {
			var c = source.charAt(i);
			i += 1;
			return c;

		};

		var addANewLine = function () {
			convertedLine = convertedLine.join('');
			result.push(convertedLine);
			convertedLine = [];
		};

		var pushACharacterToTheOutput = function () {
			convertedLine.push(characterToConvert);
		};

		var i = 0;
		var result = [];
		var convertedLine = [];
		var characterToConvert = stashNextCharacterAndAdvanceThePointer();
		while (i <= source.length) {

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
		result = result.join('<br />');
		return result;
	}
};
