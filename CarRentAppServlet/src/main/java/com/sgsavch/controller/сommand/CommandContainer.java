package com.sgsavch.controller.сommand;

import com.sgsavch.controller.сommand.EventCommands.EventCommand;
import com.sgsavch.controller.сommand.EventCommands.EventListCommand;
import com.sgsavch.controller.сommand.carmodelcommands.*;
import com.sgsavch.controller.сommand.optionscommands.OptionListCommand;
import com.sgsavch.controller.сommand.orderscommands.SetOptionsCommand;
import com.sgsavch.controller.сommand.orderscommands.SetOrderCommand;
import com.sgsavch.controller.сommand.orderscommands.SetPeriodCommand;
import com.sgsavch.controller.сommand.orderscommands.SetVehicleCommand;
import com.sgsavch.controller.сommand.usercommands.*;
import com.sgsavch.controller.сommand.vehiclescommands.VehicleAddCommand;
import com.sgsavch.controller.сommand.vehiclescommands.VehicleDeleteCommand;
import com.sgsavch.controller.сommand.vehiclescommands.VehicleEditCommand;
import com.sgsavch.controller.сommand.vehiclescommands.VehicleListCommand;
import com.sgsavch.model.service.*;
//import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;


public class CommandContainer {
	
	//private static final Logger log = Logger.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		// common commands
		commands.put("logout", new LogOutCommand());
		commands.put("login", new LoginCommand(new UserService()));
		commands.put("activate", new ActivatedCommand(new UserService()));
		commands.put("registration", new RegisterCommand(new UserService()));
		commands.put("exception" , new ExceptionCommand());
		commands.put("events", new EventListCommand(new EventService()));
		commands.put("event", new EventCommand(new EventService()));
		commands.put("users", new UserListCommand(new UserService()));
		//TODO: ERROR formatexception "USER"
		commands.put("user_edit", new UserEditCommand(new UserService()));
		//TODO user_delet
		//commands.put("user_delete", new UserDeleteCommand(new UserService()));
		commands.put("setPeriod", new SetPeriodCommand());
		commands.put("setVehicles", new SetVehicleCommand());
		commands.put("setOptions", new SetOptionsCommand());
		commands.put("setOrder", new SetOrderCommand());
		commands.put("options", new OptionListCommand(new OptionService()));
		//TODO option_edit
		//commands.put("option_edit", new OptionCommand(new OptionService()));
		//TODO order
		//commands.put("order", new OrderCommand(new OrderService()));
		//TODO order_edit
		//commands.put("order_edit", new OrderEditCommand(new OrderService()));
		//TODO order_delete
		//commands.put("order_delete", new OrderDeleteCommand(new OrderService()));
		//TODO orders
		//commands.put("orders", new OrderListCommand(new OrderService()));
		//TODO invoice
		//commands.put("invoice", new InvoiceCommand(new InvoiceService()));
		//TODO invoiceDamage
		//commands.put("invoiceDamage", new InvoiceDamageCommand(new InvoiceService()));
		commands.put("carModels", new CarModelListCommand(new CarModelService()));
		commands.put("carModel_add", new CarModelAddCommand(new CarModelService()));
		commands.put("carModel_edit", new CarModelEditCommand(new CarModelService()));
		commands.put("carModel_delete", new CarModelDeleteCommand(new CarModelService()));
		commands.put("carModel_save", new CarModelSaveCommand(new CarModelService()));
		commands.put("vehicles", new VehicleListCommand(new VehicleService()));
		commands.put("vehicle_add", new VehicleAddCommand(new CarModelService(), new UserService()));
		commands.put("vehicle_edit", new VehicleEditCommand(new VehicleService(), new CarModelService(), new UserService()));
		commands.put("vehicle_delete", new VehicleDeleteCommand(new VehicleService()));
		
		// client commands
//		commands.put("listMenu", new ListMenuCommand());
//
//		// admin commands
//		commands.put("listOrders", new ListOrdersCommand());
//
//		log.debug("Command container was successfully initialized");
//		log.trace("Number of commands --> " + commands.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
//			log.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}
	
}