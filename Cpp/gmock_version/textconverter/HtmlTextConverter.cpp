
#include "HtmlTextConverter.hpp"
#include "StreamConverter.hpp"
#include "StringEscapeUtils.hpp"

#include <fstream>

HtmlTextConverter::HtmlTextConverter(std::string& filename) :
    m_filename(filename)
{}

std::string HtmlTextConverter::convertToHtml()
{
    std::ifstream reader(m_filename);
    StreamConverter converter(reader);
    return converter.convertToHtml();
}

std::string HtmlTextConverter::getFilename()
{
    return m_filename;
}