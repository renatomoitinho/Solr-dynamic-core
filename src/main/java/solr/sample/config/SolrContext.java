package solr.sample.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @author cin_redias
 * @since 20/08/15
 */
@Configuration
@ComponentScan(basePackages = "solr.sample")
@EnableSolrRepositories(basePackages = {"solr.sample"}, multicoreSupport = true)
public class SolrContext {

    static final String SOLR_HOST = "http://localhost:8983/solr";

    @Bean
    public SolrServer solrServer() {
        return new HttpSolrServer(SOLR_HOST);
    }
}
