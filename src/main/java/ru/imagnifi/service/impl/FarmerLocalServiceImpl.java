package ru.imagnifi.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import ru.imagnifi.NoSuchFarmerException;
import ru.imagnifi.model.District;
import ru.imagnifi.model.Farmer;
import ru.imagnifi.service.DistrictLocalServiceUtil;
import ru.imagnifi.service.FarmerLocalServiceUtil;
import ru.imagnifi.service.base.FarmerLocalServiceBaseImpl;
import ru.imagnifi.service.persistence.FarmerPersistence;
import ru.imagnifi.service.persistence.FarmerUtil;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private final String noAcreage = "no acreage";
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link ru.imagnifi.service.FarmerLocalServiceUtil} to
     * access the farmer local service.
     */

    public ru.imagnifi.model.Farmer addFarmer(String organization, String orgForm, long inn, long kpp, long ogrn,
                                              long districtNumber, String shownDistricts, String regDate,
                                              boolean archiveStatus) throws SystemException, SystemException {

//        long increment = counterLocalService.increment();
        FarmerPersistence pers = FarmerUtil.getPersistence();
        Farmer farmer = pers.create(1);
//        farmer.setFarmerId(increment);
        farmer.setOrganization(organization);
        farmer.setOrgForm(orgForm);
        farmer.setInn(inn);
        farmer.setKpp(kpp);
        farmer.setOgrn(ogrn);
        farmer.setDistrictNumber(districtNumber);
        farmer.setRegistrationDate(regDate);
        farmer.setArchiveStatus(archiveStatus);
        pers.update(farmer);
        FarmerLocalServiceUtil.addFarmerDistricts(farmer, shownDistricts);
        return farmer;
    }

    public String getListSownDistricts(long farmerId) throws SystemException {
        StringBuilder result = new StringBuilder();
        List<District> farmerDistricts = DistrictLocalServiceUtil.getFarmerDistricts(farmerId);
//        List<Farmer> districtFarmers = FarmerLocalServiceUtil.getDistrictFarmers(1);
//        System.out.println(districtFarmers);
        if (farmerDistricts.size() > 0) {
            for (District d : farmerDistricts) {
                result.append(d.getNumber())
                      .append(",");
            }
            result = new StringBuilder(result.substring(0, result.length() - 1));
        } else {
            result.append(noAcreage);
        }


        return result.toString();
    }

    public void addFarmerDistricts(Farmer farmer, String districtIds) throws SystemException {
        String[] strings = districtIds.split(",");
        long[] arrayDistrictIds = new long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arrayDistrictIds[i] = Long.parseLong(strings[i]);
        }
        List<Farmer> farmers = FarmerLocalServiceUtil.findByNameInn(farmer.getOrganization(), farmer.getInn());
        if (!farmers.isEmpty()) {
            addFarmerDistricts(farmers.get(0).getFarmerId(), arrayDistrictIds);
        }
    }

    public void addFarmerDistricts(long farmerId, long[] districtIds) throws SystemException {
        for (long dId : districtIds) {
            FarmerLocalServiceUtil.addDistrictFarmer(dId, farmerId);
        }
    }

    public void deleteFarmerDistricts(Farmer farmer, String districtIds) throws SystemException {
        String[] split = districtIds.split(",");
        List<Farmer> listNameInn = FarmerLocalServiceUtil.findByNameInn(farmer.getOrganization(), farmer.getInn());
        if (listNameInn.size() == 1){
            Farmer farmer1 = listNameInn.get(0);
            String listSownDistricts = FarmerLocalServiceUtil.getListSownDistricts(farmer1.getFarmerId());
            if (!listSownDistricts.equalsIgnoreCase(noAcreage)) {
                String districtToIds = FarmerLocalServiceUtil.numbersDistrictToIds(listSownDistricts);
                String[] split1 = districtToIds.split(",");
                if (!Arrays.equals(split, split1)) {
                    for (String s : split1) {
                        FarmerLocalServiceUtil.deleteDistrictFarmer(Long.parseLong(s), farmer1);
                    }
                }
            }
        }
    }

    public String numbersDistrictToIds(String numbersDistrict) throws SystemException {
        StringBuilder result = new StringBuilder();
        String[] split = numbersDistrict.split(",");
        for (String s : split) {
            s = s.trim();
            boolean isNumeric = isNumeric(s);
            if(isNumeric) {
                District district = DistrictLocalServiceUtil.findDistrictToNumber(Long.parseLong(s));
                if (district != null) {
                    result.append(district.getDistrictId())
                          .append(",");
                }
            }
        }
        return result.toString();
    }

    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public void updateFarmerDistricts(Farmer farmer, String districtIds) throws SystemException {
        deleteFarmerDistricts(farmer,districtIds);
        addFarmerDistricts(farmer, districtIds);
    }

    public boolean isDistrictNumberExist(Long districtNumber) throws SystemException {
        boolean result = false;
        District district = DistrictLocalServiceUtil.findDistrictToNumber(districtNumber);
        if (district != null){
            result = true;
        }
        return result;
    }
    public boolean isDistrictIdExist(Long districtId) throws SystemException, PortalException {
        boolean result = false;
        District district = DistrictLocalServiceUtil.getDistrict(districtId);
        if (district != null){
            result = true;
        }
        return result;
    }


    public void updateFarmerCust(Farmer farmer) throws SystemException, NoSuchFarmerException {
        FarmerPersistence pers = FarmerUtil.getPersistence();
        Farmer farmer1 = pers.findByPrimaryKey(farmer.getPrimaryKey());
        pers.update(farmer);
    }

    public List<Farmer> findByNameInn(String name, long inn) throws SystemException {
        return FarmerUtil.findByname_inn(name, inn);
    }

    public Farmer findById(long id) throws SystemException, NoSuchFarmerException {
        return FarmerUtil.findByPrimaryKey(id);
    }

    public Set<Farmer> findByOrganization(String org) throws SystemException {
        return new HashSet<Farmer>(FarmerUtil.findByorganization(org));
    }
    public Set<Farmer> findByInn(long inn) throws SystemException {
        return new HashSet<Farmer>(FarmerUtil.findByinn(inn));
    }
    public Set<Farmer> findByDistrictNumber(long inn) throws SystemException {
        return new HashSet<Farmer>(FarmerUtil.findBydistrictNumber(inn));
    }
    public Set<Farmer> findByRegistrationDate(String regDate) throws SystemException {
        return new HashSet<Farmer>(FarmerUtil.findByregistrationDate(regDate));
    }
    public Set<Farmer> findByArchiveStatus(boolean status) throws SystemException {
        return new HashSet<Farmer>(FarmerUtil.findByarchiveStatus(status));
    }

    public void clearCash() {
        FarmerUtil.clearCache();
    }
}
