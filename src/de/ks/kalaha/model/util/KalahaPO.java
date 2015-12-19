package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.PatternObject;
import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.util.PlayerPO;
import de.ks.kalaha.model.Player;
import de.ks.kalaha.model.util.KalahaPO;
import de.ks.kalaha.model.util.PlayerSet;

public class KalahaPO extends PatternObject<KalahaPO, Kalaha>
{

    public KalahaSet allMatches()
   {
      this.setDoAllMatches(true);
      
      KalahaSet matches = new KalahaSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Kalaha) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public KalahaPO(){
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public KalahaPO(Kalaha... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public PlayerPO hasPlayers()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Kalaha.PROPERTY_PLAYERS, result);
      
      return result;
   }

   public PlayerPO createPlayers()
   {
      return this.startCreate().hasPlayers().endCreate();
   }

   public KalahaPO hasPlayers(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Kalaha.PROPERTY_PLAYERS);
   }

   public KalahaPO createPlayers(PlayerPO tgt)
   {
      return this.startCreate().hasPlayers(tgt).endCreate();
   }

   public PlayerSet getPlayers()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Kalaha) this.getCurrentMatch()).getPlayers();
      }
      return null;
   }

   public PlayerPO hasWinner()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Kalaha.PROPERTY_WINNER, result);
      
      return result;
   }

   public PlayerPO createWinner()
   {
      return this.startCreate().hasWinner().endCreate();
   }

   public KalahaPO hasWinner(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Kalaha.PROPERTY_WINNER);
   }

   public KalahaPO createWinner(PlayerPO tgt)
   {
      return this.startCreate().hasWinner(tgt).endCreate();
   }

   public Player getWinner()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Kalaha) this.getCurrentMatch()).getWinner();
      }
      return null;
   }

   public PlayerPO hasCurrentPlayer()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Kalaha.PROPERTY_CURRENTPLAYER, result);
      
      return result;
   }

   public PlayerPO createCurrentPlayer()
   {
      return this.startCreate().hasCurrentPlayer().endCreate();
   }

   public KalahaPO hasCurrentPlayer(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Kalaha.PROPERTY_CURRENTPLAYER);
   }

   public KalahaPO createCurrentPlayer(PlayerPO tgt)
   {
      return this.startCreate().hasCurrentPlayer(tgt).endCreate();
   }

   public Player getCurrentPlayer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Kalaha) this.getCurrentMatch()).getCurrentPlayer();
      }
      return null;
   }

}
