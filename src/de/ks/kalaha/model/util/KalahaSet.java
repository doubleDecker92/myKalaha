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
import de.ks.kalaha.model.Kalaha;
import java.util.Collection;
import org.sdmlib.models.modelsets.ObjectSet;
import java.util.Collections;
import de.ks.kalaha.model.util.PlayerSet;
import de.ks.kalaha.model.Player;

public class KalahaSet extends SDMSet<Kalaha>
{

   public static final KalahaSet EMPTY_SET = new KalahaSet().withReadOnly();


   public KalahaPO hasKalahaPO()
   {
      return new KalahaPO(this.toArray(new Kalaha[this.size()]));
   }


   public String getEntryType()
   {
      return "de.ks.kalaha.model.Kalaha";
   }


   @SuppressWarnings("unchecked")
   public KalahaSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Kalaha>)value);
      }
      else if (value != null)
      {
         this.add((Kalaha) value);
      }
      
      return this;
   }
   
   public KalahaSet without(Kalaha value)
   {
      this.remove(value);
      return this;
   }

   /**
    * Loop through the current set of Kalaha objects and collect a set of the Player objects reached via players. 
    * 
    * @return Set of Player objects reachable via players
    */
   public PlayerSet getPlayers()
   {
      PlayerSet result = new PlayerSet();
      
      for (Kalaha obj : this)
      {
         result.addAll(obj.getPlayers());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Kalaha objects and collect all contained objects with reference players pointing to the object passed as parameter. 
    * 
    * @param value The object required as players neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via players
    */
   public KalahaSet hasPlayers(Object value)
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
      
      KalahaSet answer = new KalahaSet();
      
      for (Kalaha obj : this)
      {
         if ( ! Collections.disjoint(neighbors, obj.getPlayers()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Kalaha object passed as parameter to the Players attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Players attributes.
    */
   public KalahaSet withPlayers(Player value)
   {
      for (Kalaha obj : this)
      {
         obj.withPlayers(value);
      }
      
      return this;
   }

   /**
    * Loop through current set of ModelType objects and remove the Kalaha object passed as parameter from the Players attribute of each of it. 
    * 
    * @return The original set of ModelType objects now without the old neighbor.
    */
   public KalahaSet withoutPlayers(Player value)
   {
      for (Kalaha obj : this)
      {
         obj.withoutPlayers(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Kalaha objects and collect a set of the Player objects reached via winner. 
    * 
    * @return Set of Player objects reachable via winner
    */
   public PlayerSet getWinner()
   {
      PlayerSet result = new PlayerSet();
      
      for (Kalaha obj : this)
      {
         result.add(obj.getWinner());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Kalaha objects and collect all contained objects with reference winner pointing to the object passed as parameter. 
    * 
    * @param value The object required as winner neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via winner
    */
   public KalahaSet hasWinner(Object value)
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
      
      KalahaSet answer = new KalahaSet();
      
      for (Kalaha obj : this)
      {
         if (neighbors.contains(obj.getWinner()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Kalaha object passed as parameter to the Winner attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Winner attributes.
    */
   public KalahaSet withWinner(Player value)
   {
      for (Kalaha obj : this)
      {
         obj.withWinner(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Kalaha objects and collect a set of the Player objects reached via currentPlayer. 
    * 
    * @return Set of Player objects reachable via currentPlayer
    */
   public PlayerSet getCurrentPlayer()
   {
      PlayerSet result = new PlayerSet();
      
      for (Kalaha obj : this)
      {
         result.add(obj.getCurrentPlayer());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Kalaha objects and collect all contained objects with reference currentPlayer pointing to the object passed as parameter. 
    * 
    * @param value The object required as currentPlayer neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via currentPlayer
    */
   public KalahaSet hasCurrentPlayer(Object value)
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
      
      KalahaSet answer = new KalahaSet();
      
      for (Kalaha obj : this)
      {
         if (neighbors.contains(obj.getCurrentPlayer()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Kalaha object passed as parameter to the CurrentPlayer attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their CurrentPlayer attributes.
    */
   public KalahaSet withCurrentPlayer(Player value)
   {
      for (Kalaha obj : this)
      {
         obj.withCurrentPlayer(value);
      }
      
      return this;
   }

}
