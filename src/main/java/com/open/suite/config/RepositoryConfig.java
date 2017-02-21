package com.open.suite.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author    Minhajul Sarkar<polash.pbt@gmail.com>
 * @version   1.0.00
 * @since     1.0.00
 * 
 */

@Configuration
@EnableJpaRepositories(basePackages= {"com.open.suite.repository"})
public class RepositoryConfig {

}
