package com.graphql.graphql.repository;

import com.graphql.graphql.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    Collection<Document> findDocumentsByPersonId(Long personId);
}
