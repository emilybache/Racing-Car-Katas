#pragma once

#include "Driver.h"

#include <string>
#include <list>
#include <unordered_map>

class Race
{
    static const int POINTS[];

    std::string m_name;
    std::list<Driver> m_results;
    std::unordered_map<Driver, std::string> m_driverNames;

public: 
    Race(std::string const& name, std::list<Driver> const& drivers);

    int position(Driver const& driver);

    int getPoints(Driver driver);

    std::list<Driver> getResults();

    std::string getDriverName(Driver driver);
    
    std::string toString();
};
