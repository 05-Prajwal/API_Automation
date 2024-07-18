package org.example;

import io.cucumber.datatable.DataTable;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

public class CommonMethods {

    public static JSONObject createPostRequest(String endpoint, List<Map<String, String>> data) {
        JSONObject Request=new JSONObject();
        try {
            if (endpoint.equalsIgnoreCase("users")){
                Request.put("firstName",data.get(0).get("firstName"));
                Request.put("lastName",data.get(0).get("lastName"));
                Request.put("subjectId",data.get(0).get("subjectId").toString());
                Request.put("id",data.get(0).get("id").toString());
            }
            if (endpoint.equalsIgnoreCase("subjects")){
                Request.put("id",data.get(0).get("id").toString());
                Request.put("name",data.get(0).get("name"));
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
        return Request;
    }
}
