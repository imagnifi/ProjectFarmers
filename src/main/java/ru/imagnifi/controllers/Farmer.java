package ru.imagnifi.controllers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.imagnifi.service.FarmerLocalServiceUtil;
import ru.imagnifi.service.persistence.FarmerUtil;

import javax.portlet.*;
import java.io.IOException;

public class Farmer extends MVCPortlet {

    public void addFarmer(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
        System.out.println(" Farmer controller: addFarmer 21");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Farmer.class.getName(), request);
        String org = ParamUtil.getString(request, "organization");
        String orgForm = ParamUtil.getString(request, "orgForm");
        long inn = ParamUtil.getLong(request, "inn");
        long kpp = ParamUtil.getLong(request, "kpp");
        long ogrn = ParamUtil.getLong(request, "ogrn");
        long districtId = ParamUtil.getLong(request, "districtId");
        FarmerLocalServiceUtil.addFarmer(org, orgForm, inn, kpp, ogrn, districtId);
        String path = ParamUtil.getString(request, "path");
        System.out.println("path in addFarmer:30 = " + path);
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

    private void update() {
        FarmerUtil.clearCache();
    }

    public void editFarmer(ActionRequest request, ActionResponse response) {
        System.out.println("Farmer controller: editFarmer 42");
        ru.imagnifi.model.Farmer farmer = getLFarmer(request);
        if (farmer != null) {
            response.setRenderParameter("path", "addFarmerPage");
        }
    }

    public void deleteFarmer(ActionRequest request, ActionResponse response) {
        System.out.println("Farmer controller: deleteFarmer 46");
        ru.imagnifi.model.Farmer farmer = getLFarmer(request);

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

    private static ru.imagnifi.model.Farmer getLFarmer(ActionRequest request) {
        long farmerId = Long.parseLong(request.getParameter("farmerId"));
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
        String path = renderRequest.getParameter("path");
        String path1 = ParamUtil.getString(renderRequest, "path", "");
        System.out.println("path = " + path);
        if (path != null && path.equalsIgnoreCase("addFarmerPage")) {
            include("/jsp/Farmer/addFarmer.jsp", renderRequest, renderResponse);
        } else if (path != null && path.equalsIgnoreCase("findFarmerPage")) {
            include("/jsp/Farmer/addFarmer.jsp", renderRequest, renderResponse);
        } else if (path != null && path.equalsIgnoreCase("findFormPage")) {
            String org = renderRequest.getParameter("org");
            renderRequest.setAttribute("org", org);
            String inn = renderRequest.getParameter("inn");
            renderRequest.setAttribute("inn", inn);
            include("/jsp/Farmer/findFarmer.jsp", renderRequest, renderResponse);
        } else {
            super.doView(renderRequest, renderResponse);
        }
    }


}
