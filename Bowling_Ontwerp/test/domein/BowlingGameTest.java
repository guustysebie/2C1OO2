/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dzhem
 */
public class BowlingGameTest {
    private BowlingGame game;
    @Before
    public void before(){
        game = new BowlingGame();   
    }
    
    @Test
    public void testAllZeros(){
        for(int i=0; i<20; i++){
            game.roll(0);
        }
        
        Assert.assertEquals(0, game.score());
    }
    @Test
    public void testAllOnes(){
        for(int i=0; i<20; i++){
            game.roll(1);
        }
        
        Assert.assertEquals(20, game.score());
    }
    
    @Test
    public void testOneSpare(){
        rollSpare();
        game.roll(3);
        rollMany(17,0);
        Assert.assertEquals(16,game.score());
        
    }
    @Test
    public void testOneStrike(){
        rollStrike();
        game.roll(3);
        game.roll(4);
        Assert.assertEquals(24,game.score());
        
    }
    
    @Test
    public void testStrikeTwo(){
        rollStrike();
        game.roll(0);
        game.roll(5);
        game.roll(5);
        game.roll(2);
        Assert.assertEquals(27,game.score());
    }
    @Test
    public void testAllSpares(){
        rollMany(21, 5);
        Assert.assertEquals(150, game.score());
    }
    
    @Test
    public void testFullGame(){
        int rolls[] = {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6};
        for(int roll : rolls)
            game.roll(roll);
        Assert.assertEquals(133, game.score());
    }
    
    private void rollMany(int x, int y){
        for(int i=0;i<x; i++){
            game.roll(y);
        }
    }
    private void rollStrike(){
        game.roll(10);
    }
    
    private void rollSpare(){
    game.roll(5);
    game.roll(5);
}
}
