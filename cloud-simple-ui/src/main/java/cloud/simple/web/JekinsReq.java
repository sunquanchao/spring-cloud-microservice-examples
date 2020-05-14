package com.gofun.ms.api.manage.common;

/**
 * @author Mackchao.Sun
 * @class:JekinsParam
 * @description: TODO
 * @date:2020/5/11 18:13
 **/
public class JekinsReq {

    private  String env;

    private  String targetIp;

    private  String targetPid;

    private  String agentId;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public String getTargetPid() {
        return targetPid;
    }

    public void setTargetPid(String targetPid) {
        this.targetPid = targetPid;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}