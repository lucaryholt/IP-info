package com.lucaryholt.ipinfojava.Service;

import com.lucaryholt.ipinfojava.Model.IPInfoHolder;
import com.lucaryholt.ipinfojava.Tool.ProjectVariable;
import io.ipinfo.api.IPInfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;

public class IPInfoAPI implements com.lucaryholt.ipinfojava.Service.IPInfo {

    public IPResponse getResponse(String ip){
        IPInfo ipInfo = IPInfo.builder().setToken(ProjectVariable.token).build();

        try {
            return ipInfo.lookupIP(ip);
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IPInfoHolder getHolder() {
        return getHolder("");
    }

    @Override
    public IPInfoHolder getHolder(String ip) {
        IPResponse response = getResponse(ip);
        IPInfoHolder ipInfoHolder = new IPInfoHolder(response.getLocation(), response.getPostal(), response.getCity(), response.getIp());
        return ipInfoHolder;
    }
}
