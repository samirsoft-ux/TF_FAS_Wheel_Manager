package pe.edu.upc.user.services;

import pe.edu.upc.user.entities.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Long>{
    Optional<User> findByUserName(String userName) throws Exception; //Nickname
    Optional<User> findByEmail(String email) throws Exception;
    Optional<User> findByName(String name) throws Exception;
    Optional<User> findByLastName(String lastName) throws Exception;
    Optional<User> findByDni(Long dni) throws Exception;
    Optional<User> findByGender(String gender) throws Exception;
}
