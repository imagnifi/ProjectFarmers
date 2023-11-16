package ru.imagnifi.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ru.imagnifi.model.District;

import ru.imagnifi.service.DistrictLocalServiceUtil;

/**
 * @author imagnifi
 * @generated
 */
public abstract class DistrictActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DistrictActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DistrictLocalServiceUtil.getService());
        setClass(District.class);

        setClassLoader(ru.imagnifi.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("districtId");
    }
}
