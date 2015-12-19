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
import de.ks.kalaha.model.util.PlayerSet;
   /**
    * 
    * @see <a href='../../../../../src/de/ks/kalaha/modelcreate/SDMLibModel.java'>SDMLibModel.java</a>/n */
   public  class Kalaha implements SendableEntity
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
   
      withoutPlayers(this.getPlayers().toArray(new Player[this.getPlayers().size()]));
      setWinner(null);
      setCurrentPlayer(null);
      getPropertyChangeSupport().firePropertyChange("REMOVE_YOU", this, null);
   }

   
   /********************************************************************
    * <pre>
    *              one                       many
    * Kalaha ----------------------------------- Player
    *              game                   players
    * </pre>
    */
   
   public static final String PROPERTY_PLAYERS = "players";

   private PlayerSet players = null;
   
   public PlayerSet getPlayers()
   {
      if (this.players == null)
      {
         return PlayerSet.EMPTY_SET;
      }
   
      return this.players;
   }

   public Kalaha withPlayers(Player... value)
   {
      if(value==null){
         return this;
      }
      for (Player item : value)
      {
         if (item != null)
         {
            if (this.players == null)
            {
               this.players = new PlayerSet();
            }
            
            boolean changed = this.players.add (item);

            if (changed)
            {
               item.withGame(this);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERS, null, item);
            }
         }
      }
      return this;
   } 

   public Kalaha withoutPlayers(Player... value)
   {
      for (Player item : value)
      {
         if ((this.players != null) && (item != null))
         {
            if (this.players.remove(item))
            {
               item.setGame(null);
               getPropertyChangeSupport().firePropertyChange(PROPERTY_PLAYERS, item, null);
            }
         }
      }
      return this;
   }

   public Player createPlayers()
   {
      Player value = new Player();
      withPlayers(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Kalaha ----------------------------------- Player
    *              wonGame                   winner
    * </pre>
    */
   
   public static final String PROPERTY_WINNER = "winner";

   private Player winner = null;

   public Player getWinner()
   {
      return this.winner;
   }

   public boolean setWinner(Player value)
   {
      boolean changed = false;
      
      if (this.winner != value)
      {
         Player oldValue = this.winner;
         
         if (this.winner != null)
         {
            this.winner = null;
            oldValue.setWonGame(null);
         }
         
         this.winner = value;
         
         if (value != null)
         {
            value.withWonGame(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_WINNER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Kalaha withWinner(Player value)
   {
      setWinner(value);
      return this;
   } 

   public Player createWinner()
   {
      Player value = new Player();
      withWinner(value);
      return value;
   } 

   
   /********************************************************************
    * <pre>
    *              one                       one
    * Kalaha ----------------------------------- Player
    *              playingGame                   currentPlayer
    * </pre>
    */
   
   public static final String PROPERTY_CURRENTPLAYER = "currentPlayer";

   private Player currentPlayer = null;

   public Player getCurrentPlayer()
   {
      return this.currentPlayer;
   }

   public boolean setCurrentPlayer(Player value)
   {
      boolean changed = false;
      
      if (this.currentPlayer != value)
      {
         Player oldValue = this.currentPlayer;
         
         if (this.currentPlayer != null)
         {
            this.currentPlayer = null;
            oldValue.setPlayingGame(null);
         }
         
         this.currentPlayer = value;
         
         if (value != null)
         {
            value.withPlayingGame(this);
         }
         
         getPropertyChangeSupport().firePropertyChange(PROPERTY_CURRENTPLAYER, oldValue, value);
         changed = true;
      }
      
      return changed;
   }

   public Kalaha withCurrentPlayer(Player value)
   {
      setCurrentPlayer(value);
      return this;
   } 

   public Player createCurrentPlayer()
   {
      Player value = new Player();
      withCurrentPlayer(value);
      return value;
   } 
}
