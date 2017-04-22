package com.urishort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by mike on 4/16/17.
 */

@RestController
public class ApplicationREST {

    @Autowired
    private UriShortRepository uriShortRepository;

    /**
     * Creates a new uri short
     * @param uriOriginal
     * @return UriShort object
     */
    @RequestMapping(path = "/uri", method = RequestMethod.POST)
    public HttpEntity<UriShort> createUriShort(@RequestParam(value = "uriOriginal") String uriOriginal) {
        UriShort uriShort = new UriShort();
        uriShort.setUriOriginal(uriOriginal);
        uriShortRepository.save(uriShort);
        uriShort.setUriShort(UriKey.getUriShort(uriShort.getUriId()));
        uriShort.add(linkTo(methodOn(ApplicationREST.class).createUriShort(uriOriginal)).withSelfRel());

        return new ResponseEntity<>(uriShort, HttpStatus.OK);
    }

    /**
     * Get a uri from the DB by the uriKey
     * @param uriKey
     * @return
     */
    @RequestMapping(path = "/uri/{uriKey}",method = RequestMethod.GET)
    public ResponseEntity<UriShort> uriRedirect(@PathVariable("uriKey") String uriKey) {
        UriShort uriShort = uriShortRepository.findOne(UriKey.getUriId(uriKey));
        UriKey.setUriShort(uriShort);
        uriShort.add(linkTo(methodOn(ApplicationREST.class).uriRedirect(uriKey)).withSelfRel());

        return new ResponseEntity<>(uriShort, HttpStatus.OK);
    }



    //UPDATE
    //@GetMapping("/uri/{id}")

    //DELETE
    //@DeleteMapping("/uri/{id}")
}
