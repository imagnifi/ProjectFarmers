<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@include file="/jsp/init.jsp" %>

<%
    ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Farmer farmer = (Farmer) resultRow.getObject();
    long id = farmer.getFarmerId();
    String org = ParamUtil.getString(request, "org");

%>
<portlet:actionURL var="deleteURL" name="deleteFarmer">
    <portlet:param name="farmerId" value="<%=String.valueOf(id) %>"/>
    <portlet:param name="loc" value="<%=org%>"/>
</portlet:actionURL>

<portlet:renderURL var="editURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>" >
    <portlet:param name="path" value="addFarmerPage"/>
    <portlet:param name="farmerIdEdit" value="<%=String.valueOf(id)%>"/>
</portlet:renderURL>

<liferay-ui:icon-menu>
    <liferay-ui:icon iconCssClass="icon-edit" message="Edit Farmer" id="editFarmer" target="top" url="<%=editURL%>" useDialog="true" />
    <liferay-ui:icon iconCssClass="icon-trash" message="Delete Famer" id="deleteFarmer" url="${deleteURL}" />
</liferay-ui:icon-menu>
