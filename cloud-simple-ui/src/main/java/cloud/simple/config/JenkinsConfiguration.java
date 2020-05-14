package com.gofun.ms.api.manage.common.config;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Mackchao.Sun
 * @class:JenkinsConfiguration
 * @description: TODO
 * @date:2020/5/11 14:20
 **/
@Configuration
public class JenkinsConfiguration {

    /*为jenkinsProperties注入配置值，也可以在jenkinsProperties上添加Component注解和ConfigurationProperties(prefix="project.jenkins")注解来实现注入功能*/
    @Bean(name = "jenkinsProperties")
    public JenkinsProperties jenkinsProperties(
            @Value("${project.jenkins.default.server-uri}") String serverUri,
            @Value("${project.jenkins.default.username}") String username,
            @Value("${project.jenkins.default.password}") String password,
            @Value("${project.jenkins.default.client-job-name}") String clientJobName,
            @Value("${project.jenkins.default.tunnel-job-name}") String tunnelJobName,
            @Value("${project.jenkins.default.tunnel-server-url}") String tunnelServerUrl) {
        JenkinsProperties jenkinsProperties = new JenkinsProperties();
        jenkinsProperties.setServerUri(serverUri);
        jenkinsProperties.setUsername(username);
        jenkinsProperties.setPassword(password);
        jenkinsProperties.setClientJobName(clientJobName);
        jenkinsProperties.setTunnelJobName(tunnelJobName);
        jenkinsProperties.setTunnelServerUrl(tunnelServerUrl);
        return jenkinsProperties;
    }
    /*注入jenkinsHttpClient对象*/
    @Bean(name = "jenkinsHttpClient")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsHttpClient getJenkinsHttpClient(@Qualifier("jenkinsProperties") JenkinsProperties jenkinsProperties) throws URISyntaxException {
        return new JenkinsHttpClient(
                new URI(jenkinsProperties.getServerUri()),
                jenkinsProperties.getUsername(),
                jenkinsProperties.getPassword());
    }
    /*注入jenkinsServer对象*/
    @Bean(name = "jenkinsServer")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsServer getJenkinsServer(@Qualifier("jenkinsHttpClient") JenkinsHttpClient jenkinsHttpClient) {
        return new JenkinsServer(jenkinsHttpClient);
    }



    @Bean(name = "jenkinsPropertiesTest")
    public JenkinsProperties jenkinsPropertiesTest(
            @Value("${project.jenkins.test.server-uri}") String serverUri,
            @Value("${project.jenkins.test.username}") String username,
            @Value("${project.jenkins.test.password}") String password,
            @Value("${project.jenkins.test.client-job-name}") String clientJobName,
            @Value("${project.jenkins.test.tunnel-job-name}") String tunnelJobName,
            @Value("${project.jenkins.test.tunnel-server-url}") String tunnelServerUrl) {
        JenkinsProperties jenkinsProperties = new JenkinsProperties();
        jenkinsProperties.setServerUri(serverUri);
        jenkinsProperties.setUsername(username);
        jenkinsProperties.setPassword(password);
        jenkinsProperties.setClientJobName(clientJobName);
        jenkinsProperties.setTunnelJobName(tunnelJobName);
        jenkinsProperties.setTunnelServerUrl(tunnelServerUrl);
        return jenkinsProperties;
    }
    /*注入jenkinsHttpClient对象*/
    @Bean(name = "jenkinsHttpClientTest")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsHttpClient getJenkinsHttpClientTest(@Qualifier("jenkinsPropertiesTest") JenkinsProperties jenkinsProperties) throws URISyntaxException {
        return new JenkinsHttpClient(
                new URI(jenkinsProperties.getServerUri()),
                jenkinsProperties.getUsername(),
                jenkinsProperties.getPassword());
    }
    /*注入jenkinsServer对象*/
    @Bean(name = "jenkinsServerTest")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsServer getJenkinsServerTest(@Qualifier("jenkinsHttpClientTest") JenkinsHttpClient jenkinsHttpClient) {
        return new JenkinsServer(jenkinsHttpClient);
    }


    @Bean(name = "jenkinsPropertiesPre")
    public JenkinsProperties jenkinsPropertiesPre(
            @Value("${project.jenkins.pre.server-uri}") String serverUri,
            @Value("${project.jenkins.pre.username}") String username,
            @Value("${project.jenkins.pre.password}") String password,
            @Value("${project.jenkins.pre.client-job-name}") String clientJobName,
            @Value("${project.jenkins.pre.tunnel-job-name}") String tunnelJobName,
            @Value("${project.jenkins.pre.tunnel-server-url}") String tunnelServerUrl) {
        JenkinsProperties jenkinsProperties = new JenkinsProperties();
        jenkinsProperties.setServerUri(serverUri);
        jenkinsProperties.setUsername(username);
        jenkinsProperties.setPassword(password);
        jenkinsProperties.setClientJobName(clientJobName);
        jenkinsProperties.setTunnelJobName(tunnelJobName);
        jenkinsProperties.setTunnelServerUrl(tunnelServerUrl);
        return jenkinsProperties;
    }
    /*注入jenkinsHttpClient对象*/
    @Bean(name = "jenkinsHttpClientPre")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsHttpClient getJenkinsHttpClientPre(@Qualifier("jenkinsPropertiesPre") JenkinsProperties jenkinsProperties) throws URISyntaxException {
        return new JenkinsHttpClient(
                new URI(jenkinsProperties.getServerUri()),
                jenkinsProperties.getUsername(),
                jenkinsProperties.getPassword());
    }
    /*注入jenkinsServer对象*/
    @Bean(name = "jenkinsServerPre")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsServer getJenkinsServerPre(@Qualifier("jenkinsHttpClientPre") JenkinsHttpClient jenkinsHttpClient) {
        return new JenkinsServer(jenkinsHttpClient);
    }


    @Bean(name = "jenkinsPropertiesProd")
    public JenkinsProperties jenkinsPropertiesProd(
            @Value("${project.jenkins.prod.server-uri}") String serverUri,
            @Value("${project.jenkins.prod.username}") String username,
            @Value("${project.jenkins.prod.password}") String password,
            @Value("${project.jenkins.prod.client-job-name}") String clientJobName,
            @Value("${project.jenkins.prod.tunnel-job-name}") String tunnelJobName,
            @Value("${project.jenkins.prod.tunnel-server-url}") String tunnelServerUrl) {
        JenkinsProperties jenkinsProperties = new JenkinsProperties();
        jenkinsProperties.setServerUri(serverUri);
        jenkinsProperties.setUsername(username);
        jenkinsProperties.setPassword(password);
        jenkinsProperties.setClientJobName(clientJobName);
        jenkinsProperties.setTunnelJobName(tunnelJobName);
        jenkinsProperties.setTunnelServerUrl(tunnelServerUrl);
        return jenkinsProperties;
    }
    /*注入jenkinsHttpClient对象*/
    @Bean(name = "jenkinsHttpClientProd")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsHttpClient getJenkinsHttpClientProd(@Qualifier("jenkinsPropertiesProd") JenkinsProperties jenkinsProperties) throws URISyntaxException {
        return new JenkinsHttpClient(
                new URI(jenkinsProperties.getServerUri()),
                jenkinsProperties.getUsername(),
                jenkinsProperties.getPassword());
    }
    /*注入jenkinsServer对象*/
    @Bean(name = "jenkinsServerProd")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public JenkinsServer getJenkinsServerProd(@Qualifier("jenkinsHttpClientProd") JenkinsHttpClient jenkinsHttpClient) {
        return new JenkinsServer(jenkinsHttpClient);
    }
}