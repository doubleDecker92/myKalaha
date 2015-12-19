/*
   Copyright (c) 2015 User
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package de.ks.kalaha.model;

import de.uniks.networkparser.interfaces.SendableEntity;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import de.ks.kalaha.model.util.ThroughSet;
   /**
    * 
    * @see <a href='../../../../../src/de/ks/kalaha/modelcreate/SDMLibModel.java'>SDMLibModel.java</a>/n */
   public  class Through implements SendableEntity
{

   
   //==========================================================================
   
   protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);
   
   public PropertyChangeSupport getPropertyChangeSupport()
   {
      return listeners;
   }
   
   public boolean addPropertyChangeListener(PropertyChangeListener listener) 
   {
      getPropertyChangeSupport().addPropertyChangeListener(listener);
      return true;
   }
   
   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
      getPropertyChangeSupport().addPropertyChangeListener(propertyName, listener);
      return true;
   }
   
   public boolean removePropertyChangeListener(PropertyChangeListener listener) {
      getPropertyChangeSupport().removePropertyChangeListener(listener);
      return true;
   }

   
   //==========================================================================
   
   
   public void removeYou()
   {
   
      setPlayer(null);
      setPreviousThrough(null);
      setNextThrough(null);
      setOpposite(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_SEED = "seed";
   
   private int seed;

   public int getSeed()
   {
      return this.seed;
   }
   
   public void setSeed(int value)
   {
      if (this.seed != value) {
      
         int oldValue = this.seed;
         this.seed = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_SEED, oldValue, value);
      }
   }
   
   public Through withSeed(int value)
   {
      setSeed(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getSeed());
      return result.substring(1);
   }


   
   //==========================================================================
   
   public static final String PROPERTY_KALAHA = "kalaha";
   
   private boolean kalaha;

   public boolean isKalaha()
   {
      return this.kalaha;
   }
   
   public void setKalaha(boolean value)
   {
      if (this.kalaha != value) {
      
         boolean oldValue = this.kalaha;
         this.kalaha = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_KALAHA, oldValue, value);
      }
   }
   
   public Through withKalaha(boolean value)
   {
      setKalaha(value);
      return this;
   } 

   
   /********************************************************************
    * <pre>
    *              many                       one
    * Through ----------------------------------- Player
    *              throughs                   player
    * </pre>
    */
   
   public static final String PROPERTY_PLAYER = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public boolean setPlayer(Player value)
   {
      boolean changed = false;
      
      if (this.player != value)
      {
         Player oldValue = this.player;
         
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutThroughs(this);
         }
         
         this.player = value;
         
         if (value != null)
         {
            value.withThroughs(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Through withPlayer(Player value)
   {
      setPlayer(value);
      return this;
   } 

   public Player createPlayer()
   {
      Player value = new Player();
      withPlayer(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Through ----------------------------------- Through
    *              nextThrough                   previousThrough
    * </pre>
    */
   
   public static final String PROPERTY_PREVIOUSTHROUGH = "previousThrough";

   private Through previousThrough = null;

   public Through getPreviousThrough()
   {
      return this.previousThrough;
   }
   public ThroughSet getPreviousThroughTransitive()
   {
      ThroughSet result = new ThroughSet().with(this);
      return result.getPreviousThroughTransitive();
   }


   public boolean setPreviousThrough(Through value)
   {
      boolean changed = false;
      
      if (this.previousThrough != value)
      {
         Through oldValue = this.previousThrough;
         
         if (this.previousThrough != null)
         {
            this.previousThrough = null;
            oldValue.setNextThrough(null);
         }
         
         this.previousThrough = value;
         
         if (value != null)
         {
            value.withNextThrough(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PREVIOUSTHROUGH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Through withPreviousThrough(Through value)
   {
      setPreviousThrough(value);
      return this;
   } 

   public Through createPreviousThrough()
   {
      Through value = new Through();
      withPreviousThrough(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Through ----------------------------------- Through
    *              previousThrough                   nextThrough
    * </pre>
    */
   
   public static final String PROPERTY_NEXTTHROUGH = "nextThrough";

   private Through nextThrough = null;

   public Through getNextThrough()
   {
      return this.nextThrough;
   }
   public ThroughSet getNextThroughTransitive()
   {
      ThroughSet result = new ThroughSet().with(this);
      return result.getNextThroughTransitive();
   }


   public boolean setNextThrough(Through value)
   {
      boolean changed = false;
      
      if (this.nextThrough != value)
      {
         Through oldValue = this.nextThrough;
         
         if (this.nextThrough != null)
         {
            this.nextThrough = null;
            oldValue.setPreviousThrough(null);
         }
         
         this.nextThrough = value;
         
         if (value != null)
         {
            value.withPreviousThrough(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NEXTTHROUGH, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Through withNextThrough(Through value)
   {
      setNextThrough(value);
      return this;
   } 

   public Through createNextThrough()
   {
      Through value = new Through();
      withNextThrough(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Through ----------------------------------- Through
    *              opposite                   opposite
    * </pre>
    */
   
   public static final String PROPERTY_OPPOSITE = "opposite";

   private Through opposite = null;

   public Through getOpposite()
   {
      return this.opposite;
   }
   public ThroughSet getOppositeTransitive()
   {
      ThroughSet result = new ThroughSet().with(this);
      return result.getOppositeTransitive();
   }


   public boolean setOpposite(Through value)
   {
      boolean changed = false;
      
      if (this.opposite != value)
      {
         Through oldValue = this.opposite;
         
         if (this.opposite != null)
         {
            this.opposite = null;
            oldValue.setOpposite(null);
         }
         
         this.opposite = value;
         
         if (value != null)
         {
            value.withOpposite(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_OPPOSITE, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Through withOpposite(Through value)
   {
      setOpposite(value);
      return this;
   } 

   public Through createOpposite()
   {
      Through value = new Through();
      withOpposite(value);
      return value;
   } 
}
