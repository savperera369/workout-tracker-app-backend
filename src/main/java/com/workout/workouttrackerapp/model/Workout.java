package com.workout.workouttrackerapp.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Workout {
    @Id
    @SequenceGenerator(
            name="workout_id_sequence",
            sequenceName = "workout_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_id_sequence"
    )
    private Integer id;
    private String name;
    private int duration;
    private String date;

    public Workout(Integer id, String name, int duration, String date){
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.date = date;
    }

    public Workout(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return duration == workout.duration && Objects.equals(id, workout.id) && Objects.equals(name, workout.name) && Objects.equals(date, workout.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, date);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", date='" + date + '\'' +
                '}';
    }
}
