package com.pleitez.helloworld.controllers.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api1")
public class HelloController {

    //Recibiendo info del Frontend
    @GetMapping("/hello/{toWho}")
    public String sayHello(@PathVariable String toWho){
        return "Saying hello to "+ toWho;
    }
    @GetMapping("/bye/{toWho}/{toWhere}/{butWhy}")
    public String sayBye(@PathVariable String toWho,
                         @PathVariable String toWhere,
                         @PathVariable String butWhy){
        return "Saying Bye to "+ toWho+" in the "+toWhere+", "+butWhy;
    }
   @PostMapping("/Cliente")
    public void crearCliente (@RequestBody Cliente cli){
        System.out.println("Cliente Creado");
        System.out.println("nombre "+ cli.getNombre());
        System.out.println("apellido "+ cli.getApellido());
    }

    //Enviando info al Frontend Change usando ResponseBody

    @GetMapping("/Cliente/traer")
    @ResponseBody  //devuelve la info en el body de la response
    public List<Cliente> traerClientes(){
        //Simulando los datos de la DB
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente(1L, "Ronaldo", "Nazario"));
        listaClientes.add(new Cliente(2L, "Cristiano", "Ronaldo"));
        listaClientes.add(new Cliente(3L, "Ronaldiño", "Gaucho"));

        return listaClientes;

    }

    //Enviando info al Frontend Change usando ResponseEntity
    @GetMapping("/pruebaresponse")
    ResponseEntity<String> traerRespuesta(){
        return new ResponseEntity<> ("Esta es una prueba de Response", HttpStatus.NOT_FOUND);
        //Se puede escoger cualquier otro Status Code despues de usar HttpStatus.
    }

}
