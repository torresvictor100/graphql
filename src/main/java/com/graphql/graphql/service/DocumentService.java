package com.graphql.graphql.service;

import com.graphql.graphql.entity.Document;
import com.graphql.graphql.entity.Person;
import com.graphql.graphql.entity.PersonRecord;
import com.graphql.graphql.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PersonService personService;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Person createPersonAndDocument(String number, PersonRecord personRecord){
        Person person = personService.createPerson(personRecord.name());
        Document document = documentRepository.save(instanciarDocument(number, person.getId()));
        person = personService.getPersonById(person.getId());
        return person;
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }


    public Collection<Document> findDocumentsByPersonId(Long id) {
        return documentRepository.findDocumentsByPersonId(id);
    }

    public Document createDocument(String number, Long personId) {

        return documentRepository.save(instanciarDocument(number, personId));
    }

    private Document instanciarDocument(String number, Long personId) {
        Document document = new Document();
        document.setNumber(number);
        document.setPerson(personService.getPersonById(personId));
        return document;
    }

    public Document updateDocument(Long id, Document updatedDocument) {
        Optional<Document> existingDocumentOptional = documentRepository.findById(id);
        if (existingDocumentOptional.isPresent()) {
            Document existingDocument = existingDocumentOptional.get();
            existingDocument.setNumber(updatedDocument.getNumber());
            return documentRepository.save(existingDocument);
        } else {
            throw new IllegalArgumentException("Document with id " + id + " not found");
        }
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
