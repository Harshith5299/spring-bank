package com.example.bank2.repository;

import com.example.bank2.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//When you define a repository interface that extends JpaRepository, Spring Data JPA automatically creates a proxy
// implementation of that interface at runtime. This proxy class provides concrete implementations of all the methods
// inherited from JpaRepository (like save(), findById(), findAll(), etc.), even though your repository interface does
// not contain any method implementations. //The proxy class interacts with the underlying JPA provider (like Hibernate)
// to execute queries and perform operations on the database.
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    //By following Spring Data's naming conventions, you can create methods that
    // generate queries without needing to write SQL. These will always return Entity class object(s)

    //Eg: findByEmail, findByNameAndEmail

    //If you want your own query for the method, use @Query("Enter SQL query here")


    //List<AccountEntity> findByFirstNameAndLastName(String name);
    Optional<AccountEntity> findByEmail(String email);

    @Query("SELECT u FROM AccountEntity u WHERE u.email = :email AND u.accountId <> :accountId")
    List<AccountEntity> findByEmailExceptCurrent(@Param("accountId") long accountId, @Param("email") String email);

    //This defines a custom query where the email matches but the accountId is different.
    // :email and :accountId -> These are placeholders for the method parameters, which are provided using
    // @Param("email") and @Param("accountId").
    //List<User> findByEmailExceptAccountId(...): This method returns a list of User objects that match the query.

}
