package com.workout.workouttrackerapp.controller;

import com.workout.workouttrackerapp.dao.WorkoutRepository;
import com.workout.workouttrackerapp.model.Workout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutController {
    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("api/workouts")
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }
}