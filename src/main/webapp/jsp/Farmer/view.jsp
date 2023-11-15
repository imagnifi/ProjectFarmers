<%@include file="/jsp/init.jsp" %>
<%--<liferay-util:include page="/addFarmer.jsp"/>--%>


This is the <b>Farmer Portlet</b>.
<%="\nHello World Farmer"%>

<%
//    FarmerPersistence persistence = FarmerUtil.getPersistence();
    List<Farmer> farmerList;
    try {
        System.out.println("Farmer.view.jsp");
        farmerList = FarmerLocalServiceUtil.getFarmers(0, FarmerLocalServiceUtil.getFarmersCount());
        System.out.println("farmerList.size() = " + farmerList.size());
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }

%>

<portlet:renderURL var="addURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="path" value="addFarmerPage"/>
</portlet:renderURL>

<portlet:actionURL var="updateURL" name="updateFarmerBase">
<%--     <portlet:param name="listFarmer" value="<%=farmerList%>"/>--%>
</portlet:actionURL>

<aui:button-row>
    <aui:button type="button" name="addFarmer"  id="addFarmer" value="Add new Farmer"/>
    <aui:button type="button" onClick="<%=updateURL%>" value="Update Farmer Base"/>
</aui:button-row>

<aui:script use="liferay-util-window">
    A.one('#<portlet:namespace/>addFarmer').on('click', function(event) {
    <!-- alert("open"); -->
    Liferay.Util.openWindow({
    dialog: {
    centered: true,
    height: 500,
    modal: true,
    width: 500
    },
    id: '<portlet:namespace/>dialog',
    title: 'Add new Farmer or Edit existing Farmer',
    uri: '<%=addURL %>'
    });
    });
</aui:script>

<liferay-ui:search-container
        delta="5"
        emptyResultsMessage="No Results Found"
        deltaConfigurable="true">

    <liferay-ui:search-container-results
            results="<%= ListUtil.subList(farmerList, searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= farmerList.size() %>"/>
    <liferay-ui:search-container-row className="ru.imagnifi.model.impl.FarmerModelImpl" modelVar="farmer">
        <liferay-ui:search-container-column-text property="farmerId" title="ID"/>
        <liferay-ui:search-container-column-text property="organization"/>
        <liferay-ui:search-container-column-text property="orgForm"/>
        <liferay-ui:search-container-column-text property="inn"/>
        <liferay-ui:search-container-column-text property="kpp"/>
        <liferay-ui:search-container-column-text property="ogrn"/>
        <liferay-ui:search-container-column-text property="districtId" title="District Registration"/>
        <liferay-ui:search-container-column-jsp name="Action" align="center" path="/jsp/Farmer/details.jsp"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="<%=true %>"/>
</liferay-ui:search-container>


<!-- For Closing -->
<aui:script>
    Liferay.provide(window,'<portlet:namespace/>closeYourPopUp',
    function(data, dialogId) {
    <!-- alert("second"); -->
    var A = AUI();
    var dialog = Liferay.Util.Window.getById(dialogId);
    dialog.destroy();
    },
    ['liferay-util-window']
    );
</aui:script>
