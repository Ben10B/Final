package main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.frames.Game;
import main.frames.Play;

public class JUnitTest {
	//@@@@  “At least 3 passing tests using Junit”
	@Test
	public void testIfObjectsAreCured() {
		/*
		 * The 4th object is poisoned at the start of the game.
		 * Check to see if 'areAllObjectsCured()' method return false.
		 */
		//arrange
		Game g = new Game();
		Play p = new Play(g);
		p.setObjectSize(4);
		Level lvl = new Level(p);
		boolean expected = false;
		//act
		boolean actual = lvl.areAllObjectsCured();
		//assert
		assertEquals(expected, actual);
	}

	@Test
	public void testIfVirusIsWithinBounds() {
		/*
		 * The virus has a random location at the start of the game.
		 * Check to see if 'isWithinBounds()' method return true.
		 */
		//arrange
		Game g = new Game();
		Play p = new Play(g);
		Level lvl = new Level(p);
		boolean expected = true; 
		//act
		boolean actual = lvl.isWithinBounds();
		//assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void testFreezeAttack(){
		/*
		 * Check to see if 'freeze()' method reduces speed to 0;
		 */
		//arrange
		Virus v = new Virus(null, null);
		v.freeze(15);
		int expected = 0;
		//act
		int actual = v.purify();
		//assert
		assertEquals(expected, actual);
	}
}
