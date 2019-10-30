/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tiera
 */
public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchReturnsAPlayer() {
        Player p = stats.search("Kurr");
        
        Assert.assertEquals("Kurri", p.getName());
    }
    
    @Test
    public void emptySearchReturnsNull() {
        Player p = stats.search("ei muuten sit löydy pojat");
//        boolean isNull = false;
//        if (p.ge)
//        
        Assert.assertEquals(null, p);
    }
    
    @Test
    public void teamReturnsAListOfPlayers() {
        List<Player> lista = stats.team("EDM");
        
        Assert.assertTrue(lista instanceof List);
        Assert.assertTrue(lista.get(0) instanceof Player);
    }
    
    @Test
    public void topscorersReturnsListOfPlayersOfRightLength() {
        List<Player> lista = stats.topScorers(3);
        
        Assert.assertTrue(lista instanceof ArrayList);
        Assert.assertTrue(lista.get(0) instanceof Player);
        Assert.assertEquals(4, lista.size(), 0.0001);
    }
}
