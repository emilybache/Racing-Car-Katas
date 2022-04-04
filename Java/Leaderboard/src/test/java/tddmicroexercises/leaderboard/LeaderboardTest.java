package tddmicroexercises.leaderboard;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeaderboardTest {
  private static final Driver MARCO = new Driver("Marco", "Italy");
  private static final Driver ALEX = new Driver("Alex", "Austria");
  private static final Driver STEFAN = new Driver("Stefan", "Serbia");
  private static final Driver NEMANJA = new Driver("Nemanja", "Serbia");

  @Test
  void driverRankings_givenOneRace_thenDriversShouldHaveExpectedPositions() {
    Race race = new Race("Mugello", MARCO, ALEX, STEFAN);
    Leaderboard sut = new Leaderboard(race);

    List<String> result = sut.driverRankings();

    assertThat(result).hasSize(3);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
    assertThat(result.get(1)).isEqualTo(ALEX.getName());
    assertThat(result.get(2)).isEqualTo(STEFAN.getName());
  }

  @Test
  void driverRankings_noRaceGiven_thenNoDrivers() {
    Leaderboard sut = new Leaderboard();

    List<String> result = sut.driverRankings();

    assertThat(result).isEmpty();
  }

  @Test
  void driverRankings_givenOneDriver_thenResultHasSizeOfOne() {
    Race race = new Race("Mugello", MARCO);
    Leaderboard sut = new Leaderboard(race);

    List<String> result = sut.driverRankings();

    assertThat(result).hasSize(1);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
  }

  @Test
  void driverRankings_givenMoreThan3_thenShowFirst3() {
    Race race = new Race("Mugello", MARCO, ALEX, STEFAN, NEMANJA);
    Leaderboard sut = new Leaderboard(race);

    assertThrows(ArrayIndexOutOfBoundsException.class, sut::driverRankings);
  }

  @Test
  void driverRankings_givenTwoRacesWithSameOrder_thenDriversShouldHaveExpectedPositions() {
    Race raceMugello = new Race("Mugello", MARCO, ALEX, STEFAN);
    Race raceMisano = new Race("Misano", MARCO, ALEX, STEFAN);
    Leaderboard sut = new Leaderboard(raceMugello, raceMisano);

    List<String> result = sut.driverRankings();

    assertThat(result).hasSize(3);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
    assertThat(result.get(1)).isEqualTo(ALEX.getName());
    assertThat(result.get(2)).isEqualTo(STEFAN.getName());
  }

  @Test
  void
      driverRankings_givenTwoRacesWithTwoDifferentWinners_thenDriversShouldHaveExpectedPositions() {
    Race raceMugello = new Race("Mugello", MARCO);
    Race raceMisano = new Race("Misano", ALEX);
    Leaderboard sut = new Leaderboard(raceMugello, raceMisano);

    List<String> result = sut.driverRankings();

    // note: the order of MARCO and ALEX is JDK/platform dependent
    assertThat(result).hasSize(2);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
    assertThat(result.get(1)).isEqualTo(ALEX.getName());
  }

  @Test
  void
      driverRankings_givenTwoRacesWithTwoDifferentWinnersAnotherOrder_thenDriversShouldHaveExpectedPositions() {
    Race raceMugello = new Race("Mugello", MARCO);
    Race raceMisano = new Race("Misano", ALEX);
    Leaderboard sut = new Leaderboard(raceMisano, raceMugello);

    List<String> result = sut.driverRankings();

    // note: the order of MARCO and ALEX is JDK/platform dependent
    assertThat(result).hasSize(2);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
    assertThat(result.get(1)).isEqualTo(ALEX.getName());
  }

  @Test
  void driverRankings_givenTwoRacesWithRandomOrder_thenDriversShouldHaveExpectedPositions() {
    Race raceMugello = new Race("Mugello", MARCO, ALEX, STEFAN);
    Race raceNavak = new Race("Navak", STEFAN, MARCO, ALEX);
    Leaderboard sut = new Leaderboard(raceMugello, raceNavak);

    List<String> result = sut.driverRankings();

    assertThat(result).hasSize(3);
    assertThat(result.get(0)).isEqualTo(MARCO.getName());
    assertThat(result.get(1)).isEqualTo(STEFAN.getName());
    assertThat(result.get(2)).isEqualTo(ALEX.getName());
  }

  @Test
  void driverRankings_givenTwoRacesWithFourDrivers_thenDriversShouldHaveExpectedPositions() {
    Race raceMugello = new Race("Mugello", MARCO, ALEX, STEFAN);
    Race raceNavak = new Race("Navak", STEFAN, NEMANJA, ALEX);
    Leaderboard sut = new Leaderboard(raceMugello, raceNavak);

    List<String> result = sut.driverRankings();

    assertThat(result).hasSize(4);
    assertThat(result.get(0)).isEqualTo(STEFAN.getName());
    assertThat(result.get(1)).isEqualTo(ALEX.getName());
    assertThat(result.get(2)).isEqualTo(MARCO.getName());
    assertThat(result.get(3)).isEqualTo(NEMANJA.getName());
  }

  @Test
  void driverResults_givenOneDriverAndOneRace_thenDriverPointsEqualTo25() {
    Race race = new Race("Mugello", MARCO);
    Leaderboard sut = new Leaderboard(race);

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).containsEntry(MARCO.getName(), 25);
  }

  @Test
  void driverResults_givenTwoDriversAndOneRace_thenDriverPointsShouldBeAsExpected() {
    Race race = new Race("Mugello", MARCO, ALEX);
    Leaderboard sut = new Leaderboard(race);

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).containsEntry(MARCO.getName(), 25);
    assertThat(result).containsEntry(ALEX.getName(), 18);
  }

  @Test
  void driverResults_givenThreeDriversAndOneRace_thenDriverPointsShouldBeAsExpected() {
    Race race = new Race("Navak", STEFAN, MARCO, ALEX);
    Leaderboard sut = new Leaderboard(race);

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).containsEntry(STEFAN.getName(), 25);
    assertThat(result).containsEntry(MARCO.getName(), 18);
    assertThat(result).containsEntry(ALEX.getName(), 15);
  }

  @Test
  void driverResults_givenThreeDriversAndTwoRaces_thenDriverPointsShouldBeAsExpected() {
    Race raceNavak = new Race("Navak", STEFAN, MARCO, ALEX);
    Race raceMugello = new Race("Mugello", MARCO, ALEX, STEFAN);

    Leaderboard sut = new Leaderboard(raceNavak, raceMugello);

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).containsEntry(STEFAN.getName(), 25 + 15);
    assertThat(result).containsEntry(MARCO.getName(), 18 + 25);
    assertThat(result).containsEntry(ALEX.getName(), 15 + 18);
  }

  @Test
  void driverResults_givenFourDriversAndTwoRaces_thenDriverPointsShouldBeAsExpected() {
    Race raceNavak = new Race("Navak", STEFAN, MARCO, ALEX);
    Race raceMugello = new Race("Mugello", MARCO, ALEX, NEMANJA);

    Leaderboard sut = new Leaderboard(raceNavak, raceMugello);

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).containsEntry(STEFAN.getName(), 25);
    assertThat(result).containsEntry(MARCO.getName(), 18 + 25);
    assertThat(result).containsEntry(ALEX.getName(), 15 + 18);
    assertThat(result).containsEntry(NEMANJA.getName(), 15);
  }

  @Test
  void driverResults_givenLeaderboardWithoutRaces_thenResultShouldBeEmpty() {
    Leaderboard sut = new Leaderboard();

    Map<String, Integer> result = sut.driverResults();

    assertThat(result).isEmpty();
  }
}
