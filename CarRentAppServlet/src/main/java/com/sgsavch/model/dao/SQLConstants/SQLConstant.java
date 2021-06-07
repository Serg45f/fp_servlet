package com.sgsavch.model.dao.SQLConstants;

public interface SQLConstant {
	/////////////////////////////////USERS///////////////////////////////////////////////

	String TABLE_USERS = "users";

	String USER_ID = "users.id";
	String USER_EMAIL = "users.email";
	String USER_PASSWORD = "users.password";
	String USER_FIRSTNAME = "users.first_name";
	String USER_LASTNAME = "users.last_name";
	String USER_STATUS = "users.status";
	String USER_ACTIVATION_CODE = "users.activation_code";

	String SQL_FIND_USER_BY_LOGIN =
			"SELECT * FROM " + TABLE_USERS + " WHERE " + USER_EMAIL + " LIKE ?  ESCAPE '!';";

	String SQL_FIND_USER_BY_ID =
			"SELECT * FROM " + TABLE_USERS + " WHERE " + USER_ID + " LIKE ?  ESCAPE '!';";

	String SQL_FIND_ALL_USERS =
			"SELECT * FROM " + TABLE_USERS + ";";

	String SQL_ADD_NEW_USER =
			"INSERT INTO users (" +
					USER_EMAIL + ", " +
					USER_PASSWORD + ", " +
					USER_FIRSTNAME + ", " +
					USER_LASTNAME + ", " +
					USER_STATUS + ", " +
					USER_ACTIVATION_CODE + ") VALUES (?,?,?,?,?,?);";

	String SQL_FIND_USER_BY_ACTIVATION_CODE =
			"SELECT * FROM " + TABLE_USERS + " WHERE " + USER_ACTIVATION_CODE +	" LIKE ? ESCAPE '!'";

	String SQL_ACTIVATION_UPDATE_USER =
			"UPDATE " + TABLE_USERS + " SET " + USER_ACTIVATION_CODE + " = ?, "+ USER_STATUS +" = ? WHERE "+USER_ID+" = ?";

	String SQL_DELETE_USER_BY_USER_ID =
			"DELETE FROM " + TABLE_USERS + " WHERE "+USER_ID+"=?";

	String SQL_UPDATE_USER =
			"UPDATE " + TABLE_USERS + " SET " +
					USER_EMAIL + " = ?, "+
					USER_FIRSTNAME + " = ?, "+
					USER_LASTNAME +" = ? WHERE "+USER_ID+" = ?";


	/////////////////////////////////////////ROLES/////////////////////////////////////////

	String TABLE_USER_ROLE = "user_role";

	String USER_ROLE_USER_ID = "user_role.user_id";
	String USER_ROLE_ROLES = "user_role.roles";

	String SQL_ADD_ROLE_FOR_USER =
			"INSERT INTO " + TABLE_USER_ROLE + " (" +
			USER_ROLE_USER_ID + ", " +
			USER_ROLE_ROLES + ") VALUES (?, ?)";

	String SQL_GET_USER_ROLES_BY_USER_ID =
			"SELECT * FROM " + TABLE_USER_ROLE + " WHERE " +
					USER_ROLE_USER_ID + " =?";

	String SQL_DELETE_USER_ROLES_BY_USER_ID =
			"DELETE FROM " + TABLE_USER_ROLE + " WHERE "+USER_ROLE_USER_ID+"=?";

	String SQL_FIND_USER_BY_ROLE =
			"SELECT "+TABLE_USERS+".* FROM " + TABLE_USERS + ", " + TABLE_USER_ROLE  + " WHERE " + USER_ROLE_USER_ID + " = " + USER_ID + " AND " + USER_ROLE_ROLES + " LIKE ? ESCAPE '!'";



	//////////////////////////////////////CAR_MODELS/////////////////////////////////////////////
	String TABLE_CARMODELS = "carmodels";

	String CARMODEL_ID = "carmodels.id";
	String CARMODEL_NAME = "carmodels.name";
	String CARMODEL_NUMBER_OF_DOORS = "carmodels.numb_of_doors";
	String CARMODEL_NUMBER_OF_SEATS = "carmodels.numb_of_seats";
	String CARMODEL_PICTURE = "carmodels.picture";
	String CARMODEL_STATUS = "carmodels.status";
	String CARMODEL_TYPE = "carmodels.type";
	String CARMODEL_PRICE = "carmodels.price";
	String CARMODEL_DEPOSIT = "carmodels.deposit";

	String SQL_GET_CARMODEL_BY_ID =
			"SELECT * FROM " + TABLE_CARMODELS + " WHERE " + CARMODEL_ID + "=?";

	String SQL_GET_ALL_CARMODELS =
			"SELECT * FROM "+TABLE_CARMODELS;

	String SQL_GET_CARMODELS_PAGINATED =
			"SELECT * FROM " + TABLE_CARMODELS + " LIMIT ?, ?";

	String SQL_GET_NUMBER_OF_CARDS_CARMODELS = "SELECT COUNT(id) as count FROM "+TABLE_CARMODELS;

	String SQL_ADD_NEW_CARMODEL = "INSERT INTO " + TABLE_CARMODELS + " (" +
			CARMODEL_NAME + ", " +
			CARMODEL_NUMBER_OF_SEATS + ", " +
			CARMODEL_NUMBER_OF_DOORS + ", " +
			CARMODEL_PICTURE + ", " +
			CARMODEL_STATUS + ", " +
			CARMODEL_TYPE + ", " +
			CARMODEL_PRICE + ", " +
			CARMODEL_DEPOSIT + ") VALUES (?,?,?,?,?,?,?,?);";

	String SQL_UPDATE_CARMODEL =
			"UPDATE " + TABLE_CARMODELS + " SET " +
					CARMODEL_NAME + " = ?, "+
					CARMODEL_NUMBER_OF_SEATS + " = ?, "+
					CARMODEL_NUMBER_OF_DOORS + " = ?, "+
					CARMODEL_PICTURE + " = ?, "+
					CARMODEL_STATUS + " = ?, "+
					CARMODEL_TYPE + " = ?, "+
					CARMODEL_PRICE + " = ?, "+
					CARMODEL_DEPOSIT + " = ?, "+
					" = ? WHERE "+CARMODEL_ID+" = ?";

	String SQL_DELETE_CARMODEL_BY_ID =
			"DELETE FROM " + TABLE_CARMODELS + " WHERE "+CARMODEL_ID+"=?";



	////////////////////////////////ORDERS//////////////////////////////////////////////////

	String TABLE_ORDERS = "orders";


	String ORDER_ID = "orders.id";
	String ORDER_CODE = "orders.code";
	String ORDER_QR = "orders.qrcode";
	String ORDER_START = "orders.start_date_time";
	String ORDER_END = "orders.end_date_time";
	String ORDER_REAL_END = "orders.real_date_time";
	String ORDER_USER_ID = "orders.user_id";
	String ORDER_LOCATION = "orders.location";
	String ORDER_VEHICLE_ID = "orders.vehicle_id";
	String ORDER_DAYS = "orders.days";
	String ORDER_STATUS_ORDER = "orders.status_order";
	String ORDER_PRICE_PERIOD = "orders.price_period";
	String ORDER_PRICE_OPTIONS = "orders.price_options";
	String ORDER_TOTAL_PRICE = "orders.total_price";
	String ORDER_DAMAGE_DESCRIPTION = "orders.damage_description";
	String ORDER_DAMAGE_PRICE = "orders.damage_price";
	String ORDER_DAMAGE_PAYED= "orders.damage_is_payed";



	String SQL_GET_ORDER_BY_ID =
			"SELECT * FROM " + TABLE_ORDERS + " WHERE " + ORDER_ID + "=?";

	String SQL_GET_ALL_ORDERS =
			"SELECT * FROM "+TABLE_ORDERS;

	String SQL_GET_ORDERS_PAGINATED =
			"SELECT * FROM " + TABLE_ORDERS + " LIMIT ?, ?";

	String SQL_GET_NUMBER_OF_CARDS_ORDERS = "SELECT COUNT(id) as count FROM "+TABLE_ORDERS;


	String SQL_ADD_NEW_ORDER = "INSERT INTO " + TABLE_ORDERS + " (" +
			ORDER_CODE + ", " +
			ORDER_QR + ", " +
			ORDER_START + ", " +
			ORDER_END + ", " +
			ORDER_USER_ID + ", " +
			ORDER_LOCATION + ", " +
			ORDER_VEHICLE_ID + ", " +
			ORDER_STATUS_ORDER + ", " +
			ORDER_DAYS + ", " +
			ORDER_PRICE_PERIOD + ", " +
			ORDER_PRICE_OPTIONS + ", " +
			ORDER_TOTAL_PRICE + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

	String SQL_UPDATE_ORDER =
			"UPDATE " + TABLE_ORDERS + " SET " +
					ORDER_REAL_END  + " = ?, " +
					ORDER_DAMAGE_DESCRIPTION + " = ?, " +
					ORDER_DAMAGE_PRICE + " = ?, " +
					ORDER_DAMAGE_PAYED + " = ?, " +
					ORDER_STATUS_ORDER + " = ?, " +
					" = ? WHERE "+ORDER_ID+" = ?";

	String SQL_DELETE_ORDER_BY_ID =
			"DELETE FROM " + TABLE_ORDERS + " WHERE "+ORDER_ID+"=?";

	//////////////////////////////////INVOICE////////////////////////////////////////////////

	String TABLE_INVOICE = "invoice";

	String INVOICE_ID = "id";
	String INVOICE_NUMBER = "number";
	String INVOICE_ORDER_ID = "order_id";
	String INVOICE_PAYMENT_DATE_TIME = "payment_date_time";
	String INVOICE_IS_PAYED = "is_payed";

	String SQL_ADD_NEW_INVOICE =  "INSERT INTO " + TABLE_INVOICE + " (" +
			INVOICE_ORDER_ID + ", " +
			INVOICE_IS_PAYED + ", " +
			INVOICE_PAYMENT_DATE_TIME + ", " +
			INVOICE_NUMBER + ") VALUES (?,?,?,?);";

	String SQL_UPDATE_INVOICE =
			"UPDATE " + TABLE_INVOICE + " SET " +
					INVOICE_ORDER_ID  + " = ?, " +
					INVOICE_IS_PAYED + " = ?, " +
					INVOICE_PAYMENT_DATE_TIME + " = ?, " +
					INVOICE_NUMBER + " = ?, " +
					" = ? WHERE "+INVOICE_ID+" = ?";;

	String GET_ALL_INVOICES = "SELECT * FROM "+ TABLE_INVOICE + ";";

	String SQL_GET_INVOICES_BY_ID =
			"SELECT * FROM " + TABLE_INVOICE + " WHERE " + INVOICE_ID + "=?";

	String SQL_DELETE_INVOICE_BY_ID =
			"DELETE FROM " + TABLE_INVOICE + " WHERE "+INVOICE_ID+"=?";

	String SQL_GET_INVOICES_PAGINATED =
			"SELECT * FROM " + TABLE_INVOICE + " LIMIT ?, ?";

	String SQL_GET_NUMBER_OF_CARDS_INVOICES = "SELECT COUNT(id) as count FROM "+TABLE_INVOICE;


	//////////////////////////////////OPTIONS////////////////////////////////////////////////

	String TABLE_OPTIONS = "options";

	String OPTION_ID = "options.id";
	String OPTION_DESCRIPTION = "options.description";
	String OPTION_NAME = "options.name";
	String OPTION_PICTURE = "options.picture";
	String OPTION_PRICE = "options.price";

	String TABLE_ORDERS_OPTIONS = "orders_options";
	String ORDERS_OPTIONS_ORDER_ID = "orders_options.order_id";
	String ORDERS_OPTIONS_OPTIONS_ID = "orders_options.options_id";


	String SQL_GET_OPTION_BY_ID =
			"SELECT * FROM " + TABLE_OPTIONS + " WHERE " + OPTION_ID + "=?";

	String SQL_GET_OPTIONS_BY_ORDER_ID =
			"SELECT "+TABLE_OPTIONS+".* FROM " + TABLE_OPTIONS + ", " + TABLE_ORDERS_OPTIONS +
					" WHERE " + OPTION_ID +" = "+ORDERS_OPTIONS_OPTIONS_ID+" AND "+ORDERS_OPTIONS_ORDER_ID+ "=?";

	String SQL_GET_ALL_OPTIONS =
			"SELECT * FROM "+TABLE_OPTIONS;

	String SQL_ADD_NEW_OPTION = "INSERT INTO " + TABLE_OPTIONS + " (" +
			OPTION_DESCRIPTION + ", " +
			OPTION_NAME + ", " +
			OPTION_PICTURE + ", " +
			OPTION_PRICE + ") VALUES (?,?,?,?);";

	String SQL_UPDATE_OPTION =
			"UPDATE " + TABLE_OPTIONS + " SET " +
					OPTION_DESCRIPTION   + " = ?, " +
					OPTION_NAME  + " = ?, " +
					OPTION_PICTURE  + " = ?, " +
					OPTION_PRICE  + " = ?, " +
					" = ? WHERE "+CARMODEL_ID+" = ?";

	String SQL_DELETE_OPTION_BY_ID =
			"DELETE FROM " + TABLE_OPTIONS + " WHERE "+OPTION_ID+"=?";

	String SQL_ADD_OPTION_TO_ORDER =
			"INSERT INTO " + TABLE_ORDERS_OPTIONS + " (" +
					ORDERS_OPTIONS_ORDER_ID + ", " +
					ORDERS_OPTIONS_OPTIONS_ID + ") VALUES (?, ?)";

	String SQL_DELETE_OPTIONS_BY_ORDER_ID =
			"DELETE FROM " + TABLE_ORDERS_OPTIONS + " WHERE "+ORDERS_OPTIONS_ORDER_ID+"=?";

	String SQL_FIND_OPTIONS_BY_ORDER =
			"SELECT "+TABLE_OPTIONS+".* FROM " + TABLE_OPTIONS + ", " + TABLE_ORDERS_OPTIONS  + " WHERE " +
					ORDERS_OPTIONS_OPTIONS_ID + " = " + OPTION_ID + " AND " + ORDERS_OPTIONS_ORDER_ID + " LIKE ? ESCAPE '!'";

/////////////////////////////////////VEHICLES/////////////////////////////////////////////

	String TABLE_VEHICLES = "vehicles";

	String VEHICLE_ID = "vehicles.id";
	String VEHICLE_COLOR = "vehicles.color";
	String VEHICLE_REG_NUMBER = "vehicles.reg_number";
	String VEHICLE_TRANSMISSION = "vehicles.transmission";
	String VEHICLE_YEAR_ISSUE = "vehicles.year_issue";
	String VEHICLE_ORDER_ID = "vehicles.order_id";
	String VEHICLE_DISCOUNT = "vehicles.discount";
	String VEHICLE_CARMODEL_ID = "vehicles.carmodel_id";
	String VEHICLE_USER_ID = "vehicles.user_id";

	String SQL_GET_VEHICLE_BY_ID =
			"SELECT * FROM " + TABLE_VEHICLES + " WHERE " + VEHICLE_ID + "=?";

	String SQL_GET_ALL_VEHICLES =
			"SELECT * FROM " + TABLE_VEHICLES;

	String SQL_GET_VEHICLES_PAGINATED =
			"SELECT * FROM " + TABLE_VEHICLES + " LIMIT ?, ?";

	/**
	 * @params start, end, current page, records per page
	 * Returns vacant and new cars
	 */
	String SQL_GET_VEHICLES_PAGINATED_BY_PERIOD =
			"SELECT DISTINCTROW " + TABLE_VEHICLES + ".* FROM " + TABLE_VEHICLES + ", " + TABLE_ORDERS +
					" WHERE ( " + ORDER_VEHICLE_ID+" = " + VEHICLE_ID +
					" AND DATEDIFF(?," + ORDER_END +") > 0  OR DATEDIFF(" + ORDER_START +",?) > 0 )" +
					" OR " + VEHICLE_ID + " != " + ORDER_VEHICLE_ID + " LIMIT ?, ?";

	String SQL_GET_NUMBER_OF_CARDS_VEHICLES = "SELECT COUNT(id) as count FROM "+TABLE_VEHICLES;

	String SQL_ADD_NEW_VEHICLE = "INSERT INTO " + TABLE_VEHICLES + " (" +
			VEHICLE_COLOR + ", " +
			VEHICLE_REG_NUMBER + ", " +
			VEHICLE_TRANSMISSION + ", " +
			VEHICLE_YEAR_ISSUE + ", " +
			VEHICLE_DISCOUNT + ", " +
			VEHICLE_CARMODEL_ID + ", " +
			VEHICLE_USER_ID + ") VALUES (?,?,?,?,?,?,?);";

	String SQL_UPDATE_VEHICLE =
			"UPDATE " + TABLE_VEHICLES + " SET " +
					VEHICLE_COLOR + " = ?, " +
					VEHICLE_REG_NUMBER + " = ?, " +
					VEHICLE_TRANSMISSION + " = ?, " +
					VEHICLE_CARMODEL_ID + " = ?, "+
					VEHICLE_YEAR_ISSUE + " = ?, " +
					VEHICLE_DISCOUNT + " = ?, "+
					VEHICLE_USER_ID + " = ?" + " = ? WHERE "+VEHICLE_ID+" = ?";

	String SQL_DELETE_VEHICLE_BY_ID =
			"DELETE FROM " + TABLE_VEHICLES + " WHERE "+VEHICLE_ID+"=?";



	///////////////////////////////////////////////////////////////////////////////////

	String SQL_FIND_TEAM_BY_NAME = "SELECT * FROM teams WHERE name LIKE ? ESCAPE '!'";
	String SQL_FIND_TEAMS_BY_USER_ID = "SELECT teams.id, teams.name FROM teams, users_teams " +
			"WHERE teams.id = users_teams.team_id " +
			"AND  users_teams.user_id = ?";

	String SQL_UPDATE_TEAM = "UPDATE teams SET teams.name = ? WHERE teams.id = ?";



	String SQL_ADD_NEW_TEAM =
			"INSERT INTO teams (name) VALUES (?)";

	String SQL_FIND_ALL_TEAMS = "SELECT * FROM teams";

	String SQL_DELETE_TEAM = "DELETE FROM teams WHERE id=?";



}
