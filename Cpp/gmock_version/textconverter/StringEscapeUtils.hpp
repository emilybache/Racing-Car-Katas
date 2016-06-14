
#include <string>

class StringEscapeUtils 
{
public:
    static std::string escapeHtml(std::string const& input) 
    {
        std::string output = input;
        output = replaceAll(output, "&", "&amp;");
        output = replaceAll(output, "<", "&lt;");
        output = replaceAll(output, ">", "&gt;");
        output = replaceAll(output, "\"", "&quot;");
        output = replaceAll(output, "'", "&quot;");
        return output;
    }

    static std::string replaceAll(std::string str, const std::string& from, const std::string& to) 
    {
        size_t start_pos = 0;
        while((start_pos = str.find(from, start_pos)) != std::string::npos) 
        {
            str.replace(start_pos, from.length(), to);
            start_pos += to.length(); // Handles case where 'to' is a substring of 'from'
        }
        return str;
    }
};
