<%@include file="/jsp/init.jsp" %>

<portlet:actionURL name="addFarmer" var="addFarmerURL"/>
<portlet:actionURL name="findFarmer" var="findFarmerURL"/>

<%
    System.out.println("Farmer/addFarmer.jsp");
    String path = request.getParameter("path");
    String result = "";
    if (path.equalsIgnoreCase("addFarmerPage")){
        result = addFarmerURL;
    } else if (path.equalsIgnoreCase("findFarmerPage")) {
        result = findFarmerURL;
    }
%>

<aui:form action="<%= result %>" name="<portlet:namespace />fm" >
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
    <%
        System.out.println("request.getParameter(\"path\") = " + request.getParameter("path"));
    %>
    <aui:button-row>
        <aui:button type="submit" value="confirm"/>
        <aui:button type="cancel" name="cancel" />
    </aui:button-row>



</aui:form>

<%--<script>--%>
<%--    function Close() {--%>
<%--        window.close();--%>
<%--    }--%>
<%--</script>--%>

<!-- For Closing -->
<aui:script use="aui-base">
    A.one('#<portlet:namespace/>cancel').on('click', function(event) {
    <!-- alert("first"); -->
    var data = '';
    Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(data, '<portlet:namespace/>dialog');
    });
</aui:script>
