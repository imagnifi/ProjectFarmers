package ru.imagnifi.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import ru.imagnifi.service.ClpSerializer;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.FarmerLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            DistrictLocalServiceUtil.clearService();

            FarmerLocalServiceUtil.clearService();
        }
    }
}
