package com.soCompany.database;

import com.soCompany.entity.Employee;
import com.soCompany.dto.unusable.EmployeeInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Slice<Employee> findAllBy(Pageable pageable);
    public List<Employee> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("select e from Employee e where lower(e.firstName) like lower(concat('%', :firstName, '%')) and lower(e.lastName) like lower(concat('%', :lastName, '%'))")
    List<Employee> findAllByNamesContaining(String firstName, String lastName);

    @Query(value = "SELECT e.* FROM Employee e WHERE e.firstname = :firstname", nativeQuery = true)
    public List<Employee> findAllByFirstName(@Param("firstname") String firstName);

    @Modifying(clearAutomatically = true)
    @Query("update Employee e set e.position = :position where e.id in (:ids)")
    int updatePosition(String position, Integer... ids);

    @Query(value = "SELECT e.employee_id as id, e.first_name as firstName, e.company_id as company_id FROM employees e" +
            " WHERE e.company_id = :companyId", nativeQuery = true)
    List<EmployeeInfo> findAllByCompanyID(Integer companyId); // This method can not parse info to EmployeeInfo and throws exception

    Optional<Employee> findFirstBySalaryIsNotNullOrderBySalaryDesc();
    List<Employee> findFirst3BySalaryIsNotNullOrderBySalaryDesc();

    List<Employee> findFirst3By(Sort sort);
}
