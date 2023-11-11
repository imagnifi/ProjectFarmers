<%@ page import="ru.imagnifi.service.DistrictLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="ru.imagnifi.model.District" %>
<%@ page import="java.util.List" %><%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<portlet:defineObjects />

This is the <b>ProjectFarmers1</b>.
<%="\nHello World1"%>
<%=DistrictLocalServiceUtil.printStr()%>
<%
    List<District> districtList;
    try {
        districtList = DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
        System.out.println("kkk");
    } catch (SystemException e) {
        throw new RuntimeException(e);
    }
%>

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
