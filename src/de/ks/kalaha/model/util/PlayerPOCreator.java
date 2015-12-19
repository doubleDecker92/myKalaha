package de.ks.kalaha.model.util;

import org.sdmlib.models.pattern.util.PatternObjectCreator;
import de.uniks.networkparser.json.JsonIdMap;
import de.ks.kalaha.model.Player;

public class PlayerPOCreator extends PatternObjectCreator
{
   @Override
   public Object getSendableInstance(boolean reference)
   {
      if(reference) {
          return new PlayerPO(new Player[]{});
      } else {
          return new PlayerPO();
      }
   }
   
   public static JsonIdMap createIdMap(String sessionID) {
      return de.ks.kalaha.model.util.CreatorCreator.createIdMap(sessionID);
   }
}
