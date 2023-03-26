use crate::leaderboard::{Driver, Leaderboard, Race, SelfDrivingCar};
use std::collections::HashSet;

fn test_data() -> (
    Driver,
    Driver,
    Driver,
    SelfDrivingCar,
    Vec<Race>,
    Leaderboard,
    Leaderboard,
) {
    let driver1 = Driver::new("Nico Rosberg", "DE");
    let driver2 = Driver::new("Lewis Hamilton", "UK");
    let driver3 = Driver::new("Sebastian Vettel", "DE");
    let driver4 = SelfDrivingCar::new("1.2", "Acme");

    let race1 = Race::new(
        "Australian Grand Prix",
        &[driver1.clone(), driver2.clone(), driver3.clone()],
    );
    let race2 = Race::new(
        "Malaysian Grand Prix",
        &[driver3.clone(), driver2.clone(), driver1.clone()],
    );
    let race3 = Race::new(
        "Chinese Grand Prix",
        &[driver2.clone(), driver1.clone(), driver3.clone()],
    );
    let race4 = Race::new(
        "Fictional Grand Prix 1",
        &[driver1.clone(), driver2.clone(), driver4.driver.clone()],
    );
    let race5 = Race::new(
        "Fictional Grand Prix 2",
        &[driver4.driver.clone(), driver2.clone(), driver1.clone()],
    );
    let race6 = Race::new(
        "Fictional Grand Prix 3",
        &[driver2.clone(), driver1.clone(), driver4.driver.clone()],
    );

    let sample_leaderboard1 = Leaderboard::new(&[race1.clone(), race2.clone(), race3.clone()]);
    let sample_leaderboard2 = Leaderboard::new(&[race4.clone(), race5.clone(), race6.clone()]);

    (
        driver1,
        driver2,
        driver3,
        driver4,
        vec![race1, race2, race3, race4, race5, race6],
        sample_leaderboard1,
        sample_leaderboard2,
    )
}

#[tokio::test]
async fn it_should_sum_the_points() {
    let (_, _, _, _, _, sample_leaderboard1, _) = test_data();

    let results = sample_leaderboard1.driver_results();
    assert!(results.contains_key("Lewis Hamilton"));
    assert_eq!((18 + 18 + 25), *results.get("Lewis Hamilton").unwrap());
}

#[tokio::test]
async fn it_should_find_the_winner() {
    let (_, _, _, _, _, sample_leaderboard1, _) = test_data();

    let result = sample_leaderboard1.driver_rankings();
    assert_eq!("Lewis Hamilton", result[0]);
}

#[tokio::test]
async fn it_should_keep_all_drivers_when_same_points() {
    let (driver1, driver2, driver3, _, _, _, _) = test_data();
    let win_driver1 = Race::new(
        "Australian Grand Prix",
        &[driver1.clone(), driver2.clone(), driver3.clone()],
    );
    let win_driver2 = Race::new(
        "Malaysian Grand Prix",
        &[driver2.clone(), driver1.clone(), driver3.clone()],
    );
    let ex_equo_leaderboard = Leaderboard::new(&[win_driver1, win_driver2]);

    let rankings = ex_equo_leaderboard.driver_rankings();
    let expected_rankings = vec![
        driver1.name.clone(),
        driver2.name.clone(),
        driver3.name.clone(),
    ];
    let rankings_set: HashSet<_> = rankings.into_iter().collect();
    let expected_rankings_set: HashSet<_> = expected_rankings.into_iter().collect();

    assert_eq!(expected_rankings_set, rankings_set);
}
