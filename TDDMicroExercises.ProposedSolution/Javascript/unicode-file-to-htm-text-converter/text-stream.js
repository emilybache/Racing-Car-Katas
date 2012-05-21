TextStream = function (fileBlob) {
	this._fileBlob = fileBlob;
};

TextStream.prototype = {

	getText: function () {

		var fileReader = new FileReader();
		var text;
		fileReader.onload = function (evt) {
			text = evt.target.result;
		};

		fileReader.readAsText(this._fileBlob);

		return text;
	}
};
