package de.ks.kalaha.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.ks.kalaha.controller.GameCreator;
import de.ks.kalaha.model.Through;
import de.ks.kalaha.model.util.ThroughSet;

public class GameCreatorTest {
	
	
	
	@Test
	public void testCreatePlayers() throws Exception {
		String alice = "Alice";
		String bob = "Bob";
		ArrayList<String> players = new ArrayList<>();
		
		players.add(bob);
		players.add(alice);
		
		GameCreator gameCreator = new GameCreator(players);
		
		//Player with names alice and bob are existing
		assertTrue(gameCreator.getKalaha().getPlayers().getName().contains(alice));
		assertTrue(gameCreator.getKalaha().getPlayers().getName().contains(bob));
		
		//Check next and previous Player
		assertEquals(gameCreator.getKalaha().getPlayers().hasName(bob).getName()
				, gameCreator.getKalaha().getPlayers().hasName(alice).getPreviousPlayer().hasName(bob).getName());
		assertEquals(gameCreator.getKalaha().getPlayers().hasName(bob).getName()
				, gameCreator.getKalaha().getPlayers().hasName(alice).getNextPlayer().hasName(bob).getName());
		
		assertEquals(gameCreator.getKalaha().getPlayers().hasName(alice).getName()
				, gameCreator.getKalaha().getPlayers().hasName(bob).getPreviousPlayer().hasName(alice).getName());
		assertEquals(gameCreator.getKalaha().getPlayers().hasName(alice).getName()
				, gameCreator.getKalaha().getPlayers().hasName(bob).getNextPlayer().hasName(alice).getName());
	}
	
	@Test
	public void testInit() throws Exception {
		String alice = "Alice";
		String bob = "Bob";
		ArrayList<String> players = new ArrayList<>();
		
		players.add(bob);
		players.add(alice);
		
		GameCreator gameCreator = new GameCreator(players);
		
		//Game has 12 Through
		assertEquals(12, gameCreator.getKalaha().getPlayers().getThroughs().hasKalaha(false).size());
		
		//Each player has 7 througs
		assertEquals(6, gameCreator.getKalaha().getPlayers().first().getThroughs().hasKalaha(false).size());
		assertEquals(6, gameCreator.getKalaha().getPlayers().last().getThroughs().hasKalaha(false).size());
		
		//Each through has 3 seeds
		for (Through through : gameCreator.getKalaha().getPlayers().getThroughs().hasKalaha(false)) {
			assertEquals(3, through.getSeed());
		}
		
		//Each player has 1 Kalaha
		assertEquals(1, gameCreator.getKalaha().getPlayers().first().getThroughs().hasKalaha(true).size());
		assertEquals(1, gameCreator.getKalaha().getPlayers().last().getThroughs().hasKalaha(true).size());
		
		//Check opposite Through
		
		ThroughSet throughsPlayer1 = gameCreator.getKalaha().getPlayers().first().getThroughs().hasKalaha(false);
		ThroughSet throughsPlayer2 = gameCreator.getKalaha().getPlayers().last().getThroughs().hasKalaha(false);
		
		for (int i = 0; i < throughsPlayer1.size(); i++) {
			assertEquals(throughsPlayer1.get(i), throughsPlayer2.get(i).getOpposite());
		}
		
		//Check previous and next Through from every Through and Kalaha
		
		for (Through through : gameCreator.getKalaha().getPlayers().getThroughs().hasKalaha(false)) {
			assertNotNull(through.getPreviousThrough());
			assertNotNull(through.getNextThrough());
		}
		
		for (Through through : gameCreator.getKalaha().getPlayers().getThroughs().hasKalaha(true)) {
			assertNotNull(through.getPreviousThrough());
			assertNotNull(through.getNextThrough());
		}
	}
}
