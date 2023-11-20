package ru.imagnifi.comparator;

import ru.imagnifi.model.Farmer;

import java.util.Comparator;

public class CustomComparatorUtil {
    public static Comparator<Farmer> getComparator(String orderByCol, String orderByType){
        Comparator<Farmer> comparator = null;
        if (orderByCol.equalsIgnoreCase("registrationDate")){
            comparator = new OrderByDate(orderByType);
        } else if (orderByCol.equalsIgnoreCase("farmerId")) {
            comparator = new OrderById(orderByType);
        } else if (orderByCol.equalsIgnoreCase("districtNumber")) {
            comparator = new OrderByDistrictReg(orderByType);
        }


        return comparator;
    }
    public static class OrderById implements Comparator<Farmer>{
        private final String orderByType;
        public OrderById(String order){
            orderByType = order;
        }
        @Override
        public int compare(Farmer o1, Farmer o2) {
            int result = 0;
            if (orderByType.equalsIgnoreCase("asc")){
                result = (int) (o1.getFarmerId()-o2.getFarmerId());
            } else if (orderByType.equalsIgnoreCase("desc")) {
                result = (int) (o2.getFarmerId()-o1.getFarmerId());
            }
            return result;
        }
    }

    public static class OrderByDistrictReg implements Comparator<Farmer>{
        private final String orderByType;
        public OrderByDistrictReg(String order){
            orderByType = order;
        }
        @Override
        public int compare(Farmer o1, Farmer o2) {
            int result = 0;
            if (orderByType.equals("asc")){
                result = (int) (o1.getDistrictNumber() - o2.getDistrictNumber());
            } else if (orderByType.equals("desc")) {
                result = (int) (o2.getDistrictNumber() - o1.getDistrictNumber());
            }
            return result;
        }
    }
    public static class OrderByDate implements Comparator<Farmer>{
        private final String orderByType;
        public OrderByDate(String order){
            orderByType = order;
        }
        @Override
        public int compare(Farmer o1, Farmer o2) {
            int result = 0;
            String date1 = o1.getRegistrationDate();
            String date2 = o2.getRegistrationDate();
            String[] split1 = date1.split("/");
            String[] split2 = date2.split("/");
            if (split1.length == 3 && split2.length == 3){
                int i3 = Integer.parseInt(split1[2]) - Integer.parseInt(split2[2]);
                if (i3 != 0){
                    result = i3;
                } else {
                    int i2 = Integer.parseInt(split1[1]) - Integer.parseInt(split2[1]);
                    if (i2 != 0){
                        result = i2;
                    } else {
                        result = Integer.parseInt(split1[0]) - Integer.parseInt(split2[0]);
                    }
                }
            } else {
                result = Integer.compare(split1.length, split2.length);
            }
            if (orderByType.equalsIgnoreCase("desc")){
                result *= -1;
            }
            return result;
        }
    }
}
