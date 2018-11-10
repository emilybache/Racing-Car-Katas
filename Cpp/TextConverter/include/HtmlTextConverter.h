
#include <string>
#include <fstream>

class HtmlTextConverter
{
    std::string m_fullFilenameWithPath;

public: 
    HtmlTextConverter(std::string const& fullFilenameWithPath);

    std::string convertToHtml();

    std::string getFilename();
};
