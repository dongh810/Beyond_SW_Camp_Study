package com.ohgiraffers.bootproject.service;

import com.ohgiraffers.bootproject.DTO.CalculatorDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(CalculatorDTO calculatorDTO) {
        return calculatorDTO.getNum1() + calculatorDTO.getNum2();
    }
}
