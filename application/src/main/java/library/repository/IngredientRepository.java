package library.repository;

import library.models.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
