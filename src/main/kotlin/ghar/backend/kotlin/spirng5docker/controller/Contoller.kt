package ghar.backend.kotlin.spirng5docker.controller

import ghar.backend.kotlin.spirng5docker.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Contoller {

    val employeeService: EmployeeService = EmployeeService()

    @GetMapping("/{sId}")
    fun getName(@PathVariable("sId") id : Int): String{    // local 'id' maps to 'sId' coming from
                                                                 // 'PathVariable' (from Controller)
        return "Name: ${employeeService.findEmployee(id)}\n"
    }
}