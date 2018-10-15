package com.demo.aemLearning.core;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
import com.adobe.cq.sightly.WCMUsePojo;
  
public class MovieService extends WCMUsePojo {
    Logger logger = LoggerFactory.getLogger(MovieService.class);
    protected int numberOfMovies;
    protected String path;
  
    MovieInterface service;
    private List<String> file;
  
    @Override
    public void activate() {
  
        this.numberOfMovies = Integer.valueOf(getProperties().get("maxMovies", ""));
        this.path = getProperties().get("moviesPath", "");
          
        service = getSlingScriptHelper().getService(MovieInterface.class);
    }
  
    public List<String> getFiles() {
        try {
            logger.info("The search term is " + this.numberOfMovies);
            this.file = new ArrayList();
            this.file = service.getUpcomingMovies(numberOfMovies, path);
              
        } catch(Exception e) {
  
        } finally {
            return this.file;
        }
    }
  
}
