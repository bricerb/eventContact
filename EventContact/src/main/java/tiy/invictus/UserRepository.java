package tiy.invictus;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Brice on 9/29/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstByName(String name);
}
