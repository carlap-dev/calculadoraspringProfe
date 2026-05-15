package cl.usm.calculadoraspring.controllers;

import cl.usm.calculadoraspring.entities.CalculadoraRequest;
import cl.usm.calculadoraspring.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    private CalculadoraService calculadoraService;
    @Autowired
    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<Object> calcular(@RequestBody CalculadoraRequest calculadoraRequest){

        try {
            var res = calculadoraService.calcular(calculadoraRequest.getOperation(),
                    calculadoraRequest.getN1(), calculadoraRequest.getN2());

            return new ResponseEntity<>(res, HttpStatus.OK);
        }catch(NumberFormatException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
