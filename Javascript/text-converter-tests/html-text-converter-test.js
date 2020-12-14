/* globals describe, it */
var chai = require('chai');
chai.should();

var HtmlTextConverter = require('../text-converter/html-text-converter.js');

describe('Html Converter', function() {

	describe('HtmlTextConverter', function() {

		it('foo', function() {
			var converter = new HtmlTextConverter('foo');
			converter.getFilename().should.equal('fixme');
		});

	});

});
