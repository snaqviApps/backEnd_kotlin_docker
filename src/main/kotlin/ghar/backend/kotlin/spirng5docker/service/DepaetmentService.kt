package ghar.backend.kotlin.spirng5docker.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.kotlin.core.publisher.toFlux

@Service
class DepaetmentService {

    @Autowired
    lateinit var employeeService: EmployeeService

    fun getAllDepartments() = employeeService.getAllEmployees()
            .map { it.department }
            .distinct()
            .collectList()
}