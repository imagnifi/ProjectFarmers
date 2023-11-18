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

<%--<aui:script use="liferay-util-window">--%>
<%--    A.one('#<portlet:namespace/>editFarmer').on('click', function(event) {--%>
<%--    <!-- alert("open"); -->--%>
<%--    Liferay.Util.openWindow({--%>
<%--    dialog: {--%>
<%--    centered: true,--%>
<%--    height: 500,--%>
<%--    modal: true,--%>
<%--    width: 500--%>
<%--    },--%>
<%--    id: '<portlet:namespace/>dialog',--%>
<%--    title: 'Edit Farmer'--%>
<%--    });--%>
<%--    });--%>
<%--</aui:script>--%>
<%--<!-- For Closing -->--%>
<%--<aui:script>--%>
<%--    Liferay.provide(window,'<portlet:namespace/>closeYourPopUp',--%>
<%--    function(data, dialogId) {--%>
<%--    <!-- alert("second"); -->--%>
<%--    var A = AUI();--%>
<%--    var dialog = Liferay.Util.Window.getById(dialogId);--%>
<%--    dialog.destroy();--%>
<%--    },--%>
<%--    ['liferay-util-window']--%>
<%--    );--%>
<%--</aui:script>--%>
<!-- For Closing -->
<%--<% if (!org.equals("")) {--%>

<%--%>--%>

<%--<aui:script use="aui-base">--%>
<%--    A.one('#<portlet:namespace/>deleteFarmer').on('click', function(event) {--%>
<%--    <!-- alert("first"); -->--%>
<%--    var data = '';--%>
<%--    Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(data, '<portlet:namespace/>dialog');--%>
<%--    });--%>
<%--</aui:script>--%>

<%--<%--%>
<%--    }--%>
<%--%>--%>
