/*
package com.demo.Test.Repository;



import com.demo.Test.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Interface
// Extends JpaRepository
public interface PersonRepo
        extends JpaRepository<Person, Integer> {
    //Spring data jpa will automatically provide implementation for it when using existsBy{fieldName}
    @Query("SELECT CASE WHEN COUNT(s)>0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId=:id")
    boolean existsById(Integer id);
}

*/
