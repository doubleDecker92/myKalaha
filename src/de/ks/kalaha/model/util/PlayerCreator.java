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

import de.uniks.networkparser.interfaces.SendableEntityCreator;
import de.uniks.networkparser.json.JsonIdMap;
import de.ks.kalaha.model.Player;
import de.ks.kalaha.model.Kalaha;
import de.ks.kalaha.model.Through;

public class PlayerCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
      Player.PROPERTY_NAME,
      Player.PROPERTY_GAME,
      Player.PROPERTY_WONGAME,
      Player.PROPERTY_PLAYINGGAME,
      Player.PROPERTY_PREVIOUSPLAYER,
      Player.PROPERTY_NEXTPLAYER,
      Player.PROPERTY_THROUGHS,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Player();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Player.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getName();
      }

      if (Player.PROPERTY_GAME.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getGame();
      }

      if (Player.PROPERTY_WONGAME.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getWonGame();
      }

      if (Player.PROPERTY_PLAYINGGAME.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getPlayingGame();
      }

      if (Player.PROPERTY_PREVIOUSPLAYER.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getPreviousPlayer();
      }

      if (Player.PROPERTY_NEXTPLAYER.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getNextPlayer();
      }

      if (Player.PROPERTY_THROUGHS.equalsIgnoreCase(attribute))
      {
         return ((Player) target).getThroughs();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Player.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((Player) target).withName((String) value);
         return true;
      }

      if (JsonIdMap.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Player.PROPERTY_GAME.equalsIgnoreCase(attrName))
      {
         ((Player) target).setGame((Kalaha) value);
         return true;
      }

      if (Player.PROPERTY_WONGAME.equalsIgnoreCase(attrName))
      {
         ((Player) target).setWonGame((Kalaha) value);
         return true;
      }

      if (Player.PROPERTY_PLAYINGGAME.equalsIgnoreCase(attrName))
      {
         ((Player) target).setPlayingGame((Kalaha) value);
         return true;
      }

      if (Player.PROPERTY_PREVIOUSPLAYER.equalsIgnoreCase(attrName))
      {
         ((Player) target).setPreviousPlayer((Player) value);
         return true;
      }

      if (Player.PROPERTY_NEXTPLAYER.equalsIgnoreCase(attrName))
      {
         ((Player) target).setNextPlayer((Player) value);
         return true;
      }

      if (Player.PROPERTY_THROUGHS.equalsIgnoreCase(attrName))
      {
         ((Player) target).withThroughs((Through) value);
         return true;
      }
      
      if ((Player.PROPERTY_THROUGHS + JsonIdMap.REMOVE).equalsIgnoreCase(attrName))
      {
         ((Player) target).withoutThroughs((Through) value);
         return true;
      }
      
      return false;
   }
   public static JsonIdMap createIdMap(String sessionID)
   {
      return de.ks.kalaha.model.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((Player) entity).removeYou();
   }
}
