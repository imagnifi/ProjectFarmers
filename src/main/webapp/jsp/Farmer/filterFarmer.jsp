<%@include file="/jsp/init.jsp" %>

<portlet:actionURL var="viewUrl" name="filterFarmer"/>

<%
    String org =(String) portletSession.getAttribute("organizationFilter");
    String inn =(String) portletSession.getAttribute("innFilter");
    String  districtNumber=(String) portletSession.getAttribute("districtNumberFilter");
    String  regDateFrom=(String) portletSession.getAttribute("regDateFromFilter");
    String regDateTo =(String) portletSession.getAttribute("regDateToFilter");
    String archiveStatusTrue =(String) portletSession.getAttribute("archiveStatusTrueFilter");
    String archiveStatusFalse =(String) portletSession.getAttribute("archiveStatusFalseFilter");
    if (archiveStatusTrue == null && archiveStatusFalse == null){
        archiveStatusTrue = "true";
        archiveStatusFalse = "true";
    }

%>

<aui:form action="<%= viewUrl %>" name="<portlet:namespace />fm1">
    <aui:fieldset>
        <aui:input label="Organization Name" name="organizationFilter" type="text" value="<%=org%>">
            <aui:validator name="maxLength">1000</aui:validator>
        </aui:input>

        <aui:input label="INN (12-digits)" name="innFilter" type="number" value="<%=inn%>">
            <aui:validator name="number"/>
            <aui:validator errorMessage="INN need's 12-digits number."
                           name="range">[100000000000,999999999999]</aui:validator>
        </aui:input>
        <aui:input label="Registration District"  name="districtNumberFilter" type="number"
                   value="<%=districtNumber%>"/>

        <aui:input name="regDateFromFilter" id="regDate" class="form-control" type="text"  placeholder="mm/dd/yy" label="Registration Date From"
                   value="<%=regDateFrom%>"/>
        <aui:input name="regDateToFilter" id="regDate" class="form-control" type="text"  placeholder="mm/dd/yy" label="Registration Date To"
                   value="<%=regDateTo%>"/>
        <aui:input label="Archive Status True"  name="archiveStatusTrueFilter" type="checkbox"
                   value="<%=archiveStatusTrue%>"/>
        <aui:input label="Archive Status False"  name="archiveStatusFalseFilter" type="checkbox"
                   value="<%=archiveStatusFalse%>"/>
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
<aui:script>
    YUI().use(
    'aui-datepicker',
    function(Y) {
    new Y.DatePicker(
    {
    trigger: '#<portlet:namespace />regDate',
    mask: '%d/%m/%y',
    calendar: {
    selectionMode: 'multiple'
    },
    popover: {
    zIndex: 1
    },
    panes: 2
    }
    );
    }
    );
</aui:script>
