/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dzhem
 */
public class RekeningTest {
    
    @Test
    public void nummerOk() {
        new Rekening("063-1547563-60");
    }
    @Test(expected = IllegalArgumentException.class)
    public void verkeerdControleGetal() {
        new Rekening("063-1547563-61");
    }
    @Test(expected = IllegalArgumentException.class)
    public void legeString(){
        new Rekening("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void spaties(){
        new Rekening("     ");
    }
    @Test(expected = IllegalArgumentException.class)
    public void teLangOfTeKort(){
        new Rekening("63-1547563-60");
        new Rekening("063-1547563-060");
    }
    @Test(expected = IllegalArgumentException.class)
    public void letter(){
        new Rekening("6a3-1547563-60");
        new Rekening("063-1547b56-60");
        new Rekening("063-1547563-6c");
    }
    @Test
    public void grootstMogelijkEnKleinstMogelijk(){
        new Rekening("999-9999999-48");
        new Rekening("001-0000001-77");
    }
}
