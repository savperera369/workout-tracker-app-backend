package com.workout.workouttrackerapp.dao;

import com.workout.workouttrackerapp.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
