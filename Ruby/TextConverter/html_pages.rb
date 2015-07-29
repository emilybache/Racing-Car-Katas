require 'cgi'
class HtmlPagesConverter
  def initialize(filename)
    @filename = filename
    @breaks = [0]
    File.open(@filename, "r") do |f|
      f.each_line do |line|
        line = line.strip
        if line.include?("PAGE_BREAK")
          page_break_position = f.tell
          @breaks << f.tell
        end
      end
      @breaks << f.tell
    end
  end

  def get_html_page(page)
    # Return html page with the given page number
    # (zero-indexed)
    page_start = @breaks[page]
    page_end = @breaks[page + 1]
    html = ""
    File.open(@filename, "r") do |f|
      f.seek(page_start)
      while f.tell != page_end
        line = f.readline
        line = line.strip
        next if line.include?("PAGE_BREAK")
        html << CGI.escapeHTML(line)
        html << "<br />"
        
      end
    end
    
    return html
  end
end
