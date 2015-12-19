package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.PatternObject;
import de.ks.kalaha.model.Player;
import org.sdmlib.models.pattern.AttributeConstraint;
import de.ks.kalaha.model.util.KalahaPO;
import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.util.PlayerPO;
import de.ks.kalaha.model.util.ThroughPO;
import de.ks.kalaha.model.Through;
import de.ks.kalaha.model.util.ThroughSet;

public class PlayerPO extends PatternObject<PlayerPO, Player>
{

    public PlayerSet allMatches()
   {
      this.setDoAllMatches(true);
      
      PlayerSet matches = new PlayerSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Player) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public PlayerPO(){
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public PlayerPO(Player... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PlayerPO hasName(String value)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_NAME)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PlayerPO hasName(String lower, String upper)
   {
      new AttributeConstraint()
      .withAttrName(Player.PROPERTY_NAME)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public PlayerPO createName(String value)
   {
      this.startCreate().hasName(value).endCreate();
      return this;
   }
   
   public String getName()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) getCurrentMatch()).getName();
      }
      return null;
   }
   
   public PlayerPO withName(String value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Player) getCurrentMatch()).setName(value);
      }
      return this;
   }
   
   public KalahaPO hasGame()
   {
      KalahaPO result = new KalahaPO(new Kalaha[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_GAME, result);
      
      return result;
   }

   public KalahaPO createGame()
   {
      return this.startCreate().hasGame().endCreate();
   }

   public PlayerPO hasGame(KalahaPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_GAME);
   }

   public PlayerPO createGame(KalahaPO tgt)
   {
      return this.startCreate().hasGame(tgt).endCreate();
   }

   public Kalaha getGame()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getGame();
      }
      return null;
   }

   public KalahaPO hasWonGame()
   {
      KalahaPO result = new KalahaPO(new Kalaha[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_WONGAME, result);
      
      return result;
   }

   public KalahaPO createWonGame()
   {
      return this.startCreate().hasWonGame().endCreate();
   }

   public PlayerPO hasWonGame(KalahaPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_WONGAME);
   }

   public PlayerPO createWonGame(KalahaPO tgt)
   {
      return this.startCreate().hasWonGame(tgt).endCreate();
   }

   public Kalaha getWonGame()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getWonGame();
      }
      return null;
   }

   public KalahaPO hasPlayingGame()
   {
      KalahaPO result = new KalahaPO(new Kalaha[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_PLAYINGGAME, result);
      
      return result;
   }

   public KalahaPO createPlayingGame()
   {
      return this.startCreate().hasPlayingGame().endCreate();
   }

   public PlayerPO hasPlayingGame(KalahaPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_PLAYINGGAME);
   }

   public PlayerPO createPlayingGame(KalahaPO tgt)
   {
      return this.startCreate().hasPlayingGame(tgt).endCreate();
   }

   public Kalaha getPlayingGame()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getPlayingGame();
      }
      return null;
   }

   public PlayerPO hasPreviousPlayer()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_PREVIOUSPLAYER, result);
      
      return result;
   }

   public PlayerPO createPreviousPlayer()
   {
      return this.startCreate().hasPreviousPlayer().endCreate();
   }

   public PlayerPO hasPreviousPlayer(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_PREVIOUSPLAYER);
   }

   public PlayerPO createPreviousPlayer(PlayerPO tgt)
   {
      return this.startCreate().hasPreviousPlayer(tgt).endCreate();
   }

   public Player getPreviousPlayer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getPreviousPlayer();
      }
      return null;
   }

   public PlayerPO hasNextPlayer()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_NEXTPLAYER, result);
      
      return result;
   }

   public PlayerPO createNextPlayer()
   {
      return this.startCreate().hasNextPlayer().endCreate();
   }

   public PlayerPO hasNextPlayer(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_NEXTPLAYER);
   }

   public PlayerPO createNextPlayer(PlayerPO tgt)
   {
      return this.startCreate().hasNextPlayer(tgt).endCreate();
   }

   public Player getNextPlayer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getNextPlayer();
      }
      return null;
   }

   public ThroughPO hasThroughs()
   {
      ThroughPO result = new ThroughPO(new Through[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Player.PROPERTY_THROUGHS, result);
      
      return result;
   }

   public ThroughPO createThroughs()
   {
      return this.startCreate().hasThroughs().endCreate();
   }

   public PlayerPO hasThroughs(ThroughPO tgt)
   {
      return hasLinkConstraint(tgt, Player.PROPERTY_THROUGHS);
   }

   public PlayerPO createThroughs(ThroughPO tgt)
   {
      return this.startCreate().hasThroughs(tgt).endCreate();
   }

   public ThroughSet getThroughs()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Player) this.getCurrentMatch()).getThroughs();
      }
      return null;
   }

}
