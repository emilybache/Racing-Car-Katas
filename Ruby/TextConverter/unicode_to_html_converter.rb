require 'cgi'

class UnicodeFileToHtmlTextConverter
  attr_accessor :full_filename_with_path
  def initialize(full_filename_with_path)
    @full_filename_with_path = full_filename_with_path
  end

  def convert_to_html
    html = ""
    File.open(self.full_filename_with_path, "r") do |f|
      while (line = f.gets)
          line = line.chomp()
          html += CGI.escapeHTML(line)
          html += "<br />"
      end
    end

    return html
  end
end
