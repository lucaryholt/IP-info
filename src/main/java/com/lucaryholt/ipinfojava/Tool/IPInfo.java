package com.lucaryholt.ipinfojava.Tool;

import com.lucaryholt.ipinfojava.Model.IPInfoHolder;

public interface IPInfo {

    IPInfoHolder getHolder();
    IPInfoHolder getHolder(String ip);

}
