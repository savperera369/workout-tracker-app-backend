package com.workout.workouttrackerapp.controller;

import com.workout.workouttrackerapp.dao.WorkoutRepository;
import com.workout.workouttrackerapp.model.Workout;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    record NewWorkoutRequest(String name, int duration, String date){}

    // request that comes from the client, we need to capture that to the request body
    // request body will be JSON object that will be mapped into a NewWorkoutRequest object
    @PostMapping
    public void addCustomer(@RequestBody NewWorkoutRequest request){
        Workout workout = new Workout();
        workout.setName(request.name());
        workout.setDuration(request.duration());
        workout.setDate(request.date());
        // save to database
        workoutRepository.save(workout);
    }
    @DeleteMapping("/{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") Integer id){
        workoutRepository.deleteById(id);
    }
}
