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
import de.ks.kalaha.model.Through;
import de.ks.kalaha.model.Player;

public class ThroughCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
      Through.PROPERTY_SEED,
      Through.PROPERTY_KALAHA,
      Through.PROPERTY_PLAYER,
      Through.PROPERTY_PREVIOUSTHROUGH,
      Through.PROPERTY_NEXTTHROUGH,
      Through.PROPERTY_OPPOSITE,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Through();
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

      if (Through.PROPERTY_SEED.equalsIgnoreCase(attribute))
      {
         return ((Through) target).getSeed();
      }

      if (Through.PROPERTY_KALAHA.equalsIgnoreCase(attribute))
      {
         return ((Through) target).isKalaha();
      }

      if (Through.PROPERTY_PLAYER.equalsIgnoreCase(attribute))
      {
         return ((Through) target).getPlayer();
      }

      if (Through.PROPERTY_PREVIOUSTHROUGH.equalsIgnoreCase(attribute))
      {
         return ((Through) target).getPreviousThrough();
      }

      if (Through.PROPERTY_NEXTTHROUGH.equalsIgnoreCase(attribute))
      {
         return ((Through) target).getNextThrough();
      }

      if (Through.PROPERTY_OPPOSITE.equalsIgnoreCase(attribute))
      {
         return ((Through) target).getOpposite();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Through.PROPERTY_KALAHA.equalsIgnoreCase(attrName))
      {
         ((Through) target).withKalaha((Boolean) value);
         return true;
      }

      if (Through.PROPERTY_SEED.equalsIgnoreCase(attrName))
      {
         ((Through) target).withSeed(Integer.parseInt(value.toString()));
         return true;
      }

      if (JsonIdMap.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Through.PROPERTY_PLAYER.equalsIgnoreCase(attrName))
      {
         ((Through) target).setPlayer((Player) value);
         return true;
      }

      if (Through.PROPERTY_PREVIOUSTHROUGH.equalsIgnoreCase(attrName))
      {
         ((Through) target).setPreviousThrough((Through) value);
         return true;
      }

      if (Through.PROPERTY_NEXTTHROUGH.equalsIgnoreCase(attrName))
      {
         ((Through) target).setNextThrough((Through) value);
         return true;
      }

      if (Through.PROPERTY_OPPOSITE.equalsIgnoreCase(attrName))
      {
         ((Through) target).setOpposite((Through) value);
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
      ((Through) entity).removeYou();
   }
}
