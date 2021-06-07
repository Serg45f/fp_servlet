package com.sgsavch.controller.сommand;

import com.sgsavch.controller.сommand.carmodelcommands.*;
import com.sgsavch.controller.сommand.optionscommands.OptionListCommand;
import com.sgsavch.controller.сommand.orderscommands.*;
import com.sgsavch.controller.сommand.usercommands.*;
import com.sgsavch.controller.сommand.vehiclescommands.*;
import com.sgsavch.model.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Map;
import java.util.TreeMap;


public class CommandContainer {
	
	private static final Logger log = LogManager.getLogger(CommandContainer.class);
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		// common commands

		commands.put("logout", new LogOutCommand());
		commands.put("login", new LoginCommand(new UserService()));
		commands.put("activate", new ActivatedCommand(new UserService()));
		commands.put("registration", new RegistrationCommand(new UserService()));
		commands.put("exception" , new ExceptionCommand());
		commands.put("setPeriod", new SetPeriodCommand());
		commands.put("setVehicle", new SetVehicleCommand());
		commands.put("setOptions", new SetOptionsCommand());
		commands.put("saveOrderOptions", new SaveOrderOptionsCommand(new OptionService()));
		commands.put("options", new OptionListCommand(new OptionService()));
		commands.put("vehicles", new VehicleListCommand(new VehicleService()));

		// USER commands

		commands.put("setOrder", new SetOrderCommand( new UserService()));
		commands.put("order_create", new OrderSaveCommand(new OrderService()));
		commands.put("invoice", new InvoiceCommand());
		commands.put("invoice_save", new InvoiceSaveCommand(new InvoiceService()));
		//commands.put("invoice_payed", new InvoicePayedCommand(new InvoiceService()));

		//TODO invoiceDamage
		//commands.put("invoiceDamage", new InvoiceDamageCommand(new InvoiceService()));

		// MANGER commands

		commands.put("order_edit", new OrderEditCommand(new OrderService()));
		//TODO order_delete
		//commands.put("order_delete", new OrderDeleteCommand(new OrderService()));
		//TODO orders
		commands.put("orders", new OrderListCommand(new OrderService()));

		// ADMIN commands

		commands.put("users", new UserListCommand(new UserService()));
		commands.put("user_edit", new UserEditCommand(new UserService()));
		commands.put("user_save", new UserSaveCommand(new UserService()));
		//TODO user_delet
		//commands.put("user_delete", new UserDeleteCommand(new UserService()));
		//TODO option_delete
		//commands.put("option_delete", new OptionDeleteCommand(new OptionService()));
		//TODO option_edit
		//commands.put("option_edit", new OptionEditCommand(new OptionService()));
		//TODO option_add
		//commands.put("option_add", new OptionAddCommand(new OptionService()));
		//TODO option_save
		//commands.put("option_save", new OptionSaveCommand(new OptionService()));
		commands.put("carModels", new CarModelListCommand(new CarModelService()));
		commands.put("carModel_add", new CarModelAddCommand(new CarModelService()));
		commands.put("carModel_edit", new CarModelEditCommand(new CarModelService()));
		commands.put("carModel_delete", new CarModelDeleteCommand(new CarModelService()));
		commands.put("carModel_save", new CarModelSaveCommand(new CarModelService()));

		commands.put("vehicle_add", new VehicleAddCommand(new CarModelService(), new UserService()));
		commands.put("vehicle_edit", new VehicleEditCommand(new VehicleService(), new CarModelService(), new UserService()));
		commands.put("vehicle_delete", new VehicleDeleteCommand(new VehicleService()));
		commands.put("vehicle_save", new VehicleSaveCommand(new VehicleService(), new UserService(), new CarModelService()));


		log.debug("Command container was successfully initialized");
		log.trace("Number of commands --> " + commands.size());
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
			log.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}
	
}