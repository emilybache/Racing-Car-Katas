describe('Unicode To Htm Converter', function () {

	describe('UnicodeFileToHtmTextConverter', function () {

		it('should convert ampersand', function () {

			var stubTextStream = a.stub(TextStream);
			spyOn(stubTextStream, 'getText').andCallFake(function () { return 'Cut & Paste'; });
			var target = new UnicodeFileToHtmTextConverter(stubTextStream);

			var result = target.convertToHtml();

			expect(result).toEqual('Cut &amp; Paste');
			
		});

		it('should convert greate than and less than', function () {

			var stubTextStream = a.stub(TextStream);
			spyOn(stubTextStream, 'getText').andCallFake(function () { return '10 > 5; 5 < 10'; });
			var target = new UnicodeFileToHtmTextConverter(stubTextStream);

			var result = target.convertToHtml();

			expect(result).toEqual('10 &gt; 5; 5 &lt; 10');

		});


		it('should add breakline for multiple lines', function () {

			var stubTextStream = a.stub(TextStream);
			spyOn(stubTextStream, 'getText').andCallFake(function () { return 'hello\nhow are you doing?\n'; });
			var target = new UnicodeFileToHtmTextConverter(stubTextStream);

			var result = target.convertToHtml();

			expect(result).toEqual('hello<br />how are you doing?<br />');

		});
	});

});
