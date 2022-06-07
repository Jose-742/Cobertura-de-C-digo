package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    private final Conta conta = new Conta();
    
    @Test
    void setNumeroR1a(){              
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero("1234"));
    }
    
    @Test
    void setNumeroR1b(){
        final String invalido = "abcde-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido ));
        
        final String obtido = conta.getNumero();
        assertNotEquals(invalido, obtido);       
    }
    
    @Test
    void setNumeroR1c(){   
        final String invalido = "12345-f";
        assertThrows(IllegalArgumentException.class, () -> conta.setNumero(invalido ));
    }
    
    @Test
    void testInstanciaPadraoPoupancaR2() {
    	assertFalse(conta.isPoupanca());
    }
    
    @Test
    void setLimiteContaColumR3(){
        final double limite = 1000;
        conta.setEspecial(false);
        assertThrows(IllegalStateException.class, () -> conta.setLimite(limite));
    }
    
    @Test
    void testSetLimiteContaEspecialR3a() {
    	conta.setEspecial(true);
    	final double esperado = 1000;
    	conta.setLimite(esperado);
    	final double obtido = conta.getLimite();
    	assertEquals(esperado, obtido);
    }
    
    @Test
    void getSaldoTotalR6(){
        conta.setEspecial(true);
    	final double limite= 1000, saldo = 200, saldoTotal = 1200;
    	conta.setLimite(limite);
        conta.setSaldo(saldo);
    	assertEquals( saldoTotal,conta.getSaldoTotal());
    }
    
    @Test
    void getSaldoTotalR6a(){
        conta.setEspecial(true);
    	final double limite= 0.2, saldo = 0.1, saldoTotalEsperado = 0.3;
    	conta.setLimite(limite);
        conta.setSaldo(saldo);
        final double obtido = conta.getSaldoTotal();
    	assertEquals( saldoTotalEsperado,obtido, 0.001);
        //no final o 0.001 e chamado de delta ele serve para que o valor 
        //menor que isso nas casas decimais nao sejam considerados
    }
     /****  
    @Test
    void testHistoricoNotNullR4() {
    	assertNotNull(conta.getMovimentacoes());
    }*/
    
    
   /* @Test
    void testAddMovimentacao() {
        //TODO: Você precisa implementar este teste
    }*/
    
    
}
