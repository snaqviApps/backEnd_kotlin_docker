package ghar.backend.kotlin.spirng5docker.service

import org.springframework.stereotype.Service

/**
 * Service calls implements the 'busniss-logic', i.e:
 * what is going to be done; processed with the info coming from front-end / client
 * and being received at 'Controller', then returned to same 'Controller' who could in turn
 * send it back the response, if any, to the cleint
 */

@Service
class EmployeeService {


     val employeeMap = hashMapOf(1 to "emp-1", 2 to "emp-2", 3 to "emp-3")

    fun findEmployee(id: Int) = employeeMap[id] ?: "Not found"      // used 'Elvis Operator' for default
                                                                    // value in case input value is null

}