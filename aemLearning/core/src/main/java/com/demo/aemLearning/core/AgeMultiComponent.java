package com.demo.aemLearning.core;

import java.util.ArrayList;
import java.util.List;
  
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
  
import com.adobe.cq.sightly.WCMUsePojo;
  
@SuppressWarnings("deprecation")
public class AgeMultiComponent extends WCMUsePojo {
  
private static final Logger LOGGER = LoggerFactory.getLogger(AgeMultiComponent.class);
private List<AgeMultiBean> submenuItems = new ArrayList<AgeMultiBean>();
  
@Override
public void activate() throws Exception {
setMultiFieldItems();
}
  
/**
* Method to get Multi field data
* @return submenuItems
*/
private List<AgeMultiBean> setMultiFieldItems() {
  
@SuppressWarnings("deprecation")
JSONObject jObj;
try{
String[] itemsProps = getProperties().get("myUserSubmenu", String[].class);
 
if (itemsProps == null) {
     
    LOGGER.info("PROPS IS NULL") ; 
}
 
 
if (itemsProps != null) {
for (int i = 0; i < itemsProps.length; i++) {
  
jObj = new JSONObject(itemsProps[i]);

AgeMultiBean menuItem = new AgeMultiBean();
  
String title = jObj.getString("title");
String age = jObj.getString("age");

  
menuItem.setTitle(title);
menuItem.setAge(age);

submenuItems.add(menuItem);
}
}
}catch(Exception e){
LOGGER.error("Exception while Multifield data {}", e.getMessage(), e);
}
return submenuItems;
}
  
public List<AgeMultiBean> getMultiFieldItems() {
return submenuItems;
}
}


