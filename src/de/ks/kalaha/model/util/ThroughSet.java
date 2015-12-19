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
import de.ks.kalaha.model.Through;
import java.util.Collection;
import org.sdmlib.models.modelsets.intList;
import org.sdmlib.models.modelsets.booleanList;
import org.sdmlib.models.modelsets.ObjectSet;
import de.ks.kalaha.model.util.PlayerSet;
import de.ks.kalaha.model.Player;
import de.ks.kalaha.model.util.ThroughSet;

public class ThroughSet extends SDMSet<Through>
{

   public static final ThroughSet EMPTY_SET = new ThroughSet().withReadOnly();


   public ThroughPO hasThroughPO()
   {
      return new ThroughPO(this.toArray(new Through[this.size()]));
   }


   public String getEntryType()
   {
      return "de.ks.kalaha.model.Through";
   }


   @SuppressWarnings("unchecked")
   public ThroughSet with(Object value)
   {
      if (value == null)
      {
         return this;
      }
      else if (value instanceof java.util.Collection)
      {
         this.addAll((Collection<Through>)value);
      }
      else if (value != null)
      {
         this.add((Through) value);
      }
      
      return this;
   }
   
   public ThroughSet without(Through value)
   {
      this.remove(value);
      return this;
   }


   /**
    * Loop through the current set of Through objects and collect a list of the seed attribute values. 
    * 
    * @return List of int objects reachable via seed attribute
    */
   public intList getSeed()
   {
      intList result = new intList();
      
      for (Through obj : this)
      {
         result.add(obj.getSeed());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Through objects and collect those Through objects where the seed attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Through objects that match the parameter
    */
   public ThroughSet hasSeed(int value)
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         if (value == obj.getSeed())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Through objects and collect those Through objects where the seed attribute is between lower and upper. 
    * 
    * @param lower Lower bound 
    * @param upper Upper bound 
    * 
    * @return Subset of Through objects that match the parameter
    */
   public ThroughSet hasSeed(int lower, int upper)
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         if (lower <= obj.getSeed() && obj.getSeed() <= upper)
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Through objects and assign value to the seed attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Through objects now with new attribute values.
    */
   public ThroughSet withSeed(int value)
   {
      for (Through obj : this)
      {
         obj.setSeed(value);
      }
      
      return this;
   }


   /**
    * Loop through the current set of Through objects and collect a list of the kalaha attribute values. 
    * 
    * @return List of boolean objects reachable via kalaha attribute
    */
   public booleanList getKalaha()
   {
      booleanList result = new booleanList();
      
      for (Through obj : this)
      {
         result.add(obj.isKalaha());
      }
      
      return result;
   }


   /**
    * Loop through the current set of Through objects and collect those Through objects where the kalaha attribute matches the parameter value. 
    * 
    * @param value Search value
    * 
    * @return Subset of Through objects that match the parameter
    */
   public ThroughSet hasKalaha(boolean value)
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         if (value == obj.isKalaha())
         {
            result.add(obj);
         }
      }
      
      return result;
   }


   /**
    * Loop through the current set of Through objects and assign value to the kalaha attribute of each of it. 
    * 
    * @param value New attribute value
    * 
    * @return Current set of Through objects now with new attribute values.
    */
   public ThroughSet withKalaha(boolean value)
   {
      for (Through obj : this)
      {
         obj.setKalaha(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Through objects and collect a set of the Player objects reached via player. 
    * 
    * @return Set of Player objects reachable via player
    */
   public PlayerSet getPlayer()
   {
      PlayerSet result = new PlayerSet();
      
      for (Through obj : this)
      {
         result.add(obj.getPlayer());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Through objects and collect all contained objects with reference player pointing to the object passed as parameter. 
    * 
    * @param value The object required as player neighbor of the collected results. 
    * 
    * @return Set of Player objects referring to value via player
    */
   public ThroughSet hasPlayer(Object value)
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
      
      ThroughSet answer = new ThroughSet();
      
      for (Through obj : this)
      {
         if (neighbors.contains(obj.getPlayer()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Loop through current set of ModelType objects and attach the Through object passed as parameter to the Player attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Player attributes.
    */
   public ThroughSet withPlayer(Player value)
   {
      for (Through obj : this)
      {
         obj.withPlayer(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Through objects and collect a set of the Through objects reached via previousThrough. 
    * 
    * @return Set of Through objects reachable via previousThrough
    */
   public ThroughSet getPreviousThrough()
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         result.add(obj.getPreviousThrough());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Through objects and collect all contained objects with reference previousThrough pointing to the object passed as parameter. 
    * 
    * @param value The object required as previousThrough neighbor of the collected results. 
    * 
    * @return Set of Through objects referring to value via previousThrough
    */
   public ThroughSet hasPreviousThrough(Object value)
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
      
      ThroughSet answer = new ThroughSet();
      
      for (Through obj : this)
      {
         if (neighbors.contains(obj.getPreviousThrough()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow previousThrough reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of Through objects reachable via previousThrough transitively (including the start set)
    */
   public ThroughSet getPreviousThroughTransitive()
   {
      ThroughSet todo = new ThroughSet().with(this);
      
      ThroughSet result = new ThroughSet();
      
      while ( ! todo.isEmpty())
      {
         Through current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getPreviousThrough()))
            {
               todo.with(current.getPreviousThrough());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the Through object passed as parameter to the PreviousThrough attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their PreviousThrough attributes.
    */
   public ThroughSet withPreviousThrough(Through value)
   {
      for (Through obj : this)
      {
         obj.withPreviousThrough(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Through objects and collect a set of the Through objects reached via nextThrough. 
    * 
    * @return Set of Through objects reachable via nextThrough
    */
   public ThroughSet getNextThrough()
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         result.add(obj.getNextThrough());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Through objects and collect all contained objects with reference nextThrough pointing to the object passed as parameter. 
    * 
    * @param value The object required as nextThrough neighbor of the collected results. 
    * 
    * @return Set of Through objects referring to value via nextThrough
    */
   public ThroughSet hasNextThrough(Object value)
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
      
      ThroughSet answer = new ThroughSet();
      
      for (Through obj : this)
      {
         if (neighbors.contains(obj.getNextThrough()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow nextThrough reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of Through objects reachable via nextThrough transitively (including the start set)
    */
   public ThroughSet getNextThroughTransitive()
   {
      ThroughSet todo = new ThroughSet().with(this);
      
      ThroughSet result = new ThroughSet();
      
      while ( ! todo.isEmpty())
      {
         Through current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getNextThrough()))
            {
               todo.with(current.getNextThrough());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the Through object passed as parameter to the NextThrough attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their NextThrough attributes.
    */
   public ThroughSet withNextThrough(Through value)
   {
      for (Through obj : this)
      {
         obj.withNextThrough(value);
      }
      
      return this;
   }

   /**
    * Loop through the current set of Through objects and collect a set of the Through objects reached via opposite. 
    * 
    * @return Set of Through objects reachable via opposite
    */
   public ThroughSet getOpposite()
   {
      ThroughSet result = new ThroughSet();
      
      for (Through obj : this)
      {
         result.add(obj.getOpposite());
      }
      
      return result;
   }

   /**
    * Loop through the current set of Through objects and collect all contained objects with reference opposite pointing to the object passed as parameter. 
    * 
    * @param value The object required as opposite neighbor of the collected results. 
    * 
    * @return Set of Through objects referring to value via opposite
    */
   public ThroughSet hasOpposite(Object value)
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
      
      ThroughSet answer = new ThroughSet();
      
      for (Through obj : this)
      {
         if (neighbors.contains(obj.getOpposite()))
         {
            answer.add(obj);
         }
      }
      
      return answer;
   }

   /**
    * Follow opposite reference zero or more times and collect all reachable objects. Detect cycles and deal with them. 
    * 
    * @return Set of Through objects reachable via opposite transitively (including the start set)
    */
   public ThroughSet getOppositeTransitive()
   {
      ThroughSet todo = new ThroughSet().with(this);
      
      ThroughSet result = new ThroughSet();
      
      while ( ! todo.isEmpty())
      {
         Through current = todo.first();
         
         todo.remove(current);
         
         if ( ! result.contains(current))
         {
            result.add(current);
            
            if ( ! result.contains(current.getOpposite()))
            {
               todo.with(current.getOpposite());
            }
         }
      }
      
      return result;
   }

   /**
    * Loop through current set of ModelType objects and attach the Through object passed as parameter to the Opposite attribute of each of it. 
    * 
    * @return The original set of ModelType objects now with the new neighbor attached to their Opposite attributes.
    */
   public ThroughSet withOpposite(Through value)
   {
      for (Through obj : this)
      {
         obj.withOpposite(value);
      }
      
      return this;
   }

}
