package library.repository;

import library.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RecipeRepository extends MongoRepository<Recipe, String>{
    Recipe findByName(String name);
}
