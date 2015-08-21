package solr.sample.repository;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.SolrRepository;
import org.springframework.stereotype.Component;

/**
 * @author cin_redias
 * @since 21/08/15
 */
@Component
public class SolrRepositoryFactory {

    @Autowired private SolrServer solrServer;

    public<T extends SolrRepository> T getRepository(String coreName ,Class<T> aClass) {
        SolrTemplate solrTemplate = new SolrTemplate(solrServer, coreName);
        return new org.springframework.data.solr.repository.support.SolrRepositoryFactory(solrTemplate).getRepository(aClass);
    }
}
