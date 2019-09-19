package com.rootnite.template.springrest.controller.dto;

public class EmployeeRequestDto {

    private long id;
    private String name;
    private String document;
    private String documentExt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentExt() {
        return documentExt;
    }

    public void setDocumentExt(String documentExt) {
        this.documentExt = documentExt;
    }
}
