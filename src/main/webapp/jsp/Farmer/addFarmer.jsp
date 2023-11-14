<%@include file="/jsp/init.jsp" %>
<%
    System.out.println("addFarmer.jsp is visited");
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/jsp/Farmer/addFarmer.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addFarmer" var="addFarmerURL">
    <%--    <portlet:param name="winId" value="<%= <portlet:namespace/>dialog%>"/>--%>
</portlet:actionURL>

<aui:form action="<%= addFarmerURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input label="Organization Name" name="organization" type="text">
            <aui:validator name="required"/>
            <aui:validator name="maxLength">1000</aui:validator>
        </aui:input>
        <aui:input label="Organization Form" name="orgForm" type="text">
            <aui:validator name="maxLength">1000</aui:validator>
        </aui:input>
        <aui:input label="INN (12-digits)" name="inn" type="number">
            <aui:validator name="required"/>
            <aui:validator name="number"/>
            <aui:validator errorMessage="INN need's 12-digits number."
                           name="range">[100000000000,999999999999]</aui:validator>
        </aui:input>
        <aui:input label="KPP (9-digits)" name="kpp" type="number">
            <aui:validator name="number"/>
            <aui:validator errorMessage="KPP need's 9-digits number." name="range">[100000000,999999999]</aui:validator>
        </aui:input>
        <aui:input label="OGRN (13-digits)" name="ogrn" type="number">
            <aui:validator name="number"/>
            <aui:validator errorMessage="OGRN need's 13-digits number."
                           name="range">[1000000000000,9999999999999]</aui:validator>
        </aui:input>
        <aui:input label="Registration District" name="districtId" type="number"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" onClick="Submit()"/>
        <%--        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"/>--%>
        <aui:button type="cancel" onClick="window.close();"/>
<%--        <aui:script>window.close()</aui:script>--%>
    </aui:button-row>
</aui:form>

<script>
    var jj=0
    function Submit() {
        <%--        <%=addFarmerURL%>--%>
        <%--        <%=viewURL%>--%>
        window.Submit()

        // window.close()
    }
</script>
