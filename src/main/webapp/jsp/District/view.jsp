<%@include file="/jsp/init.jsp"%>

<portlet:renderURL var="addURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="path" value="addDistrictPage"/>
</portlet:renderURL>
<portlet:actionURL var="updateURL" name="updateDistrictBase"/>
<%
    List<District> districtList;
    try {
        districtList = DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }
%>

<aui:button-row>
    <aui:button value="Update District Base" name="updateDistrictBase" onClick="<%=updateURL%>"/>
    <aui:button value="Add new District" name="addDistrict"/>
</aui:button-row>

<liferay-ui:search-container
        delta="5"
        emptyResultsMessage="No Results Found"
        deltaConfigurable="true">

    <liferay-ui:search-container-results results="<%= ListUtil.subList(districtList, searchContainer.getStart(), searchContainer.getEnd()) %>"
                                         total="<%= districtList.size() %>"/>
    <liferay-ui:search-container-row className="ru.imagnifi.model.impl.DistrictModelImpl" modelVar="district">
       <liferay-ui:search-container-column-text property="districtId"/>
       <liferay-ui:search-container-column-text property="name"/>
       <liferay-ui:search-container-column-text property="number"/>
       <liferay-ui:search-container-column-text property="status"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator searchContainer="<%=searchContainer %>" paginate="<%=true %>" />
</liferay-ui:search-container>

<aui:script use="liferay-util-window">
    A.one('#<portlet:namespace/>addDistrict').on('click', function(event) {
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
    title: 'Add District'
    });
    });
</aui:script>
