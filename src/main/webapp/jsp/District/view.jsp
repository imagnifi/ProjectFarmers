<%@include file="/jsp/init.jsp"%>

This is the <b>ProjectFarmers1</b>.
<%="\nHello World1"%>
<%=DistrictLocalServiceUtil.printStr()%>
<%
    List<District> districtList;
    try {
        districtList = DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
        System.out.println("jsp/District/view.jsp:row 34 print here");
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }
%>

<%--<portlet:renderURL var="addDistrictURL">--%>
<%--    <portlet:param name="mvcPath" value="/guestbook/edit_entry.jsp"/>--%>
<%--</portlet:renderURL>--%>

<aui:button-row>
    <aui:button value="Add new District" name="addDistrict"/>
</aui:button-row>

<liferay-ui:search-container
        delta="2"
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
