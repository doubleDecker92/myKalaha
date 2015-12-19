package de.ks.kalaha.model.util;

import de.uniks.networkparser.json.JsonIdMap;

class CreatorCreator{

   public static JsonIdMap createIdMap(String sessionID)
   {
      JsonIdMap jsonIdMap = new JsonIdMap().withSessionId(sessionID);
      jsonIdMap.withCreator(new KalahaCreator());
      jsonIdMap.withCreator(new KalahaPOCreator());
      jsonIdMap.withCreator(new PlayerCreator());
      jsonIdMap.withCreator(new PlayerPOCreator());
      jsonIdMap.withCreator(new ThroughCreator());
      jsonIdMap.withCreator(new ThroughPOCreator());
      return jsonIdMap;
   }
}
