package ghar.backend.kotlin.spirng5docker.controller

import ghar.backend.kotlin.spirng5docker.model.Employee
import ghar.backend.kotlin.spirng5docker.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Contoller {

    @Autowired
    lateinit var employeeService: EmployeeService                

    @PostMapping("/employeeEndPoint")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<String> {
        employeeService.createEmployee(employee)
        return ResponseEntity.status(HttpStatus.CREATED).build<String>()
    }
}