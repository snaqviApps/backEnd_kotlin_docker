package ghar.backend.kotlin.spirng5docker.controller

import com.fasterxml.jackson.databind.util.ClassUtil.defaultValue
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

    @PostMapping("/employee")
    fun createEmployee(@RequestBody employee: Employee): ResponseEntity<String> {
        employeeService.createEmployee(employee)
        return ResponseEntity.status(HttpStatus.CREATED).build<String>()
    }

    @GetMapping("/employee/{idIn}")
    fun getEmployee(@PathVariable("idIn") id: Int)
            = employeeService.getEmployee(id)

    @GetMapping("/employee")
    fun getEmployees(@RequestParam("minAgeC", required = false) minAgeC: Int?,
                     @RequestParam("minSalary", required = false) minSalary: Double?)
            = employeeService.getAllEmployees(minAgeC, minSalary)
}