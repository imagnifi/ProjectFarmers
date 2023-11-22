<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="java.util.Collections" %>
<%@ page import="ru.imagnifi.comparator.CustomComparatorUtil" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="/jsp/init.jsp" %>

<%

    String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
    String orderByType = ParamUtil.getString(renderRequest, "orderByType");
    System.out.println("------------VVV");
    ParamUtil.print(renderRequest);
    System.out.println("------------^^^");

    /* Code to convert asc in desc after clicking on cloumn */
    if (orderByCol == null || orderByCol.equals(StringPool.BLANK)) {
        orderByCol = "farmerId";
//        renderRequest.setAttribute("orderByCol", orderByCol);
    }
    if (orderByType == null || orderByType.equals(StringPool.BLANK)) {
        orderByType = "asc";
//        renderRequest.setAttribute("orderByType", orderByType);
    } else {
        orderByType = orderByType.equals("desc") ? "asc" : "desc";
    }

    List<Farmer> farmerListUnmod;
    List<Farmer> farmerListMod;
    try {
        PortletSession ps = renderRequest.getPortletSession();
        System.out.println("Farmer.view.jsp");
        List<Farmer> listFarmers = (List<Farmer>) ps.getAttribute("listFarmers");
        if (listFarmers != null) {
            farmerListMod = listFarmers;
        } else {
            farmerListUnmod = FarmerLocalServiceUtil.getFarmers(0, FarmerLocalServiceUtil.getFarmersCount());
            farmerListMod = new ArrayList<Farmer>(farmerListUnmod);
        }

        Collections.sort(farmerListMod, CustomComparatorUtil.getComparator(orderByCol, orderByType));
        System.out.println("farmerListUnmod.size() = " + farmerListMod.size());
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }
    boolean disabledResetFilter = true;
    String resetButtonFarmerFilter = (String) portletSession.getAttribute("resetButtonFarmerFilter");
    if (resetButtonFarmerFilter!= null && resetButtonFarmerFilter.equals("true")){
        disabledResetFilter = false;
    }
%>

<portlet:renderURL var="addURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="path" value="addFarmerPage"/>
</portlet:renderURL>

<portlet:renderURL var="findURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="path" value="findFarmerPage"/>
</portlet:renderURL>

<portlet:renderURL var="filterURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="path" value="filterFarmerPage"/>
</portlet:renderURL>

<portlet:actionURL var="updateURL" name="updateFarmerBase"/>
<portlet:actionURL var="resetFilterURL" name="resetFilter"/>


<aui:button-row>
    <aui:button type="button" onClick="<%=updateURL%>" value="Update Farmer Base"/>
    <aui:button type="button" name="addFarmer" id="addFarmer" value="Add new Farmer"/>
    <aui:button type="button" name="findFarmer" value="Find"/>
    <aui:button type="button" name="filterFarmer" value="Filter"/>
    <aui:button type="button" value="Reset Filter" onClick="<%=resetFilterURL%>" disabled="<%=disabledResetFilter%>"/>
</aui:button-row>


<liferay-ui:search-container
        delta="10"
        emptyResultsMessage="No Results Found"
        deltaConfigurable="true"
        orderByType="<%=orderByType %>">
    <liferay-ui:search-container-results
            results="<%= ListUtil.subList(farmerListMod, searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= farmerListMod.size() %>"/>
    <liferay-ui:search-container-row className="ru.imagnifi.model.impl.FarmerModelImpl" modelVar="farmerModel">
        <%--        <liferay-ui:custom-attribute-list className="<%=District.class.getName()%>" classPK="districtId"/>--%>
        <liferay-ui:search-container-column-text property="farmerId" name="ID" orderable="true"
                                                 orderableProperty="farmerId"/>
        <liferay-ui:search-container-column-text property="organization"/>
        <liferay-ui:search-container-column-text property="orgForm" />
        <liferay-ui:search-container-column-text property="inn"/>
        <liferay-ui:search-container-column-text property="kpp"/>
        <liferay-ui:search-container-column-text property="ogrn"/>
        <liferay-ui:search-container-column-text property="districtNumber" name="District Registration" orderable="true"
                                                 orderableProperty="districtNumber"/>
        <liferay-ui:search-container-column-text
                value="<%=FarmerLocalServiceUtil.getListSownDistricts(farmerModel.getFarmerId())%>"
                name="Shown Districts"/>
        <liferay-ui:search-container-column-text property="registrationDate" name="Reg Date" orderable="true"
                                                 orderableProperty="registrationDate">
            <aui:input name="from" type="text"/>
            <aui:input name="to" type="text"/>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text property="archiveStatus" name="Archive Status"/>
        <liferay-ui:search-container-column-jsp name="Action" align="center" path="/jsp/Farmer/details.jsp"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="<%=true %>"/>
</liferay-ui:search-container>

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
    uri: '<%=addURL %>',
    title: 'Add Farmer'

    });
    });
</aui:script>

<aui:script use="liferay-util-window">
    A.one('#<portlet:namespace/>findFarmer').on('click', function(event) {
    <!-- alert("open"); -->
    Liferay.Util.openWindow({
    dialog: {
    centered: true,
    height: 500,
    modal: true,
    width: 700
    },
    id: '<portlet:namespace/>dialog',
    uri: '<%=findURL %>',
    title: 'Find Farmer'
    });
    });
</aui:script>

<aui:script use="liferay-util-window">
    A.one('#<portlet:namespace/>filterFarmer').on('click', function(event) {
    <!-- alert("open"); -->
    Liferay.Util.openWindow({
    dialog: {
    centered: true,
    height: 500,
    modal: true,
    width: 700
    },
    id: '<portlet:namespace/>dialog',
    uri: '<%=filterURL %>',
    title: 'Filter Farmer'
    });
    });
</aui:script>


<%
    portletSession.setAttribute("atr", "add", PortletSession.PORTLET_SCOPE);
%>

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
