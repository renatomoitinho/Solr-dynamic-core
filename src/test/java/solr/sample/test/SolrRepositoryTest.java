/*

<doc>
  <field name="sku">AD096SH83ZSUDFMX</field>
  <field name="name">Neo 3 Stripes LO</field>
  <field name="brand">Adidas</field>
  <field name="category">Zapatos para Hombre</field>
  <field name="url">http://www.dafiti.com.mx/Neo-3-Stripes-LO-70116.html</field>
  <field name="image_url">http://static.dafiti.com.mx/p/adidas-9077-61107-2.jpg</field>
  <field name="price">699.00</field>
  <field name="sale_price">559.00</field>
  <field name="active">true</field>
  <field name="suggestions">CH157SH61AFEDFMX, CH157SH22AGRDFMX</field>
</doc>

 */

package solr.sample.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import solr.sample.config.SolrContext;
import solr.sample.repository.SlayerRepository;
import solr.sample.repository.SolrRepositoryFactory;

/**
 * @author cin_redias
 * @since 21/08/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SolrContext.class})
public class SolrRepositoryTest {

    @Autowired
    SolrRepositoryFactory repositoryFactory;

    SlayerRepository repositoryCoreA;
    SlayerRepository repositoryCoreB;

    @Before
    public void init() {
        repositoryCoreA = repositoryFactory.getRepository("coreA", SlayerRepository.class);
        repositoryCoreB = repositoryFactory.getRepository("coreB", SlayerRepository.class);
    }

    public @Test void delete() {
        repositoryCoreA.delete("AAA");
    }

    public @Test void insert() {
        repositoryCoreA.save(null);
    }

    public @Test void find() {
        repositoryCoreA.findAll();
    }

}
