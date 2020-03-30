import PojoTeam.Teams;
import PojoTeam.TeamsPojo;
import Team66PojoPackage.Squad;
import Team66PojoPackage.Team66Pojo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class APITasks {

    /*
     * GET all soccer team names listed in given resource
     * Deserialization type: Pojo
     */
    public static List<String> getAllTeams() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        TeamsPojo pojo = objectMapper.readValue(response.getEntity().getContent(),TeamsPojo.class);
         List<String> willBeReturned = new ArrayList<>();
         List<Teams> teams = pojo.getTeams();
         for (int i =0 ; i<teams.size();i++){
            willBeReturned.add(teams.get(i).getName());
         }


        return willBeReturned;
    }

    /*
     * GET names of all goalkeepers from England team
     * note: manchesterUnited team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAllGoalkeepers() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token", "7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> stringObjectMap = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> squad = (List<Map<String, Object>>) stringObjectMap.get("squad");
        List<String> goalKeeperName = new ArrayList<>();
        for (int i = 0; i < squad.size(); i++) {
            try {
                if (squad.get(i).get("position").equals("Goalkeeper")) {

                    goalKeeperName.add((String) squad.get(i).get("name"));
                }
            } catch (NullPointerException e) {
                continue;
            }
        }

            return goalKeeperName;
        }

    /*
     * GET names of all defenders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getDefenders() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> stringObjectMap=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});
        List<Map<String,Object>> squad = (List<Map<String, Object>>) stringObjectMap.get("squad");
        List<String> defenderName= new ArrayList<>();
        for (int i = 0; i <squad.size(); i++) {
            try {
                if(squad.get(i).get("position").equals("Defender")){

                    defenderName.add((String)squad.get(i).get("name"));
                }
            }catch (NullPointerException e){
                continue;
            }

        }
        return defenderName;

    }

    /*
     * GET names of all midfielders from England team
     * note: England team id is 66
     * Deserialization type: Pojo
     */
    public static List<String> getMidfielders() throws IOException, URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Team66Pojo team66Pojo =objectMapper.readValue(response.getEntity().getContent(),Team66Pojo.class);
        List<Squad> squad = team66Pojo.getSquad();
        List<String> midFielderName= new ArrayList<>();
        for (int i = 0; i <squad.size() ; i++) {
            try {
            if(squad.get(i).getPosition().equals("Midfielder")){

                midFielderName.add(squad.get(i).getName());
            }}catch (NullPointerException e){
                continue;

            }
        }
        return midFielderName;
    }


        /*
     * GET names of all midfielders from England team whose country is Brazil
     * note: England team id is 66
     * Deserialization type: Pojo
     */
    public static List<String> getMidfielderFromBrazil() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Team66Pojo team66Pojo =objectMapper.readValue(response.getEntity().getContent(),Team66Pojo.class);
        List<Squad> squad = team66Pojo.getSquad();
        List<String> midFielderName= new ArrayList<>();
        for (int i = 0; i <squad.size() ; i++) {
            try {
                if(squad.get(i).getPosition().equals("Midfielder")&&squad.get(i).getNationality().equals("Brazil")){

                    midFielderName.add(squad.get(i).getName());
                }
            }catch (NullPointerException e){
                continue;
            }

        }
        return midFielderName;
    }

    /*
     * GET names of all attackers from England team whose origin country is England
     * note: England team id is 66
     * Deserialization type: Pojo
     */
    public static List<String> getAttackerFromEngland() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/66");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Team66Pojo team66Pojo =objectMapper.readValue(response.getEntity().getContent(),Team66Pojo.class);
        List<Squad> squad = team66Pojo.getSquad();
        List<String> attackerName= new ArrayList<>();
        for (int i = 0; i <squad.size() ; i++) {
            try {
                if(squad.get(i).getPosition().equals("Attacker")&&squad.get(i).getNationality().equals("England")){

                    attackerName.add(squad.get(i).getName());
                }
            }catch (NullPointerException e){


            }
        }
        return attackerName;
    }

    /*
     * GET name of Spain team coach
     * note: Spain team id is 77
     * Deserialization type: Pojo
     */
    public static List<String> getSpainCoach() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/teams/77");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Team66Pojo team66Pojo =objectMapper.readValue(response.getEntity().getContent(),Team66Pojo.class);
        List<Squad> squad = team66Pojo.getSquad();
        List<String> nameOfSpainTeamCoach= new ArrayList<>();
        for (int i = 0; i <squad.size() ; i++) {
            try {
                if(squad.get(i).getRole().equals("COACH")){

                    nameOfSpainTeamCoach.add(squad.get(i).getName());
                }
            }catch (NullPointerException e){
                continue;
            }

        }
        return nameOfSpainTeamCoach;
    }

    public static List<String> getAllCompetitions() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        //http://api.football-data.org/v2/teams/
        uriBuilder.setScheme("http").setHost("api.football-data.org").setPath("v2/competitions/");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("X-Auth-Token","7cf82ca9d95e498793ac0d3179e1ec9f");
        httpGet.setHeader("Accept","application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> stringObjectMap=objectMapper.readValue(response.getEntity().getContent(),new TypeReference<Map<String,Object>>(){});
          List<Map<String,Object>> competitions= (List<Map<String, Object>>) stringObjectMap.get("competitions");
          List<String> getAllCompetitions = new ArrayList<>();
        for (int i = 0; i <competitions.size() ; i++) {
            try {
                getAllCompetitions.add((String)competitions.get(i).get("name"));

            }catch (NullPointerException e){

                continue;

            }        }
return getAllCompetitions;
    }

    /*
     * GET names of second highest scorrer from competitions of 2000 season
     * note: endpoint for competitions: `competitions/<year>/
     * note: endpoint for scorers: `competitions/<year>/scorers`
     * Deserialization type: Pojo and TypeReference
     */
    public static List<String> getSecondHighestScorer() throws URISyntaxException, IOException {

        return null;
    }
}
//# Football project
//
//        ##API Documentation
//        ```https://www.football-data.org/documentation/api#requesting-a-resource```
//
//        ##Base URL
//        >http://api.football-data.org/
//
//        ##Base path
//        - v2/
//
//        #Teams path
//        - teams/
//
//        #Competitions path
//        - competitions/
//
//        ##Endpoints
//        - {teamId}:
//        * teams/66 - England teamIdf
//        * teams/77 - Spain teamId
//        - competition scorers:
//        * competitions/2000/scorers/
//
//
//
//        ##Get api key
//        1. Navigate to `http://api.football-data.org/`
//        2. Register with you email.
//        3. Check your email and follow instructions.
//        4. Add a token from email as a `HEADER` parameter to your calls as following example:
//        * key: `X-Auth-Token`
//        * value: `token from email`



