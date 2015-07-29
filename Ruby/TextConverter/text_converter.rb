require 'cgi'

class UnicodeFileToHtmlTextConverter
  attr_reader :full_path_to_file
  
  def initialize(full_path_to_file)
    @full_path_to_file = full_path_to_file
  end

  def convert_to_html
    f = File.open(@full_path_to_file)
    html = ""
    f.each_line do |line|
      line = line.strip
      html << CGI.escapeHTML(line)
      html << "<br />"
    end

    return html
  end
end
