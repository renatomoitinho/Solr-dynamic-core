/* Copyright (c) - UOL Inc,
 * Todos os direitos reservados
 *
 * Este arquivo e uma propriedade confidencial do Universo Online Inc.
 * Nenhuma parte do mesmo pode ser copiada, reproduzida, impressa ou
 * transmitida por qualquer meio sem autorizacao expressa e por escrito
 * de um representante legal do Universo Online Inc.
 *
 * All rights reserved
 *
 * This file is a confidential property of Universo Online Inc.
 * No part of this file may be reproduced or copied in any form or by
 * any means without written permission from an authorized person from
 * Universo Online Inc.
 */

package solr.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.Query.Operator;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import solr.sample.model.Slayer;
import solr.sample.util.SearchableSlayerDefinition;

import java.util.Collection;

/**
 * @author cin_redias
 * @since 20/08/15
 */
public interface SlayerRepository extends SearchableSlayerDefinition, SolrCrudRepository<Slayer, String> {

    @Query(value = "sku:?0")
    @Facet(fields = {SKU})
    FacetPage<Slayer> findWith(String sku, Pageable pageable);

    @Query(fields = { NAME, SKU, BRAND, CATEGORY}, defaultOperator = Operator.AND)
    HighlightPage<Slayer> findByNameIn(Collection<String> names, Pageable page);

}
