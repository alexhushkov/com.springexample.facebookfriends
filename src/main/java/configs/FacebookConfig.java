package configs;

import facebook.FbReader;
import facebook.FbFriendsReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:fb.properties")
public class FacebookConfig {
    @Resource
    Environment env;

    @Bean
    FbReader fbReader () {
        FbReader fbReader = new FbFriendsReader();
        fbReader.setFbConnection(env.getProperty("accessToken"));

        return fbReader;
    }
}
