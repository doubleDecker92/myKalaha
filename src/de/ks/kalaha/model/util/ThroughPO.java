package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.PatternObject;
import de.ks.kalaha.model.Through;
import org.sdmlib.models.pattern.AttributeConstraint;
import de.ks.kalaha.model.util.PlayerPO;
import de.ks.kalaha.model.Player;
import de.ks.kalaha.model.util.ThroughPO;

public class ThroughPO extends PatternObject<ThroughPO, Through>
{

    public ThroughSet allMatches()
   {
      this.setDoAllMatches(true);
      
      ThroughSet matches = new ThroughSet();

      while (this.getPattern().getHasMatch())
      {
         matches.add((Through) this.getCurrentMatch());
         
         this.getPattern().findMatch();
      }
      
      return matches;
   }


   public ThroughPO(){
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"));
   }

   public ThroughPO(Through... hostGraphObject) {
      if(hostGraphObject==null || hostGraphObject.length<1){
         return ;
      }
      newInstance(de.ks.kalaha.model.util.CreatorCreator.createIdMap("PatternObjectType"), hostGraphObject);
   }
   public ThroughPO hasSeed(int value)
   {
      new AttributeConstraint()
      .withAttrName(Through.PROPERTY_SEED)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public ThroughPO hasSeed(int lower, int upper)
   {
      new AttributeConstraint()
      .withAttrName(Through.PROPERTY_SEED)
      .withTgtValue(lower)
      .withUpperTgtValue(upper)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public ThroughPO createSeed(int value)
   {
      this.startCreate().hasSeed(value).endCreate();
      return this;
   }
   
   public int getSeed()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) getCurrentMatch()).getSeed();
      }
      return 0;
   }
   
   public ThroughPO withSeed(int value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Through) getCurrentMatch()).setSeed(value);
      }
      return this;
   }
   
   public ThroughPO hasKalaha(boolean value)
   {
      new AttributeConstraint()
      .withAttrName(Through.PROPERTY_KALAHA)
      .withTgtValue(value)
      .withSrc(this)
      .withModifier(this.getPattern().getModifier())
      .withPattern(this.getPattern());
      
      super.hasAttr();
      
      return this;
   }
   
   public ThroughPO createKalaha(boolean value)
   {
      this.startCreate().hasKalaha(value).endCreate();
      return this;
   }
   
   public boolean getKalaha()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) getCurrentMatch()).isKalaha();
      }
      return false;
   }
   
   public ThroughPO withKalaha(boolean value)
   {
      if (this.getPattern().getHasMatch())
      {
         ((Through) getCurrentMatch()).setKalaha(value);
      }
      return this;
   }
   
   public PlayerPO hasPlayer()
   {
      PlayerPO result = new PlayerPO(new Player[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Through.PROPERTY_PLAYER, result);
      
      return result;
   }

   public PlayerPO createPlayer()
   {
      return this.startCreate().hasPlayer().endCreate();
   }

   public ThroughPO hasPlayer(PlayerPO tgt)
   {
      return hasLinkConstraint(tgt, Through.PROPERTY_PLAYER);
   }

   public ThroughPO createPlayer(PlayerPO tgt)
   {
      return this.startCreate().hasPlayer(tgt).endCreate();
   }

   public Player getPlayer()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) this.getCurrentMatch()).getPlayer();
      }
      return null;
   }

   public ThroughPO hasPreviousThrough()
   {
      ThroughPO result = new ThroughPO(new Through[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Through.PROPERTY_PREVIOUSTHROUGH, result);
      
      return result;
   }

   public ThroughPO createPreviousThrough()
   {
      return this.startCreate().hasPreviousThrough().endCreate();
   }

   public ThroughPO hasPreviousThrough(ThroughPO tgt)
   {
      return hasLinkConstraint(tgt, Through.PROPERTY_PREVIOUSTHROUGH);
   }

   public ThroughPO createPreviousThrough(ThroughPO tgt)
   {
      return this.startCreate().hasPreviousThrough(tgt).endCreate();
   }

   public Through getPreviousThrough()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) this.getCurrentMatch()).getPreviousThrough();
      }
      return null;
   }

   public ThroughPO hasNextThrough()
   {
      ThroughPO result = new ThroughPO(new Through[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Through.PROPERTY_NEXTTHROUGH, result);
      
      return result;
   }

   public ThroughPO createNextThrough()
   {
      return this.startCreate().hasNextThrough().endCreate();
   }

   public ThroughPO hasNextThrough(ThroughPO tgt)
   {
      return hasLinkConstraint(tgt, Through.PROPERTY_NEXTTHROUGH);
   }

   public ThroughPO createNextThrough(ThroughPO tgt)
   {
      return this.startCreate().hasNextThrough(tgt).endCreate();
   }

   public Through getNextThrough()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) this.getCurrentMatch()).getNextThrough();
      }
      return null;
   }

   public ThroughPO hasOpposite()
   {
      ThroughPO result = new ThroughPO(new Through[]{});
      
      result.setModifier(this.getPattern().getModifier());
      super.hasLink(Through.PROPERTY_OPPOSITE, result);
      
      return result;
   }

   public ThroughPO createOpposite()
   {
      return this.startCreate().hasOpposite().endCreate();
   }

   public ThroughPO hasOpposite(ThroughPO tgt)
   {
      return hasLinkConstraint(tgt, Through.PROPERTY_OPPOSITE);
   }

   public ThroughPO createOpposite(ThroughPO tgt)
   {
      return this.startCreate().hasOpposite(tgt).endCreate();
   }

   public Through getOpposite()
   {
      if (this.getPattern().getHasMatch())
      {
         return ((Through) this.getCurrentMatch()).getOpposite();
      }
      return null;
   }

}
