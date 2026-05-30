package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    @Query("SELECT u FROM User u WHERE u.firstName LIKE %:searchTerm% OR u.lastName LIKE %:searchTerm% OR u.email LIKE %:searchTerm%")
    List<User> searchUsers(@Param("searchTerm") String searchTerm);
}