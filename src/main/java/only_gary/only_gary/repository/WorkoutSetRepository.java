package only_gary.repository;

import only_gary.model.WorkoutSet;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WorkoutSetRepository extends CrudRepository<WorkoutSet, Long> {

}

