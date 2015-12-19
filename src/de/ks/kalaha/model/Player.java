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
import org.sdmlib.StrUtil;
import de.ks.kalaha.model.util.PlayerSet;
import de.ks.kalaha.model.util.ThroughSet;
   /**
    * 
    * @see <a href='../../../../../src/de/ks/kalaha/modelcreate/SDMLibModel.java'>SDMLibModel.java</a>/n */
   public  class Player implements SendableEntity
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
   
      setGame(null);
      setWonGame(null);
      setPlayingGame(null);
      setPreviousPlayer(null);
      setNextPlayer(null);
      withoutThroughs(this.getThroughs().toArray(new Through[this.getThroughs().size()]));
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   //==========================================================================
   
   public static final String PROPERTY_NAME = "name";
   
   private String name;

   public String getName()
   {
      return this.name;
   }
   
   public void setName(String value)
   {
      if ( ! StrUtil.stringEquals(this.name, value)) {
      
         String oldValue = this.name;
         this.name = value;
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NAME, oldValue, value);
      }
   }
   
   public Player withName(String value)
   {
      setName(value);
      return this;
   } 


   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      result.append(" ").append(this.getName());
      return result.substring(1);
   }


   
   /********************************************************************
    * <pre>
    *              many                       one
    * Player ----------------------------------- Kalaha
    *              players                   game
    * </pre>
    */
   
   public static final String PROPERTY_GAME = "game";

   private Kalaha game = null;

   public Kalaha getGame()
   {
      return this.game;
   }

   public boolean setGame(Kalaha value)
   {
      boolean changed = false;
      
      if (this.game != value)
      {
         Kalaha oldValue = this.game;
         
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutPlayers(this);
         }
         
         this.game = value;
         
         if (value != null)
         {
            value.withPlayers(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_GAME, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withGame(Kalaha value)
   {
      setGame(value);
      return this;
   } 

   public Kalaha createGame()
   {
      Kalaha value = new Kalaha();
      withGame(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Player ----------------------------------- Kalaha
    *              winner                   wonGame
    * </pre>
    */
   
   public static final String PROPERTY_WONGAME = "wonGame";

   private Kalaha wonGame = null;

   public Kalaha getWonGame()
   {
      return this.wonGame;
   }

   public boolean setWonGame(Kalaha value)
   {
      boolean changed = false;
      
      if (this.wonGame != value)
      {
         Kalaha oldValue = this.wonGame;
         
         if (this.wonGame != null)
         {
            this.wonGame = null;
            oldValue.setWinner(null);
         }
         
         this.wonGame = value;
         
         if (value != null)
         {
            value.withWinner(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_WONGAME, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withWonGame(Kalaha value)
   {
      setWonGame(value);
      return this;
   } 

   public Kalaha createWonGame()
   {
      Kalaha value = new Kalaha();
      withWonGame(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Player ----------------------------------- Kalaha
    *              currentPlayer                   playingGame
    * </pre>
    */
   
   public static final String PROPERTY_PLAYINGGAME = "playingGame";

   private Kalaha playingGame = null;

   public Kalaha getPlayingGame()
   {
      return this.playingGame;
   }

   public boolean setPlayingGame(Kalaha value)
   {
      boolean changed = false;
      
      if (this.playingGame != value)
      {
         Kalaha oldValue = this.playingGame;
         
         if (this.playingGame != null)
         {
            this.playingGame = null;
            oldValue.setCurrentPlayer(null);
         }
         
         this.playingGame = value;
         
         if (value != null)
         {
            value.withCurrentPlayer(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYINGGAME, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withPlayingGame(Kalaha value)
   {
      setPlayingGame(value);
      return this;
   } 

   public Kalaha createPlayingGame()
   {
      Kalaha value = new Kalaha();
      withPlayingGame(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Player ----------------------------------- Player
    *              nextPlayer                   previousPlayer
    * </pre>
    */
   
   public static final String PROPERTY_PREVIOUSPLAYER = "previousPlayer";

   private Player previousPlayer = null;

   public Player getPreviousPlayer()
   {
      return this.previousPlayer;
   }
   public PlayerSet getPreviousPlayerTransitive()
   {
      PlayerSet result = new PlayerSet().with(this);
      return result.getPreviousPlayerTransitive();
   }


   public boolean setPreviousPlayer(Player value)
   {
      boolean changed = false;
      
      if (this.previousPlayer != value)
      {
         Player oldValue = this.previousPlayer;
         
         if (this.previousPlayer != null)
         {
            this.previousPlayer = null;
            oldValue.setNextPlayer(null);
         }
         
         this.previousPlayer = value;
         
         if (value != null)
         {
            value.withNextPlayer(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_PREVIOUSPLAYER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withPreviousPlayer(Player value)
   {
      setPreviousPlayer(value);
      return this;
   } 

   public Player createPreviousPlayer()
   {
      Player value = new Player();
      withPreviousPlayer(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Player ----------------------------------- Player
    *              previousPlayer                   nextPlayer
    * </pre>
    */
   
   public static final String PROPERTY_NEXTPLAYER = "nextPlayer";

   private Player nextPlayer = null;

   public Player getNextPlayer()
   {
      return this.nextPlayer;
   }
   public PlayerSet getNextPlayerTransitive()
   {
      PlayerSet result = new PlayerSet().with(this);
      return result.getNextPlayerTransitive();
   }


   public boolean setNextPlayer(Player value)
   {
      boolean changed = false;
      
      if (this.nextPlayer != value)
      {
         Player oldValue = this.nextPlayer;
         
         if (this.nextPlayer != null)
         {
            this.nextPlayer = null;
            oldValue.setPreviousPlayer(null);
         }
         
         this.nextPlayer = value;
         
         if (value != null)
         {
            value.withPreviousPlayer(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_NEXTPLAYER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Player withNextPlayer(Player value)
   {
      setNextPlayer(value);
      return this;
   } 

   public Player createNextPlayer()
   {
      Player value = new Player();
      withNextPlayer(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Player ----------------------------------- Through
    *              player                   throughs
    * </pre>
    */
   
   public static final String PROPERTY_THROUGHS = "throughs";

   private ThroughSet throughs = null;
   
   public ThroughSet getThroughs()
   {
      if (this.throughs == null)
      {
         return ThroughSet.EMPTY_SET;
      }
   
      return this.throughs;
   }

   public Player withThroughs(Through... value)
   {
      if(value==null){
         return this;
      }
      for (Through item : value)
      {
         if (item != null)
         {
            if (this.throughs == null)
            {
               this.throughs = new ThroughSet();
            }
            
            boolean changed = this.throughs.add (item);

            if (changed)
            {
               item.withPlayer(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_THROUGHS, null, item);
            }
         }
      }
      return this;
   } 

   public Player withoutThroughs(Through... value)
   {
      for (Through item : value)
      {
         if ((this.throughs != null) && (item != null))
         {
            if (this.throughs.remove(item))
            {
               item.setPlayer(null);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_THROUGHS, item, null);
            }
         }
      }
      return this;
   }

   public Through createThroughs()
   {
      Through value = new Through();
      withThroughs(value);
      return value;
   } 
}
