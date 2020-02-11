package com.lucaryholt.ipinfojava.Service;

import com.lucaryholt.ipinfojava.Model.IPInfoHolder;
import com.lucaryholt.ipinfojava.Tool.ProjectVariable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;

public class JSONHandler implements IPInfo {

    private String readAll(BufferedReader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);

            BufferedReader rd = new BufferedReader(new InputStreamReader(url.openStream()));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        } catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getInfo(String info, String ip){
        JSONObject jsonObject = readJsonFromUrl("http://ipinfo.io/" + ip + "/geo?token=" + ProjectVariable.token);

        return (String ) jsonObject.get(info);
    }

    public String getInfo(String info){
        JSONObject jsonObject = readJsonFromUrl("https://ipinfo.io/geo?token=" + ProjectVariable.token);

        return (String) jsonObject.get(info);
    }

    @Override
    public IPInfoHolder getHolder() {
        IPInfoHolder ipInfoHolder = new IPInfoHolder();

        ipInfoHolder.setLocation(getInfo("loc"));
        ipInfoHolder.setPostal(getInfo("postal"));
        ipInfoHolder.setCity(getInfo("city"));
        ipInfoHolder.setIp(getInfo("ip"));

        return ipInfoHolder;
    }

    @Override
    public IPInfoHolder getHolder(String ip) {
        IPInfoHolder ipInfoHolder = new IPInfoHolder();

        ipInfoHolder.setLocation(getInfo("loc", ip));
        ipInfoHolder.setPostal(getInfo("postal", ip));
        ipInfoHolder.setCity(getInfo("city", ip));
        ipInfoHolder.setIp(getInfo("ip", ip));

        return ipInfoHolder;
    }
}
