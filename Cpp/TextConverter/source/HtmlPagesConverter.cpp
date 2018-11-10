
#include "../include/HtmlPagesConverter.h"
#include "../include/StringEscapeUtils.h"

#include <sstream>
#include <fstream>

HtmlPagesConverter::HtmlPagesConverter(std::string const& filename) : m_filename(filename)
{
    m_breaks.push_back(0);
    
    std::ifstream reader(m_filename);
    int cumulativeCharCount = 0;
    std::string line;
    while (std::getline(reader,line))
    {
        cumulativeCharCount += line.length() + 1; // add one for the newline
        if (line.find("PAGE_BREAK") != std::string::npos) 
        {
            int page_break_position = cumulativeCharCount;
            m_breaks.push_back(page_break_position);
        }
    }
    reader.close();
}

std::string HtmlPagesConverter::getHtmlPage(int page)
{
    std::ifstream reader(m_filename);
    reader.seekg(m_breaks[page]);
    std::ostringstream htmlPage;
    std::string line;
    while (std::getline(reader,line))
    {
        if (line.find("PAGE_BREAK") != std::string::npos) 
        {
            break;
        }
        htmlPage << StringEscapeUtils::escapeHtml(line);
        htmlPage << "<br />";
    }
    reader.close();
    return htmlPage.str();
}

std::string HtmlPagesConverter::getFilename() 
{
    return m_filename;
}
