
#include "../include/Race.h"
#include "../include/SelfDrivingCar.h"

#include <typeinfo>

const int Race::POINTS[] = { 25, 18, 15 };

Race::Race(std::string const& name, std::list<Driver> const& drivers) : m_name(name), m_results(drivers)
{
    for (Driver& driver : m_results)
    {
        std::string driverName = driver.getName();
        if (typeid(driver) == typeid(SelfDrivingCar))
        {
            driverName = "Self Driving Car - " + driver.getCountry() + " (" + (static_cast<SelfDrivingCar&>(driver)).getAlgorithmVersion() + ")";
        }
        m_driverNames[driver] = driverName;
    }
}

int Race::position(Driver const& driver)
{
    int count = 0;
    for (Driver& d : m_results)
    {
        if ( d == driver ) 
        {
            break;
        }
        ++count;
    }
    return count;
}

int Race::getPoints(Driver driver)
{
    return POINTS[position(driver)];
}

std::list<Driver> Race::getResults()
{
    return m_results;
}

std::string Race::getDriverName(Driver driver)
{
    return m_driverNames[driver];
}

std::string Race::toString()
{
    return m_name;
}
