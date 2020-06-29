package ghar.backend.kotlin.spirng5docker.service

import org.springframework.stereotype.Service

@Service
class EmployeeService {

    val employeeMap = hashMapOf(1 to "emp-1", 2 to "emp-2", 3 to "emp-3")

    fun findEmployee(id: Int) = employeeMap[id] ?: "Not found"      // used 'Elvis Operator' for default
                                                                    // value in case input value is null

}