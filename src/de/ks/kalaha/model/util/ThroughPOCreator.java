package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import de.ks.kalaha.model.Through;

public class ThroughPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new ThroughPO(new Through[]{});
      } else {
          return new ThroughPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return de.ks.kalaha.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
