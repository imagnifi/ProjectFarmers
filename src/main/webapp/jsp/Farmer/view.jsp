<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ page import="ru.imagnifi.service.persistence.FarmerUtil" %>
<%@ page import="ru.imagnifi.service.persistence.FarmerPersistence" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@include file="/jsp/init.jsp"%>
<liferay-util:include page="/addFarmer.jsp" />


This is the <b>Farmer Portlet</b>.
<%="\nHello World Farmer"%>

<%
    List<Farmer> farmerList;
    try {
        farmerList = FarmerLocalServiceUtil.getFarmers(0, FarmerLocalServiceUtil.getFarmersCount());
        System.out.println("Farmer/view.jsp row 10 is print");
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }
    FarmerPersistence persistence = FarmerUtil.getPersistence();

%>

<aui:button-row>
    <portlet:renderURL var="addFarmerURL">
        <portlet:param name="addFarmerPath" value="/addFarmer.jsp"/>
    </portlet:renderURL>
<%--    <aui:button onClick="<%= addFarmerURL %>" value="Add new Farmer"/>--%>
    <button onClick="
var organizationWindow = window.open('<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="jspPage" value="/jsp/Farmer/addFarmer.jsp"/><portlet:param name="redirect" value="#"/></portlet:renderURL>',
         'title', 'directories=no, height=340, location=no, menubar=no, resizable=yes, scrollbars=yes, status=no, toolbar=no,
               width=680, left=200, top=200');
        organizationWindow.focus();">Add new Farmer</button>
    <aui:button value="Update Farmer Base"/>
</aui:button-row>

<liferay-ui:search-container
        delta="2"
        emptyResultsMessage="No Results Found"
        deltaConfigurable="true">

    <liferay-ui:search-container-results results="<%= ListUtil.subList(farmerList, searchContainer.getStart(), searchContainer.getEnd()) %>"
                                         total="<%= farmerList.size() %>"/>
    <liferay-ui:search-container-row className="ru.imagnifi.model.impl.FarmerModelImpl" modelVar="farmer">
       <liferay-ui:search-container-column-text property="id" title="ID"/>
       <liferay-ui:search-container-column-text property="organization"/>
       <liferay-ui:search-container-column-text property="orgForm"/>
       <liferay-ui:search-container-column-text property="inn"/>
       <liferay-ui:search-container-column-text property="kpp"/>
       <liferay-ui:search-container-column-text property="ogrn"/>
       <liferay-ui:search-container-column-text property="districtId" title="District Registration" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="<%=true %>" />
</liferay-ui:search-container>


<%--<aui:fieldset>--%>

<%--    <aui:input name="name" />--%>
<%--    <aui:input name="email" />--%>
<%--    <aui:input name="message" />--%>
<%--    <aui:input name='guestbookId'/>--%>

<%--</aui:fieldset>--%>
