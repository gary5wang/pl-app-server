package only_gary.controller;

import only_gary.model.WorkoutSet;
import only_gary.repository.WorkoutSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/workoutSet")
public class WorkoutSetController {

    @Autowired
    private WorkoutSetRepository workoutSetRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewWorkout (@RequestParam int userId, @RequestParam WorkoutSet workoutSet) {

        return "test";
    }

    @GetMapping(path="/getAll")
    public @ResponseBody Iterable<WorkoutSet> getAllWorkoutSets() {
        return workoutSetRepository.findAll();
    }
}