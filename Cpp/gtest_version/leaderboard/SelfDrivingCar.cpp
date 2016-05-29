
#include "SelfDrivingCar.hpp"

SelfDrivingCar::SelfDrivingCar(std::string algorithmVersion, 
                               std::string company) : Driver(algorithmVersion, company), m_algorithmVersion( algorithmVersion )
{}

std::string SelfDrivingCar::getAlgorithmVersion()
{
    return m_algorithmVersion;
}

void SelfDrivingCar::setAlgorithmVersion(std::string algorithmVersion)
{
    m_algorithmVersion = algorithmVersion;
}
