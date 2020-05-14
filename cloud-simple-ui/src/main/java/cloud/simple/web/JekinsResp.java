package cloud.simple.web;

/**
 * @author Mackchao.Sun
 * @class:JekinsParam
 * @description: TODO
 * @date:2020/5/11 18:13
 **/
public class JekinsResp {

    private  String env;

    private  String targetIp;

    private  String targetPid;

    private  String agentId;

    private  String jobName;

    private  String tunnelServerUrl;

    public String getTunnelServerUrl() {
        return tunnelServerUrl;
    }

    public void setTunnelServerUrl(String tunnelServerUrl) {
        this.tunnelServerUrl = tunnelServerUrl;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

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