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
   
package de.ks.kalaha.model.util;

import de.uniks.networkparser.list.SDMSet;
import de.ks.kalaha.model.Player;
import java.util.Collection;
import org.sdmlib.models.modelsets.StringList;
import org.sdmlib.models.modelsets.ObjectSet;
import de.ks.kalaha.model.util.KalahaSet;
import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.util.PlayerSet;
import java.util.Collections;
import de.ks.kalaha.model.util.ThroughSet;
import de.ks.kalaha.model.Through;

public class PlayerSet extends SDMSet<Player>
{

   public static final PlayerSet EMPTY_SET = new PlayerSet().withReadOnly();


   public PlayerPO hasPlayerPO()
   {
      return new PlayerPO(this.toArray(new Player[this.size()]));
   }


   public String getEntryType()
   {
      return "de.ks.kalaha.model.Player";
   }


   @SuppressWarnings("unchecked")
   public PlayerSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Player>)value);
      }
      else if (value != null)
      {
         this.add((Player) value);
      }
      
      return this;
   }
   
   public PlayerSet without(Player value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Player objects and collect a list of the name attribute values. 
    * 
    * @return List of String objects reachable via name attribute
    */
   public StringList getName()
   {
      StringList result = new StringList();
      
      for (Player obj : this)
      {
         result.add(obj.getName());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Player objects and collect those Player objects where the name attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Player objects that match the parameter
    */
   public PlayerSet hasName(String value)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (value.equals(obj.getName()))
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Player objects and collect those Player objects where the name attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Player objects that match the parameter
    */
   public PlayerSet hasName(String lower, String upper)
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         if (lower.compareTo(obj.getName()) <= 0 && obj.getName().compareTo(upper) <= 0)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Player objects and assign value to the name attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Player objects now with new attribute values.
    */
   public PlayerSet withName(String value)
   {
      for (Player obj : this)
      {
         obj.setName(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Kalaha objects reached via game. 
    * 
    * @return Set of Kalaha objects reachable via game
    */
   public KalahaSet getGame()
   {
      KalahaSet result = new KalahaSet();
      
      for (Player obj : this)
      {
         result.add(obj.getGame());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference game pointing to the object passed as parameter. 
    * 
    * @param value The object required as game neighbor of the collected results. 
    * 
    * @return Set of Kalaha objects referring to value via game
    */
   public PlayerSet hasGame(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getGame()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the Game attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Game attributes.
    */
   public PlayerSet withGame(Kalaha value)
   {
      for (Player obj : this)
      {
         obj.withGame(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Kalaha objects reached via wonGame. 
    * 
    * @return Set of Kalaha objects reachable via wonGame
    */
   public KalahaSet getWonGame()
   {
      KalahaSet result = new KalahaSet();
      
      for (Player obj : this)
      {
         result.add(obj.getWonGame());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference wonGame pointing to the object passed as parameter. 
    * 
    * @param value The object required as wonGame neighbor of the collected results. 
    * 
    * @return Set of Kalaha objects referring to value via wonGame
    */
   public PlayerSet hasWonGame(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getWonGame()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the WonGame attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their WonGame attributes.
    */
   public PlayerSet withWonGame(Kalaha value)
   {
      for (Player obj : this)
      {
         obj.withWonGame(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Kalaha objects reached via playingGame. 
    * 
    * @return Set of Kalaha objects reachable via playingGame
    */
   public KalahaSet getPlayingGame()
   {
      KalahaSet result = new KalahaSet();
      
      for (Player obj : this)
      {
         result.add(obj.getPlayingGame());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference playingGame pointing to the object passed as parameter. 
    * 
    * @param value The object required as playingGame neighbor of the collected results. 
    * 
    * @return Set of Kalaha objects referring to value via playingGame
    */
   public PlayerSet hasPlayingGame(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getPlayingGame()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the PlayingGame attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PlayingGame attributes.
    */
   public PlayerSet withPlayingGame(Kalaha value)
   {
      for (Player obj : this)
      {
         obj.withPlayingGame(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Player objects reached via previousPlayer. 
    * 
    * @return Set of Player objects reachable via previousPlayer
    */
   public PlayerSet getPreviousPlayer()
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         result.add(obj.getPreviousPlayer());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference previousPlayer pointing to the object passed as parameter. 
    * 
    * @param value The object required as previousPlayer neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via previousPlayer
    */
   public PlayerSet hasPreviousPlayer(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getPreviousPlayer()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow previousPlayer reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of Player objects reachable via previousPlayer transitively (including the start set)
    */
   public PlayerSet getPreviousPlayerTransitive()
   {
      PlayerSet todo = new PlayerSet().with(this);
      
      PlayerSet result = new PlayerSet();
      
      while ( ! todo.isEmpty())
      {
         Player current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getPreviousPlayer()))
            {
               todo.with(current.getPreviousPlayer());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the PreviousPlayer attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PreviousPlayer attributes.
    */
   public PlayerSet withPreviousPlayer(Player value)
   {
      for (Player obj : this)
      {
         obj.withPreviousPlayer(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Player objects reached via nextPlayer. 
    * 
    * @return Set of Player objects reachable via nextPlayer
    */
   public PlayerSet getNextPlayer()
   {
      PlayerSet result = new PlayerSet();
      
      for (Player obj : this)
      {
         result.add(obj.getNextPlayer());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference nextPlayer pointing to the object passed as parameter. 
    * 
    * @param value The object required as nextPlayer neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via nextPlayer
    */
   public PlayerSet hasNextPlayer(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if (neighbors.contains(obj.getNextPlayer()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow nextPlayer reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of Player objects reachable via nextPlayer transitively (including the start set)
    */
   public PlayerSet getNextPlayerTransitive()
   {
      PlayerSet todo = new PlayerSet().with(this);
      
      PlayerSet result = new PlayerSet();
      
      while ( ! todo.isEmpty())
      {
         Player current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getNextPlayer()))
            {
               todo.with(current.getNextPlayer());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the NextPlayer attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their NextPlayer attributes.
    */
   public PlayerSet withNextPlayer(Player value)
   {
      for (Player obj : this)
      {
         obj.withNextPlayer(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Player objects and collect a set of the Through objects reached via throughs. 
    * 
    * @return Set of Through objects reachable via throughs
    */
   public ThroughSet getThroughs()
   {
      ThroughSet result = new ThroughSet();
      
      for (Player obj : this)
      {
         result.addAll(obj.getThroughs());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Player objects and collect all contained objects with reference throughs pointing to the object passed as parameter. 
    * 
    * @param value The object required as throughs neighbor of the collected results. 
    * 
    * @return Set of Through objects referring to value via throughs
    */
   public PlayerSet hasThroughs(Object value)
   {
      ObjectSet neighbors = new ObjectSet();

      if (value instanceof Collection)
      {
         neighbors.addAll((Collection<?>) value);
      }
      else
      {
         neighbors.add(value);
      }
      
      PlayerSet answer = new PlayerSet();
      
      for (Player obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getThroughs()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Player object passed as parameter to the Throughs attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Throughs attributes.
    */
   public PlayerSet withThroughs(Through value)
   {
      for (Player obj : this)
      {
         obj.withThroughs(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Player object passed as parameter from the Throughs attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public PlayerSet withoutThroughs(Through value)
   {
      for (Player obj : this)
      {
         obj.withoutThroughs(value);
      }
      
      return this;
   }

}
