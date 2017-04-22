package com.urishort;

import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by mike on 4/16/17.
 */

@Entity
@Table(name = "lookup", indexes = {
        @Index(columnList = "uriOriginal", name = "uriOriginal_x")
})
public class UriShort extends ResourceSupport {
    /**
     * Creates a new uri
     * @param uri
     * @return
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long uriId;

    @Column(columnDefinition="TEXT")
    private String uriOriginal;

    @Transient
    private String uriShort;

    public long getUriId() {
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
