package only_gary;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class WorkoutSet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    //Tie to user
    //Date

    @Enumerated(EnumType.ORDINAL)
    @Column(length = 2)
    private Exercise exercise;

    private Integer reps;

    private Integer rpe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Enumerated(EnumType.ORDINAL)
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getRpe() {
        return rpe;
    }

    public void setRpe(Integer rpe) {
        this.rpe = rpe;
    }
}