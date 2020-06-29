package ghar.backend.kotlin.spirng5docker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Contoller {

    @GetMapping("/{pName}")
    fun getName(@PathVariable("pName") name : String): String{
        return "Name: $name\n"
    }
}