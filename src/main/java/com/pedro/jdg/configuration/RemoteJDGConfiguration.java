package com.pedro.jdg.configuration;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.pedro.jdg.spring.session.infinispan.remote.config.annotation.web.http.EnableInfinispanRemoteHttpSession;



@Configuration
@EnableInfinispanRemoteHttpSession
@PropertySource("classpath:hotrod-client.properties")
public class RemoteJDGConfiguration {
	@Value("${hotrod.server_list}")
	private  String servers;

    @Bean
    public RemoteCacheManager remoteCacheManager() {
        return new RemoteCacheManager(
                new org.infinispan.client.hotrod.configuration.ConfigurationBuilder()
                        .addServers(servers)
                        .build());
    }

}
