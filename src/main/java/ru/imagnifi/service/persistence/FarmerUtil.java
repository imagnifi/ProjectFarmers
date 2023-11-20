package ru.imagnifi.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ru.imagnifi.model.Farmer;

import java.util.List;

/**
 * The persistence utility for the farmer service. This utility wraps {@link FarmerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author imagnifi
 * @see FarmerPersistence
 * @see FarmerPersistenceImpl
 * @generated
 */
public class FarmerUtil {
    private static FarmerPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Farmer farmer) {
        getPersistence().clearCache(farmer);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Farmer> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Farmer> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Farmer> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Farmer update(Farmer farmer) throws SystemException {
        return getPersistence().update(farmer);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Farmer update(Farmer farmer, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(farmer, serviceContext);
    }

    /**
    * Returns all the farmers where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByname_inn(
        java.lang.String organization, long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname_inn(organization, inn);
    }

    /**
    * Returns a range of all the farmers where organization = &#63; and inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param organization the organization
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByname_inn(
        java.lang.String organization, long inn, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByname_inn(organization, inn, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where organization = &#63; and inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param organization the organization
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByname_inn(
        java.lang.String organization, long inn, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByname_inn(organization, inn, start, end,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByname_inn_First(
        java.lang.String organization, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByname_inn_First(organization, inn, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByname_inn_First(
        java.lang.String organization, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByname_inn_First(organization, inn, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByname_inn_Last(
        java.lang.String organization, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByname_inn_Last(organization, inn, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByname_inn_Last(
        java.lang.String organization, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByname_inn_Last(organization, inn, orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where organization = &#63; and inn = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param organization the organization
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findByname_inn_PrevAndNext(
        long farmerId, java.lang.String organization, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByname_inn_PrevAndNext(farmerId, organization, inn,
            orderByComparator);
    }

    /**
    * Removes all the farmers where organization = &#63; and inn = &#63; from the database.
    *
    * @param organization the organization
    * @param inn the inn
    * @throws SystemException if a system exception occurred
    */
    public static void removeByname_inn(java.lang.String organization, long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByname_inn(organization, inn);
    }

    /**
    * Returns the number of farmers where organization = &#63; and inn = &#63;.
    *
    * @param organization the organization
    * @param inn the inn
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countByname_inn(java.lang.String organization, long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByname_inn(organization, inn);
    }

    /**
    * Returns all the farmers where organization = &#63;.
    *
    * @param organization the organization
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByorganization(
        java.lang.String organization)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByorganization(organization);
    }

    /**
    * Returns a range of all the farmers where organization = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param organization the organization
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByorganization(
        java.lang.String organization, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByorganization(organization, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where organization = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param organization the organization
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByorganization(
        java.lang.String organization, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByorganization(organization, start, end,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where organization = &#63;.
    *
    * @param organization the organization
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByorganization_First(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByorganization_First(organization, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where organization = &#63;.
    *
    * @param organization the organization
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByorganization_First(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByorganization_First(organization, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where organization = &#63;.
    *
    * @param organization the organization
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByorganization_Last(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByorganization_Last(organization, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where organization = &#63;.
    *
    * @param organization the organization
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByorganization_Last(
        java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByorganization_Last(organization, orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where organization = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param organization the organization
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findByorganization_PrevAndNext(
        long farmerId, java.lang.String organization,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByorganization_PrevAndNext(farmerId, organization,
            orderByComparator);
    }

    /**
    * Removes all the farmers where organization = &#63; from the database.
    *
    * @param organization the organization
    * @throws SystemException if a system exception occurred
    */
    public static void removeByorganization(java.lang.String organization)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByorganization(organization);
    }

    /**
    * Returns the number of farmers where organization = &#63;.
    *
    * @param organization the organization
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countByorganization(java.lang.String organization)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByorganization(organization);
    }

    /**
    * Returns all the farmers where inn = &#63;.
    *
    * @param inn the inn
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByinn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByinn(inn);
    }

    /**
    * Returns a range of all the farmers where inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByinn(long inn,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByinn(inn, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where inn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param inn the inn
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByinn(long inn,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByinn(inn, start, end, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByinn_First(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence().findByinn_First(inn, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByinn_First(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByinn_First(inn, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByinn_Last(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence().findByinn_Last(inn, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where inn = &#63;.
    *
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByinn_Last(long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByinn_Last(inn, orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where inn = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param inn the inn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findByinn_PrevAndNext(
        long farmerId, long inn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByinn_PrevAndNext(farmerId, inn, orderByComparator);
    }

    /**
    * Removes all the farmers where inn = &#63; from the database.
    *
    * @param inn the inn
    * @throws SystemException if a system exception occurred
    */
    public static void removeByinn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByinn(inn);
    }

    /**
    * Returns the number of farmers where inn = &#63;.
    *
    * @param inn the inn
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countByinn(long inn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByinn(inn);
    }

    /**
    * Returns all the farmers where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findBydistrictNumber(
        long districtNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBydistrictNumber(districtNumber);
    }

    /**
    * Returns a range of all the farmers where districtNumber = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param districtNumber the district number
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findBydistrictNumber(
        long districtNumber, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBydistrictNumber(districtNumber, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where districtNumber = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param districtNumber the district number
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findBydistrictNumber(
        long districtNumber, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBydistrictNumber(districtNumber, start, end,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findBydistrictNumber_First(
        long districtNumber,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findBydistrictNumber_First(districtNumber, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchBydistrictNumber_First(
        long districtNumber,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydistrictNumber_First(districtNumber,
            orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findBydistrictNumber_Last(
        long districtNumber,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findBydistrictNumber_Last(districtNumber, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchBydistrictNumber_Last(
        long districtNumber,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBydistrictNumber_Last(districtNumber, orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where districtNumber = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param districtNumber the district number
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findBydistrictNumber_PrevAndNext(
        long farmerId, long districtNumber,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findBydistrictNumber_PrevAndNext(farmerId, districtNumber,
            orderByComparator);
    }

    /**
    * Removes all the farmers where districtNumber = &#63; from the database.
    *
    * @param districtNumber the district number
    * @throws SystemException if a system exception occurred
    */
    public static void removeBydistrictNumber(long districtNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBydistrictNumber(districtNumber);
    }

    /**
    * Returns the number of farmers where districtNumber = &#63;.
    *
    * @param districtNumber the district number
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countBydistrictNumber(long districtNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBydistrictNumber(districtNumber);
    }

    /**
    * Returns all the farmers where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByregistrationDate(
        java.lang.String registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByregistrationDate(registrationDate);
    }

    /**
    * Returns a range of all the farmers where registrationDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param registrationDate the registration date
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByregistrationDate(
        java.lang.String registrationDate, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregistrationDate(registrationDate, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where registrationDate = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param registrationDate the registration date
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByregistrationDate(
        java.lang.String registrationDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByregistrationDate(registrationDate, start, end,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByregistrationDate_First(
        java.lang.String registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByregistrationDate_First(registrationDate,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByregistrationDate_First(
        java.lang.String registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregistrationDate_First(registrationDate,
            orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByregistrationDate_Last(
        java.lang.String registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByregistrationDate_Last(registrationDate,
            orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByregistrationDate_Last(
        java.lang.String registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByregistrationDate_Last(registrationDate,
            orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where registrationDate = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param registrationDate the registration date
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findByregistrationDate_PrevAndNext(
        long farmerId, java.lang.String registrationDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByregistrationDate_PrevAndNext(farmerId,
            registrationDate, orderByComparator);
    }

    /**
    * Removes all the farmers where registrationDate = &#63; from the database.
    *
    * @param registrationDate the registration date
    * @throws SystemException if a system exception occurred
    */
    public static void removeByregistrationDate(
        java.lang.String registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByregistrationDate(registrationDate);
    }

    /**
    * Returns the number of farmers where registrationDate = &#63;.
    *
    * @param registrationDate the registration date
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countByregistrationDate(java.lang.String registrationDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByregistrationDate(registrationDate);
    }

    /**
    * Returns all the farmers where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @return the matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByarchiveStatus(
        boolean archiveStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByarchiveStatus(archiveStatus);
    }

    /**
    * Returns a range of all the farmers where archiveStatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param archiveStatus the archive status
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByarchiveStatus(
        boolean archiveStatus, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByarchiveStatus(archiveStatus, start, end);
    }

    /**
    * Returns an ordered range of all the farmers where archiveStatus = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param archiveStatus the archive status
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findByarchiveStatus(
        boolean archiveStatus, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByarchiveStatus(archiveStatus, start, end,
            orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByarchiveStatus_First(
        boolean archiveStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByarchiveStatus_First(archiveStatus, orderByComparator);
    }

    /**
    * Returns the first farmer in the ordered set where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByarchiveStatus_First(
        boolean archiveStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByarchiveStatus_First(archiveStatus, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByarchiveStatus_Last(
        boolean archiveStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByarchiveStatus_Last(archiveStatus, orderByComparator);
    }

    /**
    * Returns the last farmer in the ordered set where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching farmer, or <code>null</code> if a matching farmer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByarchiveStatus_Last(
        boolean archiveStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByarchiveStatus_Last(archiveStatus, orderByComparator);
    }

    /**
    * Returns the farmers before and after the current farmer in the ordered set where archiveStatus = &#63;.
    *
    * @param farmerId the primary key of the current farmer
    * @param archiveStatus the archive status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer[] findByarchiveStatus_PrevAndNext(
        long farmerId, boolean archiveStatus,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence()
                   .findByarchiveStatus_PrevAndNext(farmerId, archiveStatus,
            orderByComparator);
    }

    /**
    * Removes all the farmers where archiveStatus = &#63; from the database.
    *
    * @param archiveStatus the archive status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByarchiveStatus(boolean archiveStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByarchiveStatus(archiveStatus);
    }

    /**
    * Returns the number of farmers where archiveStatus = &#63;.
    *
    * @param archiveStatus the archive status
    * @return the number of matching farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countByarchiveStatus(boolean archiveStatus)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByarchiveStatus(archiveStatus);
    }

    /**
    * Caches the farmer in the entity cache if it is enabled.
    *
    * @param farmer the farmer
    */
    public static void cacheResult(ru.imagnifi.model.Farmer farmer) {
        getPersistence().cacheResult(farmer);
    }

    /**
    * Caches the farmers in the entity cache if it is enabled.
    *
    * @param farmers the farmers
    */
    public static void cacheResult(
        java.util.List<ru.imagnifi.model.Farmer> farmers) {
        getPersistence().cacheResult(farmers);
    }

    /**
    * Creates a new farmer with the primary key. Does not add the farmer to the database.
    *
    * @param farmerId the primary key for the new farmer
    * @return the new farmer
    */
    public static ru.imagnifi.model.Farmer create(long farmerId) {
        return getPersistence().create(farmerId);
    }

    /**
    * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer that was removed
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer remove(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence().remove(farmerId);
    }

    public static ru.imagnifi.model.Farmer updateImpl(
        ru.imagnifi.model.Farmer farmer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(farmer);
    }

    /**
    * Returns the farmer with the primary key or throws a {@link ru.imagnifi.NoSuchFarmerException} if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer
    * @throws ru.imagnifi.NoSuchFarmerException if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer findByPrimaryKey(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ru.imagnifi.NoSuchFarmerException {
        return getPersistence().findByPrimaryKey(farmerId);
    }

    /**
    * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param farmerId the primary key of the farmer
    * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ru.imagnifi.model.Farmer fetchByPrimaryKey(long farmerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(farmerId);
    }

    /**
    * Returns all the farmers.
    *
    * @return the farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ru.imagnifi.model.Farmer> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the farmers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of farmers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.Farmer> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the farmers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of farmers.
    *
    * @return the number of farmers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the districts associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.District> getDistricts(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDistricts(pk);
    }

    /**
    * Returns a range of all the districts associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @return the range of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.District> getDistricts(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDistricts(pk, start, end);
    }

    /**
    * Returns an ordered range of all the districts associated with the farmer.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ru.imagnifi.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param pk the primary key of the farmer
    * @param start the lower bound of the range of farmers
    * @param end the upper bound of the range of farmers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ru.imagnifi.model.District> getDistricts(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDistricts(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of districts associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @return the number of districts associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static int getDistrictsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getDistrictsSize(pk);
    }

    /**
    * Returns <code>true</code> if the district is associated with the farmer.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @return <code>true</code> if the district is associated with the farmer; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDistrict(pk, districtPK);
    }

    /**
    * Returns <code>true</code> if the farmer has any districts associated with it.
    *
    * @param pk the primary key of the farmer to check for associations with districts
    * @return <code>true</code> if the farmer has any districts associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsDistricts(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsDistricts(pk);
    }

    /**
    * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDistrict(pk, districtPK);
    }

    /**
    * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param district the district
    * @throws SystemException if a system exception occurred
    */
    public static void addDistrict(long pk, ru.imagnifi.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDistrict(pk, district);
    }

    /**
    * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts
    * @throws SystemException if a system exception occurred
    */
    public static void addDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDistricts(pk, districtPKs);
    }

    /**
    * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts
    * @throws SystemException if a system exception occurred
    */
    public static void addDistricts(long pk,
        java.util.List<ru.imagnifi.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addDistricts(pk, districts);
    }

    /**
    * Clears all associations between the farmer and its districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer to clear the associated districts from
    * @throws SystemException if a system exception occurred
    */
    public static void clearDistricts(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearDistricts(pk);
    }

    /**
    * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPK the primary key of the district
    * @throws SystemException if a system exception occurred
    */
    public static void removeDistrict(long pk, long districtPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDistrict(pk, districtPK);
    }

    /**
    * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param district the district
    * @throws SystemException if a system exception occurred
    */
    public static void removeDistrict(long pk,
        ru.imagnifi.model.District district)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDistrict(pk, district);
    }

    /**
    * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts
    * @throws SystemException if a system exception occurred
    */
    public static void removeDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDistricts(pk, districtPKs);
    }

    /**
    * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts
    * @throws SystemException if a system exception occurred
    */
    public static void removeDistricts(long pk,
        java.util.List<ru.imagnifi.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeDistricts(pk, districts);
    }

    /**
    * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districtPKs the primary keys of the districts to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void setDistricts(long pk, long[] districtPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDistricts(pk, districtPKs);
    }

    /**
    * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the farmer
    * @param districts the districts to be associated with the farmer
    * @throws SystemException if a system exception occurred
    */
    public static void setDistricts(long pk,
        java.util.List<ru.imagnifi.model.District> districts)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setDistricts(pk, districts);
    }

    public static FarmerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FarmerPersistence) PortletBeanLocatorUtil.locate(ru.imagnifi.service.ClpSerializer.getServletContextName(),
                    FarmerPersistence.class.getName());

            ReferenceRegistry.registerReference(FarmerUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FarmerPersistence persistence) {
    }
}
