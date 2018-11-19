#include "../include/Driver.h"

Driver::Driver(std::string const name, std::string const country) : m_name(name), m_country(country) 
{}

std::string Driver::getName() const
{
    return m_name;
}

std::string Driver::getCountry() const
{
    return m_country;
}

bool Driver::operator==(Driver const& other) const
{
    if (this == &other)
    {
        return true;
    }
    return (m_name.compare(other.m_name) == 0 && m_country.compare(other.m_country) == 0);
}
