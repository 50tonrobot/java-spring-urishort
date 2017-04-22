package com.urishort;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by mike on 4/16/17.
 */

@Entity
public class UriShort extends ResourceSupport {
    /**
     * Creates a new uri
     * @param uri
     * @return
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer uriId;

    @Column(unique = true, columnDefinition="TEXT")
    private String uriOriginal;

    @Transient
    private String uriShort;

    public Integer getUriId() {
        return uriId;
    }

    public String getUriOriginal() {
        return uriOriginal;
    }

    public void setUriOriginal(String uriOriginal) {
        this.uriOriginal = uriOriginal;
    }

    public String getUriShort() {
        return uriShort;
    }

    public void setUriShort(String uriShort) {
        this.uriShort = uriShort;
    }
}
