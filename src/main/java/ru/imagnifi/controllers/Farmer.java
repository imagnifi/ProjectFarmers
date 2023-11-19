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
import ru.imagnifi.model.District;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.FarmerLocalServiceUtil;
import ru.imagnifi.service.persistence.FarmerUtil;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;


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
        if (!FarmerLocalServiceUtil.isDistrictNumberExist(districtNumber)){
            districtNumber = 0;
        }
        String shownDistricts = ParamUtil.getString(request, "shownDistricts");
        String districtIds = numbersDistrictToIds(shownDistricts);
        String regDate = ParamUtil.getString(request, "regDate");
        boolean archiveStatus = Boolean.parseBoolean(ParamUtil.getString(request, "archiveStatus"));
        FarmerLocalServiceUtil.addFarmer(org, orgForm, inn, kpp, ogrn, districtNumber, districtIds, regDate, archiveStatus);
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

    public void updateFarmerBase(ActionRequest request, ActionResponse response) {
        System.out.println("Farmer controller: updateFarmerBase 34");
        FarmerUtil.clearCache();
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

    public void editFarmer(ActionRequest request,
                           ActionResponse response) throws SystemException, PortalException {
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
            if (!FarmerLocalServiceUtil.isDistrictNumberExist(districtNumber)){
                districtNumber = 0;
            }
            farmer.setDistrictNumber(districtNumber);
            farmer.setRegistrationDate(ParamUtil.getString(request, "regDate"));
            farmer.setArchiveStatus(ParamUtil.getBoolean(request, "archiveStatus"));
            FarmerLocalServiceUtil.updateFarmerCust(farmer);
            String shownDistricts = ParamUtil.getString(request, "shownDistricts");
            String districtIds = numbersDistrictToIds(shownDistricts);
            FarmerLocalServiceUtil.updateFarmerDistricts(farmer, districtIds);
        }
    }

    private String numbersDistrictToIds(String numbersDistrict) throws SystemException {
        StringBuilder result = new StringBuilder();
        String[] split = numbersDistrict.split(",");
        for (String s : split) {
            District district = DistrictLocalServiceUtil.findDistrictToNumber(Long.parseLong(s));
            if (district != null) {
                result.append(district.getDistrictId())
                      .append(",");
            }
        }
        return result.toString();
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
        } else {
            System.out.println(" from doView 147");
            super.doView(renderRequest, renderResponse);
        }
    }


}
