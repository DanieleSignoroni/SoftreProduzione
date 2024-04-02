<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/5.0.0/websrcsvil/dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>
  <head>
<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector YAssDocDgtRilevBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YAssDocDgtRilevForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YAssDocDgtRilevForm", "YAssDocDgtRilev", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/produzione/raccoltaDati/YAssDocDgtRilev.js"); 
  YAssDocDgtRilevForm.setServletEnvironment(se); 
  YAssDocDgtRilevForm.setJSTypeList(jsList); 
  YAssDocDgtRilevForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YAssDocDgtRilevForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YAssDocDgtRilevForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YAssDocDgtRilevForm.getMode(); 
  String key = YAssDocDgtRilevForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YAssDocDgtRilevForm.outTraceInfo(getClass().getName()); 
        String collectorName = YAssDocDgtRilevForm.findBODataCollectorName(); 
                YAssDocDgtRilevBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YAssDocDgtRilevBODC instanceof WebDataCollector) 
            ((WebDataCollector)YAssDocDgtRilevBODC).setServletEnvironment(se); 
        YAssDocDgtRilevBODC.initialize("YAssDocDgtRilev", true, 0); 
        YAssDocDgtRilevForm.setBODataCollector(YAssDocDgtRilevBODC); 
        int rcBODC = YAssDocDgtRilevForm.initSecurityServices(); 
        mode = YAssDocDgtRilevForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YAssDocDgtRilevForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YAssDocDgtRilevBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YAssDocDgtRilevForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YAssDocDgtRilevForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YAssDocDgtRilevForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YAssDocDgtRilevForm.getBodyOnBeforeUnload()%>" onload="<%=YAssDocDgtRilevForm.getBodyOnLoad()%>" onunload="<%=YAssDocDgtRilevForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YAssDocDgtRilevForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YAssDocDgtRilevForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YAssDocDgtRilevBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YAssDocDgtRilevForm.getServlet()%>" method="post" name="YAssDocDgtRilevForm" style="height:100%"><%
  YAssDocDgtRilevForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YAssDocDgtRilevForm); 
 mytabbed.addTab("tab1", "it.softre.thip.produzione.raccoltaDati.resources.YAssDocDgtRilev", "tab1", "YAssDocDgtRilev", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YAssDocDgtRilev", "IdTipoDocDgt", null); 
   label.setParent(YAssDocDgtRilevForm); 
%><label class="<%=label.getClassType()%>" for="AssociazioneEntitaTpDgt"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YAssDocDgtRilevAssociazioneEntitaTpDgt =  
     new com.thera.thermfw.web.WebMultiSearchForm("YAssDocDgtRilev", "AssociazioneEntitaTpDgt", false, false, true, 2, null, null); 
  YAssDocDgtRilevAssociazioneEntitaTpDgt.setParent(YAssDocDgtRilevForm); 
  YAssDocDgtRilevAssociazioneEntitaTpDgt.setSpecificDOList("it.softre.thip.produzione.raccoltaDati.web.YAssDocDgtRilevDoList"); 
  YAssDocDgtRilevAssociazioneEntitaTpDgt.write(out); 
%>
<!--<span class="multisearchform" id="AssociazioneEntitaTpDgt"></span>-->
                    </td>
                    <td valign="top">
                      <% 
  WebCheckBox YAssDocDgtRilevShow =  
     new com.thera.thermfw.web.WebCheckBox("YAssDocDgtRilev", "Show"); 
  YAssDocDgtRilevShow.setParent(YAssDocDgtRilevForm); 
%>
<input id="<%=YAssDocDgtRilevShow.getId()%>" name="<%=YAssDocDgtRilevShow.getName()%>" type="checkbox" value="Y"><%
  YAssDocDgtRilevShow.write(out); 
%>

                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YAssDocDgtRilevForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YAssDocDgtRilevForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YAssDocDgtRilevForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YAssDocDgtRilevBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YAssDocDgtRilevForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YAssDocDgtRilevBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YAssDocDgtRilevBODC.getErrorList().getErrors()); 
           if(YAssDocDgtRilevBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(YAssDocDgtRilevBODC != null && !YAssDocDgtRilevBODC.close(false)) 
        errors.addAll(0, YAssDocDgtRilevBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = YAssDocDgtRilevForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YAssDocDgtRilevBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YAssDocDgtRilevForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
