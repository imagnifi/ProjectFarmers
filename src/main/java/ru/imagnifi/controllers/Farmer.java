package ru.imagnifi.controllers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.imagnifi.NoSuchFarmerException;
import ru.imagnifi.comparator.CustomComparatorUtil;
import ru.imagnifi.model.District;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.FarmerLocalServiceUtil;
import ru.imagnifi.service.persistence.FarmerUtil;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Farmer extends MVCPortlet {

    public void addFarmer(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
        System.out.println(" Farmer controller: addFarmer 21");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Farmer.class.getName(), request);
        String org = ParamUtil.getString(request, "organization");
        String orgForm = ParamUtil.getString(request, "orgForm");
        long inn = ParamUtil.getLong(request, "inn");
        long kpp = ParamUtil.getLong(request, "kpp");
        long ogrn = ParamUtil.getLong(request, "ogrn");
        long districtNumber = ParamUtil.getLong(request, "districtNumber");
        if (!FarmerLocalServiceUtil.isDistrictNumberExist(districtNumber)) {
            districtNumber = 0;
        }
        String shownDistricts = ParamUtil.getString(request, "shownDistricts");
        String districtIds = FarmerLocalServiceUtil.numbersDistrictToIds(shownDistricts);
        String regDate = ParamUtil.getString(request, "regDate");
        boolean archiveStatus = Boolean.parseBoolean(ParamUtil.getString(request, "archiveStatus"));
        FarmerLocalServiceUtil.addFarmer(org, orgForm, inn, kpp, ogrn, districtNumber, districtIds, regDate,
                archiveStatus);
        String path = ParamUtil.getString(request, "path");
        response.setRenderParameter("path", "addFarmerPage");
    }

    public void findFarmer(ActionRequest request, ActionResponse response) {
        System.out.println(" Farmer controller: findFarmer 38");
        String org = ParamUtil.getString(request, "organization");
        long inn = ParamUtil.getLong(request, "inn");
        response.setRenderParameter("org", org);
        response.setRenderParameter("inn", String.valueOf(inn));
        response.setRenderParameter("path", "findFormPage");
        update();
    }

    public void updateFarmerBase(ActionRequest request, ActionResponse response) throws SystemException {
        System.out.println("Farmer controller: updateFarmerBase 34");
        FarmerUtil.clearCache();
        PortletSession session = request.getPortletSession();
        String resetButtonFarmerFilter = (String) session.getAttribute("resetButtonFarmerFilter");
        if (resetButtonFarmerFilter != null && resetButtonFarmerFilter.equals("true")) {
            session.setAttribute("updateFarmerBaseControl", "true");
            filterFarmer(request, response);
        }
    }

    public void update() {
        FarmerLocalServiceUtil.clearCash();
    }

    public void updateFinder(ActionRequest request,
                             ActionResponse response) throws SystemException, NoSuchFarmerException {
        FarmerLocalServiceUtil.clearCash();
        response.setRenderParameter("path", "findFormPage");
        long farmId = ParamUtil.getLong(request, "farmId");
        ru.imagnifi.model.Farmer farmer = FarmerLocalServiceUtil.findById(farmId);
        response.setRenderParameter("farmId", String.valueOf(farmId));
        response.setRenderParameter("org", farmer.getOrganization());
        response.setRenderParameter("inn", String.valueOf(farmer.getInn()));
    }

    public void editFarmer(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
        System.out.println("Farmer controller: editFarmer 42");
        PortletSession ps = request.getPortletSession();
        ru.imagnifi.model.Farmer farmer = getLFarmer(request, "idEdit");
        if (farmer != null) {
            response.setRenderParameter("path", "addFarmerPage");
            farmer.setOrganization(ParamUtil.getString(request, "organization"));
            farmer.setOrgForm(ParamUtil.getString(request, "orgForm"));
            farmer.setInn(ParamUtil.getLong(request, "inn"));
            farmer.setKpp(ParamUtil.getLong(request, "kpp"));
            farmer.setOgrn(ParamUtil.getLong(request, "ogrn"));
            long districtNumber = ParamUtil.getLong(request, "districtNumber");
            if (!FarmerLocalServiceUtil.isDistrictNumberExist(districtNumber)) {
                districtNumber = 0;
            }
            farmer.setDistrictNumber(districtNumber);
            farmer.setRegistrationDate(ParamUtil.getString(request, "regDate"));
            farmer.setArchiveStatus(ParamUtil.getBoolean(request, "archiveStatus"));
            FarmerLocalServiceUtil.updateFarmerCust(farmer);
            String shownDistricts = ParamUtil.getString(request, "shownDistricts");
            String districtIds = FarmerLocalServiceUtil.numbersDistrictToIds(shownDistricts);
            FarmerLocalServiceUtil.updateFarmerDistricts(farmer, districtIds);
        }
    }



    public void deleteFarmer(ActionRequest request, ActionResponse response) {
        System.out.println("Farmer controller: deleteFarmer 46");
        ru.imagnifi.model.Farmer farmer = getLFarmer(request, "farmerId");
        if (farmer != null) {
            try {
                FarmerLocalServiceUtil.deleteFarmer(farmer);
                SessionMessages.add(request, farmer.getOrganization() + " delete successful");
                update();
            } catch (SystemException e) {
                SessionErrors.add(request, e.getMessage());
                System.out.println("68");
                throw new RuntimeException(e);
            }
        } else {
            SessionErrors.add(request, "Farmer null");
        }
        String loc = ParamUtil.getString(request, "loc");
        if (loc.equals("")) {
            response.setRenderParameter("path", "");
        } else {
            response.setRenderParameter("path", "findFarmerPage");
        }
    }

    private static ru.imagnifi.model.Farmer getLFarmer(ActionRequest request, String param) {
        String parameter = request.getParameter(param);
        long farmerId = Long.parseLong(parameter);
        ru.imagnifi.model.Farmer farmer = null;
        try {
            farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
        } catch (PortalException | SystemException e) {
            throw new RuntimeException(e);
        }
        return farmer;
    }

    @Override
    public void processAction(ActionRequest actionRequest,
                              ActionResponse actionResponse) throws IOException, PortletException {
        System.out.println(" Farmer controller: processAction 41");


        super.processAction(actionRequest, actionResponse);
    }

    public void filterFarmer(ActionRequest request, ActionResponse response) throws SystemException {
        PortletSession portletSession = request.getPortletSession();
        String control = (String) portletSession.getAttribute("updateFarmerBaseControl");
        String organization, inn, districtNumber, regDateFrom, regDateTo, archiveStatusTrue, archiveStatusFalse;
        organization = inn = districtNumber = regDateFrom = regDateTo = archiveStatusTrue = archiveStatusFalse = null;

        if (control != null && control.equals("true")) {
            organization = (String) portletSession.getAttribute("organizationFilter");
            inn = (String) portletSession.getAttribute("innFilter");
            districtNumber = (String) portletSession.getAttribute("districtNumberFilter");
            regDateFrom = (String) portletSession.getAttribute("regDateFromFilter");
            regDateTo = (String) portletSession.getAttribute("regDateToFilter");
            archiveStatusTrue = (String) portletSession.getAttribute("archiveStatusTrueFilter");
            archiveStatusFalse = (String) portletSession.getAttribute("archiveStatusFalseFilter");
        } else {
            organization = ParamUtil.getString(request, "organizationFilter");
            inn = ParamUtil.getString(request, "innFilter");
            districtNumber = ParamUtil.getString(request, "districtNumberFilter");
            regDateFrom = ParamUtil.getString(request, "regDateFromFilter");
            regDateTo = ParamUtil.getString(request, "regDateToFilter");
            archiveStatusTrue = ParamUtil.getString(request, "archiveStatusTrueFilter");
            archiveStatusFalse = ParamUtil.getString(request, "archiveStatusFalseFilter");
        }
        Set<ru.imagnifi.model.Farmer> farmerSetOrganizaion = null;
        Set<ru.imagnifi.model.Farmer> farmerSetInn = null;
        Set<ru.imagnifi.model.Farmer> farmerSetDistrictNumber = null;
        Set<ru.imagnifi.model.Farmer> farmerSetRegDateFrom = null;
        Set<ru.imagnifi.model.Farmer> farmerSetRegDateTo = null;
        Set<ru.imagnifi.model.Farmer> farmerSetArchiveStatusTrue = null;
        Set<ru.imagnifi.model.Farmer> farmerSetArchiveStatusFalse = null;
        int farmersCount = FarmerLocalServiceUtil.getFarmersCount();
        Set<ru.imagnifi.model.Farmer> farmers =
                new HashSet<ru.imagnifi.model.Farmer>(FarmerLocalServiceUtil.getFarmers(0, farmersCount));
        if (organization != null && !organization.equals("")) {
            portletSession.setAttribute("organizationFilter", organization);
            portletSession.setAttribute("resetButtonFarmerFilter", "true");
            farmerSetOrganizaion = FarmerLocalServiceUtil.findByOrganization(organization);
        }
        if (inn != null && !inn.equals("")) {
            portletSession.setAttribute("innFilter", inn);
            portletSession.setAttribute("resetButtonFarmerFilter", "true");
            long innL = Long.parseLong(inn);
            farmerSetInn = FarmerLocalServiceUtil.findByInn(innL);
        }
        if (districtNumber != null && !districtNumber.equals("")) {
            portletSession.setAttribute("districtNumberFilter", districtNumber);
            portletSession.setAttribute("resetButtonFarmerFilter", "true");
            long number = Long.parseLong(districtNumber);
            farmerSetDistrictNumber = FarmerLocalServiceUtil.findByDistrictNumber(number);
        }
        ru.imagnifi.model.Farmer farmerCurrent = FarmerUtil.getPersistence()
                                                           .create(1);
        CustomComparatorUtil.OrderByDate order = new CustomComparatorUtil.OrderByDate("asc");
        if (regDateFrom != null && !regDateFrom.equals("")) {
            portletSession.setAttribute("regDateFromFilter", regDateFrom);
            portletSession.setAttribute("resetButtonFarmerFilter", "true");
            farmerSetRegDateFrom = new HashSet<>();
            farmerCurrent.setRegistrationDate(regDateFrom);
            for (ru.imagnifi.model.Farmer farmer : farmers) {
                if (order.compare(farmer, farmerCurrent) >= 0) {
                    farmerSetRegDateFrom.add(farmer);
                }
            }
        }
        if (regDateTo != null && !regDateTo.equals("")) {
            portletSession.setAttribute("regDateToFilter", regDateTo);
            portletSession.setAttribute("resetButtonFarmerFilter", "true");
            farmerSetRegDateTo = new HashSet<>();
            farmerCurrent.setRegistrationDate(regDateTo);
            for (ru.imagnifi.model.Farmer farmer : farmers) {
                if (order.compare(farmer, farmerCurrent) <= 0) {
                    farmerSetRegDateTo.add(farmer);
                }
            }
        }
        Set<ru.imagnifi.model.Farmer> arhiveStatus = null;
        if (archiveStatusTrue != null && !archiveStatusTrue.equals("") && !archiveStatusTrue.equals("false") ||
                archiveStatusFalse != null && !archiveStatusFalse.equals("") && !archiveStatusFalse.equals("false")) {
            portletSession.setAttribute("archiveStatusTrueFilter", archiveStatusTrue);
            portletSession.setAttribute("archiveStatusFalseFilter", archiveStatusFalse);
            if (!(archiveStatusTrue.equals("true") && archiveStatusFalse.equals("true"))) {
                portletSession.setAttribute("resetButtonFarmerFilter", "true");
            }

            if (archiveStatusTrue.equals("true")) {
                farmerSetArchiveStatusTrue = FarmerLocalServiceUtil.findByArchiveStatus(true);
            }
            if (archiveStatusFalse.equals("true")) {
                farmerSetArchiveStatusFalse = FarmerLocalServiceUtil.findByArchiveStatus(false);
            }
            if (farmerSetArchiveStatusTrue != null && farmerSetArchiveStatusFalse != null) {
                arhiveStatus = farmerSetArchiveStatusTrue;
                arhiveStatus.addAll(farmerSetArchiveStatusFalse);
            } else if (farmerSetArchiveStatusTrue != null) {
                arhiveStatus = farmerSetArchiveStatusTrue;
            } else if (farmerSetArchiveStatusFalse != null) {
                arhiveStatus = farmerSetArchiveStatusFalse;
            }
        }

        if (farmerSetOrganizaion != null && !farmerSetOrganizaion.isEmpty()) {
            farmers.retainAll(farmerSetOrganizaion);
        }
        if (farmerSetInn != null && !farmerSetInn.isEmpty()) {
            farmers.retainAll(farmerSetInn);
        }
        if (farmerSetDistrictNumber != null && !farmerSetDistrictNumber.isEmpty()) {
            farmers.retainAll(farmerSetDistrictNumber);
        }
        if (farmerSetRegDateFrom != null && !farmerSetRegDateFrom.isEmpty()) {
            farmers.retainAll(farmerSetRegDateFrom);
        }
        if (farmerSetRegDateTo != null && !farmerSetRegDateTo.isEmpty()) {
            farmers.retainAll(farmerSetRegDateTo);
        }
        if (arhiveStatus != null && !arhiveStatus.isEmpty()) {
            farmers.retainAll(arhiveStatus);
        }

        ArrayList<ru.imagnifi.model.Farmer> listResult = new ArrayList<>(farmers);
        portletSession.setAttribute("listFarmers", listResult);
        if (control != null && control.equals("true")) {
            response.setRenderParameter("path", "");
            portletSession.removeAttribute("updateFarmerBaseControl");
        } else {
            response.setRenderParameter("path", "filterFarmerPage");
        }
    }

    public void resetFilter(ActionRequest request, ActionResponse response) throws SystemException {
        PortletSession ps = request.getPortletSession();
        ps.removeAttribute("organizationFilter");
        ps.removeAttribute("innFilter");
        ps.removeAttribute("districtNumberFilter");
        ps.removeAttribute("regDateFromFilter");
        ps.removeAttribute("regDateToFilter");
        ps.removeAttribute("archiveStatusTrueFilter");
        ps.removeAttribute("archiveStatusFalseFilter");
        ps.removeAttribute("resetButtonFarmerFilter");
        filterFarmer(request, response);
        response.setRenderParameter("path", "");
    }

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {
        System.out.println(" Farmer controller: doView 50");
        update();
        String path = renderRequest.getParameter("path");
        String path1 = ParamUtil.getString(renderRequest, "path", "");
        String farmerIdEdit = renderRequest.getParameter("farmerIdEdit");
        System.out.println("farmerIdEdit = " + farmerIdEdit);
        if (path != null && path.equalsIgnoreCase("addFarmerPage") && farmerIdEdit == null) {
            include("/jsp/Farmer/addFarmer.jsp", renderRequest, renderResponse);
            System.out.println(" from doView 118");
        } else if (path != null && path.equalsIgnoreCase("addFarmerPage") && farmerIdEdit != null) {
            try {
                ru.imagnifi.model.Farmer farmer = FarmerLocalServiceUtil.findById(Long.parseLong(farmerIdEdit));
                PortletSession ps = renderRequest.getPortletSession();
                ps.setAttribute("farmerId", farmer.getPrimaryKey());
                ps.setAttribute("org", farmer.getOrganization());
                ps.setAttribute("orgForm", farmer.getOrgForm());
                ps.setAttribute("inn", farmer.getInn());
                ps.setAttribute("kpp", farmer.getKpp());
                ps.setAttribute("ogrn", farmer.getOgrn());
                ps.setAttribute("districtNumber", farmer.getDistrictNumber());
                ps.setAttribute("shownDistricts", DistrictLocalServiceUtil.getFarmerDistricts(farmer.getFarmerId()));
                ps.setAttribute("regDate", farmer.getRegistrationDate());
                ps.setAttribute("archiveStatus", String.valueOf(farmer.getArchiveStatus()));
            } catch (SystemException | NoSuchFarmerException e) {
                throw new RuntimeException(e);
            }
            include("/jsp/Farmer/addFarmer.jsp", renderRequest, renderResponse);
            System.out.println(" from doView 135");
        } else if (path != null && path.equalsIgnoreCase("findFarmerPage")) {
            include("/jsp/Farmer/addFarmer.jsp", renderRequest, renderResponse);
            System.out.println(" from doView 138");
        } else if (path != null && path.equalsIgnoreCase("findFormPage")) {
            include("/jsp/Farmer/findFarmer.jsp", renderRequest, renderResponse);
            System.out.println(" from doView 145");
        } else if (path != null && path.equalsIgnoreCase("filterFarmerPage")) {
            include("/jsp/Farmer/filterFarmer.jsp", renderRequest, renderResponse);
            System.out.println(" from doView 145");
        } else {
            System.out.println(" from doView 147");
            super.doView(renderRequest, renderResponse);
        }
    }


}
