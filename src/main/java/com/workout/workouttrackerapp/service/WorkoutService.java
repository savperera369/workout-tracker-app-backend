package com.workout.workouttrackerapp.service;

import com.workout.workouttrackerapp.dao.WorkoutRepository;
import com.workout.workouttrackerapp.dto.WorkoutDTO;
import com.workout.workouttrackerapp.model.Workout;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    @Transactional
    public List<WorkoutDTO> getAllWorkouts(){
        return workoutRepository.findAll()
                .stream()
                .map(workout -> new WorkoutDTO(workout.getName(), workout.getDuration(), workout.getDate()))
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkoutDTO getWorkoutById(Integer id){
        Workout workout = workoutRepository.findWorkoutById(id);
        WorkoutDTO clientWorkout = new WorkoutDTO(workout.getName(), workout.getDuration(), workout.getDate());
        return clientWorkout;
    }

    @Transactional
    public void addWorkout(WorkoutDTO newWorkout){
        Workout workout = new Workout();
        workout.setName(newWorkout.name());
        workout.setDuration(newWorkout.duration());
        workout.setDate(newWorkout.date());
        // save to database
        workoutRepository.save(workout);
    }

    @Transactional
    public void deleteWorkoutById(Integer id){
        workoutRepository.deleteById(id);
    }
}
