package com.example.docs.test;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings(value = "unchecked")
public class DataParser {

    public static List<Problem> parseProblems(JSONObject res) {
        List<Problem> result = new ArrayList<>();
        // Precondition : res[items] is Iterable
        Iterable<JSONObject> items = (JSONArray) res.get("items");

        if (items == null)
            return result;
        for (JSONObject rawObject : items) {
            try {
                Problem problem = new Problem();
                problem.setProblemId(Integer.parseInt(rawObject.get("problemId").toString()));
                problem.setTitle(rawObject.get("titleKo").toString());
                problem.setLevel(Integer.parseInt(rawObject.get("level").toString()));
                result.add(problem);
            } catch (NumberFormatException e){
                // TODO: Exception Handling
            }
        }

        return result;
    }

}
