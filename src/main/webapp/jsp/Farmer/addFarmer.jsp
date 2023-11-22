<%@ taglib prefix="aiu" uri="http://alloy.liferay.com/tld/aui" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@include file="/jsp/init.jsp" %>


<portlet:actionURL name="addFarmer" var="addFarmerURL"/>
<portlet:actionURL name="findFarmer" var="findFarmerURL"/>


<%
    boolean bool = false;
    PortletSession ps = renderRequest.getPortletSession();
    boolean edit = false;
    // if from Edit
    String org, orgForm, inn, kpp, ogrn, districtNumber, shownDistricts, regDate, archiveStatus;
    org = orgForm = inn = kpp = ogrn = districtNumber = shownDistricts = regDate = archiveStatus = "";
    String farmerId = String.valueOf(ps.getAttribute("farmerId"));
    boolean selectedFL = false;
    boolean selectedUR = false;
    boolean selectedIP = false;
    if (!farmerId.equalsIgnoreCase("null")) {
        org = (String) ps.getAttribute("org");
        orgForm = (String) ps.getAttribute("orgForm");
        if (orgForm != null){
            if (orgForm.equalsIgnoreCase("fl")){
                selectedFL = true;
            } else if (orgForm.equalsIgnoreCase("ur")) {
                selectedUR = true;
            } else if (orgForm.equalsIgnoreCase("ip")) {
                selectedIP = true;
            }
        }
        inn = String.valueOf(Long.parseLong(ps.getAttribute("inn")
                                              .toString()) == 0 ? "" : ps.getAttribute("inn"));
        kpp = String.valueOf(Long.parseLong(ps.getAttribute("kpp")
                                              .toString()) == 0 ? "" : ps.getAttribute("kpp"));
        ogrn = String.valueOf(Long.parseLong(ps.getAttribute("ogrn")
                                               .toString()) == 0 ? "" : ps.getAttribute("ogrn"));
        districtNumber = String.valueOf(ps.getAttribute("districtNumber"));
        String distr = "";
        for (District district : (List<District>) ps.getAttribute("shownDistricts")) {
            distr += district.getNumber() + ",";
        }
        if (!distr.isEmpty()) {
            distr = distr.substring(0, distr.length() - 1);
        }
        shownDistricts = distr;
        regDate = (String) ps.getAttribute("regDate");
        archiveStatus = (String) ps.getAttribute("archiveStatus");
        ps.removeAttribute("farmerId");
        ps.removeAttribute("org");
        ps.removeAttribute("orgForm");
        ps.removeAttribute("inn");
        ps.removeAttribute("kpp");
        ps.removeAttribute("ogrn");
        ps.removeAttribute("districtNumber");
        ps.removeAttribute("shownDistricts");
        ps.removeAttribute("regDate");
        ps.removeAttribute("archiveStatus");
        edit = true;
    }
%>
<portlet:actionURL name="editFarmer" var="editFarmerURL">
    <portlet:param name="idEdit" value="<%=farmerId%>"/>
</portlet:actionURL>
<%
    String path = request.getParameter("path");
    String result = "";
    if (path.equalsIgnoreCase("addFarmerPage") && !edit) {
        result = addFarmerURL;
    } else if (path.equalsIgnoreCase("findFarmerPage") && !edit) {
        result = findFarmerURL;
        bool = true;
    } else if (edit) {
        result = editFarmerURL;
    }
%>

<aui:form action="<%= result %>" name="<portlet:namespace />fm">
    <aui:fieldset>
        <aui:input label="Organization Name" name="organization" type="text" value="<%=org%>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength">1000</aui:validator>
        </aui:input>
        <aui:select label="Organization Form" name="orgForm" disabled="<%=bool%>" type="text">
            <aui:option value="FL" selected="<%=selectedFL%>">FL</aui:option>
            <aui:option value="UR" selected="<%=selectedUR%>">UR</aui:option>
            <aui:option value="IP" selected="<%=selectedIP%>">IP</aui:option>
        </aui:select>
        <aui:input label="INN (12-digits)" name="inn" type="number" value="<%=inn%>">
            <aui:validator name="required"/>
            <aui:validator name="number"/>
            <aui:validator errorMessage="INN need's 12-digits number."
                           name="range">[100000000000,999999999999]</aui:validator>
        </aui:input>
        <aui:input label="KPP (9-digits)" disabled="<%=bool%>" name="kpp" type="number" value="<%=kpp%>">
            <aui:validator name="number"/>
            <aui:validator errorMessage="KPP need's 9-digits number." name="range">[100000000,999999999]</aui:validator>
        </aui:input>
        <aui:input label="OGRN (13-digits)" disabled="<%=bool%>" name="ogrn" type="number" value="<%=ogrn%>">
            <aui:validator name="number"/>
            <aui:validator errorMessage="OGRN need's 13-digits number."
                           name="range">[1000000000000,9999999999999]</aui:validator>
        </aui:input>
        <aui:input label="Registration District" disabled="<%=bool%>" name="districtNumber" type="number"
                   value="<%=districtNumber%>"/>
        <aui:input label="Shown Districts" disabled="<%=bool%>" name="shownDistricts" type="text"
                   value="<%=shownDistricts%>"/>
        <aui:input name="regDate" id="regDate" class="form-control" type="text" placeholder="mm/dd/yy"
                   label="Registration Date" disabled="<%=bool%>"
                   value="<%=regDate%>"/>
        <aui:input label="Archive Status" disabled="<%=bool%>" name="archiveStatus" type="checkbox"
                   value="<%=archiveStatus%>"/>
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
    trigger: '#<portlet:namespace/>regDate',
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
