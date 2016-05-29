
#include "Leaderboard.hpp"

#include <algorithm>

Leaderboard::Leaderboard(std::list<Race> const& races) : m_races(races)
{}

std::map<std::string, int> Leaderboard::driverResults()
{
    std::map<std::string, int> results;
    for (Race& race : m_races)
    {
        for (Driver& driver : race.getResults())
        {
            std::string driverName = race.getDriverName(driver);
            int points = race.getPoints(driver);
            if (results.end() != results.find(driverName))
            {
                results[driverName] += points;
            } else
            {
                results[driverName] = points;
            }
        }
    }
    return results;
}

std::list<std::string> Leaderboard::driverRankings()
{
    std::map<std::string, int> results = driverResults();
    std::list<std::string> resultsList;
    for(std::map<std::string, int>::value_type const& v : results)
    { 
        resultsList.push_back( v.first ); 
    }
    resultsList.sort([&results](std::string const& driverName1, std::string const& driverName2)
    {
        return results[driverName1] > results[driverName2];
    });
    return resultsList;
}
