#pragma once

#include "LeaderBoard/include/Driver.h"
#include "LeaderBoard/include/Race.h"
#include "LeaderBoard/include/SelfDrivingCar.h"
#include "LeaderBoard/include/LeaderBoard.h"

class TestData
{
public:
    static Driver driver1;
    static Driver driver2;
    static Driver driver3;
    static SelfDrivingCar driver4;

    static Race race1;
    static Race race2;
    static Race race3;
    static Race race4;
    static Race race5;
    static Race race6;

    static Leaderboard sampleLeaderboard1;
    static Leaderboard sampleLeaderboard2;
    
    static std::list< Driver > CreateDriverList( Driver a, Driver b, Driver c )
    {
        std::list< Driver > l;
        l.push_back(a);
        l.push_back(b);
        l.push_back(c);
        return std::move(l);
    }
    
    static std::list< Race > CreateRaceList( Race a, Race b, Race c )
    {
        std::list< Race > l;
        l.push_back(a);
        l.push_back(b);
        l.push_back(c);
        return std::move(l);
    }
    
    static std::list< Race > CreateRaceList( Race a, Race b )
    {
        std::list< Race > l;
        l.push_back(a);
        l.push_back(b);
        return std::move(l);
    }
};
