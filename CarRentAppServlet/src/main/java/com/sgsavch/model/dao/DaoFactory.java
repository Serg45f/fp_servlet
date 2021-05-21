package com.sgsavch.model.dao;


import com.sgsavch.model.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract EventDao createEventDao();
    public abstract OrderDao createOrderDao();
    public abstract OptionDao createOptionDao();
    public abstract CarModelDao createCarModelDao();
    public abstract VehicleDao createVehicleDao();
    public abstract UserDao createUserDao();
    public abstract TicketDao createTicketDao();
    public abstract LectureDao createLectureDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
