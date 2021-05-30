package com.sgsavch;

import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

/**
 * Path holder (jsp pages, controller commands).
 * 
 * @author D.Kolesnikov
 * 
 */
public final class Path {
	
	// pages

	public static final String PAGE__INDEX = "/index.jsp";
	public static final String PAGE__LOGIN = "/login.jsp";
	public static final String PAGE__ERROR_PAGE = "/jsp/WEB-INF/error.jsp";
	public static final String PAGE__OPTIONS = "/jsp/WEB-INF/options.jsp";
	public static final String PAGE__VEHICLES = "/jsp/WEB-INF/vehicles.jsp";
	public static final String PAGE__REGISTRATION = "/registration.jsp";
	public static final String PAGE__PERIOD = "/jsp/WEB-INF/period.jsp";

	//user
	public static final String PAGE__ORDER = "/jsp/WEB-INF/user/order.jsp";
	public static final String PAGE__INVOICE = "/jsp/WEB-INF/user/invoice.jsp";
	//public static final String PAGE__INVOICE_DAMAGE = "/jsp/WEB-INF/user/invoiceDamage.jsp";

	//manager
	public static final String PAGE__ORDERS = "/jsp/WEB-INF/manager/orders.jsp";

	//admin
	public static final String PAGE__CARMODELS = "/jsp/WEB-INF/admin/carmodels.jsp";
	public static final String PAGE__CARMODEL_EDIT = "/jsp/WEB-INF/admin/carmodelEdit.jsp";
	public static final String PAGE__VEHICLE_EDIT = "/jsp/WEB-INF/admin/vehicleEdit.jsp";
	public static final String PAGE__USERS_LIST = "/jsp/WEB-INF/admin/userList.jsp";
	public static final String PAGE__USER_EDIT = "/jsp/WEB-INF/admin/userEdit.jsp";
	public static final String PAGE__OPTION_EDIT = "/jsp/WEB-INF/optionEdit.jsp";

//	// commands
//
//	public static final String COMMAND__LOGOUT = "/controller?command=logout";
//	public static final String COMMAND__LOGIN = "/controller?command=login";
//	public static final String COMMAND__ACTIVATE = "/controller?command=activate";
//	public static final String COMMAND__REGISTRATION = "/controller?command=registration";
//	public static final String COMMAND__EXCEPTION = "/controller?command=exception";
//	public static final String COMMAND__SET_PERIOD = "/controller?command=setPeriod";
//	public static final String COMMAND__SET_VEHICLE = "/controller?command=setVehicle";
//	public static final String COMMAND__SET_OPTIONS = "/controller?command=setOptions";
//	public static final String COMMAND__SET_ORDER = "/controller?command=setOrder";
//	public static final String COMMAND__OPTIONS = "/controller?command=options";
//	public static final String COMMAND__VEHICLES = "/controller?command=vehicles";
//
//	// USER commands
//	public static final String COMMAND__INVOICE = "/controller?command=invoice";
//	public static final String COMMAND__ORDER = "/controller?command=order";
//	public static final String COMMAND__INVOICE_DAMAGE = "/controller?command=invoiceDamage";
//
//	// MANGER commands
//	public static final String COMMAND__ORDER_EDIT = "/controller?command=order_edit";
//	public static final String COMMAND__ORDER_DELETE = "/controller?command=order_delete";
//	public static final String COMMAND__ORDERS = "/controller?command=orders";
//
//	// ADMIN commands
//	public static final String COMMAND__USERS = "/controller?command=users";
//	public static final String COMMAND__USER_EDIT = "/controller?command=user_edit";
//	public static final String COMMAND__USER_DELETE = "/controller?command=user_delete";
//
//	public static final String COMMAND__OPTION_DELETE = "/controller?command=option_delete";
//	public static final String COMMAND__OPTION_EDIT = "/controller?command=option_edit";
//	public static final String COMMAND__OPTION_ADD = "/controller?command=option_add";
//	public static final String COMMAND__OPTION_SAVE = "/controller?command=option_save";
//
//	public static final String COMMAND__VEHICLE_DELETE = "/controller?command=vehicle_delete";
//	public static final String COMMAND__VEHICLE_EDIT = "/controller?command=vehicle_edit";
//	public static final String COMMAND__VEHICLE_ADD = "/controller?command=vehicle_add";
//	public static final String COMMAND__VEHICLE_SAVE = "/controller?command=vehicle_save";
//
//	public static final String COMMAND__CARMODEL_DELETE = "/controller?command=carModel_delete";
//	public static final String COMMAND__CARMODEL_EDIT = "/controller?command=carModel_edit";
//	public static final String COMMAND__CARMODEL_ADD = "/controller?command=carModel_add";
//	public static final String COMMAND__CARMODEL_SAVE = "/controller?command=carModel_save";
//	public static final String COMMAND__CARMODELS = "/controller?command=carModels";


}