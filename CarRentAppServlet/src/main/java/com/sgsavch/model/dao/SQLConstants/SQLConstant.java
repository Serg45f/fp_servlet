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


	///////////////////////////////////////////////////////////////////////////////////
	String TABLE_EVENT = "event";

	String EVENT_ID = "event.id";
	String EVENT_PRICE = "event.price";
	String EVENT_PLACE = "event.place";
	String EVENT_LANGUAGE = "event.language";
	String EVENT_DATE = "event.date";
	String EVENT_TIME = "event.time";
	String EVENT_NAME = "event.name";
	String EVENT_STATUS = "event.status";
	String EVENT_DESCRIPTION = "event.description";
	String EVENT_PICTURE = "event.picture";

	String SQL_GET_EVENT_BY_ID =
			"SELECT * FROM "+TABLE_EVENT+" WHERE "+EVENT_ID+"=?";


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
	String ORDER_START = "orders.start_day_time";
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
			ORDER_STATUS_ORDER + ") VALUES (?,?,?,?,?,?,?,?);";

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


	//////////////////////////////////OPTIONS////////////////////////////////////////////////

	String TABLE_OPTIONS = "options";

	String OPTION_ID = "options.id";
	String OPTION_DESCRIPTION = "options.description";
	String OPTION_NAME = "options.name";
	String OPTION_PICTURE = "options.picture";
	String OPTION_PRICE = "options.price";

	String SQL_GET_OPTION_BY_ID =
			"SELECT * FROM " + TABLE_OPTIONS + " WHERE " + OPTION_ID + "=?";

	String SQL_GET_OPTIONS_BY_ORDER_ID =
			"SELECT * FROM " + TABLE_OPTIONS + " WHERE " + ORDER_ID + "=?";

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
 */
	String SQL_GET_VEHICLES_PAGINATED_BY_PERIOD =
			"SELECT " + TABLE_VEHICLES + ".* FROM " + TABLE_VEHICLES + ", " + TABLE_ORDERS +
					" WHERE " + ORDER_VEHICLE_ID+" = " + VEHICLE_ID +
					" AND DATEDIFF(?," + ORDER_END +") > 0  OR DATEDIFF(" + ORDER_START +",?) > 0  LIMIT ?, ?";

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


	//////////////////////////////////////////////////////////////////////////////////

	String TABLE_TICKET = "ticket";

	String TICKET_ID = "ticket.id";
	String TICKET_PRICE = "ticket.price";
	String TICKET_EVENT_ID = "ticket.event_id";
	String TICKET_USER_ID = "ticket.user_id";
	String TICKET_STATUS_TICKET = "ticket.status_ticket";
	String TICKET_CODE = "ticket.code";
	String TICKET_DISCOUNT = "ticket.discount";
	String TICKET_QRCODE = "ticket.qrcode";

	String SQL_COUNT_TICKETS_BY_USER_GROUP_BY_EVENT =
			"SELECT "+EVENT_DATE+", "+EVENT_TIME+", "+EVENT_PLACE+", "+EVENT_LANGUAGE+", "+EVENT_ID+", "+EVENT_PRICE+", "+EVENT_NAME+", "+TICKET_CODE+", "+USER_ID+", "+USER_EMAIL+", " +
 			" "+USER_FIRSTNAME+", "+USER_LASTNAME+", COUNT("+TICKET_EVENT_ID+") AS tcount, SUM("+EVENT_PRICE+") AS esum "+
			"FROM "+TABLE_TICKET+", "+TABLE_EVENT+", "+TABLE_USERS+" "+
			"WHERE "+EVENT_ID+" = "+TICKET_EVENT_ID+" AND "+USER_ID+"="+TICKET_USER_ID+" AND "+TICKET_USER_ID+" = ? "+
			"GROUP BY "+TICKET_EVENT_ID+
			" ORDER BY "+EVENT_DATE+" asc;";

	String SQL_COUNT_TICKETS_BY_EVENT_GROUP_BY_USER =
			"SELECT "+EVENT_DATE+", "+EVENT_TIME+", "+EVENT_PLACE+", "+EVENT_LANGUAGE+", "+EVENT_ID+", "+EVENT_PRICE+", "+EVENT_NAME+", "+TICKET_CODE+", "+USER_ID+", "+USER_EMAIL+", " +
					" "+USER_FIRSTNAME+", "+USER_LASTNAME+" as user, COUNT("+TICKET_EVENT_ID+") AS tcount, SUM("+EVENT_PRICE+") AS esum "+
					"FROM "+TABLE_TICKET+", "+TABLE_EVENT+", "+TABLE_USERS+" "+
					"WHERE "+EVENT_ID+" = "+TICKET_EVENT_ID+" AND "+USER_ID+"="+TICKET_USER_ID+" AND "+TICKET_EVENT_ID+" = ? "+
					"GROUP BY "+TICKET_USER_ID+
					" ORDER BY "+EVENT_DATE+" asc;";


	String SQL_FIND_ALL_TICKETS_GROUP_BY_USER =
			"SELECT "+EVENT_DATE+", "+EVENT_TIME+", "+EVENT_PLACE+", "+EVENT_LANGUAGE+", "+EVENT_ID+", "+EVENT_PRICE+", "+EVENT_NAME+", "+TICKET_CODE+", "+USER_ID+", "+USER_EMAIL+", " +
					" "+USER_FIRSTNAME+", "+USER_LASTNAME+" as user, COUNT("+TICKET_EVENT_ID+") AS tcount, SUM("+EVENT_PRICE+") AS esum "+
					" FROM "+TABLE_TICKET+", "+TABLE_EVENT+", "+TABLE_USERS+
					" WHERE "+EVENT_ID+" = "+TICKET_EVENT_ID+" AND "+USER_ID+"="+TICKET_USER_ID+
					" GROUP BY "+TICKET_USER_ID+
					" ORDER BY "+EVENT_DATE+" asc;";

	String SQL_FIND_ALL_TICKETS_GROUP_BY_EVENT =
			"SELECT "+EVENT_DATE+", "+EVENT_TIME+", "+EVENT_PLACE+", "+EVENT_LANGUAGE+", "+EVENT_ID+", "+EVENT_PRICE+", "+EVENT_NAME+", "+TICKET_CODE+", "+USER_ID+", "+USER_EMAIL+", " +
					" "+USER_FIRSTNAME+", "+USER_LASTNAME+" as user, COUNT("+TICKET_EVENT_ID+") AS tcount, SUM("+EVENT_PRICE+") AS esum "+
					" FROM "+TABLE_TICKET+", "+TABLE_EVENT+", "+TABLE_USERS+
					" WHERE "+EVENT_ID+" = "+TICKET_EVENT_ID+" AND "+USER_ID+"="+TICKET_USER_ID+
					" GROUP BY "+TICKET_EVENT_ID+
					" ORDER BY "+EVENT_DATE+" asc;";

	String SQL_QUANTITY_TICKETS_BY_EVENT_ID =
					"SELECT  COUNT(*) as quantity  FROM " +TABLE_TICKET+ " WHERE "+TICKET_EVENT_ID+" = ?;";


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
