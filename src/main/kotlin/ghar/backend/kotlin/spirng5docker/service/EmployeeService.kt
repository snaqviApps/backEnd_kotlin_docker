package ghar.backend.kotlin.spirng5docker.service

import ghar.backend.kotlin.spirng5docker.model.Employee
import ghar.backend.kotlin.spirng5docker.model.EmployeeUpdateReq
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toFlux
import reactor.kotlin.core.publisher.toMono

/**
 * Service calls implements the 'busniss-logic', i.e:
 * what is going to be done; processed with the info coming from front-end / client
 * and being received at 'Controller', then returned to same 'Controller' who could in turn
 * send it back the response, if any, to the cleint
 */

@Service
class EmployeeService {

    companion object {
        val employeeDb = mutableMapOf(
                1 to Employee(1, "Zee Sis", 25, "HR", 500.57),
                2 to Employee(2, "Bro Rey", 28,"Technology", 450.20),
                3 to Employee(3, "Bro Rey - II", 48,"Excutive", 1450.20))
    }

    fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)  // for-POST

    fun getEmployee(id: Any) = employeeDb[id]?.toMono()

    fun getAllEmployees(minAgeS: Int? = null, minSalaryS: Double? = null)
            = employeeDb.values.toFlux()
                .filter { it.age >= minAgeS ?: Int.MIN_VALUE }
                .filter { it.salary >= minSalaryS ?: Double.MIN_VALUE }

    fun updateEmployee(id: Int, employeeUpdateReq: EmployeeUpdateReq){
        val employeeOnDb = employeeDb[id]!!
        employeeDb[id] =
                Employee(employeeOnDb.id, employeeOnDb.name, employeeOnDb.age,
                        employeeUpdateReq.department ?: employeeOnDb.department,
                        employeeUpdateReq.salary ?: employeeOnDb.salary
                )
    }
}


