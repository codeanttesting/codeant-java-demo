/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jtbank.codeant.codeant_demo.controller;

import java.util.HashMap;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author JT0020031_admin
 */
//Constant name should not be found
//Object array passed to varargs should be found
//Unnecessary String assignment instead of direct return should be found
//Unnecessary throws Exception should be found
//Generic exception instead of a specific one should be found
//Unnecessary boxing of a boolean value should be found
//Parametrized value for HashMap should be found, eg. new HashMap<>();
//Equals and to lowercase should be modified to equailsIgnoreCase call should be found
//Unused imports should be found
//Recommendation to switch to SecureRandom from Random should be found
@RestController
@RequestMapping("/codeant")
public class CodeantController {
    private final Logger LOGGER = LogManager.getLogger(CodeantController.class);
    private static final HashMap<String, String> API_ENDPOINTS = new HashMap();
    
    @GetMapping("/test-method")
    public String testMethod() throws Exception {
        LOGGER.log(Level.DEBUG, "{} {} {} {} {}{}", new Object[]{
                "This",
                "is",
                "a",
                "test",
                "message",
                "."
            }
        );
        return getTestMethodResponse();
    }
    
    @GetMapping("/generic-exception")
    public ResponseEntity<Exception> genericException(){
        try
        {
            getGenericException();
            return ResponseEntity.ok().build();
        }
        catch(Exception ex)
        {
            return ResponseEntity.internalServerError().body(ex);
        }
    }
    
    @GetMapping("/evaluate-condition")
    public void conditionEval(){
        evaluateCondition(Boolean.TRUE);
    }
    
    @GetMapping("/string-compare")
    private ResponseEntity<Boolean> compareString(){
        return ResponseEntity.ok(checkStrings("a", "B"));
    }
    
    @GetMapping
    private ResponseEntity<Integer> getRandomNumber(){
        return ResponseEntity.ok(randomNumber());
    }
    
    private String getTestMethodResponse() throws Exception {
        String returnVal = "";
        returnVal = "This is a test message";
        return returnVal;
    }
    
    private void getGenericException() throws Exception {
        int val = 1 + 1;
        if(val == 2)
        {
            throw new Exception("Generic Exception");
        }
    }
    
    private void evaluateCondition(Boolean condition){
        if(condition)
        {
            //This log should not be found
            LOGGER.log(Level.DEBUG, "Condition {} is evaluated as {}", condition, condition);
        }
    }
    
    private boolean checkStrings(String a, String b){
        return a.toLowerCase().equals(b.toLowerCase());
    }
    
    private int randomNumber(){
        Random r = new Random();
        return r.nextInt();
    }
}
