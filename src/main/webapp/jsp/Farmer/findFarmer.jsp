<%@include file="/jsp/init.jsp" %>

<portlet:renderURL var="update">
    <portlet:param name="path" value="findFarmerPage"/>
</portlet:renderURL>


<%
    String org = ParamUtil.getString(request, "org");
    long inn = ParamUtil.getLong(request, "inn");
    List<Farmer> farmerList;
    long farmId = 0;
    try {
        System.out.println("Farmer.view.jsp");
        farmerList = FarmerLocalServiceUtil.findByNameInn(org, inn);
        Farmer farmer = null;
        if (!farmerList.isEmpty()) {
            farmer = farmerList.get(0);
        }
        if (farmer != null) {
            farmId = farmer.getFarmerId();
        }
        System.out.println("farmerList.size() = " + farmerList.size());
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }

%>

<portlet:actionURL var="updateURL" name="updateFinder">
    <portlet:param name="farmId" value="<%=String.valueOf(farmId)%>"/>
</portlet:actionURL>


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

<aui:button-row>
    <aui:button type="button" value="Update Base" onClick="<%=updateURL%>"/>
</aui:button-row>
