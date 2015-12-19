package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import de.ks.kalaha.model.Kalaha;

public class KalahaPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new KalahaPO(new Kalaha[]{});
      } else {
          return new KalahaPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return de.ks.kalaha.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
