package ru.imagnifi.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.imagnifi.model.Farmer;
import ru.imagnifi.service.base.FarmerLocalServiceBaseImpl;
import ru.imagnifi.service.persistence.FarmerPersistence;
import ru.imagnifi.service.persistence.FarmerUtil;

import java.util.List;

/**
 * The implementation of the farmer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the {@link ru.imagnifi.service.FarmerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author imagnifi
 * @see ru.imagnifi.service.base.FarmerLocalServiceBaseImpl
 * @see ru.imagnifi.service.FarmerLocalServiceUtil
 */
public class FarmerLocalServiceImpl extends FarmerLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ru.imagnifi.service.FarmerLocalServiceUtil} to
     * access the farmer local service.
     */

    public ru.imagnifi.model.Farmer addFarmer(String organization, String orgForm, long inn, long kpp, long ogrn,
                                              long districtId) throws SystemException, SystemException {
        long increment = counterLocalService.increment();
        FarmerPersistence pers = FarmerUtil.getPersistence();
        Farmer farmer = pers.create(increment);
        farmer.setFarmerId(increment);
        farmer.setOrganization(organization);
        farmer.setOrgForm(orgForm);
        farmer.setInn(inn);
        farmer.setKpp(kpp);
        farmer.setOgrn(ogrn);
        farmer.setDistrictId(districtId);
        pers.update(farmer);
        return farmer;
    }

    public List<Farmer> findByNameInn(String name, long inn) throws SystemException {
        return FarmerUtil.findByname_inn(name, inn);
    }
}
