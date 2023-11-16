<%@include file="/jsp/init.jsp" %>

<%
    String org = ParamUtil.getString(request, "org");
    long inn = ParamUtil.getLong(request, "inn");
    List<Farmer> farmerList;
    try {
        System.out.println("Farmer.view.jsp");
        farmerList = FarmerLocalServiceUtil.findByNameInn(org, inn);
        System.out.println("farmerList.size() = " + farmerList.size());
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }

%>

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
