package com.utn.server;

import spark.Spark;
import spark.debug.DebugScreen;
public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		Router.init();
		DebugScreen.enableDebugScreen();
	}
}

/*
TODO: No me deja levantar el servidor, esta tirando este error que desconozco que es

Error: Could not find or load main class tempCodeRunnerFile
Caused by: java.lang.ClassNotFoundException: tempCodeRunnerFile
*/