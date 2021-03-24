/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.sessionBEAN;

import javax.ejb.Local;

/**
 *
 * @author Paula Sabogal
 */
@Local
public interface CalcBeanLocal {

    Integer addition(int value1, int value2);

    Integer subtraction(int value1, int value2);

    Integer multiplication(int value1, int value2);

    Double division(double value1, double value2);

    Double module(double value1, double value2);

    Double power(int value1, int value2);

    
}
