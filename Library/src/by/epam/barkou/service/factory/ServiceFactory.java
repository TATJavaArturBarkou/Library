package by.epam.barkou.service.factory;

import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.impl.ClientServiceImpl;
import by.epam.barkou.service.impl.LibraryServiceImpl;

public class ServiceFactory {
	public static final ServiceFactory instance = new ServiceFactory();
	private final IClientService clientService = new ClientServiceImpl();
	private final ILibraryService libraryService = new LibraryServiceImpl();

	private ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public ILibraryService getLibraryService() {
		return libraryService;
	}
}
