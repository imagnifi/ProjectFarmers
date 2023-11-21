package ru.imagnifi.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import ru.imagnifi.model.District;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.base.DistrictLocalServiceBaseImpl;
import ru.imagnifi.service.persistence.DistrictUtil;

import java.util.List;

/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.imagnifi.service.DistrictLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author imagnifi
 * @see ru.imagnifi.service.base.DistrictLocalServiceBaseImpl
 * @see ru.imagnifi.service.DistrictLocalServiceUtil
 */
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ru.imagnifi.service.DistrictLocalServiceUtil} to access the district local service.
     */
    public void updateBase(){
        DistrictUtil.clearCache();
    }
    public District findDistrictToNumber(long number) throws SystemException {
        District district = null;
        List<District> districtList =
                DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
        for (District d : districtList) {
            if (d.getNumber() == number){
                district = d;
            }
        }
       return district;
    }


}
