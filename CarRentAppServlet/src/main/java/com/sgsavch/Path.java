package com.sgsavch;


public final class Path {
	
	// pages

	public static final String PAGE__INDEX = "/index.jsp";
	public static final String PAGE__LOGIN = "/login.jsp";
	public static final String PAGE__ERROR_PAGE = "/WEB-INF/error.jsp";
	public static final String PAGE__OPTIONS = "/WEB-INF/options.jsp";
	public static final String PAGE__VEHICLES = "/WEB-INF/vehicles.jsp";
	public static final String PAGE__REGISTRATION = "/registration.jsp";
	public static final String PAGE__PERIOD = "/WEB-INF/period.jsp";
	public static final String PAGE__SUCCESS = "/WEB-INF/success.jsp";

	//user
	public static final String PAGE__ORDER = "/WEB-INF/jsp/user/order.jsp";
	public static final String PAGE__INVOICE = "/WEB-INF/jsp/user/invoice.jsp";
	//public static final String PAGE__INVOICE_DAMAGE = "/WEB-INF/jsp/user/invoiceDamage.jsp";

	//manager
	public static final String PAGE__ORDERS = "/WEB-INF/jsp/manager/orders.jsp";
	public static final String PAGE__ORDER_EDIT = "/WEB-INF/jsp/manager/orderEdit.jsp";

	//admin
	public static final String PAGE__CARMODELS = "/WEB-INF/jsp/admin/carmodels.jsp";
	public static final String PAGE__CARMODEL_EDIT = "/WEB-INF/jsp/admin/carmodelEdit.jsp";
	public static final String PAGE__VEHICLE_EDIT = "/WEB-INF/jsp/admin/vehicleEdit.jsp";
	public static final String PAGE__USERS_LIST = "/WEB-INF/jsp/admin/userList.jsp";
	public static final String PAGE__USER_EDIT = "/WEB-INF/jsp/admin/userEdit.jsp";
	public static final String PAGE__OPTION_EDIT = "/WEB-INF/jsp/optionEdit.jsp";

	// commands

	public static final String COMMAND__LOGOUT = "/controller?command=logout";
	public static final String COMMAND__LOGIN = "/controller?command=login";
	public static final String COMMAND__ACTIVATE = "/controller?command=activate";
	public static final String COMMAND__REGISTRATION = "/controller?command=registration";
	public static final String COMMAND__EXCEPTION = "/controller?command=exception";
	public static final String COMMAND__SET_PERIOD = "/controller?command=setPeriod";
	public static final String COMMAND__SET_VEHICLE = "/controller?command=setVehicle";
	public static final String COMMAND__SET_OPTIONS = "/controller?command=setOptions";
	public static final String COMMAND__SET_ORDER = "/controller?command=setOrder";
	public static final String COMMAND__OPTIONS = "/controller?command=options";
	public static final String COMMAND__VEHICLES = "/controller?command=vehicles";

	// USER commands
	public static final String COMMAND__INVOICE = "/controller?command=invoice";
	public static final String COMMAND__INVOICE_SAVE = "/controller?command=invoice_save";
	public static final String COMMAND__ORDER = "/controller?command=order";
	public static final String COMMAND__INVOICE_DAMAGE = "/controller?command=invoiceDamage";

	// MANGER commands
	public static final String COMMAND__ORDER_EDIT = "/controller?command=order_edit";
	public static final String COMMAND__ORDER_DELETE = "/controller?command=order_delete";
	public static final String COMMAND__ORDERS = "/controller?command=orders";

	// ADMIN commands
	public static final String COMMAND__USERS = "/controller?command=users";
	public static final String COMMAND__USER_EDIT = "/controller?command=user_edit";
	public static final String COMMAND__USER_DELETE = "/controller?command=user_delete";

	public static final String COMMAND__OPTION_DELETE = "/controller?command=option_delete";
	public static final String COMMAND__OPTION_EDIT = "/controller?command=option_edit";
	public static final String COMMAND__OPTION_ADD = "/controller?command=option_add";
	public static final String COMMAND__OPTION_SAVE = "/controller?command=option_save";

	public static final String COMMAND__VEHICLE_DELETE = "/controller?command=vehicle_delete";
	public static final String COMMAND__VEHICLE_EDIT = "/controller?command=vehicle_edit";
	public static final String COMMAND__VEHICLE_ADD = "/controller?command=vehicle_add";
	public static final String COMMAND__VEHICLE_SAVE = "/controller?command=vehicle_save";

	public static final String COMMAND__CARMODEL_DELETE = "/controller?command=carModel_delete";
	public static final String COMMAND__CARMODEL_EDIT = "/controller?command=carModel_edit";
	public static final String COMMAND__CARMODEL_ADD = "/controller?command=carModel_add";
	public static final String COMMAND__CARMODEL_SAVE = "/controller?command=carModel_save";
	public static final String COMMAND__CARMODELS = "/controller?command=carModels";


}