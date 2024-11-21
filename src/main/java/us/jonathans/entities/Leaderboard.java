package us.jonathans.entities;

import java.util.*;

public class Leaderboard {
    private final Map<String, ArrayList<Object>> data;

    public Leaderboard() {
        data = new HashMap<>();
    }

    public void add(String username, String opponent, int score, int time) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(opponent);
        list.add(score);
        list.add(time);

        data.put(username, list);
    }

    public Map<String, ArrayList<Object>> getData(){
        return sort();
    }

    public Map<String, ArrayList<Object>> sort() {

        ArrayList<Integer> listST = new ArrayList<>();
        Map<String, ArrayList<Object>> sortedData = new LinkedHashMap<>();
        int typeC = 1;

        for (Map.Entry<String, ArrayList<Object>> entry : data.entrySet()) {
            listST.add((Integer) entry.getValue().get(typeC));
        }
        Collections.sort(listST);

        for(int num : listST){
            for (Map.Entry<String, ArrayList<Object>> entry : data.entrySet()) {
                if (((Integer)entry.getValue().get(typeC)) == num){
                    sortedData.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return sortedData;
    }
}
