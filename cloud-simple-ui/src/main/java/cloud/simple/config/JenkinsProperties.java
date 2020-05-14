package com.gofun.ms.api.manage.common.config;

/**
 * @author Mackchao.Sun
 * @class:JenkinsProperties
 * @description: TODO
 * @date:2020/5/11 14:20
 **/
public class JenkinsProperties {

    private String envs;
    private String serverUri;
    private String username;
    private String password;
    private String tunnelJobName;
    private String clientJobName;

    private  String tunnelServerUrl;

    public String getTunnelServerUrl() {
        return tunnelServerUrl;
    }

    public void setTunnelServerUrl(String tunnelServerUrl) {
        this.tunnelServerUrl = tunnelServerUrl;
    }

    public String getEnvs() {
        return envs;
    }

    public void setEnvs(String envs) {
        this.envs = envs;
    }

    public String getTunnelJobName() {
        return tunnelJobName;
    }

    public void setTunnelJobName(String tunnelJobName) {
        this.tunnelJobName = tunnelJobName;
    }

    public String getClientJobName() {
        return clientJobName;
    }

    public void setClientJobName(String clientJobName) {
        this.clientJobName = clientJobName;
    }

    public String getServerUri() {
        return serverUri;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}