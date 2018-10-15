<%@page session="false"%><%--
   ==============================================================================

  Hero Text component

  Combines the text and the image component

--%><%@ page import="
    com.day.cq.wcm.api.WCMMode,com.day.cq.wcm.foundation.Placeholder" %><%
%><%@include file="/libs/foundation/global.jsp"%><%

        String heading = (String)properties.get("jcr:Heading");
if (heading == null) {
    if(WCMMode.fromRequest(slingRequest) == WCMMode.EDIT) {
        %><%= Placeholder.getDefaultPlaceholder(slingRequest, component,
        "<img src=\"/libs/cq/ui/resources/0.gif\" class=\"cq-list-placeholder\" alt=\"\">")%><%}    
}
else {
%>
        <header>
            <cq:text property="jcr:Heading"  tagName="h1" escapeXml="true"/>
            <cq:text property="jcr:description"  tagName="p" escapeXml="true"/>
        </header>
<%
}
%>
<%<p>Here is the value of the drop component: <%=properties.get("jcr:drop") %></p>%>