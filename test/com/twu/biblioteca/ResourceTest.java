package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceTest {
    private Resource resource;

    @Before
    public void chargeResourcesOfTest(){
        resource = new Resource("Flowers", true, "2015");
    }

    @Test
    public void shouldGetNameOfResource() {
        String actual = resource.getName();
        assertEquals("Flowers", actual);
    }

    @Test
    public void shouldGetAvailabilityOfResource() {
        Boolean actual = resource.getAvailable();
        assertEquals(true, actual);
    }

    @Test
    public void shouldGetYearOfResource() {
        String actual = resource.getYear();
        assertEquals("2015", actual);
    }
}
