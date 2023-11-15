<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@include file="/jsp/init.jsp" %>

<%
    ResultRow resultRow = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Farmer farmer = (Farmer) resultRow.getObject();
    long id = farmer.getFarmerId();
%>

<portlet:actionURL var="editURL" name="editFarmer">
    <portlet:param name="farmerId" value="<%=String.valueOf(id) %>"/>
<%--    <portlet:param name="selRequestNo" value="<%=String.valueOf(farmer.getRequestNo()) %>"/>--%>
</portlet:actionURL>


<portlet:actionURL var="deleteURL" name="deleteFarmer">
    <portlet:param name="farmerId" value="<%=String.valueOf(id) %>"/>
<%--    <portlet:param name="selRequestNo" value="<%=String.valueOf(leaveObj.getRequestNo()) %>"/>--%>
</portlet:actionURL>


<liferay-ui:icon-menu>
    <liferay-ui:icon message="Edit Farmer" url="${editURL }" />
    <liferay-ui:icon message="Delete Famer" url="${deleteURL }" />
</liferay-ui:icon-menu>
