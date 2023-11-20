package ru.imagnifi.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Farmer. This utility wraps
 * {@link ru.imagnifi.service.impl.FarmerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author imagnifi
 * @see FarmerLocalService
 * @see ru.imagnifi.service.base.FarmerLocalServiceBaseImpl
 * @see ru.imagnifi.service.impl.FarmerLocalServiceImpl
 * @generated
 */
public class FarmerLocalServiceUtil {
    private static FarmerLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ru.imagnifi.service.impl.FarmerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the farmer to the database. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was added
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer addFarmer(
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addFarmer(farmer);
    }

    /**
    * Creates a new farmer with the primary key. Does not add the farmer to the database.
    *
    * @param farmerId the primary key for the new farmer
    * @return the new farmer
    */
    public static ru.imagnifi.model.Farmer createFarmer(long farmerId) {
        return getService().createFarmer(farmerId);
    }

    /**
    * Deletes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer that was removed
    * @throws PortalException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer deleteFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFarmer(farmerId);
    }

    /**
    * Deletes the farmer from the database. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer deleteFarmer(
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFarmer(farmer);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static ru.imagnifi.model.Farmer fetchFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchFarmer(farmerId);
    }

    /**
    * Returns the farmer with the primary key.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer
    * @throws PortalException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer getFarmer(long farmerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmer(farmerId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the farmers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> getFarmers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmers(start, end);
    }

    /**
    * Returns the number of farmers.
    *
    * @return the number of farmers
    * @throws SystemException if a system exception occurred
    */
    public static int getFarmersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmersCount();
    }

    /**
    * Updates the farmer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param farmer the farmer
    * @return the farmer that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer updateFarmer(
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateFarmer(farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrictFarmer(long districtId,
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDistrictFarmer(districtId, farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDistrictFarmers(districtId, farmerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrictFarmers(long districtId,
        java.util.List<ru.imagnifi.model.Farmer> Farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addDistrictFarmers(districtId, Farmers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void clearDistrictFarmers(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().clearDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDistrictFarmer(long districtId,
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDistrictFarmer(districtId, farmer);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDistrictFarmers(districtId, farmerIds);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void deleteDistrictFarmers(long districtId,
        java.util.List<ru.imagnifi.model.Farmer> Farmers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteDistrictFarmers(districtId, Farmers);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> getDistrictFarmers(
        long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> getDistrictFarmers(
        long districtId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDistrictFarmers(districtId, start, end);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> getDistrictFarmers(
        long districtId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getDistrictFarmers(districtId, start, end, orderByComparator);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static int getDistrictFarmersCount(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDistrictFarmersCount(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasDistrictFarmer(long districtId, long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasDistrictFarmer(districtId, farmerId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static boolean hasDistrictFarmers(long districtId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasDistrictFarmers(districtId);
    }

    /**
    * @throws SystemException if a system exception occurred
    */
    public static void setDistrictFarmers(long districtId, long[] farmerIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setDistrictFarmers(districtId, farmerIds);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static ru.imagnifi.model.Farmer addFarmer(
        java.lang.String organization, java.lang.String orgForm, long inn,
        long kpp, long ogrn, long districtNumber,
        java.lang.String shownDistricts, java.lang.String regDate,
        boolean archiveStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addFarmer(organization, orgForm, inn, kpp, ogrn,
            districtNumber, shownDistricts, regDate, archiveStatus);
    }

    public static java.lang.String getListSownDistricts(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getListSownDistricts(farmerId);
    }

    public static void addFarmerDistricts(ru.imagnifi.model.Farmer farmer,
        java.lang.String districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addFarmerDistricts(farmer, districtIds);
    }

    public static void addFarmerDistricts(long farmerId, long[] districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().addFarmerDistricts(farmerId, districtIds);
    }

    public static void deleteFarmerDistricts(ru.imagnifi.model.Farmer farmer,
        java.lang.String districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteFarmerDistricts(farmer, districtIds);
    }

    public static void updateFarmerDistricts(ru.imagnifi.model.Farmer farmer,
        java.lang.String districtIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().updateFarmerDistricts(farmer, districtIds);
    }

    public static boolean isDistrictNumberExist(java.lang.Long districtNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().isDistrictNumberExist(districtNumber);
    }

    public static boolean isDistrictIdExist(java.lang.Long districtId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().isDistrictIdExist(districtId);
    }

    public static void updateFarmerCust(ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        getService().updateFarmerCust(farmer);
    }

    public static java.util.List<ru.imagnifi.model.Farmer> findByNameInn(
        java.lang.String name, long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByNameInn(name, inn);
    }

    public static ru.imagnifi.model.Farmer findById(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getService().findById(id);
    }

    public static java.util.Set<ru.imagnifi.model.Farmer> findByOrganization(
        java.lang.String org)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByOrganization(org);
    }

    public static java.util.Set<ru.imagnifi.model.Farmer> findByInn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByInn(inn);
    }

    public static java.util.Set<ru.imagnifi.model.Farmer> findByDistrictNumber(
        long inn) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByDistrictNumber(inn);
    }

    public static java.util.Set<ru.imagnifi.model.Farmer> findByRegistrationDate(
        java.lang.String regDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByRegistrationDate(regDate);
    }

    public static java.util.Set<ru.imagnifi.model.Farmer> findByArchiveStatus(
        boolean status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByArchiveStatus(status);
    }

    public static void clearCash() {
        getService().clearCash();
    }

    public static void clearService() {
        _service = null;
    }

    public static FarmerLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    FarmerLocalService.class.getName());

            if (invokableLocalService instanceof FarmerLocalService) {
                _service = (FarmerLocalService) invokableLocalService;
            } else {
                _service = new FarmerLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(FarmerLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(FarmerLocalService service) {
    }
}
