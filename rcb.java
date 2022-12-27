import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {

    public static void main(String[] args) throws Exception {

        List<JSONObject> players = new ArrayList<>();
        JSONObject jsonobject;
        JSONArray res = null;
        int roleCount = 0;
        int foreignPlayersCount = 0;

        try {
            // parsing file "test_results.json"
            Object obj = new JSONParser().parse(new FileReader("/Users/ashwinidarkasthu/Downloads/team.json"));
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            //Create a JSON Array
            JSONArray ja = (JSONArray) jo.get("player");
            Iterator iterator = ja.iterator();
            while (iterator.hasNext()) {
                players.add((JSONObject) iterator.next());
            }


            for (int i = 0; i < players.size(); i++) {
                System.out.println("Role of the RCB team member is  " + players.get(i).get("role"));
                if (players.get(i).get("role").toString().equalsIgnoreCase("Wicket-keeper")) {
                    roleCount++;
                }
            }

            //Print there is only 1 Wicket-keeper in the Team
            if (roleCount >= 1) {
                System.out.println(roleCount);

                System.out.println("There is atleast one wicket keeper in the RCB team");
            }

            for (int i = 0; i < players.size(); i++) {
                System.out.println("Role of the RCB team member is  " + players.get(i).get("country"));
                if (!players.get(i).get("country").toString().equalsIgnoreCase("India")) {
                    foreignPlayersCount++;
                }
            }

            //Print there is only 4 Foreign players in the Team
            if (foreignPlayersCount == 4) {
                System.out.println(foreignPlayersCount);

                System.out.println("There is only 4 foreign Players in the RCB team");
            } else {
                System.out.println("There is more than 4  foreign Players in the RCB team");
				
            }


        } catch (Exception e) {
			
            e.printStackTrace();
			System.out.println("EE sala cup namde");
           



        }

    }
}