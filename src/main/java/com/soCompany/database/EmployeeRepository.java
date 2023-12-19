package com.soCompany.database;

import com.soCompany.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("select e from Employee e where lower(e.firstName) like lower(concat('%', :firstName, '%')) and lower(e.lastName) like lower(concat('%', :lastName, '%'))")
    List<Employee> findAllByNamesContaining(String firstName, String lastName);

    @Query(value = "SELECT e.* FROM Employee e WHERE e.firstname = :firstname", nativeQuery = true)
    public List<Employee> findAllByFirstName(@Param("firstname") String firstName);

    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.position = :position where e.id in (:ids)")
    int updatePosition(String position, Integer... ids);
}
