
#include <string>
#include <iostream>

class StreamConverter
{
    std::istream& m_textStream;

public:
    StreamConverter(std::istream& textStream);

    std::string convertToHtml();

};
