package com.lucaryholt.ipinfojava.Service;

import com.lucaryholt.ipinfojava.Model.IPInfoHolder;

public interface IPInfo {

    IPInfoHolder getHolder();
    IPInfoHolder getHolder(String ip);

}
