package ru.imagnifi.controllers;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.persistence.DistrictUtil;

import javax.portlet.*;
import java.io.IOException;

public class District extends MVCPortlet {

    public void updateDistrictBase(ActionRequest request, ActionResponse response){
        DistrictLocalServiceUtil.updateBase();
        response.setRenderParameter("path", "");
    }
    public void addDistrict(ActionRequest request, ActionResponse response) throws SystemException {
        String nameDistrict = ParamUtil.getString(request, "nameDistrict");
        String numberDistrict = ParamUtil.getString(request, "numberDistrict");
        String archiveStatusDistrict = ParamUtil.getString(request, "archiveStatusDistrict");
        ru.imagnifi.model.District district = DistrictUtil.getPersistence()
                                                          .create(1);
        district.setName(nameDistrict);
        district.setNumber(Integer.parseInt(numberDistrict));
        district.setStatus(Boolean.parseBoolean(archiveStatusDistrict));
        DistrictLocalServiceUtil.addDistrict(district);
        response.setRenderParameter("path", "addDistrictPage");
        DistrictLocalServiceUtil.updateBase();
    }

    @Override
    public void doView(RenderRequest renderRequest,
                       RenderResponse renderResponse) throws IOException, PortletException {
        String path = renderRequest.getParameter("path");
        if (path != null && path.equals("addDistrictPage")) {
            include("/jsp/District/addDistrict.jsp", renderRequest, renderResponse);
        } else {
            super.doView(renderRequest, renderResponse);
        }
    }
}
