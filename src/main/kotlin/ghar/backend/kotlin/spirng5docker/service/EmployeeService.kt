package ghar.backend.kotlin.spirng5docker.service

import ghar.backend.kotlin.spirng5docker.model.Employee
import org.springframework.stereotype.Service

/**
 * Service calls implements the 'busniss-logic', i.e:
 * what is going to be done; processed with the info coming from front-end / client
 * and being received at 'Controller', then returned to same 'Controller' who could in turn
 * send it back the response, if any, to the cleint
 */

@Service
class EmployeeService {

    companion object {
        val employeeDB = mutableMapOf(
                1 to Employee(1, "Zem n Sis", "Managers", 500),
                2 to Employee(1, "Micheal Yong", "Engineers", 450))
    }

    fun createEmployee(employee: Employee) = employeeDB.put(employee.id, employee)

}