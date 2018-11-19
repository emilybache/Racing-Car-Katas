
#include <string>
#include <vector>

class HtmlPagesConverter 
{
    std::string m_filename;
    std::vector<int> m_breaks;
    
 public:
    HtmlPagesConverter(std::string const& filename);

    std::string getHtmlPage(int page);

    std::string getFilename();
};
