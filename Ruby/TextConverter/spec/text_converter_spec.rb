require_relative '../text_converter'
describe UnicodeFileToHtmlTextConverter do
  context "#foo" do
    it "executes correctly" do
      converter = UnicodeFileToHtmlTextConverter.new("foo")

      expect(converter.full_path_to_file).to eq("foo")
    end
  end
end
