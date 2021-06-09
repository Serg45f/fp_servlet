package com.sgsavch.model.service;


import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.VehicleDao;

import com.sgsavch.model.entity.Vehicle;
import org.junit.BeforeClass;
import org.junit.Test;


import java.sql.*;


import static org.junit.Assert.*;

public class VehicleServiceTest {
    DaoFactory daoFactory = DaoFactory.getInstance();
    VehicleDao dao = daoFactory.createVehicleDao();

    @Test
    public  void shouldReturnVehicleById() throws SQLException{

        String expected = "Vehicle(id=191, carmodel=CarModel(id=187, name=BMW-i3, seatsNumb=5, doorsNumb=4, picture=0b70617a-6ee9-4de2-8b1f-5501366d8132.bmw-i3.png, type=ELECTRIC, status=PREMIUM, price=100.0, deposit=1000.0), regNumber=ВН0377ВТ, yearIssue=2014-06-03T00:00, color=BLACK, transmission=MANUAL, discount=0.0, manager=User(id=3, email=iii@gmail.com, phone=null, activationCode=null, password=$2a$12$N1FeRkVz34UGV5g1D3OS0u3XfT9i3DWozksNl4YF/RV41gkMQuaKe, firstName=Ivan, lastName=Ivanov, roles=[USER], status=ACTIVE, passportNumb=null, passDateExp=null, country=null, licenseNumb=null, cardNumb=null))";
        String result = dao.findById(191).toString();

        assertEquals(expected,result);
    }


}