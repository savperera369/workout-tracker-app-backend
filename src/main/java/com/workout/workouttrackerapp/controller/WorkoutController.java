package com.workout.workouttrackerapp.controller;

import com.workout.workouttrackerapp.dao.WorkoutRepository;
import com.workout.workouttrackerapp.dto.WorkoutDTO;
import com.workout.workouttrackerapp.model.Workout;
import com.workout.workouttrackerapp.service.WorkoutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping
    public List<WorkoutDTO> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{workoutId}")
    public WorkoutDTO getWorkoutById (@PathVariable("workoutId") Integer id){
        return workoutService.getWorkoutById(id);
    }

    // request that comes from the client, we need to capture that to the request body
    // request body will be JSON object that will be mapped into a NewWorkoutRequest object
    @PostMapping
    public void addCustomer(@RequestBody WorkoutDTO request){
        workoutService.addWorkout(request);
    }
    @DeleteMapping("/{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") Integer id){
        workoutService.deleteWorkoutById(id);
    }
}
