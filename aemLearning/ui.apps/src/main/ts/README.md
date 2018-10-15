# Aem example components

This folder contains the react components and javascript build tools for the AEM react demo project.


There are the following scripts:


will generate the server and client-side javascript files to include in the page and store it in the content package
under the path define in webpack.config.js. In environment mode _development_ the javascript will include sourcemap and in environment 
mode _production_ the javscript will
 be optimized by uglify.

*parameters*

- environment : --env=production | development 


To set the name/ip of your local AEM instance:

npm config set demo:crx http://admin:admin@localhost:4502/crx/repository/crx.default



Detects changes to files and automatically deploys these via webdav in to the running AEM instance.




will run the tests in the test directory


runs the tslint constraints.

