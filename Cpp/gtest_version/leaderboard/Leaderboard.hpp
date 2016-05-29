
#include <list>
#include <map>

#include "Race.hpp"

class Leaderboard
{
    std::list<Race> m_races;

public:
    Leaderboard(std::list<Race> const& races);

    std::map<std::string, int> driverResults();

    std::list<std::string> driverRankings();
};
