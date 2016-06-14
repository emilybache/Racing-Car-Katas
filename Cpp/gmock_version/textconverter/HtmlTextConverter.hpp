
#include <string>
#include <iostream>

class HtmlTextConverter
{
    std::string m_filename;

public:
    HtmlTextConverter(std::string& filename);

    std::string convertToHtml();

    std::string getFilename();
};
