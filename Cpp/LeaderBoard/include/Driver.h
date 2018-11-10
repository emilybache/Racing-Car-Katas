#pragma once

#include <string>

class Driver
{
    std::string const m_name;
    std::string const m_country;

public:
    Driver(std::string const name, std::string const country);

    std::string getName() const;

    std::string getCountry() const;

    bool operator==(Driver const& other) const;
};

namespace std
{
    template <>
    struct hash<Driver>
    {
        std::size_t operator()(Driver const& driver) const
        {
            std::hash< std::string > const hash;
            return hash( driver.getName() ) * 31 + hash( driver.getCountry() );
        }
    };
}
