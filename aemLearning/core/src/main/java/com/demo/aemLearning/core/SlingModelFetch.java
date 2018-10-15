package com.demo.aemLearning.core;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
  
@Model(adaptables = Resource.class)
public class SlingModelFetch {
    @Inject
    private String firstName;
    @Inject
    private String lastName;
    @Inject
    private String technology;
      
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTechnology() {
        return technology;
    }
  
}