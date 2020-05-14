package cloud.simple.web;


import cloud.simple.config.JenkinsProperties;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.JobWithDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @name:${ArthasRest.class}
 * @description: Arthas相关API类
 * @param:
 * @auther: Mackchao.Sun
 * @date: 2020-05-11
 * @version
 **/
@RestController
@RequestMapping("/arthas")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ArthasRest {

//    Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private ArthasService apiManageService;

    @Resource(name = "jenkinsHttpClient")
    private JenkinsHttpClient jenkisHttpClient;
    @Resource(name = "jenkinsServer")
    private JenkinsServer jenkinsServer;
    @Resource(name = "jenkinsProperties")
    private JenkinsProperties jenkinsProperties;

    @Resource(name = "jenkinsHttpClientTest")
    private JenkinsHttpClient jenkisHttpClientTest;
    @Resource(name = "jenkinsServerTest")
    private JenkinsServer jenkinsServerTest;
    @Resource(name = "jenkinsPropertiesTest")
    private JenkinsProperties jenkinsPropertiesTest;

    @Resource(name = "jenkinsHttpClientPre")
    private JenkinsHttpClient jenkisHttpClientPre;
    @Resource(name = "jenkinsServerPre")
    private JenkinsServer jenkinsServerPre;
    @Resource(name = "jenkinsPropertiesPre")
    private JenkinsProperties jenkinsPropertiesPre;

    @Resource(name = "jenkinsHttpClientProd")
    private JenkinsHttpClient jenkisHttpClientProd;
    @Resource(name = "jenkinsServerProd")
    private JenkinsServer jenkinsServerProd;
    @Resource(name = "jenkinsPropertiesProd")
    private JenkinsProperties jenkinsPropertiesProd;


    @Value("${project.jenkins.envs}")
    private String envs;

    /**
     * @name:${NAME}
     * @description: 环境列表
     * @param:
     * @auther: Mackchao.Sun
     * @date: 2020-05-12
     * @version
     **/
    @RequestMapping(value = "/envs", method = RequestMethod.POST)
    public Response<List<String>> envs() throws Exception {
        List resp ;
        if(StringUtils.isEmpty(envs)){
            return new Response<List<String>>().failed(ResponseCode.DATA_NOT_FOUND.getCode(),ResponseCode.DATA_NOT_FOUND.getMessage());
        }else{
            resp = Arrays.asList(envs.split(","));
            //EnvEnum.values();
        }
        return new Response<List<String>>().success(resp);
    }

    /**
     * @name:${NAME}
     * @description: 根据环境获取tunnelserver地址
     * http://172.17.20.10:8558/actuator/arthas
     * @param:
     * @auther: Mackchao.Sun
     * @date: 2020-05-12
     * @version
     **/
    @RequestMapping(value = "/tunnelServer", method = RequestMethod.POST)
    public Response<String> tunnelServe(@RequestBody @Validated JekinsReq jekinsReq) throws Exception {
        String resp = "";
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.dev.getCode())){
            resp =jenkinsProperties.getTunnelServerUrl();

        }
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.test.getCode())){
            resp =jenkinsPropertiesTest.getTunnelServerUrl();

        }
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.pre.getCode())){
            resp =jenkinsPropertiesPre.getTunnelServerUrl();

        }
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.prod.getCode())){
            resp =jenkinsPropertiesProd.getTunnelServerUrl();

        }
        return new Response<String>().success(resp);
    }

    /**
     * @name:${NAME}
     * @description: 根据环境，ip,pid激活客户端
     * 返回http://172.17.20.10:8558/actuator/arthas
     * //1.获取环境test/pre/prod
     *         //2.获取不同环境jekins配置
     *         //3.执行不同环境的调用jekins逻辑-尽量一致
     * @param:
     * @auther: Mackchao.Sun
     * @date: 2020-05-12
     * @version
     **/
    @RequestMapping(value = "/clientExecute", method = RequestMethod.POST)
    public Response<JekinsResp> clientExecute(@RequestBody @Validated JekinsReq jekinsReq) throws Exception {
        JekinsResp resp = new JekinsResp();
        Map p = new HashMap<String,Object>();
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.dev.getCode())){

            p.put("CIB_S_BRANCH","dev_2.0");
            p.put("CIB_S_ENV","test-cloud-10");
            p.put("JAVA_ARGS","-Xms512m -Xmx512m");
            Boolean success = executeJob(jenkinsServer,jenkinsProperties.getTunnelJobName(),p);
            resp.setTunnelServerUrl(jenkinsProperties.getTunnelServerUrl());

        }
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.test.getCode())){

            p.put("CIB_S_BRANCH","dev_2.0");
            p.put("CIB_S_ENV","test-cloud-10");
            p.put("JAVA_ARGS","-Xms512m -Xmx512m");
            Boolean success = executeJob(jenkinsServerTest,jenkinsPropertiesTest.getTunnelJobName(),p);
            resp.setTunnelServerUrl(jenkinsPropertiesTest.getTunnelServerUrl());
        }
        if(jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.pre.getCode())) {

            p.put("CIB_S_BRANCH","dev_2.0");
            p.put("CIB_S_ENV","test-cloud-10");
            p.put("JAVA_ARGS","-Xms512m -Xmx512m");
            Boolean success = executeJob(jenkinsServerPre,jenkinsPropertiesPre.getTunnelJobName(),p);
            resp.setTunnelServerUrl(jenkinsPropertiesPre.getTunnelServerUrl());
        }
        if (jekinsReq.getEnv().equalsIgnoreCase(EnvEnum.prod.getCode())) {

            p.put("CIB_S_BRANCH","dev_2.0");
            p.put("CIB_S_ENV","test-cloud-10");
            p.put("JAVA_ARGS","-Xms512m -Xmx512m");
            Boolean success = executeJob(jenkinsServerProd,jenkinsPropertiesProd.getTunnelJobName(),p);
            resp.setTunnelServerUrl(jenkinsPropertiesProd.getTunnelServerUrl());
        }

        return new Response<JekinsResp>().success(resp);
    }

    private Boolean executeJob(JenkinsServer server,String jobName ,Map param) {
        Boolean success = true;
        Map p = new HashMap<String,Object>();
        p.putAll(param);
        try {
            JobWithDetails j = server.getJob(jobName);
            Integer num = j.getNextBuildNumber();
            j.build(p);
            success = watchBuildEvent(server,jobName, num);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("warning");
            success = false;
        }finally {
            //do nothing
            //log.info("finally");
        }
        return success;
    }

    private Boolean watchBuildEvent(JenkinsServer server,String jobName, Integer num) throws InterruptedException, IOException {
        Boolean success = true;
        JobWithDetails j;
        Build build = null;
        while (null == build){
            Thread.sleep(1000L);
            j = server.getJob(jobName);
            build = j.getBuildByNumber(num);
        }
        BuildWithDetails buildWithDetails = build.details();
        Boolean flag = buildWithDetails.isBuilding();
        while(flag){
            Thread.sleep(1000L);
            j = server.getJob(jobName);
            build = j.getBuildByNumber(num);
            buildWithDetails = build.details();
            flag = buildWithDetails.isBuilding();
        }
        BuildResult buildResult = buildWithDetails.getResult();
        String log = buildWithDetails.getConsoleOutputText();
        if(BuildResult.SUCCESS  == buildResult
            //&& log.contains("Finished: SUCCESS")
        ){
            System.out.println("success");
        }else{
            success = false;
            System.out.println("warning");
        }
        return success;
    }



}

