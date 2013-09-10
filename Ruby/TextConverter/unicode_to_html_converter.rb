require 'cgi'

class UnicodeFileToHtmlTextConverter

  def initialize(full_filename_with_path):
    @full_filename_with_path = full_filename_with_path
  end

  def convert_to_html
    File.open(self.full_filename_with_path, "r") do |f|
      html = ""
      while (line = f.gets)
          line = line.chomp()
          html += CGI.escapeHTML(line, quote=True)
          html += "<br />"
      end
      html
  end
end