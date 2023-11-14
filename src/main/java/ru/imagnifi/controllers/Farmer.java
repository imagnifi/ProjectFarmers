package ru.imagnifi.controllers;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.imagnifi.service.FarmerLocalServiceUtil;
import ru.imagnifi.service.persistence.FarmerPersistence;
import ru.imagnifi.service.persistence.FarmerUtil;

import javax.portlet.*;
import java.io.IOException;

public class Farmer extends MVCPortlet {

     public void addFarmer(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
         ServiceContext serviceContext = ServiceContextFactory.getInstance(Farmer.class.getName(), actionRequest);
         String org = ParamUtil.getString(actionRequest, "organization");
         String orgForm = ParamUtil.getString(actionRequest, "orgForm");
         long inn = ParamUtil.getLong(actionRequest, "inn");
         long kpp = ParamUtil.getLong(actionRequest, "kpp");
         long ogrn = ParamUtil.getLong(actionRequest, "ogrn");
         long districtId = ParamUtil.getLong(actionRequest, "districtId");
         FarmerLocalServiceUtil.addFarmer(org, orgForm, inn, kpp, ogrn, districtId);
         String windowID = actionRequest.getWindowID();

     }
    @Override
    public void processAction(ActionRequest actionRequest,
                              ActionResponse actionResponse) throws IOException, PortletException {

        super.processAction(actionRequest, actionResponse);
    }

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {
        String data = renderRequest.getParameter("addFarmerPath");
        String data1= ParamUtil.getString(renderRequest, "addFarmerPath","");
        System.out.println("data = " + data);
        System.out.println("data1 = " + data1);
        super.doView(renderRequest, renderResponse);
    }


}
