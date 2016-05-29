
#include "../include/TestData.h"

Driver TestData::driver1("Nico Rosberg", "DE");
Driver TestData::driver2("Lewis Hamilton", "UK");
Driver TestData::driver3("Sebastian Vettel", "DE");
SelfDrivingCar TestData::driver4("1.3", "Acme");

Race TestData::race1("Australian Grand Prix", TestData::CreateDriverList(driver1, driver2, driver3));
Race TestData::race2("Malaysian Grand Prix", TestData::CreateDriverList(driver3, driver2, driver1));
Race TestData::race3("Chinese Grand Prix", TestData::CreateDriverList(driver2, driver1, driver3));
Race TestData::race4("Fictional Grand Prix 1", TestData::CreateDriverList(driver1, driver2, driver4));
Race TestData::race5("Fictional Grand Prix 2", TestData::CreateDriverList(driver4, driver2, driver1));
Race TestData::race6("Fictional Grand Prix 3", TestData::CreateDriverList(driver2, driver1, driver4));

Leaderboard TestData::sampleLeaderboard1(TestData::CreateRaceList(race1, race2, race3));
Leaderboard TestData::sampleLeaderboard2(TestData::CreateRaceList(race4, race5, race6));
