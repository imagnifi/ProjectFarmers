<%@include file="/jsp/init.jsp" %>

<portlet:actionURL var="addURL" name="addDistrict"/>

<aui:form action="<%= addURL %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input label="Name" name="nameDistrict" type="text" >
            <aui:validator name="required"/>
            <aui:validator name="maxLength">1000</aui:validator>
        </aui:input>
        <aui:input label="Number"  name="numberDistrict" type="text">
            <aui:validator name="number"/>
        </aui:input>
        <aui:input label="Archive Status"  name="archiveStatusDistrict" type="checkbox"/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="confirm"/>
        <aui:button type="cancel" name="cancel"/>
    </aui:button-row>

</aui:form>

<!-- For Closing -->
<aui:script use="aui-base">
    A.one('#<portlet:namespace/>cancel').on('click', function(event) {
    <!-- alert("first"); -->
    var data = '';
    Liferay.Util.getOpener().<portlet:namespace/>closeYourPopUp(data, '<portlet:namespace/>dialog');
    });
</aui:script>
