/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import org.junit.Test;
import org.junit.Assert;
import java.math.BigDecimal;
import org.junit.Before;

/**
 *
 * @author deano
 */
public class ZichtrekeningTest {
    
    public ZichtrekeningTest() {
    }
    private Zichtrekening rekening;
    
    @Before
    public void before()// de naam van de methode mag je zelf kiezen
    {
        rekening = new Zichtrekening();
    }
    @Test
    public void stortenMoetSaldoAanpassen(){
        BigDecimal bedrag = new BigDecimal(200);
        rekening.storten(bedrag);
        Assert.assertEquals(bedrag,rekening.getSaldo());
    }
    
    @Test
    public void nieuweRekeningGeeftSaldoNul(){
        Assert.assertEquals(BigDecimal.ZERO,rekening.getSaldo());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void stortenMetNegatiefBedrag()
    {
        BigDecimal bedrag = new BigDecimal(-10);
        rekening.storten(bedrag);
    }
    @Test(expected = IllegalArgumentException.class)
    public void stortenMetNull()
    {
        rekening.storten(null);
    }
    
    
    
}
