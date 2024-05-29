package com.graphql.graphql.controller;

import com.graphql.graphql.entity.Document;
import com.graphql.graphql.entity.Person;
import com.graphql.graphql.entity.PersonRecord;
import com.graphql.graphql.service.DocumentService;
import com.graphql.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import javax.print.Doc;
import java.util.Collection;

@Controller
public class DocumentController {

    @Autowired
    public DocumentService documentService;

    @QueryMapping
    public Document getDocumentById(@Argument Long id){
        return documentService.getDocumentById(id);
    }
    @MutationMapping
    public Person createPersonAndDocument(@Argument String number,@Argument PersonRecord person){
        return documentService.createPersonAndDocument(number, person);
    }

    @MutationMapping
    public Document createDocument(@Argument String number, @Argument Long personId){
        return documentService.createDocument(number, personId);
    }

    @SchemaMapping
    public Collection<Document> documents(Person person){
        return documentService.findDocumentsByPersonId(person.getId());
    }
}
