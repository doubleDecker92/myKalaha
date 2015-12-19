package de.ks.kalaha.modelcreate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.sdmlib.models.classes.Card;
import org.sdmlib.models.classes.ClassModel;
import org.sdmlib.models.classes.Clazz;
import org.sdmlib.models.classes.DataType;
import org.sdmlib.storyboards.Storyboard;

public class SDMLibModel {

   /**
    * 
    * @see <a href='../../../../../doc/generateModel.html'>generateModel.html</a>/n */
   @Test
	public void generateModel(){
		
		//container
		ClassModel model = new ClassModel("de.ks.kalaha.model");
		
		//classes
		Clazz kalaha = model.createClazz("Kalaha");
		
		Clazz player = model.createClazz("Player");
		
		Clazz through = model.createClazz("Through");
		
		//methods
		
		//attributes
		player.withAttribute("name", DataType.STRING);
		
		through.withAttribute("seed", DataType.INT);
		through.withAttribute("kalaha", DataType.BOOLEAN);
		
		//associations
		
		kalaha.withAssoc(player, "players", Card.MANY, "game", Card.ONE);
		kalaha.withAssoc(player, "winner", Card.ONE, "wonGame", Card.ONE);
		kalaha.withAssoc(player, "currentPlayer", Card.ONE, "playingGame", Card.ONE);
		
		player.withAssoc(player, "previousPlayer", Card.ONE, "nextPlayer", Card.ONE);
		player.withAssoc(through, "throughs", Card.MANY, "player", Card.ONE);
		
		through.withAssoc(through, "previousThrough", Card.ONE, "nextThrough", Card.ONE);
		through.withAssoc(through, "opposite", Card.ONE, "opposite", Card.ONE);
		
		//generate
	    model.generate();
	    Storyboard storyboard = new Storyboard();
	    storyboard.addClassDiagram(model);
	    storyboard.dumpHTML();

	  
	}
}
