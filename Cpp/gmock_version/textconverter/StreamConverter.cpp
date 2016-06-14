
#include "StreamConverter.hpp"
#include "StringEscapeUtils.hpp"

#include <fstream>

StreamConverter::StreamConverter(std::istream& textStream) :
    m_textStream(textStream)
{}

std::string StreamConverter::convertToHtml()
{
    std::string line;
    std::string html;
    while (std::getline(m_textStream,line))
    {
        html += StringEscapeUtils::escapeHtml(line);
        html += "<br>";
    }
    return html;
}
