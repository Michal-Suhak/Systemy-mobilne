package com.example.zad_7;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("author_name")
    private List<String> authors;
    @SerializedName("cover_i")
    private String cover;
    @SerializedName("number_of_pages_median")
    private String numberOfPages;
    @SerializedName("first_publish_year")
    private int publishYear;
    @SerializedName("language")
    private List<String> languages;
    @SerializedName("ebook_access")
    private String ebookAccess;

    public void setTitle(String title) { this.title = title; }

    public void setAuthors(List<String> authors) { this.authors = authors; }

    public void setCover(String cover) { this.cover = cover; }

    public void setNumberOfPages(String numberOfPages) { this.numberOfPages = numberOfPages; }

    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }

    public void setLanguages(List<String> languages) { this.languages = languages; }

    public void setEbookAccess(String ebookAccess) { this.ebookAccess = ebookAccess; }

    public String getTitle() { return this.title; }

    public List<String> getAuthors() { return this.authors; }

    public String getCover() { return this.cover; }

    public String getNumberOfPages() { return this.numberOfPages; }

    public int getPublishYear() { return this.publishYear; }

    public List<String> getLanguages() { return this.languages; }

    public String getEbookAccess() { return this.ebookAccess; }
}
